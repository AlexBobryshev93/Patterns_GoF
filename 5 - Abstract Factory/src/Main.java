public class Main {
    public static void main(String[] args) {
        FurnitureFactory modernFurnitureFactory = new ModernFurnitureFactory();
        FurnitureFactory classicFurnitureFactory = new ClassicFurnitureFactory();
        modernFurnitureFactory.createChair().sitOn();
        modernFurnitureFactory.createTable().drinkTea();
        classicFurnitureFactory.createSofa().rest();
    }
}

abstract class FurnitureFactory {
    public abstract Chair createChair();
    public abstract Table createTable();
    public abstract Sofa createSofa();
}

class ModernFurnitureFactory extends FurnitureFactory {
    @Override
    public ModernChair createChair() {
        return new ModernChair();
    }

    @Override
    public ModernTable createTable() {
        return new ModernTable();
    }

    @Override
    public ModernSofa createSofa() {
        return new ModernSofa();
    }
}

class ClassicFurnitureFactory extends FurnitureFactory {
    @Override
    public ClassicChair createChair() {
        return new ClassicChair();
    }

    @Override
    public ClassicTable createTable() {
        return new ClassicTable();
    }

    @Override
    public ClassicSofa createSofa() {
        return new ClassicSofa();
    }
}

interface Chair {
    void sitOn();
}

interface Table {
    void drinkTea();
}

interface Sofa {
    void rest();
}

class ModernChair implements Chair {
    @Override
    public void sitOn() {
        System.out.println("Sitting on a modern chair");
    }
}

class ClassicChair implements Chair {
    @Override
    public void sitOn() {
        System.out.println("Sitting on a classic chair");
    }
}

class ModernTable implements Table {
    @Override
    public void drinkTea() {
        System.out.println("Drinking tea at a modern table");
    }
}

class ClassicTable implements Table {
    @Override
    public void drinkTea() {
        System.out.println("Drinking tea at a classic table");
    }
}

class ModernSofa implements Sofa {
    @Override
    public void rest() {
        System.out.println("Taking rest at a modern sofa");
    }
}

class ClassicSofa implements Sofa {
    @Override
    public void rest() {
        System.out.println("Taking rest at a classic sofa");
    }
}

