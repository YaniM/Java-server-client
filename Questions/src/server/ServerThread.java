package server;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServerThread extends Thread {
    private Socket socket = null;
    private DataInputStream in = null;
    private DataOutputStream out = null;
    private List<Question> questions;

    public ServerThread(Socket socket, DataInputStream in, DataOutputStream out) throws FileNotFoundException {
        this.socket = socket;
        this.in = in;
        this.out = out;
        questions=readQuestions();
    }

    public static List<Question> readQuestions() throws FileNotFoundException {
        List<Question> questions = new ArrayList<>();
        Scanner scanner = new Scanner(new File("D:\\Java\\Questions\\src\\server\\questions.txt"));

        while (scanner.hasNextLine())
        {
            List<String> answers = new ArrayList<>();
            answers.add("Answer is 3");
            answers.add("Answer is 2");
            answers.add("Answer is 4");

            String line = scanner.nextLine();
            Question question = new Question(line,answers,3);
            questions.add(question);
        }
        return questions;
    }

    public void askQuestion(List<Question> q,int num) throws IOException {
        out.writeUTF(q.get(num).toString());
        out.flush();
    }

    @Override
    public void run() {
        int correct = 0;
        try {
            out.writeUTF("Enter your username:");

            String username = in.readUTF();

            if (!Server.loggedIn.contains(username)) {
                Server.loggedIn.add(username);
            } else {
                out.writeUTF("You already logged in.");
                out.flush();
                socket.close();
            }

            if(Server.doneTest.contains(username))
            {
                out.writeUTF("You have already done the test...");
                out.flush();
            }

            synchronized (this)
            {
                Server.doneTest.add(username);
            }

            for (int i = 0; i < questions.size(); i++) {
                askQuestion(questions,i);

                Integer answer = Integer.valueOf(in.readUTF());

                if(answer.equals(questions.get(i).getCorrectAnswer()))
                {
                    correct++;
                }
            }
            out.writeUTF("Correct answers: "+correct);
            out.flush();

            Server.loggedIn.remove(username);
            out.writeUTF("Done");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
