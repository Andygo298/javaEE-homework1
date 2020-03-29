package by.ita.lozouski.service;

import by.ita.lozouski.model.SalaryInfo;

public interface SalaryInfoInterface {
    SalaryInfo calculateSalary(double brutto, double fszn, double bgs, double jobTax, double profUnion);
    void setUserSalary(String name, double netto);
}
