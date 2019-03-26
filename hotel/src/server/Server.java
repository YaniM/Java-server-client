package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    final static List<User> users = new ArrayList<>();
    final static List<Offer> offers = new ArrayList<>();
    final static List<Grade> grades = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(5555);

        Offer offer = new Offer(1,"Sofia","Kapri",90.00,8.6,new ArrayList<>());
        offers.add(offer);

        while (true)
        {
            try {
                Socket socket = serverSocket.accept();
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                DataInputStream in = new DataInputStream(socket.getInputStream());

                ServerThread t  = new ServerThread(socket,out,in);

                t.start();
            }catch (IOException e)
            {
                System.out.println(e.getMessage());
            }
        }
    }
}
