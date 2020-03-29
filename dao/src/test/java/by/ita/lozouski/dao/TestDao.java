package by.ita.lozouski.dao;

import by.ita.lozouski.dao.impl.DefaultUserDao;
import by.ita.lozouski.model.Role;
import by.ita.lozouski.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;


public class TestDao {

    DefaultUserDao defaultUserDao;

    @BeforeEach
    void init(){
        defaultUserDao = new DefaultUserDao();
    }


    @Test
    void testUserLogin(){
        System.out.println("TEST LOGIN FROM DAO");
        String testLogin = "admin";
        User nameUserTest = defaultUserDao.getByLogin(testLogin);
        String expectedLogin = nameUserTest.getLogin();
        assertEquals(testLogin,expectedLogin,"WRONG!");
        System.out.println("TEST OK!");
    }


    @Test
    void testGetArrayUsers(){
        User newUser = new User(Role.ADMIN, "admin", "admin", "admin@gmail.com");
        User newUser1 = new User(Role.USER, "root", "root", "root@gmail.com");
        ArrayList<User> testList = new ArrayList<>();
        testList.add(newUser1);
        testList.add(newUser);
        ArrayList<User> userList = new ArrayList<>(defaultUserDao.getUsers());

        assertSame(testList.get(0).getPassword(),userList.get(0).getPassword(),"asdasd");
        assertSame(testList.get(1).getPassword(),userList.get(1).getPassword(),"asdasd");
    }
}
