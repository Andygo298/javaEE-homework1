package by.ita.lozouski.service.impl;

import by.ita.lozouski.dao.UserDao;
import by.ita.lozouski.dao.impl.DefaultUserDao;
import by.ita.lozouski.model.User;
import by.ita.lozouski.service.LoginServiceInterface;

public class LoginService implements LoginServiceInterface {
    UserDao userDao = DefaultUserDao.getInstance();
    private static volatile LoginServiceInterface instance;

    public static LoginServiceInterface getInstance() {
        LoginServiceInterface localInstance = instance;
        if (localInstance == null) {
            synchronized (LoginServiceInterface.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new LoginService();
                }
            }
        }
        return localInstance;
    }

    @Override
    public User login(String login, String password) {
        User user = userDao.getByLogin(login);
        if (user == null) {
            return null;
        }
        if (user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}
