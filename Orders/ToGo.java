package Orders;
import Person.Costumer;

import java.io.Serializable;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ToGo extends Order implements Serializable {
    private String pickUpTime;
    private String pickUpDate;

    public ToGo(int orderId, String orderDate,int totalPrice, Costumer costumer) {
        super(orderId, orderDate, totalPrice, costumer);
        this.pickUpTime = "";
        this.pickUpDate = "";
    }

    public ToGo() {
        super();
        this.pickUpTime = "";
        this.pickUpDate = "";
    }

    // Methods
    public String getPickUpTime() {
        return pickUpTime;
    }

    public void setPickUpTime() {
        LocalTime time = LocalTime.now();
        DateTimeFormatter Date = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter hour = DateTimeFormatter.ofPattern("HH:mm:ss");
        this.pickUpDate = Date.format(time);
        this.pickUpTime = time.format(hour);
    }

    public String getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(String pickUpDate) {
        this.pickUpDate = pickUpDate;
    }
    public void setOrderList(ArrayList<Dish> orderList) {
        this.orderedDishes = orderList;
    }
    public ArrayList<Dish> getDishList() {
        return this.orderedDishes;
    }
}
