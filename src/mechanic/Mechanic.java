package mechanic;

import driver.Driver;
import transport.Competing;
import transport.Transport;

import java.util.Random;
import java.util.SortedMap;

public class Mechanic <T extends Transport>{
    private final String initials;
    private String company;
    private String workLicence;

    public Mechanic(String initials, String company, String workLicence) {
        this.initials = initials;
        this.company = company;
        this.workLicence = workLicence;
    }

    public String getInitials() {
        return initials;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getWorkLicence() {
        return workLicence;
    }

    public void setWorkLicence(String workLicence) {
        this.workLicence = workLicence;
    }

    @Override
    public String toString(){
        return "Механик: " + initials + ", работает в компании " + company + ", может работать с транспортом: " + workLicence;
    }
    public void maintenance(){
    }

    public void fix(){}

}
