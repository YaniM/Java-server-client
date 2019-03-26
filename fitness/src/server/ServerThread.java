package server;

import client.Machine;
import client.User;

import java.io.*;
import java.net.Socket;

public class ServerThread extends Thread {
    private DataInputStream in = null;
    private DataOutputStream out = null;
    private Socket socket = null;

    public ServerThread(Socket socket, DataInputStream in, DataOutputStream out) {
        this.socket = socket;
        this.in = in;
        this.out = out;
    }

    @Override
    public void run() {
        try {

            User user = new User();
            Machine machine = new Machine();
            machine.setId(in.readUTF());
            machine.setSeconds(in.readInt());
            user.setUsername(in.readUTF());
            user.setMachines(machine);

            if (Server.users.size() == 0) {
                user.setFirstWeight(50);
                user.setCurrentWeight(51);
                Server.users.add(user);
                out.writeDouble(user.getFirstWeight());
                out.writeDouble(user.getCurrentWeight());
                out.writeInt(Server.users.size());
                out.writeUTF("Done");
            } else {
                synchronized (this) {
                    for (User u : Server.users) {
                        if (user.getUsername().equals(u.getUsername())) {
                            u.setCurrentWeight(u.getCurrentWeight() + 1);
                            out.writeDouble(u.getFirstWeight());
                            out.writeDouble(u.getCurrentWeight());
                            out.writeInt(Server.users.size());
                            out.writeUTF("Done");
                            return;
                        }
                    }
                    user.setFirstWeight(50);
                    user.setCurrentWeight(51);
                    Server.users.add(user);
                    out.writeDouble(user.getFirstWeight());
                    out.writeDouble(user.getCurrentWeight());
                    out.writeInt(Server.users.size());
                    out.writeUTF("Done");
                }
            }


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
