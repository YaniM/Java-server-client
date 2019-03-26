package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5056);

        while (true) {
            Socket s = null;
            try {
                s = serverSocket.accept();
                System.out.println("New client is connected.");

                DataInputStream in = new DataInputStream(s.getInputStream());
                DataOutputStream out = new DataOutputStream(s.getOutputStream());

                System.out.println("Assigning new thread for this client");

                Thread serverThread = new ServerThread(s,in,out);

                serverThread.start();

            } catch (IOException e) {
                s.close();
                System.out.println(e.getMessage());
            }
        }
    }
}
