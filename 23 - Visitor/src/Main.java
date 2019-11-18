public class Main {
    public static void main(String[] args) {
        Visitor visitor = new CityVisitor();
        Element cafe = new FoodLocation();
        Element concert = new EntertainmentLocation();

        cafe.accept(visitor);
        concert.accept(visitor);
    }
}

interface Visitor {
    void visit(FoodLocation location);
    void visit(EntertainmentLocation location);
}

class CityVisitor implements Visitor {
    @Override
    public void visit(FoodLocation location) {
        System.out.println("Getting some food...");
    }

    @Override
    public void visit(EntertainmentLocation location) {
        System.out.println("Having fun...");
    }
}

interface Element {
    void accept(Visitor visitor);
}

class FoodLocation implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this); // Double dispatch
    }
}

class EntertainmentLocation implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this); // Double dispatch
    }
}
