package by.ita.lozouski.web.servlet;

import by.ita.lozouski.model.User;
import by.ita.lozouski.service.RegisterServiceInterface;
import by.ita.lozouski.service.impl.RegisterService;
import by.ita.lozouski.web.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    RegisterServiceInterface registerServiceInterface = RegisterService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebUtils.forward("register", req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        User user = registerServiceInterface.register(login, password, email);
        if (user == null) {
            req.setAttribute("error","Такой пользователь уже существует");
            WebUtils.forward("register", req, resp);
        }
        req.getSession().setAttribute("activeUser", user);
        req.setAttribute("customMessage","Привет, новый пользователь");
//            resp.sendRedirect(req.getContextPath() + "/homepage");
        WebUtils.forward("homepage", req, resp);

    }
}
