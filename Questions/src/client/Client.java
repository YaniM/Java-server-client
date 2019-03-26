package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Socket socket;

        try {
            socket = new Socket("localhost",5000);
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            while (true)
            {
                String received = in.readUTF();
                System.out.println(received);

                String send = scanner.nextLine();
                out.writeUTF(send);

                if(received.equals("Done"))
                {
                    System.out.println("Connection is closing");
                    socket.close();
                    in.close();
                    out.close();
                    break;
                }
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
