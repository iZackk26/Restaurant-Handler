package Orders;

public class ToGo extends Order{
    private String pickUpTime;
    private String pickUpDate;

    public ToGo(int orderId, String orderDate, String orderTime) {
        super(orderId, orderDate, orderTime);
    }

    public ToGo() {
        super();
        this.pickUpTime = "";
        this.pickUpDate = "";
    }

    // Methods
    public void MarkAsPickedUp() {
    }

    public void MarkAsReady() {
    }

    public String getPickUpTime() {
        return pickUpTime;
    }

    public void setPickUpTime(String pickUpTime) {
        this.pickUpTime = pickUpTime;
    }

    public String getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(String pickUpDate) {
        this.pickUpDate = pickUpDate;
    }
}
