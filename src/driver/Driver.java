package driver;

import mechanic.Mechanic;
import transport.Transport;

public class Driver<T extends Transport> {
    private String initials;
    private String driversLicence;
    private int experience;
    private T car;

    public Driver(String initials, String driversLicence, int experience, T car) {
        if (initials == null || initials.isBlank() || initials.isEmpty()) {
            this.initials = "водитель";
        } else {
            this.initials = initials;
        } if (driversLicence == null || driversLicence.isBlank() || driversLicence.isEmpty()) {
            this.driversLicence = "отсутствуют";
        } else {
            this.driversLicence = driversLicence;
        } if (experience <= 0) {
            this.experience = Math.abs(experience);
        } else {
            this.experience = experience;
        }
        this.car = car;
    }

    public String getInitials() {
        return initials;
    }

    public String getDriversLicence() {
        return driversLicence;
    }

    public void setDriversLicence(String driversLicence) {
        if (driversLicence == null) {
            throw new IllegalArgumentException("Необходимо указать категорию прав!");
        }
        this.driversLicence = driversLicence;
    }

    public int getExperience() {
        return experience;
    }

    public T getCar() {
        return car;
    }

    public void setCar(T car) {
        this.car = car;
    }

    public void startMoving1() {
        System.out.println("Водитель " + initials + " начал движение");
    }
    public void stopMoving1() {
        System.out.println("Водитель " + initials + " остановился");
    }
    public void refuelAuto() {
        System.out.println("Водителю " + initials + " необходимо заправить авто");
    }
    @Override
    public String toString() {
        return "ФИО: " + initials + " , водительские права: " + driversLicence + " , опыт вождения: " + experience;
    }
}
