package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    final static List<String> loggedIn = new ArrayList<>();
    final static List<String> doneTest = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(5000);

        while (true)
        {
            Socket socket = null;

            try {
                socket = server.accept();
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                ServerThread t = new ServerThread(socket,in,out);
                t.start();
            }catch (IOException e)
            {
                System.out.println(e.getMessage());
            }
        }
    }
}
