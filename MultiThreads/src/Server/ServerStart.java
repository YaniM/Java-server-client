package Server;

public class ServerStart {
    public static void main(String[] args) {
        SocketServer socketServer = new SocketServer();

        socketServer.serverRun();
    }
}
