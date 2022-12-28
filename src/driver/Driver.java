package driver;

import transport.Transport;

public class Driver<T extends Transport> {
    private final String initials;
    private final String driversLicence;
    private final int experience;
    private final T car;

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

    public boolean getDriversLicence() {
        return driversLicence;
    }

    public int getExperience() {
        return experience;
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
