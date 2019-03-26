package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    ServerSocket serverSocket = null;

    public void serverRun() {
        try {
            serverSocket = new ServerSocket(8888);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            try {
                Socket socket = serverSocket.accept();
                ServerThread thread = new ServerThread(socket);
                thread.start();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
