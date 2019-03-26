package testChatclient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {

        Socket socket;


        try {
            Scanner scanner = new Scanner(System.in);
            socket = new Socket("localhost", 5555);
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());

            while (true) {
                String line = scanner.nextLine();

                out.writeUTF(line);

                if (line.equals("bye")) {
                    System.out.println("Closing " + socket);
                    socket.close();
                    System.out.println("Closed");
                    break;
                }

                line = in.readUTF();
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
