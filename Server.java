import Orders.EatingIn;
import Orders.Express;
import Orders.Order;
import Orders.ToGo;
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

    public void checkOrdersStatus() {
        System.out.println("Those are the eating in orders: ");
        for (Order order : orders) {
            if (order instanceof EatingIn) {
                System.out.println(order + "\n");
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
    public void assignOrderHandler() {
        System.out.println("Enter your employee ID: ");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        for (Employee employee : employees) {
            if (employee.getEmployeeId() == id) {
                System.out.println("Enter the order number: ");
                int orderId = scanner.nextInt();
                for (Order order : orders) {
                    if (order.getOrderNumber() == orderId) {
                        order.setHandler(employee);
                        System.out.println("Order assigned");
                        scanner.close();
                        return;
                    }
                }
                System.out.println("Invalid order number");
            }
            System.out.println("Invalid employee ID");
        }
        scanner.close();
    }
    public ArrayList<Order> showHandlerOrders(int id) {
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

    public void manageOrders() {
        System.out.println("Enter your employee ID: ");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        ArrayList<Order> handlerOrders = showHandlerOrders(id);
        System.out.println("Enter the order number: ");
        int orderNumber = scanner.nextInt();
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
                        scanner.close();
                        return;
                    }
                }
            }
            System.out.println("Invalid order number");
        }
    }

}
