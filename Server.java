import Orders.*;
import Person.Employee;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Server {
    static ArrayList<Employee> employees = new ArrayList<Employee>();
    static ArrayList<Order> orders = new ArrayList<Order>();
    static ArrayList<ToGo> readyToGoOrders = new ArrayList<ToGo>();
    static ArrayList<Express> readyExpressOrders = new ArrayList<Express>();
    static ArrayList<Order> history = new ArrayList<Order>();

    public static void checkOrdersStatus() {
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

    public static void assignOrderHandler() {
        try {
            System.out.println("Enter your employee ID: ");
            Scanner scanner = new Scanner(System.in);
            int id = scanner.nextInt();
            boolean employeeFound = false;
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
                    return;
                }
            }
            if (!employeeFound) {
                System.out.println("Invalid employee ID");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number.");
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
        try {
            System.out.println("Enter your employee ID: ");
            Scanner scanner = new Scanner(System.in);
            int id = scanner.nextInt();
            scanner.nextLine();
            ArrayList<Order> handlerOrders = showHandlerOrders(id);
            System.out.println("Enter the order number: ");
            int orderNumber = scanner.nextInt();
            scanner.nextLine();
            boolean orderFound = false;
            for (Order order : handlerOrders) {
                if (order.getOrderNumber() == orderNumber) {
                    System.out.println("These are the dishes of the order: ");
                    order.showDishes();
                    System.out.println();
                    System.out.println("Enter the dish name you want to mark as completed: ");
                    String dishName = scanner.nextLine();
                    //for (Dish dish : order.getOrderedDishes()) {
                        //if (dish.getName().equals(dishName)) {
                            //dish.setFinished(true);
                            //System.out.println("Dish marked as completed");
                            //analyzeOrder(order);
                            //return;
                        //}
                    //} Check this!
                    System.out.println("Invalid dish name");
                    return;
                }
            }
            if (!orderFound) {
                System.out.println("Invalid order number");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number.");
        }
    }


    public static void analyzeOrder(Order order) {
        for (Dish dish : order.orderedDishes) {
            if (!dish.isFinished()) {
                return;
            }
        }
        if (order instanceof EatingIn) {
            System.out.println("The order is ready to serve");
            orders.remove(order);
            history.add(order);
            return;
        }
        else if (order instanceof ToGo) {
            System.out.println("The order is ready to pick up, wait for the customer");
            orders.remove(order);
            readyToGoOrders.add((ToGo) order);
            return;
        }
        else {
            System.out.println("The order is ready to deliver, wait for the driver");
            orders.remove(order);
            readyExpressOrders.add((Express) order);
            return;
        }
    }

    public static void employeeServerMenu() {
        System.out.println("1. Check pending orders status");
        System.out.println("2. Check waiting to pick up orders status");
        System.out.println("3. Assign order handler");
        System.out.println("4. Manage orders");
        System.out.println("5. Exit");

        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        scanner.nextLine();
        switch (option) {
            case 1:
                checkOrdersStatus();
                break;
            case 2:
                System.out.println("Those are the orders waiting to pick up: ");
                for (ToGo order : readyToGoOrders) {
                    System.out.println(order);
                }
                break;
            case 3:
                assignOrderHandler();
                break;
            case 4:
                manageOrders();
                break;
            case 5:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option");
                break;
        }
    }

    public Server() throws Exception{
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Waiting for conection...");
        Socket socket = serverSocket.accept();

        ObjectInputStream o = new ObjectInputStream(socket.getInputStream());

        Order receivedObject = (Order) o.readObject();
        orders.add((Order) receivedObject);
        //System.out.println("Received object: " + receivedObject);
        o.close();
        socket.close();
        serverSocket.close();
    }
    public static void main (String[] args) {
        Employee izack = new Employee("iZack", "Ramirez", "male", 18, 1, 88288680, 1, "Juan", 5);
        employees.add(izack);
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Waiting for connection...");

            // Start a thread for socket communication
            Thread socketThread = new Thread(() -> {
                while (true) {
                    try {
                        Socket socket = serverSocket.accept();
                        ObjectInputStream o = new ObjectInputStream(socket.getInputStream());
                        Order receivedObject = (Order) o.readObject();
                        orders.add(receivedObject);
                        o.close();
                        socket.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });

            // Start the socket thread
            socketThread.start();

            // Main UI loop
            while (true) {
                employeeServerMenu();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
