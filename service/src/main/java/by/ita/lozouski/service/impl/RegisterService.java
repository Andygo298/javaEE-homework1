package by.ita.lozouski.service.impl;

import by.ita.lozouski.dao.UserDao;
import by.ita.lozouski.dao.impl.DefaultUserDao;
import by.ita.lozouski.model.Role;
import by.ita.lozouski.model.User;
import by.ita.lozouski.service.RegisterServiceInterface;

public class RegisterService implements RegisterServiceInterface {
    UserDao userDao = DefaultUserDao.getInstance();
    private static volatile RegisterServiceInterface instance;

    public static RegisterServiceInterface getInstance() {
        RegisterServiceInterface localInstance = instance;
        if (localInstance == null) {
            synchronized (RegisterServiceInterface.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new RegisterService();
                }
            }
        }
        return localInstance;
    }
    
    @Override
    public User register(String login, String password, String email) {
        User newUser = new User(Role.USER, login, password, email);
        return userDao.saveUser(newUser);
    }
}
