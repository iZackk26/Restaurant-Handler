import Orders.Dish;
import Orders.Menu;
import Person.Costumer;

import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    static ArrayList<Costumer> costumerList = new ArrayList<Costumer>();
    static Costumer currentCostumer = null;
    static Menu healthyFoods = new Menu();
    static Menu mainDishes = new Menu();
    static Menu fastFood = new Menu();
    static Menu drinks = new Menu();
    static Menu desserts = new Menu();
    public static void main(String[] args) {
        setMenu();
        Costumer isaac = new Costumer("iZack", "Ramirez","Male", 18, 1, 88288680, "Alajuela", "San Ramon", "Las lomas, 50 metros sur de la central de taxis", "123");
        costumerList.add(isaac);
        System.out.println("Welcome to Chakalito's Restaurant");
        System.out.println("1. Register User");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        switch (option){
            case 1:
                registerUser();
                break;
            case 2:
                if (login()){
                    menu();
                }
                break;
            case 3:
                System.out.println("Exit");
                break;
            default:
                System.out.println("Invalid option");
                break;
        }
    }

    public static void registerUser(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name");
        String name = scanner.nextLine();
        System.out.println("Enter your last name");
        String lastName = scanner.nextLine();
        System.out.println("Enter your gender");
        String gender = scanner.nextLine();
        System.out.println("Enter your age");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter your id");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter your cellphone number");
        int cellphoneNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter your province");
        String province = scanner.nextLine();
        System.out.println("Enter your district");
        String district = scanner.nextLine();
        System.out.println("Enter your address information");
        String addressInformation = scanner.nextLine();
        System.out.println("Enter your password");
        String password = scanner.nextLine();
        Costumer costumer = new Costumer(name, lastName, gender, age, id, cellphoneNumber, province, district, addressInformation, password);
        costumerList.add(costumer);
        System.out.println("Costumer created");
    }

    public static boolean login(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your id");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter your password");
        String password = scanner.nextLine();
        for (Costumer costumer: costumerList) {
            if (costumer.getId() == id && costumer.getPassword().equals(password)){
                currentCostumer = costumer;
                System.out.println("Login successful");
                return true;
            }
        }
        if (currentCostumer == null){
            System.out.println("Invalid credentials");
        }
        return false;
    }

    public static void menu(){
        int repeatedTimes = 0;
        System.out.println("1. Order");
        if (repeatedTimes > 0) {
            System.out.println("2. See order");
        }
        System.out.println("3. Exit");
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        scanner.nextLine();
        switch (option){
            case 1:
                //order();
                break;
            case 2:
                //seeOrder();
                break;
            case 3:
                System.out.println("Exit");
                break;
            default:
                System.out.println("Invalid option");
                break;
        }
    }

    public static void setMenu(){
        // Healthy Foods
        Dish salad = new Dish("Green Salad", "Salad de with lettuce, tomatoes, and cucumber", "10 minutes", 2850, false);
        Dish chickenSalad = new Dish("Chicken Salad", "Salad de with lettuce, tomatoes, cucumber, and chicken", "15 minutes", 4000, false);
        Dish grilledSalmon = new Dish("Grilled Salmon", "Salmon grilled with vegetables", "20 minutes", 10000, false);
        Dish bakedChicken = new Dish("Baked Chicken", "Chicken baked with vegetables", "25 minutes", 6500, false);
        Dish grilledFishTacos = new Dish("Grilled Fish Tacos", "Fish tacos grilled with salad", "30 minutes", 7000, false);
        Dish spinachSalad = new Dish("Spinach Salad", "Salad de with spinach, tomatoes, and cucumber", "10 minutes", 3250, false);

        // Add dishes to the healthy foods menu
        healthyFoods.AddDish(salad);
        healthyFoods.AddDish(chickenSalad);
        healthyFoods.AddDish(grilledSalmon);
        healthyFoods.AddDish(bakedChicken);
        healthyFoods.AddDish(grilledFishTacos);
        healthyFoods.AddDish(spinachSalad);

        // Main dishes
        Dish chickenFingers = new Dish("Chicken Fingers", "Chicken fingers with french fries", "10 minutos", 4000, false);
        Dish grilledSalmonWithDilliSauce = new Dish("Grilled Salmon with Dill Sauce", "Freshly grilled salmon served with a creamy dill sauce, accompanied by steamed asparagus and garlic mashed potatoes","25 minutes", 8000, false );
        Dish beefFilletWithMushroomSauce = new Dish("Beef Fillet with Mushroom Sauce", "Beef fillet served with a mushroom sauce, accompanied by steamed asparagus and garlic mashed potatoes", "30 minutes", 9000, false);
        Dish roastChickenWithFreshHerbs = new Dish("Roast Chicken with Fresh Herbs", "Roast chicken served with fresh herbs, accompanied by steamed asparagus and garlic mashed potatoes", "30 minutes", 7500, false);

        // Add dishes to the main dishes menu
        mainDishes.AddDish(chickenFingers);
        mainDishes.AddDish(grilledSalmonWithDilliSauce);
        mainDishes.AddDish(beefFilletWithMushroomSauce);
        mainDishes.AddDish(roastChickenWithFreshHerbs);

        // Fast Food
        Dish hamburger = new Dish("Hamburger", "Hamburger with french fries", "10 minutes", 3000, false);
        Dish hotDog = new Dish("Hot Dog", "Hot dog with french fries", "10 minutes", 2500, false);
        Dish pizza = new Dish("Pizza", "Pizza with french fries", "10 minutes", 3500, false);
        Dish chickenNuggets = new Dish("Chicken Nuggets", "Chicken nuggets with french fries", "10 minutes", 3000, false);
        Dish frenchFries = new Dish("French Fries", "French fries", "10 minutes", 1500, false);
        Dish chickenWings = new Dish("Chicken Wings", "Chicken wings with french fries", "10 minutes", 3000, false);

        // Add dishes to the fast food menu
        fastFood.AddDish(hamburger);
        fastFood.AddDish(hotDog);
        fastFood.AddDish(pizza);
        fastFood.AddDish(chickenNuggets);
        fastFood.AddDish(frenchFries);
        fastFood.AddDish(chickenWings);

        // Drinks
        Dish water = new Dish("Water", "Water", "5 minutes", 500, false);
        Dish soda = new Dish("Soda", "Soda", "5 minutes", 1000, false);
        Dish juice = new Dish("Juice", "Juice", "5 minutes", 1500, false);
        Dish beer = new Dish("Beer", "Beer", "5 minutes", 2000, false);

        // Add dishes to the drinks menu
        drinks.AddDish(water);
        drinks.AddDish(soda);
        drinks.AddDish(juice);
        drinks.AddDish(beer);

        // Desserts
        Dish iceCream = new Dish("Ice Cream", "Ice cream", "5 minutes", 2000, false);
        Dish cake = new Dish("Cake", "Cake", "5 minutes", 2000, false);
        Dish brownie = new Dish("Brownie", "Brownie", "5 minutes", 2000, false);
        Dish pie = new Dish("Pie", "Pie", "5 minutes", 2000, false);
        Dish pudding = new Dish("Pudding", "Pudding", "5 minutes", 2000, false);
        Dish cookies = new Dish("Cookies", "Cookies", "5 minutes", 750, false);

        // Add dishes to the desserts menu
        desserts.AddDish(iceCream);
        desserts.AddDish(cake);
        desserts.AddDish(brownie);
        desserts.AddDish(pie);
        desserts.AddDish(pudding);
        desserts.AddDish(cookies);
    }

    public static void order(){

    }


}
