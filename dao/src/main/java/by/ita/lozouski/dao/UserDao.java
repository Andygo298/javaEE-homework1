package by.ita.lozouski.dao;

import by.ita.lozouski.model.User;

import java.util.ArrayList;

public interface UserDao {
    User getByLogin(String login);

    User saveUser(User user);

    ArrayList<User> getUsers();
}
