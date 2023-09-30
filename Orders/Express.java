package Orders;

import Person.DeliveryDriver;

public class Express extends Order{
    private String deliveryAddress;
    private String estimatedDeliveryTime;

    public Express(int orderId, String orderDate, String orderTime, String orderStatus, String deliveryAddress, String estimatedDeliveryTime) {
        super(orderId, orderDate, orderTime, orderStatus);
        this.deliveryAddress = deliveryAddress;
        this.estimatedDeliveryTime = estimatedDeliveryTime;
    }

    public Express() {
        super();
        this.deliveryAddress = "";
        this.estimatedDeliveryTime = "";
    }
    public DeliveryDriver deliveryDriver;

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
}
