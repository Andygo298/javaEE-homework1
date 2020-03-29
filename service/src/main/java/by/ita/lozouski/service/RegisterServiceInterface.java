package by.ita.lozouski.service;

import by.ita.lozouski.model.Role;
import by.ita.lozouski.model.User;

public interface RegisterServiceInterface {
    User register(String login, String password, String email);
}
