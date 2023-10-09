package Orders;

import Person.Costumer;
import Person.Employee;

import java.io.Serializable;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * The type Order.
 */
public abstract class Order implements Serializable {
    /**
     * The Order number.
     */
    protected int orderNumber;
    /**
     * The Initial time.
     */
    protected String initialTime;
    /**
     * The Estimated time.
     */
    protected int estimatedTime;
    /**
     * The Preparation time.
     */
    protected int preparationTime;
    /**
     * The Total price.
     */
    protected int totalPrice;
    /**
     * The Registration date.
     */
    protected String registrationDate;
    /**
     * The Status.
     */
    protected String status;
    /**
     * The Costumer.
     */
    public Costumer costumer;
    /**
     * The Order handler.
     */
    public Employee orderHandler;
    /**
     * The Ordered dishes.
     */
    public ArrayList<Dish> orderedDishes;

    /**
     * Instantiates a new Order.
     *
     * @param orderId     the order id
     * @param initialTime the initial time
     * @param totalPrice  the total price
     * @param costumer    the costumer
     */
    public Order(int orderId, String initialTime, int totalPrice, Costumer costumer) {
        this.orderNumber = orderId;
        this.initialTime = initialTime;
        this.totalPrice = totalPrice;
        this.costumer = costumer;
        this.registrationDate = "";
        this.status = "";
        this.orderedDishes = new ArrayList<Dish>();
    }

    /**
     * Instantiates a new Order.
     */

    /**
     * Calculate total price int.
     *
     * @return the int
     */
// Methods
    public int calculateTotalPrice() {
        return 0;
    }

    /**
     * Calculate total time string.
     *
     * @return the string
     */
    public String calculateTotalTime() {
        return "";
    }

    /**
     * Mark as completed.
     */
    public void MarkAsCompleted() {
    }

    /**
     * Mark as delivered.
     */
    public void MarkAsDelivered() {
    }

    /**
     * Gets order number.
     *
     * @return the order number
     */
    public int getOrderNumber() {
        return orderNumber;
    }

    /**
     * Sets order number.
     *
     * @param orderNumber the order number
     */
    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    /**
     * Gets initial time.
     *
     * @return the initial time
     */
    public String getInitialTime() {
        return initialTime;
    }

    /**
     * Sets initial time.
     *
     * @param initialTime the initial time
     */
    public void setInitialTime(String initialTime) {
        this.initialTime = initialTime;
    }

    /**
     * Gets total price.
     *
     * @return the total price
     */
    public int getTotalPrice() {
        return totalPrice;
    }

    /**
     * Sets total price.
     *
     * @param totalPrice the total price
     */
    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * Gets registration date.
     *
     * @return the registration date
     */
    public String getRegistrationDate() {
        return registrationDate;
    }

    /**
     * Sets registration date.
     *
     * @param registrationDate the registration date
     */
    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    /**
     * Gets status.
     *
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets order handler.
     *
     * @return the order handler
     */
    public Employee getOrderHandler() {
        return orderHandler;
    }

    /**
     * Sets order handler.
     *
     * @param orderHandler the order handler
     */
    public void setOrderHandler(Employee orderHandler) {
        this.orderHandler = orderHandler;
    }

    /**
     * Sets preparation time.
     *
     * @param preparationTime the preparation time
     */
    public void setPreparationTime(int preparationTime) {
        this.preparationTime = preparationTime;
    }

    /**
     * Gets preparation time.
     *
     * @return the preparation time
     */
    public int getPreparationTime() {
        return preparationTime;
    }

    /**
     * Show dishes.
     */
    public void showDishes() {
        for (Dish dish : orderedDishes) {
            System.out.println(dish);
        }
    }

    /**
     * Sets estimated time.
     *
     * @param estimatedTime the estimated time
     */
    public void setEstimatedTime(int estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    /**
     * Gets estimated time.
     *
     * @return the estimated time
     */
    public int getEstimatedTime() {
        return estimatedTime;
    }

    /**
     * Gets ordered dishes.
     *
     * @return the ordered dishes
     */
    public ArrayList<Dish> getOrderedDishes() {
        return orderedDishes;
    }

    /**
     * Sets ordered dishes.
     *
     * @param orderedDishes the ordered dishes
     */
    public void setOrderedDishes(ArrayList<Dish> orderedDishes) {
        this.orderedDishes = orderedDishes;
    }

    /**
     * Returns a string representation of the Order object.
     *
     * This method constructs and returns a string that includes information about the order,
     * such as the order number, order date, estimated preparation time, order status, order handler
     * (if assigned), and the list of ordered dishes.
     *
     * @return A string containing information about the order.
     */
    public String toString() {
        String result = "Order number: " + orderNumber + "\n" +
                "Order date: " + registrationDate + "\n" +
                "Order preparation time: " + estimatedTime + " minutes" +"\n" +
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
