package by.ita.lozouski.dao.impl;

import by.ita.lozouski.dao.UserDao;
import by.ita.lozouski.model.Role;
import by.ita.lozouski.model.User;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class DefaultUserDao implements UserDao {

    Map<String, User> userByLogin;
    AtomicInteger userId = new AtomicInteger(1);

    public DefaultUserDao() {
        this.userByLogin = new ConcurrentHashMap<>();
        this.mockInitialUsers();
    }

    private static volatile UserDao instance;

    public static UserDao getInstance() {
        UserDao localInstance = instance;
        if (localInstance == null) {
            synchronized (UserDao.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new DefaultUserDao();
                }
            }
        }
        return localInstance;
    }

    private void mockInitialUsers() {
        User newUser = new User(Role.ADMIN, "admin", "admin", "admin@gmail.com");
        this.modifyBeforeSave(newUser);
        this.userByLogin.putIfAbsent(newUser.getLogin(), newUser);
        User newUser1 = new User(Role.USER, "root", "root", "root@gmail.com");
        this.modifyBeforeSave(newUser1);
        this.userByLogin.putIfAbsent(newUser1.getLogin(), newUser1);
    }

    private User modifyBeforeSave(User newUser) {
        final int id = this.userId.incrementAndGet();
        newUser.setId(id);
        return newUser;
    }

    @Override
    public User getByLogin(String login) {
        return userByLogin.get(login);
    }

    @Override
    public User saveUser(User user) {
        User newUser = this.modifyBeforeSave(user);
        User saved = userByLogin.putIfAbsent(user.getLogin(), newUser);
        boolean isSaved = saved == null;
        if (!isSaved) {
            this.userId.decrementAndGet();
            return null;
        }
        return newUser;
    }

    @Override
    public ArrayList<User> getUsers() {
        return new ArrayList<>(this.userByLogin.values());
    }
}
