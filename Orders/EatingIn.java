package Orders;

import java.util.ArrayList;
import Person.Costumer;

public class EatingIn extends Order{
    private int tableNumber;

    // Methods

    public EatingIn(int orderId, String orderDate, int totalPrice, int tableNumber, Costumer costumer) {
        super(orderId, orderDate, totalPrice, costumer);
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
    public void setOrderList(ArrayList<Dish> orderList) {
        this.orderedDishes = orderList;
    }
    public void setCostumer(Costumer costumer) {
        this.costumer = costumer;
    }
}
