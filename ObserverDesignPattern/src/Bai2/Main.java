package Bai2;

import java.util.ArrayList;
import java.util.List;

// Component interface
interface Component {
    double getPrice();
}

// Leaf
class Product implements Component {
    private double price;

    public Product(double price) {
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }
}

// Composite
class Table implements Component {
    private List<Component> components = new ArrayList<>();

    public void addComponent(Component component) {
        components.add(component);
    }

    @Override
    public double getPrice() {
        double total = 0;
        for (Component component : components) {
            total += component.getPrice();
        }
        return total;
    }
}

class Cafe implements Component{
    private List<Component> components = new ArrayList<>();

    public void addComponent(Component component) {
        components.add(component);
    }

    @Override
    public double getPrice() {
        double total = 0;
        for (Component component : components) {
            total += component.getPrice();
        }
        return total;
    }
}

// Example
public class Main {
    public static void main(String[] args) {
        Product coffee = new Product(30000);
        Product tea = new Product(20000);
        Product cake = new Product(50000);

        Table table1 = new Table();
        table1.addComponent(coffee);
        table1.addComponent(cake);

        Table table2 = new Table();
        table2.addComponent(tea);
        table2.addComponent(coffee);

        Cafe cafe1 = new Cafe();
        cafe1.addComponent(table1);
        cafe1.addComponent(table2);
        cafe1.addComponent(cake);

        System.out.println("Tổng tiền bàn 1: " + table1.getPrice());
        System.out.println("Tổng tiền bàn 2: " + table2.getPrice()); 
        System.out.println("Tổng tiền Cafe: "+ cafe1.getPrice());
    }
}