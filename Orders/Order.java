package Orders;

public class Order {
    private int orderNumber;
    private String initialTime;
    private int totalPrice;
    private String registrationDate;
    private String status;

    public Order(int orderId, String orderDate, String orderTime, String orderStatus) {
        this.orderNumber = orderId;
        this.initialTime = orderTime;
        this.totalPrice = 0;
        this.registrationDate = orderDate;
        this.status = orderStatus;
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
}
