import Orders.EatingIn;
import Orders.Express;
import Orders.Order;
import Orders.ToGo;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Server {
    static ArrayList<EatingIn> eatingInOrders = new ArrayList<EatingIn>();
    static ArrayList<ToGo> toGoOrders = new ArrayList<ToGo>();
    static ArrayList<Express> expressOrders = new ArrayList<Express>();

    public void checkEatingInOrders() {
        for (EatingIn order : eatingInOrders) {
            if (order.getStatus().equals("Completed")) {
                eatingInOrders.remove(order);
            }
        }
    }
}
