package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerThread extends Thread {
    private Socket socket=null;
    private DataOutputStream out = null;
    private DataInputStream in = null;

    public ServerThread(Socket socket,DataOutputStream out,DataInputStream in)
    {
        this.socket=socket;
        this.out=out;
        this.in=in;
    }

    @Override
    public void run()
    {
        try{
            out.writeUTF("Reservation or raiting ?");

            String input = in.readUTF();

            if(input.toLowerCase().equals("reservation"))
            {
                out.writeUTF("Enter your destination: (Currently available Sofia - id:1)");
                int offerId = in.readInt();
                out.writeUTF("Enter your email:");
                String email = in.readUTF();
                out.writeUTF("Enter your password:");
                String password = in.readUTF();

                User user = new User();
                user.setEmail(email);
                user.setPassword(password);
                List<Grade> grades = new ArrayList<>();
                Grade grade = new Grade();
                grade.setOfferId(offerId);
                grade.setEvaluation(false);
                grades.add(grade);
                user.setGrades(grades);
                Server.users.add(user);
                Server.grades.add(grade);

                out.writeUTF("Your reservation has been made.");
            }else if (input.toLowerCase().equals("raiting"))
            {
                out.writeUTF("Send email:");
                String email = in.readUTF();
                out.writeUTF("Send offer id you have chosen:");
                int offerId = in.readInt();

                for (User user : Server.users) {
                    if(user.getEmail().equals(email))
                    {
                        for (Grade grade : user.getGrades()) {
                            if(grade.getOfferId()==offerId && !grade.isEvaluation())
                            {
                                out.writeBoolean(true);
                                out.writeUTF("Enter your grade (1-6)");
                                grade.setEvaluation(true);
                                int evaluation = in.readInt();
                                for (Offer offer : Server.offers) {
                                    if(offer.getOfferId()==offerId)
                                    {
                                        offer.getEvaluation().add(evaluation);
                                        double sum = 0;
                                        for (Integer integer : offer.getEvaluation()) {
                                            sum+=integer;
                                        }
                                        sum=sum/offer.getEvaluation().size();
                                        offer.setRating(sum);
                                        out.writeUTF("Average raiting is: " +sum);
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }

                out.writeBoolean(false);


            }



        }catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
