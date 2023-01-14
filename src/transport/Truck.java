package transport;

public class Truck extends Transport implements Competing {
    LiftingCapacity capacity;

    public Truck(String brand, String model, double engineVolume, LiftingCapacity capacity) {
        super(brand, model, engineVolume);
        this.capacity = capacity;
    }

    @Override
    public boolean diagnose() {
        return Math.random() > 0.55;
    }

    public enum LiftingCapacity {
        N1(null, 3.5F),
        N2(3.5F, 12F),
        N3(12F, null);
        private Float bottomLine;
        private Float upperLine;

        LiftingCapacity(Float bottomLine, Float upperLine) {
            this.bottomLine = bottomLine;
            this.upperLine = upperLine;
        }

        public Float getBottomLine() {
            return bottomLine;
        }

        public void setBottomLine(Float bottomLine) {
            this.bottomLine = bottomLine;
        }

        public Float getUpperLine() {
            return upperLine;
        }

        public void setUpperLine(Float upperLine) {
            this.upperLine = upperLine;
        }

        @Override
        public String toString() {
            if (upperLine == null) {
                return "Грузоподъемность: от " + bottomLine + " тонн.";
            }
            if (bottomLine == null) {
                return "Грузоподъемность: до " + upperLine + " тонн.";
            } else {
                return "Грузоподъемность: от " + bottomLine + " тонн, до " + upperLine + " тонн";
            }
        }
    }

    public LiftingCapacity getCapacity() {
        return capacity;
    }
    public void setCapacity(LiftingCapacity capacity) {
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
            if (circle % 5 == 0) {
                System.out.println("Необходим пит-стоп!");
            }
        }
        @Override
        public void bestCircleTime(int sec1, int sec2, int sec3) {
            if (sec1 < sec2 && sec1 < sec3) {
                System.out.println("Лучшее время за круг " + sec1 + " секунд");
            }
            if (sec2 < sec1 && sec2 < sec3) {
                System.out.println("Лучшее время за круг " + sec2 + " секунд");
            }
            if (sec3 < sec1 && sec3 < sec2) {
                System.out.println("Лучшее время за круг " + sec3 + " секунд");
            }
        }

        @Override
        public void maxSpeed(int speed1, int speed2, int speed3) {
            if (speed1 > speed2 && speed1 > speed3) {
                System.out.println("Максимальная скорость " + speed1 + " км/час");
            }
            if (speed2 > speed1 && speed2 > speed3) {
                System.out.println("Максимальная скорость " + speed2 + " км/час");
            }
            if (speed3 > speed1 && speed3 > speed2) {
                System.out.println("Максимальная скорость " + speed3 + " км/час");
            }
        }

}
