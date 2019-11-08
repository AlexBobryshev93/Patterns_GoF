public class Main {
    public static void main(String[] args) {
        CarDriver car = new Car();
        car.drive();
        car = new CarProxy();
        car.drive();
    }
}

interface CarDriver {
    void drive();
}

class Car implements CarDriver {
    @Override
    public void drive() {
        System.out.println("Driving a car...");
    }
}

class CarProxy implements CarDriver {
    private Car car = new Car();

    @Override
    public void drive() {
        System.out.println("In proxy code");
        car.drive();
    }
}
