package client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Scanner scn = new Scanner(System.in);
            Socket socket = new Socket("localhost",5056);
            DataInputStream in  = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            while (true)
            {
                System.out.println(in.readUTF());
                String tooSend = scn.nextLine();
                out.writeUTF(tooSend);

                if(tooSend.equals("quit"))
                {
                    System.out.println("Closing "+socket);
                    socket.close();
                    System.out.println("Closed");
                    break;
                }

                String received = in.readUTF();
                System.out.println(received);
            }
            scn.close();
            in.close();
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
