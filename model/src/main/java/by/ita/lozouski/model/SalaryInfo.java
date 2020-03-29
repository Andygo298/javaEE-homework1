package by.ita.lozouski.model;

public class SalaryInfo {
    double brutto;
    double fszn;
    double bgs;
    double jobTax;
    double profUnion;
    double netto;

    public SalaryInfo() {
        this.brutto = 0.0;
        this.fszn = 0.0;
        this.bgs = 0.0;
        this.jobTax = 0.0;
        this.profUnion = 0.0;
        this.netto = 0.0;
    }

    public double getBrutto() {
        return brutto;
    }

    public void setBrutto(double brutto) {
        this.brutto = brutto;
    }

    public double getFszn() {
        return fszn;
    }

    public void setFszn(double fszn) {
        this.fszn = fszn;
    }

    public double getBgs() {
        return bgs;
    }

    public void setBgs(double bgs) {
        this.bgs = bgs;
    }

    public double getJobTax() {
        return jobTax;
    }

    public void setJobTax(double jobTax) {
        this.jobTax = jobTax;
    }

    public double getProfUnion() {
        return profUnion;
    }

    public void setProfUnion(double profUnion) {
        this.profUnion = profUnion;
    }

    public double getNetto() {
        return netto;
    }

    public void setNetto(double netto) {
        this.netto = netto;
    }
}
