package by.ita.lozouski.web.servlet;

import by.ita.lozouski.model.User;
import by.ita.lozouski.service.LoginServiceInterface;
import by.ita.lozouski.service.impl.LoginService;
import by.ita.lozouski.web.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    LoginServiceInterface loginServiceInterface = LoginService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Object activeUser = session.getAttribute("activeUser");
        if (activeUser == null) {
            WebUtils.forward("login", req, resp);
        }
        try {
            resp.sendRedirect(req.getContextPath() + "/homepage");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User user = loginServiceInterface.login(login, password);
        if (user == null){
            req.setAttribute("error","Неправильный логин или пароль");
            WebUtils.forward("login",req,resp);
        }
        req.getSession().setAttribute("activeUser", user);
        try {
            resp.sendRedirect(req.getContextPath() + "/homepage");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
