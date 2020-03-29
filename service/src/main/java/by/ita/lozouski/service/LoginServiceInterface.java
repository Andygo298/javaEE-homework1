package by.ita.lozouski.service;

import by.ita.lozouski.model.User;

public interface LoginServiceInterface {
    User login(String login, String password);
}
