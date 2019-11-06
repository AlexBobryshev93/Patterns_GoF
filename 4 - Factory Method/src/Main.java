public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        CarFactory audiFactory = new AudiFactory();
        CarFactory porscheFactory = new PorscheFactory();
        Car audi = audiFactory.createCar();
        Car porsche = porscheFactory.createCar();
        audi.drive();
        porsche.drive();
    }
}

abstract class CarFactory {
    public abstract Car createCar(); // this method is considered to be Factory Method since it's return type is overrided in child classes
}

class AudiFactory extends CarFactory {
    public Audi createCar() {
        return new Audi();
    }
}

class PorscheFactory extends CarFactory {
    public Porsche createCar() {
        return new Porsche();
    }
}

abstract class Car {
    public abstract void drive(); // this method wasn't even necessary in this pattern
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

