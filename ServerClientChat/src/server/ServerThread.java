package server;

import java.io.*;
import java.net.Socket;

public class ServerThread extends Thread {
    private Socket socket = null;
    private DataInputStream in = null;
    private DataOutputStream out = null;

    ServerThread(Socket socket, DataInputStream in, DataOutputStream out) {
        this.socket = socket;
        this.in = in;
        this.out = out;
    }

    @Override
    public void run() {
        String receive;
        String toReturn;

        while (true) {
            try {

                out.writeUTF("Yes or No ?");

                receive = in.readUTF();

                if (receive.equals("quit")) {
                    System.out.println("Client" + this.socket + " sends exit...");
                    this.socket.close();
                    System.out.println("Connection closed");
                    break;
                }

                System.out.println(receive);

                switch (receive) {
                    case "Yes":
                        toReturn = "You said yes.";
                        out.writeUTF(toReturn);
                        break;
                    case "No":
                        toReturn = "You said no.";
                        out.writeUTF(toReturn);
                        break;

                    default:
                        toReturn = "invalid input";
                        out.writeUTF(toReturn);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }
}
