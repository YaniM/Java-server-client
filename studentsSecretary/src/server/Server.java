package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

public class Server {
    static LinkedList<Document> standard = new LinkedList<>();
    static LinkedList<Document> special = new LinkedList<>();
    static LinkedList<Document> approved = new LinkedList<>();
    static LinkedList<Document> disapproved = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(1122);

        while (true) {
            try {
                Socket socket = server.accept();

                ServerThread t = new ServerThread(socket);
                t.start();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
