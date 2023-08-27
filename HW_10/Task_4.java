package HW_10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Order {
    private String orderNumber;
    private String orderName;

    public Order(String orderNumber, String orderName) {
        this.orderNumber = orderNumber;
        this.orderName = orderName;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }
}

class OrderDatabase {
    private List<Order> orders;

    public OrderDatabase() {
        orders = new ArrayList<>();
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void deleteOrder(String orderNumber) {
        Order orderToDelete = null;
        for (Order order : orders) {
            if (order.getOrderNumber().equals(orderNumber)) {
                orderToDelete = order;
                break;
            }
        }
        if (orderToDelete != null) {
            orders.remove(orderToDelete);
            System.out.println("Order with order number " + orderNumber + " deleted.");
        } else {
            System.out.println("Order with order number " + orderNumber + " does not exist.");
        }
    }

    public void printOrders() {
        System.out.println("Order List:");
        System.out.println("Order Number\tOrder Name");
        for (Order order : orders) {
            System.out.println(order.getOrderNumber() + "\t\t" + order.getOrderName());
        }
    }
}

public class OrderManagementSystem {
    private static OrderDatabase orderDatabase;

    public static void main(String[] args) {
        orderDatabase = new OrderDatabase();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Order Management System");
            System.out.println("1. Add Order");
            System.out.println("2. Delete Order");
            System.out.println("3. Print Orders");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addOrder(scanner);
                    break;
                case 2:
                    deleteOrder(scanner);
                    break;
                case 3:
                    printOrders();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static void addOrder(Scanner scanner) {
        System.out.print("Enter order number: ");
        String orderNumber = scanner.next();
        System.out.print("Enter order name: ");
        String orderName = scanner.next();
        Order order = new Order(orderNumber, orderName);
        orderDatabase.addOrder(order);
        System.out.println("Order added successfully.");
    }

    private static void deleteOrder(Scanner scanner) {
        System.out.print("Enter order number to delete: ");
        String orderNumber = scanner.next();
        orderDatabase.deleteOrder(orderNumber);
    }

    private static void printOrders() {
        orderDatabase.printOrders();
    }
}

Результат:

Order Management System
1. Add Order
2. Delete Order
3. Print Orders
4. Exit
Enter your choice: 1
Enter order number: 1001
Enter order name: Order 1
Order added successfully.
Order Management System
1. Add Order
2. Delete Order
3. Print Orders
4. Exit
Enter your choice: 1
Enter order number: 1002
Enter order name: Order 2
Order added successfully.
Order Management System
1. Add Order
2. Delete Order
3. Print Orders
4. Exit
Enter your choice: 3
Order List:
Order Number  Order Name
1001          Order 1
1002          Order 2
Order Management System
1. Add Order
2. Delete Order
3. Print Orders
4. Exit
Enter your choice: 2
Enter order number to delete: 1001
Order with order number 1001 deleted.
Order Management System
1. Add Order
2. Delete Order
3. Print Orders
4. Exit
Enter your choice: 3
Order List:
Order Number  Order Name
1002          Order 2
Order Management System
1. Add Order
2. Delete Order
3. Print Orders
4. Exit
Enter your choice: 4
Exiting...