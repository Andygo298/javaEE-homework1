package by.ita.lozouski.web.servlet;

import by.ita.lozouski.model.SalaryInfo;
import by.ita.lozouski.model.User;
import by.ita.lozouski.service.impl.SalaryInfoService;
import by.ita.lozouski.web.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/salary")
public class SalaryServlet extends HttpServlet {
    SalaryInfoService salaryInfoService = new SalaryInfoService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("name", req.getParameter("name"));
        WebUtils.forward("salary", req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("name");
        double brutto = Double.parseDouble(req.getParameter("brutto"));
        double fszn = Double.parseDouble(req.getParameter("fszn"));
        double bgs = Double.parseDouble(req.getParameter("bgs"));
        double jobTax = Double.parseDouble(req.getParameter("jobTax"));
        double profUnion = Double.parseDouble(req.getParameter("profUnion"));

        SalaryInfo salaryInfo = salaryInfoService.calculateSalary(brutto, fszn, bgs, jobTax, profUnion);
        salaryInfoService.setUserSalary(userName, salaryInfo.getNetto());

        req.setAttribute("info", salaryInfo);
        req.setAttribute("userName", userName);
        WebUtils.forward("salary-info", req, resp);
    }
}
