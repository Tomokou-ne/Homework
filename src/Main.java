import driver.Driver;
import driver.DriverB;
import driver.DriverC;
import driver.DriverD;
import mechanic.Mechanic;
import transport.Bus;
import transport.Car;
import transport.Transport;
import transport.Truck;

import java.util.*;


public class Main {

    public static void main(String[] args)  {

        Car lada = new Car("Lada", "Grande", 1.7, Car.Carcase.SEDAN);

        Car audi = new Car("Audi", "A8 50 L TDI quattro", 3.0, Car.Carcase.HATCHBACK);
        Car bmv = new Car("BMV", "Z8",3.0, Car.Carcase.PICKUP);
        Car kia = new Car("KIA", "Sportage 4 поколение", 2.4, Car.Carcase.CROSSOVER);

        Truck zilBull = new Truck("ЗИЛ", "Бычок", 25, Truck.LiftingCapacity.N2);
        Truck eurotent = new Truck("Евротент", "", 25, Truck.LiftingCapacity.N1);
        Truck gazel = new Truck("Газель", "", 20, Truck.LiftingCapacity.N3);
        Truck zil = new Truck("ЗИЛ", "", 20, Truck.LiftingCapacity.N1);

        Bus uno = new Bus("MAN", "Lion's City", 25, Bus.SeatCapacity.SMALL);
        Bus duo = new Bus("VolgaBus", "5270GH", 30, Bus.SeatCapacity.BIG);
        Bus tres = new Bus("ЛИАЗ", "6231", 25, null);
        Bus quatro = new Bus("УАЗ", "Буханка", 35, Bus.SeatCapacity.AVERAGE);

        DriverB b = new DriverB("Иванов Иван Иванович", 5, lada);
        DriverC c = new DriverC("Колосков Дмитрий Попович", 8, gazel);
        DriverD d = new DriverD("Малицкий Николай Степанович", 4, duo);

        Mechanic m1 = new Mechanic("Василий Петров", "СЦ Асна", "все типы");
        Mechanic m2 = new Mechanic("Геннадий Алёшкин", "ООО ЧинИм", "все типы");
        Mechanic m3 = new Mechanic("Анатолий Васнецов", "ИП Гараж-Центр", "все типы");

        lada.addDriver(b);
        lada.addMechanic(m2);


        List<Transport> transports = List.of(
                lada, audi, bmv, kia,
                zilBull, eurotent, gazel,zil,
                uno, duo, tres, quatro
        );
        /*for (Transport transport : transports) {
            System.out.println(transport);
        }*/

        List<Driver> drivers = List.of(
                b, c, d
        );
        /*for (Driver value : drivers) {
            System.out.println(value);
        }*/

        Map<Transport, Mechanic> hashMap = new HashMap<Transport, Mechanic>();
        hashMap.put(lada, m1);
        hashMap.put(audi, m2);
        hashMap.put(bmv, m1);
        hashMap.put(bmv, m1);
        hashMap.put(zilBull, m3);
        hashMap.put(eurotent, m3);
        hashMap.put(gazel, m2);
        hashMap.put(zil,m2);
        hashMap.put(uno, m3);
        hashMap.put(duo, m2);
        hashMap.put(tres, m1);
        hashMap.put(quatro, m3);

        for (Map.Entry<Transport, Mechanic> entry: hashMap.entrySet()) {
            System.out.println(entry.getValue() + ", автомобиль " + entry.getKey());
        }

        //printInfo(lada);

    }
    private static void printInfo(Transport transport) {
        System.out.println("Информация по автомобилю: " + transport.getBrand() + " " + transport.getModel());
        System.out.println("Водитель: " + transport.getDrivers());
        System.out.println("Механик: " + transport.getMechanics());
    }

}