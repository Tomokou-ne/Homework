package driver;

import transport.Truck;

public class DriverC extends Driver<Truck> {
    public DriverC(String initials, int experience, Truck car) {
        super(initials, "C", experience, car);
    }
}
