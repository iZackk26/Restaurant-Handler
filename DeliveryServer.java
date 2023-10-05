import Orders.Express;
import Orders.Order;
import Person.DeliveryDriver;
import Person.Employee;
import Person.Transportation;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DeliveryServer {
    static ArrayList<Express> readyExpressOrders = new ArrayList<Express>();
    static ArrayList<DeliveryDriver> deliveryDrivers = new ArrayList<DeliveryDriver>();
    static DeliveryDriver currentDriver = null;


    public static boolean checkRepeatedId(int id){
        for (DeliveryDriver driver : deliveryDrivers) {
            if (driver.getId() == id){
                return true;
            }
        }
        return false;
    }
    public static void registerUser(){
        int id;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name");
        System.out.print(">>> ");
        String name = scanner.nextLine();
        System.out.println("Enter your last name");
        System.out.print(">>> ");
        String lastName = scanner.nextLine();
        System.out.println("Enter your gender");
        System.out.print(">>> ");
        String gender = scanner.nextLine();
        System.out.println("Enter your age");
        System.out.print(">>> ");
        int age = scanner.nextInt();
        System.out.println("Enter your id");
        System.out.print(">>> ");
        scanner.nextLine();
        id = scanner.nextInt();
        if (checkRepeatedId(id)){
            System.out.println("This id is already registered");
            return;
        }
        scanner.nextLine();
        System.out.println("Enter your cellphone number");
        System.out.print(">>> ");
        int cellphoneNumber = scanner.nextInt();
        scanner.nextLine();;
        System.out.println("Enter your password");
        System.out.print(">>> ");
        String password = scanner.nextLine();
        System.out.println("Enter your vechicule plate number");
        System.out.print(">>> ");
        String plateNumber = scanner.nextLine();
        System.out.println("Enter your vechicule type");
        System.out.print(">>> ");
        String type = scanner.nextLine();
        Transportation transportation = new Transportation(plateNumber, type);
        DeliveryDriver driver = new DeliveryDriver(name, lastName, gender, age, id, cellphoneNumber, password, transportation);
        deliveryDrivers.add(driver);
        System.out.println("Driver created");
    }
    public static boolean login(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your id");
        int id = 0;
        try{
            System.out.print(">>> ");
            id = scanner.nextInt();
            scanner.nextLine();
        }
        catch (InputMismatchException e){
            System.out.println("Invalid option");
        }
        System.out.println("Enter your password");
        System.out.print(">>> ");
        String password = scanner.nextLine();
        for (DeliveryDriver driver: deliveryDrivers) {
            if (driver.getId() == id && driver.getPassword().equals(password)){
                currentDriver = driver;
                System.out.println("Login successful");
                System.out.println("Welcome " + currentDriver.getName());
                System.out.println("\n");
                return true;
            }
        }
        if (currentDriver == null){
            System.out.println("Invalid credentials");
        }
        return false;
    }


    public static void assingOrder() {
        System.out.println("Enter the number of the order you want to deliver: ");
        for (Express order : readyExpressOrders) {
            System.out.println(order);
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print(">>> ");
        int orderNumber = scanner.nextInt();
        scanner.nextLine();

        for (Express order : readyExpressOrders) {
            if (order.getOrderNumber() == orderNumber) {
                order.setDeliveryDriver(currentDriver);
            }
        }
    }


    public static void main (String[] args) {
        DeliveryDriver izack = new DeliveryDriver("iZack", "Ramírez", "Male",18, 1, 88288680, "1234", new Transportation("777Z", "Car"));
        deliveryDrivers.add(izack);
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
                        readyExpressOrders.add((Express) receivedObject);
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
                assingOrder();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
