import Orders.*;
import Person.Employee;

import java.lang.reflect.Array;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Server {
    static ArrayList<Employee> employees = new ArrayList<Employee>();
    static ArrayList<Order> orders = new ArrayList<Order>();
    static ArrayList<Order> history = new ArrayList<Order>();

    public static void checkOrdersStatus() {
        System.out.println("Those are the eating in orders: ");
        for (Order order : orders) {
            if (order instanceof EatingIn) {
                System.out.println(order.getOrderNumber() + "\n" + order.getOrderHandler());
            }
        }
        System.out.println();
        System.out.println("Those are the to go orders: ");
        for (Order order : orders) {
            if (order instanceof ToGo) {
                System.out.println(order + "\n");
            }
        }
        System.out.println();
        System.out.println("Those are the express orders: ");
        for (Order order : orders) {
            if (order instanceof Express) {
                System.out.println(order + "\n");
            }
        }
    }

    public static void assignOrderHandler() {
        System.out.println("Enter your employee ID: ");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        for (Employee employee : employees) {
            if (employee.getEmployeeId() == id) {
                System.out.println("Enter the order number: ");
                int orderId = scanner.nextInt();
                for (Order order : orders) {
                    if (order.getOrderNumber() == orderId) {
                        order.setOrderHandler(employee);
                        System.out.println("Order assigned");
                        return;
                    }
                }
                System.out.println("Invalid order number");
            }
            System.out.println("Invalid employee ID");
        }
    }

    public static ArrayList<Order> showHandlerOrders(int id) {
        ArrayList<Order> handlerOrders = new ArrayList<Order>();
        System.out.println("Those are your orders: ");
        for (Order order : orders) {
            if (order.orderHandler.getEmployeeId() == id) {
                System.out.println(order);
                handlerOrders.add(order);
            }
        }
        return handlerOrders;
    }

    public static void manageOrders() {
        System.out.println("Enter your employee ID: ");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        scanner.nextLine();
        ArrayList<Order> handlerOrders = showHandlerOrders(id);
        System.out.println("Enter the order number: ");
        int orderNumber = scanner.nextInt();
        scanner.nextLine();
        for (Order order : handlerOrders) {
            if (order.getOrderNumber() == orderNumber) {
                System.out.println("Those are the dishes of the order: ");
                order.showDishes();
                System.out.println();
                System.out.println("Enter the dish name you want to mark as completed: ");
                String dishName = scanner.nextLine();
                for (Dish dish : order.orderedDishes) {
                    if (dish.getName().equals(dishName)) {
                        dish.setFinished(true);
                        System.out.println("Dish marked as completed");
                        return;
                    }
                }
            }
            System.out.println("Invalid order number");
        }
    }

    public static void main (String[] args) {
        EatingIn order = new EatingIn(1, "9/30/2021", "12:00", 1);
        Dish dish = new Dish("Pizza", "Pepperoni", "30 minutes", 10000, false);
        Dish secondDish = new Dish("Hamburger", "Cheeseburger", "20 minutes", 8000, false);
        ArrayList<Dish> dishes = new ArrayList<Dish>();
        Employee employee = new Employee(1, "Juan", 200);
        employees.add(employee);
        dishes.add(dish);
        dishes.add(secondDish);
        order.setOrderedDishes(dishes);
        orders.add(order);
        checkOrdersStatus();
        assignOrderHandler();
        checkOrdersStatus();
        manageOrders();
    }
}
