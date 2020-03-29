package by.ita.lozouski.service.impl;

import by.ita.lozouski.dao.UserDao;
import by.ita.lozouski.dao.impl.DefaultUserDao;
import by.ita.lozouski.model.SalaryInfo;
import by.ita.lozouski.model.User;
import by.ita.lozouski.service.SalaryInfoInterface;

public class SalaryInfoService implements SalaryInfoInterface {
    UserDao userDao = DefaultUserDao.getInstance();

    @Override
    public SalaryInfo calculateSalary(double brutto, double fszn, double bgs, double jobTax, double profUnion) {
        SalaryInfo salaryInfo = new SalaryInfo();
        salaryInfo.setBrutto(brutto);
        salaryInfo.setFszn(calculate(brutto, fszn));
        salaryInfo.setBgs(calculate(brutto, bgs));
        salaryInfo.setJobTax(calculate(brutto, jobTax));
        salaryInfo.setProfUnion(calculate(brutto, profUnion));
        double netto = calculateNetto(salaryInfo);
        salaryInfo.setNetto(netto);
        return salaryInfo;
    }

    @Override
    public void setUserSalary(String name, double netto) {
        User user = userDao.getByLogin(name);
        user.setSalary(netto);
    }

    private double calculateNetto(SalaryInfo data) {
        double brutto = data.getBrutto();
        double sum = data.getFszn() + data.getBgs() + data.getJobTax() + data.getProfUnion();
        return brutto - sum;
    }

    private double calculate(double value, double percent) {
        return value * percent / 100;
    }
}
