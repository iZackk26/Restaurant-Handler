package Orders;

import java.io.Serializable;
import java.util.ArrayList;
import Person.Costumer;

/**
 * The type Eating in.
 */
public class EatingIn extends Order implements Serializable {
    /**
     * The number of the table associated with the order.
     */
    private int tableNumber;

    /**
     * Instantiates a new Eating in.
     *
     * @param orderId     the order id
     * @param orderDate   the order date
     * @param totalPrice  the total price
     * @param tableNumber the table number
     * @param costumer    the costumer
     */
    public EatingIn(int orderId, String orderDate, int totalPrice, int tableNumber, Costumer costumer) {
        super(orderId, orderDate, totalPrice, costumer);
        this.tableNumber = tableNumber;
    }

    /**
     * Instantiates a new Eating in.
     */
    public EatingIn() {
        super();
        this.tableNumber = 0;
    }

    /**
     * Gets table number.
     *
     * @return the table number
     */
    public int getTableNumber() {
        return tableNumber;
    }

    /**
     * Sets table number.
     *
     * @param tableNumber the table number
     */
    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
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
     * Sets costumer.
     *
     * @param costumer the costumer
     */
    public void setCostumer(Costumer costumer) {
        this.costumer = costumer;
    }
}
