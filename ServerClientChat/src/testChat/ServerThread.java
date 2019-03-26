package testChat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ServerThread extends Thread {
    private DataInputStream in = null;
    private DataOutputStream out = null;
    private Socket socket = null;
    private Scanner scanner = new Scanner(System.in);

    public ServerThread(Socket socket,DataInputStream in,DataOutputStream out)
    {
        this.in = in;
        this.socket = socket;
        this.out = out;
    }

    @Override
    public void run()
    {
        while (true)
        {
            try {

                String line = in.readUTF();

                System.out.println(line);

                if(line.equals("bye"))
                {
                    System.out.println("Client " + this.socket + " says bye.");
                    socket.close();
                    System.out.println("Closed connection.");
                    break;
                }
                line=scanner.nextLine();
                out.writeUTF(line);


            }catch (IOException e)
            {
                System.out.println(e.getMessage());
            }
        }
    }
}
