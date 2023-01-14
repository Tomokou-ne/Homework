package transport;

public class Bus extends Transport implements Competing {
SeatCapacity capacity;
    public Bus(String brand, String model, double engineVolume, SeatCapacity capacity) {
        super(brand, model, engineVolume);
        this.capacity = capacity;
    }

    @Override
    public boolean diagnose() {
        return false;
    }

    public enum SeatCapacity {
        ESP_SMALL(null, 10),
        SMALL(null, 25),
        AVERAGE(40, 50),
        BIG(60, 80),
        ESP_BIG(100, 120);

    private Integer bottomLine;
    private Integer upperLine;
    SeatCapacity(Integer bottomLine, Integer upperLine){
        this.bottomLine = bottomLine;
        this.upperLine = upperLine;
    }

    public Integer getBottomLine() {
        return bottomLine;
    }

    public void setBottomLine(Integer bottomLine) {
        this.bottomLine = bottomLine;
    }

    public Integer getUpperLine() {
        return upperLine;
    }

    public void setUpperLine(Integer upperLine) {
        this.upperLine = upperLine;
    }
    @Override
    public String toString(){
        if (bottomLine == null) {
            return "Вместимость: до " + upperLine + " мест";
        } else {
            return "Вместимость: " + bottomLine + " - " + upperLine + " мест";
        }
    }
}

    public SeatCapacity getCapacity() {
        return capacity;
    }
    public void setCapacity(SeatCapacity capacity) {
        this.capacity = capacity;
    }

public void determineCarType() {
        if (capacity == null) {
            System.out.println("Данных недостаточно");
        } else {
            System.out.println(capacity);
        }
}
    @Override
public String toString() {
        return getBrand() + " " + getModel() + ", объем двигателя " + getEngineVolume() + ". " + capacity;
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
