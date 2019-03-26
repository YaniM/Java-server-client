package Client;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) {
        Socket clientSocket;
        PrintWriter out;
        BufferedReader in;

        try {
            clientSocket = new Socket("192.168.3.115",8888);
            out = new PrintWriter(clientSocket.getOutputStream(),true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            while (true) {
                out.println("Here you are, Server.");
                ;
                System.out.println("Server says: " + in.readLine());
            }
        } catch (IOException e) {
            System.exit(1);
        }
    }
}
