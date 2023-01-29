package transport;
public class Car extends Transport implements Competing {

    Carcase carcase;

    public Car(String brand, String model, double engineVolume, Carcase carcase) {
        super(brand, model, engineVolume);
        this.carcase = carcase;
    }

    @Override
    public boolean diagnose() {
        return Math.random() > 0.45;
    }

    public enum Carcase
    {
        SEDAN("Седан"),
        HATCHBACK("Хетчбек"),
        COUPE("Купе"),
        UNIVERSAL("Универсал"),
        SUV("Внедорожник"),
        CROSSOVER("Кроссовер"),
        PICKUP("Пикап"),
        VAN("Фургон"),
        MINIVAN("Минивен");
        private String carcaseType;
        Carcase(String carcaseType) {
            this.carcaseType = carcaseType;
        }
        public String getCarcaseType() {
        return carcaseType;
        }
        public void setCarcaseType(String carcaseType) {
            this.carcaseType = carcaseType;
        }
        @Override
        public String toString(){
            return "Тип кузова: " + getCarcaseType();
        }
    }

    public Carcase getCarcase() {
        return carcase;
    }

    public void setCarcase(Carcase carcase) {
        this.carcase = carcase;
    }
    public void determineCarType() {
        if (carcase == null) {
            System.out.println("Данных недостаточно");
        } else {
            System.out.println(carcase);
        }
    }
    @Override
    public String toString(){
        return getBrand() + " " + getModel() + ", объем двигателя " + getEngineVolume() + ". " + carcase;
    }
    @Override
    public void pitStop(int circle) {
        if (circle % 8 == 0) {
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

