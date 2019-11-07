import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Product phone = new Product("phone", 300);
        Product laptop = new Product("laptop", 500);
        Product tablet = new Product("tablet", 400);
        Product fitnessTracker = new Product("fitnessTracker", 50);

        Box inner = new Box();
        Box main = new Box();

        inner.addProduct(laptop);
        main.addProduct(phone);
        main.addProduct(tablet);
        main.addProduct(fitnessTracker);
        main.addBox(inner);

        System.out.println("The inner box contents total sum: " + inner.totalPrice());
        System.out.println("The main box contents total sum: " + main.totalPrice());
    }
}

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class Box {
    private List<Product> products = new ArrayList<>();
    private List<Box> boxes = new ArrayList<>();

    public List<Product> getProducts() {
        return products;
    }

    public List<Box> getBoxes() {
        return boxes;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public void addBox(Box box) {
        boxes.add(box);
    }

    public void removeBox(Box box) {
        boxes.remove(box);
    }

    public double totalPrice() {
        return products.stream().mapToDouble(Product::getPrice).sum() +
                boxes.stream().mapToDouble(Box::totalPrice).sum();
    }
}
