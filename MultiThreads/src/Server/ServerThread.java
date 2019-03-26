package Server;

import java.io.*;
import java.net.Socket;

public class ServerThread extends Thread {

    private Socket clientSocket = null;


    public ServerThread(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {

        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);

            String line;

            line = in.readLine();
            System.out.println(line);
            out.println("Thank you!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
