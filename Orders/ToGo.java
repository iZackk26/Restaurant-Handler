package Orders;
import Person.Costumer;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * The type To go.
 */
public class ToGo extends Order implements Serializable {
    /**
     * The time at which the order is scheduled for pickup.
     */
    private String pickUpTime;

    /**
     * The date on which the order is scheduled for pickup.
     */
    private String pickUpDate;

    /**
     * Instantiates a new To go.
     *
     * @param orderId    the order id
     * @param orderDate  the order date
     * @param totalPrice the total price
     * @param costumer   the costumer
     */
    public ToGo(int orderId, String orderDate,int totalPrice, Costumer costumer) {
        super(orderId, orderDate, totalPrice, costumer);
        this.pickUpTime = "";
        this.pickUpDate = "";
    }

    /**
     * Instantiates a new To go.
     */
    //public ToGo() {
        //super();
        //this.pickUpTime = "";
        //this.pickUpDate = "";
    //}

    /**
     * Gets pick up time.
     *
     * @return the pick up time
     */
// Methods
    public String getPickUpTime() {
        return pickUpTime;
    }

    /**
     * Gets pick up date.
     *
     * @return the pick up date
     */
    public String getPickUpDate() {
        return pickUpDate;
    }

    /**
     * Sets pick up date.
     *
     * @param pickUpDate the pick up date
     */
    public void setPickUpDate(String pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    /**
     * Sets order list.
     *
     * @param orderList the order list
     */
    public void setOrderList(ArrayList<Dish> orderList) {
        this.orderedDishes = orderList;
    }

    /**
     * Gets dish list.
     *
     * @return the dish list
     */
    public ArrayList<Dish> getDishList() {
        return this.orderedDishes;
    }

    /**
     * Assign pick up time.
     */
    public void assignPickUpTime() {
        LocalTime time = LocalTime.now();
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter hour = DateTimeFormatter.ofPattern("HH:mm:ss");
        this.pickUpTime = time.format(hour);
        this.pickUpDate = date.format(formatter);
    }
}
