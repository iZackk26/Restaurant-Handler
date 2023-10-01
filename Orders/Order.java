package Orders;

import Person.Costumer;
import Person.Employee;
import java.util.ArrayList;

public class Order {
    private int orderNumber;
    private String initialTime;
    private int totalPrice;
    private String registrationDate;
    private String status;
    public Costumer costumer;
    public Employee orderHandler;
    public ArrayList<Dish> orderedDishes;
    public Order(int orderId, String orderDate, String orderTime) {
        this.orderNumber = orderId;
        this.initialTime = orderTime;
        this.totalPrice = 0;
        this.registrationDate = orderDate;
        this.status = "Pending";
        this.orderHandler = null;
        this.orderedDishes = new ArrayList<Dish>();
        this.costumer = null;
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
}
