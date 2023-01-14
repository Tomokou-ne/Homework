package driver;

import transport.Bus;

public class DriverD extends Driver<Bus> {
    public DriverD(String initials, int experience, Bus car) {
        super(initials, "D", experience, car);
    }
}
