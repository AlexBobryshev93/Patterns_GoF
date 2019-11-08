import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        FlyweightGarage garage = new FlyweightGarage();
        MovingCar movingCar1 = new MovingCar(garage.getCar("Ferrari", "red"));
        MovingCar movingCar2 = new MovingCar(garage.getCar("Ferrari", "red"));
        System.out.println(movingCar1 == movingCar2);
        System.out.println(movingCar1.getCar() == movingCar2.getCar());
    }
}

class Car { // flyweight objects
    private final String model; // intrinsic property
    private final String color; // intrinsic property

    public Car(String model, String color) {
        this.model = model;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }
}

class MovingCar {
    private Car car;
    private int x; // extrinsic property
    private int y; // extrinsic property

    public MovingCar(Car car) {
        this.car = car;
    }

    public Car getCar() {
        return car;
    }
}

class FlyweightGarage {
    private Set<Car> cars = new HashSet<>();

    public Car getCar(String model, String color) {
        for (Car car : cars) {
            if (car.getModel().equals(model) && car.getColor().equals(color)) return car;
        }

        Car car = new Car(model, color);
        cars.add(car);
        return car;
    }
}
