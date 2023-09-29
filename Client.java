import Person.Costumer;

import java.util.ArrayList;
import java.util.Scanner;
public class Client {
    public static void main(String[] args) {
        System.out.println("Welcome to Chakalito's Restaurant");
        System.out.println("1. Register User");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        switch (option){
            case 1:
                System.out.println("Register User");
                break;
            case 2:
                System.out.println("Login");
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
        System.out.println("Are you a client or an employee?(C/E)");
        String option = scanner.nextLine();
        switch (option){
            case "C":
                System.out.println("Register Client");
                Costumer costumer = new Costumer();
            case "E":
                System.out.println("Register Employee");
                break;
            default:
                System.out.println("Invalid option");
                break;
        }


    }

}
