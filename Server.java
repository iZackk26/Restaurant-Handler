import Orders.*;
import Person.Employee;

import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.ObjectInputStream;
import java.util.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * The type Server.
 */
public class Server {
    /**
     * The Employees.
     */
    static ArrayList<Employee> employees = new ArrayList<Employee>();
    /**
     * The Orders.
     */
    static ArrayList<Order> orders = new ArrayList<Order>();
    /**
     * The Ready to go orders.
     */
    static ArrayList<ToGo> readyToGoOrders = new ArrayList<ToGo>();
    /**
     * The Ready express orders.
     */
    static ArrayList<Express> readyExpressOrders = new ArrayList<Express>();
    /**
     * The History.
     */
    static ArrayList<Order> history = new ArrayList<Order>();
    /**
     * The Current employee.
     */
    static Employee currentEmployee = null;

    /**
     * Check orders status.
     */
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

    /**
     * Assign order handler.
     */
    public static void assignOrderHandler() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the order number: ");
            System.out.print(">>> ");
            int orderId = scanner.nextInt();
            scanner.nextLine();
            for (Order order : orders) {
                if (order.getOrderNumber() == orderId) {
                    order.setOrderHandler(currentEmployee);
                    System.out.println("Order assigned");
                    return;
                }
            }
            System.out.println("Invalid order number");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number.");
        }
    }

    /**
     * Show handler orders array list.
     *
     * @param id the id
     * @return the array list
     */
    public static ArrayList<Order> showHandlerOrders(int id) {
        ArrayList<Order> handlerOrders = new ArrayList<Order>();
        System.out.println("Those are your orders: ");
        for (Order order : orders) {
            if (order.orderHandler != null) {
                if (order.orderHandler.getEmployeeId() == id) {
                    System.out.println(order);
                    handlerOrders.add(order);
                }
            }
        }
        return handlerOrders;
    }

    /**
     * Manage orders.
     */
    public static void manageOrders() {
        try {
            Scanner scanner = new Scanner(System.in);
            ArrayList<Order> handlerOrders = showHandlerOrders(currentEmployee.getEmployeeId());

            if (handlerOrders.isEmpty()) {
                System.out.println("You have no orders assigned.");
                return;
            }

            System.out.println("Enter the order number: ");
            System.out.print(">>> ");
            int orderNumber = scanner.nextInt();
            scanner.nextLine(); // Limpia el buffer de entrada

            for (Order order : handlerOrders) {
                if (order.orderHandler != null) {
                    if (order.getOrderNumber() == orderNumber) {
                        if (order.getOrderHandler().getEmployeeId() == currentEmployee.getEmployeeId()) {
                            System.out.println("These are the dishes of the order: ");
                            order.showDishes();
                            System.out.println();
                            System.out.println("Enter the dish name you want to mark as completed: ");
                            String dishName = scanner.nextLine();

                            for (Dish dish : order.getOrderedDishes()) {
                                if (dish.getName().equals(dishName)) {
                                    dish.setFinished(true);
                                    System.out.println("Dish marked as completed");
                                    analyzeOrder(order);
                                    return;
                                }
                            }
                            System.out.println("Invalid dish name");
                            return;
                        }
                        System.out.println("You are not the handler of this order");
                        return;
                    }
                }
            }
            System.out.println("Invalid order number");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number.");
        } catch (NoSuchElementException e) {
            System.out.println("Input not found. Please provide input.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input format. Please enter a valid number.");
        }
    }

    /**
     * Manage to go orders.
     */
    public static void manageToGoOrders() {
        try {
            System.out.println("Those are the orders waiting to pick up: ");
            for (ToGo order : readyToGoOrders) {
                System.out.println(order);
            }
            System.out.println("Enter the number of the order that has been picked up: ");
            Scanner scanner = new Scanner(System.in);
            int orderNumber = scanner.nextInt();
            scanner.nextLine();
            for (ToGo toGoOrder : readyToGoOrders) {
                if (toGoOrder.getOrderNumber() == orderNumber) {
                    if (toGoOrder.getOrderHandler().getEmployeeId() == currentEmployee.getEmployeeId()) {
                        toGoOrder.assignPickUpTime();
                        readyToGoOrders.remove(toGoOrder);
                        history.add(toGoOrder);
                        System.out.println("Order picked up");
                        return;
                    }
                    System.out.println("You are not the handler of this order");
                    return;
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number.");
        }
    }

    /**
     * Analyze order.
     *
     * @param order the order
     */
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
            history.add(order);
            sendOrder(order);
            return;
        }
    }

    /**
     * Send order.
     *
     * @param order the order
     */
    public static void sendOrder(Order order){
        try {
            Socket socket = new Socket("192.168.1.103", 8080);
            //Socket socket = new Socket("localhost", 8080);
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            // Crear y enviar objeto al servidor
            oos.writeObject(order);
            System.out.println("Objeto enviado: " + order.getOrderNumber());
            for (Dish dish : order.getOrderedDishes()) {
                System.out.println(dish);
            }
            oos.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Main menu boolean.
     *
     * @return the boolean
     */
    public static boolean mainMenu() {
        System.out.println("1. Log in");
        System.out.println("2. Register");
        System.out.println("3. Exit");
        System.out.print(">>> ");
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        scanner.nextLine();
        switch (option) {
            case 1:
                if(employeesLogIn()) {
                    return true;
                }
                break;
            case 2:
                registerEmployee();
                mainMenu();
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option");
                break;
        }
        return false;
    }

    /**
     * Employee server menu.
     */
    public static void employeeServerMenu() {
        System.out.println("1. Check pending orders status");
        System.out.println("2. Check waiting to pick up orders status");
        System.out.println("3. Assign order handler");
        System.out.println("4. Manage orders");
        System.out.println("5. Daily report");
        System.out.println("6. Exit");
        System.out.print(">>> ");

        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        scanner.nextLine();
        switch (option) {
            case 1:
                checkOrdersStatus();
                break;
            case 2:
                if (readyToGoOrders.isEmpty()) {
                    System.out.println("There are no orders waiting to pick up");
                    break;
                }
                for (ToGo order : readyToGoOrders) {
                    System.out.println(order);
                }
                manageToGoOrders();
                break;
            case 3:
                assignOrderHandler();
                break;
            case 4:
                manageOrders();
                break;
            case 5:
                dailyReport();
                break;
            case 6:
                mainMenu();
                break;
            default:
                System.out.println("Invalid option");
                break;
        }
    }

    /**
     * Employees log in boolean.
     *
     * @return the boolean
     */
    public static boolean employeesLogIn() {
        try {
            System.out.println("Enter your employee ID: ");
            System.out.print(">>> ");
            Scanner scanner = new Scanner(System.in);
            int id = scanner.nextInt();
            scanner.nextLine();
            for (Employee employee : employees) {
                if (employee.getEmployeeId() == id) {
                    System.out.println("Enter your password");
                    System.out.print(">>> ");
                    String password = scanner.nextLine();
                    if (employee.getPassword().equals(password)) {
                        currentEmployee = employee;
                        System.out.println("Login successful");
                        System.out.println("Welcome " + currentEmployee.getName());
                        System.out.println("\n");
                        employeeServerMenu();
                        return true;
                    }
                    System.out.println("Invalid password");
                    return false;
                }
            }
            System.out.println("No user found");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid employee ID.");
        }
        return false;
    }

    /**
     * Register employee.
     */
    public static void registerEmployee() {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter your employee ID (this is the ID that will be used in this system: ");
            System.out.print(">>> ");
            int employeeId = scanner.nextInt();
            scanner.nextLine();

            for (Employee existingEmployee : employees) {
                if (existingEmployee.getEmployeeId() == employeeId) {
                    System.out.println("Employee with this ID is already registered.");
                    return;
                }
            }

            System.out.println("Enter your name: ");
            System.out.print(">>> ");
            String name = scanner.nextLine();

            System.out.println("Enter your last name: ");
            System.out.print(">>> ");
            String lastName = scanner.nextLine();

            System.out.println("Enter your gender: ");
            System.out.print(">>> ");
            String gender = scanner.nextLine();

            System.out.println("Enter your age: ");
            System.out.print(">>> ");
            int age = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Enter your ID: ");
            System.out.print(">>> ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Enter your cellphone number: ");
            System.out.print(">>> ");
            int cellphoneNumber = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Enter your password: ");
            System.out.print(">>> ");
            String password = scanner.nextLine();

            Employee newEmployee = new Employee(name, lastName, gender, age, id, cellphoneNumber, employeeId, password);
            employees.add(newEmployee);
            System.out.println("Employee registered successfully");
        } catch (java.util.InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid values.");
        }
    }

    /**
     * Daily report.
     */
    public static void dailyReport() {
        try {
            System.out.print("This is the income of the day: ");
            int income = 0;
            for (Order order : history) {
                income += order.getTotalPrice();
            }
            System.out.println(income);

            ArrayList<Dish> dishes = new ArrayList<Dish>();
            for (Order order : history) {
                for (Dish dish : order.getOrderedDishes()) {
                    if (!dishes.contains(dish)) {
                        dishes.add(dish);
                    } else {
                        for (Dish dish1 : dishes) {
                            if (dish1.equals(dish)) {
                                dish1.setTimesOrdered(dish1.getTimesOrdered() + 1);
                            }
                        }
                    }
                }
            }

            Comparator<Dish> comparator = Comparator.comparingInt(Dish::getTimesOrdered).reversed();
            Collections.sort(dishes, comparator);

            System.out.println("Those are the dishes sold today: ");
            for (Dish dish : dishes) {
                System.out.println(dish.getName() + " x" + dish.getTimesOrdered() + 1);
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Instantiates a new Server.
     *
     * @throws Exception the exception
     */
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

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main (String[] args) {
        Employee izack = new Employee("iZack", "Ramirez", "male", 18, 1, 88288680, 1, "1234");
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
                        Order receivedObject = ((Order) o.readObject());
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
                if (mainMenu()) {
                    break;
                }
            }
            while (true) {
                employeeServerMenu();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
