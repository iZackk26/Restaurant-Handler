import Orders.Order;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Server {

    ArrayList<Order> orders = new ArrayList<Order>();
    public static void main(String[] args) throws IOException {
        int port = 8080;
        ServerSocket serverSocket = new ServerSocket(port);
        try {
            while (true){
                System.out.println("Server started on port " + port);

                Socket socket = serverSocket.accept();

                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                Order objetoRecibido = (Order) objectInputStream.readObject();


                System.out.println("Server stopped");
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
