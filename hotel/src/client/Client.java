package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {

        try {
            Socket socket = new Socket("localhost",5555);
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());
            Scanner scanner = new Scanner(System.in);

            String input = in.readUTF();
            System.out.println(input);
            String output = scanner.nextLine();
            out.writeUTF(output);
            if(output.toLowerCase().equals("reservation")) {
                input = in.readUTF();
                System.out.println(input);
                int offerID = Integer.parseInt(scanner.nextLine());

                out.writeInt(offerID);


                System.out.println(in.readUTF());
                out.writeUTF(scanner.nextLine());
                System.out.println(in.readUTF());
                out.writeUTF(scanner.nextLine());
                System.out.println(in.readUTF());
            }else if(output.toLowerCase().equals("raiting"))
            {
                System.out.println(in.readUTF());
                out.writeUTF(scanner.nextLine());
                System.out.println(in.readUTF());
                out.writeInt(Integer.parseInt(scanner.nextLine()));

                if(in.readBoolean())
                {
                    System.out.println(in.readUTF());
                    out.writeInt(Integer.parseInt(scanner.nextLine()));
                    System.out.println(in.readUTF());
                }else
                {
                    System.out.println("You haven't visited the hotel yet to evaluate or you have already evaluated it.");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
