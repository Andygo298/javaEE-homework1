package by.ita.lozouski.web.servlet;

import by.ita.lozouski.dao.UserDao;
import by.ita.lozouski.dao.impl.DefaultUserDao;
import by.ita.lozouski.model.User;
import by.ita.lozouski.web.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/homepage")
public class HomeServlet extends HttpServlet {
    UserDao userDao = DefaultUserDao.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO: move to filter
        HttpSession session = req.getSession();
        Object activeUser = session.getAttribute("activeUser");
        if (activeUser != null) {
            ArrayList<User> users = this.userDao.getUsers();
            req.setAttribute("users", users);
            WebUtils.forward("homepage", req, resp);
        }
        try {
            resp.sendRedirect(req.getContextPath() + "/login");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
