package server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Scanner;

public class ServerThread extends Thread {
    Socket socket = null;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            out.writeUTF("Enter your username and password");

            String username = in.readUTF();
            String password = in.readUTF();

            if (username.equals("student") && password.equals("okey")) {
                out.writeUTF("1.Standart scolarship");
                out.writeUTF("2.Special scolarship");
                out.writeUTF("Enter a choice.");

                Scanner scanner = new Scanner(System.in);
                String input = scanner.nextLine();

                if (input.equals("1")) {
                    out.writeUTF("Send your document.");
                    Document document = (Document) in.readObject();
                    Server.standard.add(document);
                } else if (input.equals("2")) {
                    out.writeUTF("Send your document.");
                    Document document = (Document) in.readObject();
                    Server.special.add(document);
                }

            } else if (username.equals("secretary") && password.equals("secretartyok")) {
                out.writeUTF("1.Check standart scolarship");
                out.writeUTF("2.Check special scolarship");
                out.writeUTF("Enter a choice");
                Scanner scanner = new Scanner(System.in);
                String input = scanner.nextLine();

                if (input.equals("1")) {
                    Document document = null;
                    if (!Server.standard.isEmpty()) {
                        document = Server.standard.getFirst();
                    }
                    SecretaryThread t = new SecretaryThread(document,socket);
                    t.start();
                } else if (input.equals("2")) {
                    Document document = null;
                    if (!Server.special.isEmpty()) {
                        document = Server.special.getFirst();
                    }
                    SecretaryThread t = new SecretaryThread(document,socket);
                    t.start();
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
