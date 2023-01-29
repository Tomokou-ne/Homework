package driver;
import transport.Car;
public class DriverB extends Driver <Car>{
    public DriverB(String initials, int experience, Car car) {
        super(initials, "B", experience, car);
    }
}
