import java.io.BufferedReader;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int port = 8080;
        ServerSocket serverSocket = new ServerSocket(port);

        System.out.println("Server started on port " + port);

        Socket socket = serverSocket.accept();

        InputStream input = socket.getInputStream();

        BufferedReader reader = new BufferedReader(new InputStreamReader(input));

        String line = reader.readLine();
        System.out.println("Message from client: " + line);

        serverSocket.close();

        System.out.println("Server stopped");
    }
}
