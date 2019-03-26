package testChat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5555);

        while (true) {
            Socket socket = null;

            try {
                socket = serverSocket.accept();
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                Thread t = new ServerThread(socket, in, out);
                t.start();
            } catch (IOException e) {
                socket.close();
                System.out.println(e.getMessage());
            }
        }
    }

}
