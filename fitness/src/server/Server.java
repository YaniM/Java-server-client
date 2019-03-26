package server;

import client.User;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    final static List<User> users = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ServerSocket  server = new ServerSocket(5000);

        while(true) {
            try {
                Socket socket = server.accept();
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                DataInputStream in = new DataInputStream(socket.getInputStream());

                ServerThread t = new ServerThread(socket, in, out);
                t.start();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
