package HW_10;

// /Часть 1: Паттерн Агрегатор

import java.util.ArrayList;
import java.util.List;

class Product {
    private String name;
    private double price;
    
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
    
    public double getPrice() {
        return price;
    }
}

class OrderItem {
    private Product product;
    private int quantity;
    
    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
    
    public double getItemTotal() {
        return product.getPrice() * quantity;
    }
}

class Order {
    private List<OrderItem> items;
    
    public Order() {
        items = new ArrayList<>();
    }
    
    public void addItem(OrderItem item) {
        items.add(item);
    }
    
    public double getTotal() {
        double total = 0;
        for (OrderItem item : items) {
            total += item.getItemTotal();
        }
        return total;
    }
}

public class Main {
    public static void main(String[] args) {
        Product product1 = new Product("Product 1", 10.99);
        Product product2 = new Product("Product 2", 5.99);
        
        OrderItem item1 = new OrderItem(product1, 2);
        OrderItem item2 = new OrderItem(product2, 3);
        
        Order order = new Order();
        order.addItem(item1);
        order.addItem(item2);
        
        System.out.println("Total cost of the order: $" + order.getTotal());
    }
}