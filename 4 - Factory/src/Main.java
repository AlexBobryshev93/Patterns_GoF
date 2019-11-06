public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Factory factory = new Factory();
        Car car1 = factory.create("Audi");
        Car car2 = factory.create("Porsche");
        car1.drive();
        car2.drive();
    }
}

abstract class Car {
    public abstract void drive();
}

class Audi extends Car {
    @Override
    public void drive() {
        System.out.println("Audi driving...");
    }
}

class Porsche extends Car {
    @Override
    public void drive() {
        System.out.println("Porsche driving...");
    }
}

class Factory {
    public Car create(String name) {
        switch (name) {
            case "Audi" : return new Audi();
            case "Porsche" : return new Porsche();
            default: throw new RuntimeException("Unknown car type");
        }
    }
}
