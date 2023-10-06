package Orders;

import Person.Costumer;
import Person.DeliveryDriver;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * The type Express.
 */
public class Express extends Order implements Serializable {
    /**
     * A unique identifier for serialization purposes.
     */
    private static final long serialVersionUID = 6321314560512687141L;

    /**
     * The delivery address where the order is to be delivered.
     */
    private String deliveryAddress;

    /**
     * The estimated delivery time for the order.
     */
    private String estimatedDeliveryTime;

    /**
     * The delivery driver responsible for delivering the order.
     */
    private DeliveryDriver deliveryDriver;

    /**
     * Instantiates a new Express.
     *
     * @param orderNumber     the order number
     * @param initialTime     the initial time
     * @param totalPrice      the total price
     * @param deliveryAddress the delivery address
     * @param costumer        the costumer
     */
    public Express(int orderNumber, String initialTime, int totalPrice, String deliveryAddress, Costumer costumer) {
        super(orderNumber, initialTime, totalPrice, costumer);
        this.deliveryAddress = deliveryAddress;
    }

    /**
     * Instantiates a new Express.
     */
    public Express() {
        super();
        this.deliveryAddress = "";
        this.estimatedDeliveryTime = "";
    }

    /**
     * Gets delivery address.
     *
     * @return the delivery address
     */
    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    /**
     * Sets delivery address.
     *
     * @param deliveryAddress the delivery address
     */
    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    /**
     * Gets estimated delivery time.
     *
     * @return the estimated delivery time
     */
    public String getEstimatedDeliveryTime() {
        return estimatedDeliveryTime;
    }

    /**
     * Sets estimated delivery time.
     *
     * @param estimatedDeliveryTime the estimated delivery time
     */
    public void setEstimatedDeliveryTime(String estimatedDeliveryTime) {
        this.estimatedDeliveryTime = estimatedDeliveryTime;
    }

    /**
     * Sets delivery driver.
     *
     * @param deliveryDriver the delivery driver
     */
    public void setDeliveryDriver(DeliveryDriver deliveryDriver) {
        this.deliveryDriver = deliveryDriver;
    }

    /**
     * Gets delivery driver.
     *
     * @return the delivery driver
     */
    public DeliveryDriver getDeliveryDriver() {
        return deliveryDriver;
    }

    /**
     * Sets costumer.
     *
     * @param costumer the costumer
     */
    public void setCostumer(Costumer costumer) {
        this.costumer = costumer;
    }

    /**
     * Gets costumer.
     *
     * @return the costumer
     */
    public Costumer getCostumer() {
        return costumer;
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
     * Gets order list.
     *
     * @return the order list
     */
    public ArrayList<Dish> getOrderList() {
        return orderedDishes;
    }

    /**
     * Returns a string representation of the Express object.
     *
     * This method constructs and returns a string that includes various attributes of the Express
     * object, such as delivery address, estimated delivery time, delivery driver, customer, ordered
     * dishes, order number, initial time, and total price.
     *
     * @return A string containing the attributes of the Express object.
     */
    @Override
    public String toString() {
        return "Express{" +
                "deliveryAddress='" + deliveryAddress + '\'' +
                ", estimatedDeliveryTime='" + estimatedDeliveryTime + '\'' +
                ", deliveryDriver=" + deliveryDriver +
                ", costumer=" + costumer +
                ", orderedDishes=" + orderedDishes +
                ", orderNumber=" + orderNumber +
                ", initialTime='" + initialTime + '\'' +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
