package Orders;

public class EatingIn extends Order{
    private int tableNumber;

    // Methods

    public EatingIn(int orderId, String orderDate, String orderTime, String orderStatus, int tableNumber) {
        super(orderId, orderDate, orderTime, orderStatus);
        this.tableNumber = tableNumber;
    }

    public EatingIn() {
        super();
        this.tableNumber = 0;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }
    public void MarkAsServed() {
    }
}
