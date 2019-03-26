package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class SecretaryThread extends Thread {
    Document document;
    Socket socket;

    public SecretaryThread(Document document, Socket socket) {
        this.document = document;
        this.socket = socket;
    }

    @Override
    public void run() {

        try {
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            out.writeUTF("Standart or special?");
            String type = in.readUTF();

            if(type.equals("standart"))
            {
                if (document.getDohod() < 500 && document.getUspeh() > 5.50 && document != null) {
                    int count = 0;
                    for (int i = 0; i < Server.approved.size(); i++) {
                        if (Server.approved.get(i).getName().equals(document.getName())) {
                            count++;
                        }
                    }
                    if (count >4) {
                        System.out.println("sorry no more stipendiq.");
                    }

                    synchronized (this) {
                        Server.standard.removeFirst();
                        Server.approved.addLast(document);
                    }
                } else {
                    synchronized (this) {
                        Server.disapproved.addLast(document);
                    }
                }
            }else if(type.equals("special"))
            {
                if (document.getDohod() < 300 && document.getUspeh() > 5.30 && document != null) {
                    int count = 0;
                    for (int i = 0; i < Server.approved.size(); i++) {
                        if (Server.approved.get(i).getName().equals(document.getName())) {
                            count++;
                        }
                    }
                    if (count > 5) {
                        System.out.println("sorry no more stipendiq.");
                    }

                    synchronized (this) {
                        Server.special.removeFirst();
                        Server.approved.addLast(document);
                    }
                } else {
                    synchronized (this) {
                        Server.disapproved.addLast(document);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
