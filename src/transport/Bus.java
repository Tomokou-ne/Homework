package transport;

import driver.DriverD;

import java.util.Arrays;

public class Bus extends Transport implements Competing {

    public Bus(String brand, String model, double engineVolume) {
        super(brand, model, engineVolume);
    }

    @Override
    public void pitStop(int circle) {
        if (circle % 3 == 0) {
            System.out.println("Необходим пит-стоп!");
        }
    }

    @Override
    public void bestCircleTime(int sec1, int sec2, int sec3) {
        if (sec1 < sec2 && sec1 < sec3) {
            System.out.println("Лучшее время за круг " + sec1 + " секунд");
        } if (sec2 < sec1 && sec2 < sec3) {
            System.out.println("Лучшее время за круг " + sec2 + " секунд");
        } if (sec3 < sec1 && sec3 < sec2) {
            System.out.println("Лучшее время за круг " + sec3 + " секунд");
        }

    }

    @Override
    public void maxSpeed(int speed1, int speed2, int speed3) {
        if (speed1 > speed2 && speed1 > speed3) {
            System.out.println("Максимальная скорость " + speed1 + " км/час");
        } if (speed2 > speed1 && speed2 > speed3) {
            System.out.println("Максимальная скорость " + speed2 + " км/час");
        } if (speed3 > speed1 && speed3 > speed2) {
            System.out.println("Максимальная скорость " + speed3 + " км/час");
        }

    }
}
