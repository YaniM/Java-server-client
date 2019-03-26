package client;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 5000);

            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter username:");

            String username = scanner.nextLine();

            out.writeUTF("lejanka");
            out.writeInt(20);
            out.writeUTF(username);

            System.out.println("First Weight: " + in.readDouble());
            System.out.println("Current Weight: " + in.readDouble());
            System.out.println("Total users: " + in.readInt());

            String asd = in.readUTF();
            if (asd.equals("Done"))
                return;

            socket.close();
            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
