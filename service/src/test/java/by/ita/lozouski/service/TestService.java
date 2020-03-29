package by.ita.lozouski.service;
import by.ita.lozouski.dao.UserDao;
import by.ita.lozouski.dao.impl.DefaultUserDao;
import by.ita.lozouski.model.SalaryInfo;
import by.ita.lozouski.model.User;
import by.ita.lozouski.service.impl.LoginService;
import by.ita.lozouski.service.impl.RegisterService;
import by.ita.lozouski.service.impl.SalaryInfoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestService {
    UserDao userDao;
    LoginServiceInterface loginServiceInterface;
    RegisterServiceInterface registerServiceInterface;
    SalaryInfoService salaryInfoService;
    @BeforeEach
    void init(){
        userDao = DefaultUserDao.getInstance();
        loginServiceInterface = LoginService.getInstance();
        registerServiceInterface = RegisterService.getInstance();
        salaryInfoService = new SalaryInfoService();
    }

    @Test
    void loginTest(){
        String testUserName = userDao.getUsers().get(0).getLogin();
        String testUserPassword = userDao.getUsers().get(0).getPassword();

        User expectedUser = loginServiceInterface.login(testUserName,testUserPassword);
        String expUserName = expectedUser.getLogin();
        String expUserPassword = expectedUser.getPassword();

        assertEquals(testUserName, expUserName,"WRONG!");
        assertEquals(testUserPassword, expUserPassword,"WRONG!");
    }
    @Test
    void loginIsNull(){
        String testUserName = "testLogin";
        String testUserPassword = "testPassword";

        User expectedUser = loginServiceInterface.login(testUserName,testUserPassword);
        assertNull(expectedUser);
    }

    @Test
    void registerTest(){
        String login = "Andrew";
        String password = "123";
        String email = "qwerty@gmail.com";
        registerServiceInterface.register(login, password, email);
        String expUserLogin = userDao.getByLogin(login).getLogin();
        assertEquals(login,expUserLogin,"WRONG!");
    }
    @Test
    void salaryCalcTest(){
        double brutto = 1000.0;
        double fszn = 35.0;
        double bgs = 0.6;
        double jobTax = 13.0;
        double profUnion = 1.0;
        SalaryInfo salaryInfo = salaryInfoService.calculateSalary(brutto,fszn,bgs,jobTax,profUnion);
        double nettoExpected = 504.0;
        double nettoActual = salaryInfo.getNetto();
        assertEquals(nettoExpected,nettoActual,"WRONG!");
    }

    @Test
    void setSalaryTest(){
        String testName = "root";
        double nettoExp = 504.0;
        salaryInfoService.setUserSalary(testName,nettoExp);
        double nettoActual = userDao.getByLogin(testName).getSalary();
        assertEquals(nettoExp,nettoActual);
    }
    /*
    * коммент для ветки хотфикс
    * */
}
