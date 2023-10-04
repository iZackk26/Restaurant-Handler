import Orders.*;
import Person.Costumer;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.awt.Desktop;
import java.io.File;
import java.io.*;
import java.net.*;

public class Client {
    static ArrayList<Costumer> costumerList = new ArrayList<>();
    static ArrayList<Dish> modifiedDishes = new ArrayList<>();
    static Costumer currentCostumer = null;
    static Menu healthyFoods = new Menu();
    static Menu mainDishes = new Menu();
    static Menu fastFood = new Menu();
    static Menu drinks = new Menu();
    static Menu desserts = new Menu();
    static ArrayList<Integer> tableNumbers = new ArrayList<>();

    public static void setMenu(){
        // Healthy Foods
        Dish salad = new Dish("green salad", "Salad de with lettuce, tomatoes, and cucumber", "10 minutes", 2850, false);
        Dish chickenSalad = new Dish("chicken salad", "Salad de with lettuce, tomatoes, cucumber, and chicken", "15 minutes", 4000, false);
        Dish grilledSalmon = new Dish("grilled salmon", "Salmon grilled with vegetables", "20 minutes", 10000, false);
        Dish bakedChicken = new Dish("baked chicken", "Chicken baked with vegetables", "25 minutes", 6500, false);
        Dish grilledFishTacos = new Dish("grilled fish tacos", "Fish tacos grilled with salad", "30 minutes", 7000, false);
        Dish spinachSalad = new Dish("spinach salad", "Salad de with spinach, tomatoes, and cucumber", "10 minutes", 3250, false);

        // Add dishes to the healthy foods menu
        healthyFoods.AddDish(salad);
        healthyFoods.AddDish(chickenSalad);
        healthyFoods.AddDish(grilledSalmon);
        healthyFoods.AddDish(bakedChicken);
        healthyFoods.AddDish(grilledFishTacos);
        healthyFoods.AddDish(spinachSalad);

        // Main dishes
        Dish chickenFingers = new Dish("chicken fingers", "Chicken fingers with french fries", "10 minutes", 4000, false);
        Dish grilledSalmonWithDilliSauce = new Dish("grilled salmon", "Freshly grilled salmon served with a creamy dill sauce, accompanied by steamed asparagus and garlic mashed potatoes","25 minutes", 8000, false );
        Dish beefFilletWithMushroomSauce = new Dish("beef fillet", "Beef fillet served with a mushroom sauce, accompanied by steamed asparagus and garlic mashed potatoes", "30 minutes", 9000, false);
        Dish roastChickenWithFreshHerbs = new Dish("roast chicken", "Roast chicken served with fresh herbs, accompanied by steamed asparagus and garlic mashed potatoes", "30 minutes", 7500, false);

        // Add dishes to the main dishes menu
        mainDishes.AddDish(chickenFingers);
        mainDishes.AddDish(grilledSalmonWithDilliSauce);
        mainDishes.AddDish(beefFilletWithMushroomSauce);
        mainDishes.AddDish(roastChickenWithFreshHerbs);

        // Fast Food
        Dish hamburger = new Dish("hamburger", "Hamburger with french fries", "10 minutes", 3000, false);
        Dish hotDog = new Dish("hot Dog", "Hot dog with french fries", "10 minutes", 2500, false);
        Dish pizza = new Dish("pizza", "Pizza with french fries", "10 minutes", 3500, false);
        Dish chickenNuggets = new Dish("chicken nuggets", "Chicken nuggets with french fries", "10 minutes", 3000, false);
        Dish frenchFries = new Dish("french fries", "French fries", "10 minutes", 1500, false);
        Dish chickenWings = new Dish("chicken wings", "Chicken wings with french fries", "10 minutes", 3000, false);

        // Add dishes to the fast food menu
        fastFood.AddDish(hamburger);
        fastFood.AddDish(hotDog);
        fastFood.AddDish(pizza);
        fastFood.AddDish(chickenNuggets);
        fastFood.AddDish(frenchFries);
        fastFood.AddDish(chickenWings);

        // Drinks
        Dish water = new Dish("water", "Water", "5 minutes", 500, false);
        Dish soda = new Dish("soda", "Soda", "5 minutes", 1000, false);
        Dish juice = new Dish("juice", "Juice", "5 minutes", 1500, false);
        Dish beer = new Dish("beer", "Beer", "5 minutes", 2000, false);

        // Add dishes to the drinks menu
        drinks.AddDish(water);
        drinks.AddDish(soda);
        drinks.AddDish(juice);
        drinks.AddDish(beer);

        // Desserts
        Dish iceCream = new Dish("ice cream", "Ice cream", "5 minutes", 2000, false);
        Dish cake = new Dish("cake", "Cake", "5 minutes", 2000, false);
        Dish brownie = new Dish("brownie", "Brownie", "5 minutes", 2000, false);
        Dish pie = new Dish("pie", "Pie", "5 minutes", 2000, false);
        Dish pudding = new Dish("pudding", "Pudding", "5 minutes", 2000, false);
        Dish cookies = new Dish("cookies", "Cookies", "5 minutes", 750, false);

        // Add dishes to the desserts menu
        desserts.AddDish(iceCream);
        desserts.AddDish(cake);
        desserts.AddDish(brownie);
        desserts.AddDish(pie);
        desserts.AddDish(pudding);
        desserts.AddDish(cookies);
    }
    public static void setTables(){
        for (int i = 1; i <= 40; i++) {
            tableNumbers.add(i);
        }
    }
    public static boolean checkTable(int tableNumber){
        for (Integer number : tableNumbers) {
            if (number == tableNumber) {
                return true;
            }
        }
        return false;
    }
    public static void printTables(){
        for (int i = 0; i < tableNumbers.size(); i++) {
            if (i % 5 == 0)
                System.out.println();
            System.out.print(tableNumbers.get(i) + " ");
        }
        System.out.println();
    }

    public static void openMenu(){
        try{
            String path = "Diagram/Menu.pdf";
            File file = new File(path);
            if (file.exists()){
                Desktop.getDesktop().open(file);
            }else{
                System.out.println("File doesn't exist");
            }
        }catch (Exception e){
            System.out.println("Error");
        }
    }
    public static boolean checkRepeatedId(int id){
        for (Costumer costumer: costumerList) {
            if (costumer.getId() == id){
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
        scanner.nextLine();
        System.out.println("Enter your province");
        System.out.print(">>> ");
        String province = scanner.nextLine();
        System.out.println("Enter your district");
        System.out.print(">>> ");
        String district = scanner.nextLine();
        System.out.println("Enter your address information");
        System.out.print(">>> ");
        String addressInformation = scanner.nextLine();
        System.out.println("Enter your password");
        System.out.print(">>> ");
        String password = scanner.nextLine();
        Costumer costumer = new Costumer(name, lastName, gender, age, id, cellphoneNumber, province, district, addressInformation, password);
        costumerList.add(costumer);
        System.out.println("Costumer created");
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
        for (Costumer costumer: costumerList) {
            if (costumer.getId() == id && costumer.getPassword().equals(password)){
                currentCostumer = costumer;
                System.out.println("Login successful");
                System.out.println("Welcome " + currentCostumer.getName());
                System.out.println("\n");
                return true;
            }
        }
        if (currentCostumer == null){
            System.out.println("Invalid credentials");
        }
        return false;
    }
    public static void checkModifiedMenu(){
        if (modifiedDishes.size() > 0){
            System.out.println("-----------------------");
            System.out.println("Modified dishes");
            for (Dish dish : modifiedDishes) {
                System.out.println(dish);
            }
            System.out.println("-----------------------");
            System.out.println("\n");
        }
    }

    public static ArrayList<Dish> order() {
        ArrayList<Dish> order = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        checkModifiedMenu();
        int option = 0;
        boolean exit = false;
        while (!exit) {
            System.out.println("1. Healthy foods");
            System.out.println("2. Main dishes");
            System.out.println("3. Fast food");
            System.out.println("4. Drinks");
            System.out.println("5. Desserts");
            System.out.println("6. Order details");
            System.out.println("7. Exit");
            try {
                System.out.print(">>> ");
                option = scanner.nextInt();
                if (option < 1 || option > 7) {
                    System.out.println("Invalid option");
                    continue;
                }
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Invalid option");
            }
            switch (option) {
                case 1 -> {
                    String dishName;
                    System.out.println("Healthy foods");
                    System.out.println("Enter the name of the dish");
                    System.out.print(">>> ");
                    dishName = scanner.nextLine();
                    String name = dishName.toLowerCase();
                    Dish dish = healthyFoods.searchDish(name);
                    if (dish != null) {
                        order.add(dish);
                        System.out.println("Dish added");
                    } else {
                        System.out.println("Dish not found");
                    }
                }
                case 2 -> {
                    String dishName;
                    System.out.println("Main dishes");
                    System.out.println("Enter the name of the dish");
                    System.out.print(">>> ");
                    dishName = scanner.nextLine();
                    String name = dishName.toLowerCase();
                    Dish dish = mainDishes.searchDish(name);
                    if (dish != null) {
                        order.add(dish);
                        System.out.println("Dish added");
                    } else {
                        System.out.println("Dish not found");
                    }
                }
                case 3 -> {
                    String dishName;
                    System.out.println("Fast food");
                    System.out.println("Enter the name of the dish");
                    System.out.print(">>> ");
                    dishName = scanner.nextLine();
                    String name = dishName.toLowerCase();
                    Dish dish = fastFood.searchDish(name);
                    if (dish != null) {
                        order.add(dish);
                        System.out.println("Dish added");
                    } else {
                        System.out.println("Dish not found");
                    }
                }
                case 4 -> {
                    String dishName;
                    System.out.println("Drinks");
                    System.out.println("Enter the name of the dish");
                    System.out.print(">>> ");
                    dishName = scanner.nextLine();
                    String name = dishName.toLowerCase();
                    Dish dish = drinks.searchDish(name);
                    if (dish != null) {
                        order.add(dish);
                        System.out.println("Dish added");
                    } else {
                        System.out.println("Dish not found");
                    }
                }
                case 5 -> {
                    String dishName;
                    System.out.println("Desserts");
                    System.out.println("Enter the name of the dish");
                    System.out.print(">>> ");
                    dishName = scanner.nextLine();
                    String name = dishName.toLowerCase();
                    Dish dish = desserts.searchDish(name);
                    if (dish != null) {
                        order.add(dish);
                        System.out.println("Dish added");
                    } else {
                        System.out.println("Dish not found");
                    }
                }
                case 6 -> {
                    System.out.println("Order details");
                    for (Dish dish : order) {
                        System.out.println(dish);
                    }
                    System.out.println("Total price: " + calculateTotalPrice(order));
                }
                case 7 -> {
                    exit = true;
                    System.out.println("Exit");
                }
                default -> System.out.println("Invalid option");
            }
        }
        return order;
    }
    public static void orderMenu(){
        openMenu();
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int orderNumber = random.nextInt(1000);
        LocalTime time = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String timeFormatted = time.format(formatter);
        ArrayList<Dish> orderList = new ArrayList<>();
        boolean exit = false;
        while (!exit) {
            System.out.println("1. Order");
            System.out.println("2. Complete order");
            System.out.println("3. Exit");
            int option = 0;
            try{
                System.out.print(">>> ");
                option = scanner.nextInt();
                scanner.nextLine();
            }
            catch (InputMismatchException e){
                System.out.println("Invalid option");
            }
            switch (option) {
                case 1 -> orderList = order();
                case 2 -> {
                    // Eating in
                    int totalPrice = calculateTotalPrice(orderList);
                    System.out.println("Does your order is for delivery, eating in or take out?");
                    System.out.println("1. Delivery");
                    System.out.println("2. Eating in");
                    System.out.println("3. Take out");
                    int option2 = 0;
                    try{
                        System.out.print(">>> ");
                        option2 = scanner.nextInt();
                        scanner.nextLine();
                    }
                    catch (InputMismatchException e){
                        System.out.println("Invalid option");
                    }
                    switch (option2) {
                        case 1 -> {
                            System.out.println("Enter your address");
                            String address = scanner.nextLine();
                            Express express = new Express(orderNumber, timeFormatted, totalPrice, address,currentCostumer );
                            express.setOrderList(orderList);
                            sendOrder(express);
                            orderNumber = random.nextInt(1000);
                            System.out.println("Order completed");
                        }
                        case 2 -> {
                            System.out.println("Tables:");
                            printTables();
                            System.out.println("Enter the table number");
                            int tableNumber = scanner.nextInt();
                            scanner.nextLine();
                            if (checkTable(tableNumber)) {
                                EatingIn eatingIn = new EatingIn(orderNumber, timeFormatted, totalPrice, tableNumber, currentCostumer);
                                eatingIn.setOrderList(orderList);
                                sendOrder(eatingIn);
                                orderNumber = random.nextInt(1000);
                                System.out.println("Order completed");
                            } else {
                                System.out.println("Invalid table number");
                            }
                        }
                        case 3 -> {
                            ToGo toGo = new ToGo(orderNumber, timeFormatted, totalPrice, currentCostumer);
                            toGo.setOrderList(orderList);
                            sendOrder(toGo);
                            orderNumber = random.nextInt(1000);
                            System.out.println("Order completed");
                        }
                        default -> System.out.println("Invalid option");
                    }
                }
                case 3 -> {
                    exit = true;
                    System.out.println("Exit");
                }
            }

        }
    }

    public static int calculateTotalPrice(ArrayList<Dish> order){
        int totalPrice = 0;
        for (Dish dish : order) {
            totalPrice += dish.getPrice();
        }
        return totalPrice;
    }

    public static void modifyMenu(Menu menu){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the dish you want to modify: ");
        System.out.print(">>> ");
        String dishName = scanner.nextLine().toLowerCase();

        Dish dish = menu.searchDish(dishName);
        if (dish == null){
            System.out.println("Dish not found");
            return;
        }

        System.out.println("What do you want to modify?");
        System.out.println("1. Name");
        System.out.println("2. Description");
        System.out.println("3. Estimated time");
        System.out.println("4. Price");
        System.out.println("5. Exit");
        int option;
        try {
            System.out.print(">>> ");
            option = scanner.nextInt();
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.nextLine();
            return;
        }
        switch (option) {
            case 1 -> {
                System.out.println("Enter the new name: ");
                System.out.print(">>> ");
                String newName = scanner.nextLine();
                dish.setName(newName);
            }
            case 2 -> {
                System.out.println("Enter the new description: ");
                System.out.print(">>> ");
                String newDescription = scanner.nextLine();
                dish.setDescription(newDescription);
            }
            case 3 -> {
                System.out.println("Enter the new estimated time: ");
                System.out.print(">>> ");
                String newEstimatedTime = scanner.nextLine();
                dish.setEstimatedTime(newEstimatedTime);
            }
            case 4 -> {
                System.out.println("Enter the new price: ");
                System.out.print(">>> ");
                int newPrice = scanner.nextInt();
                scanner.nextLine();
                dish.setPrice(newPrice);
            }
            case 5 -> {
                return;
            }
            default -> {
                System.out.println("Invalid option");
                return;
            }
        }
        modifiedDishes.add(dish);
        System.out.println("Dish modified");
    }

    public static void sendOrder(Order order){
        try {
            //Socket socket = new Socket("192.168.1.104", 8080);
            Socket socket = new Socket("localhost", 8080);
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

    public static void main(String[] args) {
        //sendOrder();
        setMenu();
        setTables();
        boolean exit = false;
        Costumer isaac = new Costumer("iZack", "Ramirez","Male", 18, 1, 88288680, "Alajuela", "San Ramon", "Las Lomas, 50 metros sur de la central de taxis", "2626");
        Costumer adrian = new Costumer("Adrian", "Villalobos", "Male", 18, 2, 78765896, "Alajuela", "San Ramon", "100 metros de la Jackson Memorial", "123");
        Costumer lorenzo = new Costumer("Jose","Lorenz", "Male", 20, 3, 89765722, "Guanacaste", "Tilarán", "100 metros del palo de mango", "123");
        costumerList.add(isaac);
        costumerList.add(adrian);
        costumerList.add(lorenzo);
        System.out.println("Welcome to Chakalito's Restaurant");
        while (!exit) {
            System.out.println("1. Register User");
            System.out.println("2. Login");
            System.out.println("3. Modify menu");
            System.out.println("4. Exit");
            Scanner scanner = new Scanner(System.in);
            int option = 0;
            try{
                System.out.print(">>> ");
                option = scanner.nextInt();
                scanner.nextLine();
            }
            catch (InputMismatchException e){
                System.out.println("Invalid type of data");
            }
            switch (option) {
                case 1 -> registerUser();
                case 2 -> {
                    if (login()) {
                        orderMenu();
                    }
                }
                case 3 -> {
                    System.out.println("What menu do you want to modify?");
                    System.out.println("1. Healthy foods");
                    System.out.println("2. Main dishes");
                    System.out.println("3. Fast food");
                    System.out.println("4. Drinks");
                    System.out.println("5. Desserts");
                    System.out.println("6. Exit");
                    int option2 = 0;
                    try{
                        System.out.print(">>> ");
                        option2 = scanner.nextInt();
                        scanner.nextLine();
                    }
                    catch (InputMismatchException e){
                        System.out.println("Invalid option");
                    }
                    switch (option2) {
                        case 1 -> modifyMenu(healthyFoods);
                        case 2 -> modifyMenu(mainDishes);
                        case 3 -> modifyMenu(fastFood);
                        case 4 -> modifyMenu(drinks);
                        case 5 -> modifyMenu(desserts);
                        case 6 -> {
                            exit = true;
                            System.out.println("Exit");
                        }
                        default -> System.out.println("Invalid option");
                    }
                }
                case 4 -> {
                    exit = true;
                    System.out.println("Exit");
                }
                default -> System.out.println("Invalid option");
            }
        }
    }

}
