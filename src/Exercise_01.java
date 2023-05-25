import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Car {
    private String brand;
    private double enginePower;
    private Driver driver;
    private double price;
    private int year;

    public Car(String brand, double enginePower, Driver driver, double price, int year) {
        this.brand = brand;
        this.enginePower = enginePower;
        this.driver = driver;
        this.price = price;
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(double enginePower) {
        this.enginePower = enginePower;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }
}

class Driver {
    private String name;
    private int age;
    private int drivingExperience;

    public Driver(String name, int age, int drivingExperience) {
        this.name = name;
        this.age = age;
        this.drivingExperience = drivingExperience;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getDrivingExperience() {
        return drivingExperience;
    }

    public void increaseDrivingExperience() {
        drivingExperience++;
    }
}

class TaxiServiceHelper {
    public static Car getRandomCar(List<Car> cars) {
        Random random = new Random();
        int index = random.nextInt(cars.size());
        return cars.get(index);
    }
}

public class Exercise_01{
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();

        // Створення 12 машинок
        Driver driver1 = new Driver("Водій 1", 30, 5);
        Car car1 = new Car("Марка 1", 100, driver1, 10000, 2010);
        cars.add(car1);

        Driver driver2 = new Driver("Водій 2", 35, 7);
        Car car2 = new Car("Марка 2", 120, driver2, 15000, 2012);
        cars.add(car2);

        // Додаткові машинки...

        Driver driver12 = new Driver("Водій 12", 27, 3);
        Car car12 = new Car("Марка 12", 90, driver12, 8000, 2008);
        cars.add(car12);

        // Ремонт половини автопарку
        for (int i = 0; i < cars.size() / 2; i++) {
            Car car = cars.get(i);
            double increasedPower = car.getEnginePower() * 1.1;
            car.setEnginePower(increasedPower);

            Driver newDriver = new Driver("Новий водій " + (i + 1), 25, 1);
            car.setDriver(newDriver);
        }

        // Підвищення потужності та ціни кожної другої машини
        for (int i = 1; i < cars.size(); i += 2) {
            Car car = cars.get(i);
            double increasedPower = car.getEnginePower() * 1.1;
            double increasedPrice = car.getPrice() * 1.05;
            car.setEnginePower(increasedPower);
            car.setPrice(increasedPrice);
        }

        // Перевірка досвіду водіїв та відправлення на курси
        for (Car car : cars) {
            Driver driver = car.getDriver();
            if (driver.getDrivingExperience() < 5 && driver.getAge() > 25) {
                driver.increaseDrivingExperience();
            }
        }

        // Випадковий вибір машинки
        Car randomCar = TaxiServiceHelper.getRandomCar(cars);
        System.out.println("Автомобіль марки " + randomCar.getBrand() + " з водієм " + randomCar.getDriver().getName() + " виїхав за вами.");

        // Виведення повідомлення про прибуття водія
        System.out.println("Водій " + randomCar.getDriver().getName() + " прибув на місце.");
    }
}
