package Orders;

import Person.Costumer;
import Person.DeliveryDriver;

import java.io.Serializable;
import java.util.ArrayList;

public class Express extends Order implements Serializable {
    private String deliveryAddress;
    private String estimatedDeliveryTime;
    private DeliveryDriver deliveryDriver;
    public Express(int orderNumber, String initialTime, int totalPrice, String deliveryAddress, Costumer costumer) {
        super(orderNumber, initialTime, totalPrice, costumer);
        this.deliveryAddress = deliveryAddress;
        this.estimatedDeliveryTime = "";
    }

    public Express() {
        super();
        this.deliveryAddress = "";
        this.estimatedDeliveryTime = "";
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getEstimatedDeliveryTime() {
        return estimatedDeliveryTime;
    }

    public void setEstimatedDeliveryTime(String estimatedDeliveryTime) {
        this.estimatedDeliveryTime = estimatedDeliveryTime;
    }
    public void setDeliveryDriver(DeliveryDriver deliveryDriver) {
        this.deliveryDriver = deliveryDriver;
    }
    public DeliveryDriver getDeliveryDriver() {
        return deliveryDriver;
    }
    public void setCostumer(Costumer costumer) {
        this.costumer = costumer;
    }
    public Costumer getCostumer() {
        return costumer;
    }
    public void setOrderList(ArrayList<Dish> orderList) {
        this.orderedDishes = orderList;
    }
    public ArrayList<Dish> getOrderList() {
        return orderedDishes;
    }

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
