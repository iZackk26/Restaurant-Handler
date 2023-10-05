package Orders;

import Person.Costumer;
import Person.Employee;

import java.io.Serializable;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public abstract class Order implements Serializable {
    protected int orderNumber;
    protected String initialTime;
    protected int estimatedTime;
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
        this.orderedDishes = new ArrayList<Dish>();
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
    public void setEstimatedTime(int estimatedTime) {
        this.estimatedTime = estimatedTime;
    }
    public int getEstimatedTime() {
        return estimatedTime;
    }

    public ArrayList<Dish> getOrderedDishes() {
        return orderedDishes;
    }
    public void setOrderedDishes(ArrayList<Dish> orderedDishes) {
        this.orderedDishes = orderedDishes;
    }
    public String toString() {
        String result = "Order number: " + orderNumber + "\n" +
                "Order date: " + registrationDate + "\n" +
                "Order time: " + initialTime + "\n" +
                "Order status: " + status + "\n";

        if (orderHandler != null) {
            result += "Order handler: " + orderHandler.getName() + "\n";
        } else {
            result += "Not affiliated to any handler yet\n";
        }

        result += "Ordered dishes: \n";
        for (Dish dish : orderedDishes) {
            result += dish + "\n";
        }

        return result;
    }


}
