/*
It substitutes the is-a relationship with a has-a and
thus prevents too high number of classes
 */
public class Main {
    public static void main(String[] args) {
        Vehicle car = new Car(new Porsche());
        Vehicle truck = new Truck(new Audi());
        car.drive();
        truck.drive();
    }
}

abstract class Vehicle {
    protected Model model;

    public Vehicle(Model model) {
        this.model = model;
    }

    public abstract void drive();
}

interface Model {
    void drive(String str);
}

class Car extends Vehicle {
    public Car(Model model) {
        super(model);
    }

    @Override
    public void drive() {
        model.drive("Driving a car ");
    }
}


class Truck extends Vehicle {
    public Truck(Model model) {
        super(model);
    }

    @Override
    public void drive() {
        model.drive("Driving a truck ");
    }
}

class Audi implements Model {
    @Override
    public void drive(String str) {
        System.out.println(str + "audi");
    }
}

class Porsche implements Model {
    @Override
    public void drive(String str) {
        System.out.println(str + "porsche");
    }
}