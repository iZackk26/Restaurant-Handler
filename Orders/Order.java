package Orders;

import Person.Costumer;
import Person.Employee;
import java.util.ArrayList;

public abstract class Order {
    protected int orderNumber;
    protected String initialTime;
    protected int totalPrice;
    protected String registrationDate;
    protected String status;
    public Costumer costumer;
    public Employee orderHandler;
    public ArrayList<Dish> orderedDishes;
    public Order(int orderId, String initialTime, int totalPrice, Costumer costumer) {
        this.orderNumber = orderId;
        this.initialTime = initialTime;
        this.totalPrice = totalPrice;
        this.registrationDate = "";
        this.status = "";
    }

    public Order() {
        this.orderNumber = 0;
        this.initialTime = "";
        this.totalPrice = 0;
        this.registrationDate = "";
        this.status = "";
    }

    // Methods
    public int calculateTotalPrice() {
        return 0;
    }
    public String calculateTotalTime() {
        return "";
    }
    public void MarkAsCompleted() {
    }
    public void MarkAsDelivered() {
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getInitialTime() {
        return initialTime;
    }

    public void setInitialTime(String initialTime) {
        this.initialTime = initialTime;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Employee getOrderHandler() {
        return orderHandler;
    }

    public void setOrderHandler(Employee orderHandler) {
        this.orderHandler = orderHandler;
    }

    public void showDishes() {
        for (Dish dish : orderedDishes) {
            System.out.println(dish);
        }
    }

    public void getOrderedDishes() {
        for (Dish dish : orderedDishes) {
            System.out.println(dish);
        }
    }
    public void setOrderedDishes(ArrayList<Dish> orderedDishes) {
        this.orderedDishes = orderedDishes;
    }

    public void ToString() {
        System.out.println("Order number: " + orderNumber);
        System.out.println("Order date: " + registrationDate);
        System.out.println("Order time: " + initialTime);
        System.out.println("Order status: " + status);
        System.out.println("Order handler: " + orderHandler);
        System.out.println("Ordered dishes: ");
        for (Dish dish : orderedDishes) {
            System.out.println(dish);
        }
    }
}
