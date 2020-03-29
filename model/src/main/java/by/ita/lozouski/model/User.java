package by.ita.lozouski.model;

import java.util.concurrent.atomic.AtomicInteger;

public class User {
    private Role role;
    private String login;
    private String password;
    private String email;
    private double salary;
    private int id;

    public User(Role role, String login, String password, String email) {
        this.role = role;
        this.login = login;
        this.password = password;
        this.email = email;
        this.salary = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
