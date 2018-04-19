package model.prank;

import com.sun.org.apache.xpath.internal.SourceTree;
import data.MailCorpus;
import data.MailCorpusList;
import data.Victim;
import data.VictimsList;
import model.mail.Group;
import model.mail.Mail;
import smtp.SmtpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

public class PrankGenerator {

    protected static final Logger LOG = Logger.getLogger(PrankGenerator.class.getName());

    private static VictimsList victimsList;
    private static List<Group> groupList;
    private static MailCorpusList mcList;
    private int groupsNumber = 0;

    private List<Mail> pranks;

    /*
    public PrankGenerator(String filenameVictims, String filenameMailCorpuses) throws IllegalArgumentException{
        victimsList = new VictimsList( filenameVictims );
        if(victimsList.getVictims().size() < 3){
            throw new IllegalArgumentException("Not enough people in your victim list!");
        }
        mcList = new MailCorpusList( filenameMailCorpuses );
        groupList = new ArrayList<Group>();
    }
    */

    public PrankGenerator() {
        groupList = new ArrayList<Group>();
        pranks = new ArrayList<Mail>();
    }


    public List<Mail> generate() throws IOException {

        boolean goodInput;
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welcome in our generator of pranks. First, select");

        System.out.println("Do you want to provide a victim list? (Y/N)");

        do{

            goodInput = true;

            line = br.readLine();
            if(!line.equals("Y") && !line.equals("N")){
                goodInput = false;
                System.out.println("Please use Y for \"yes\" and N for \"no\".");
                System.out.println("Try again: do you want to provide a victim list?");
            }

        } while (!goodInput);

        if(line.equals("N")){
            victimsList = new VictimsList();
        }else{
            System.out.println("Please provide the name of your file:");
            line = br.readLine();
            victimsList = new VictimsList(line);
        }

        System.out.println("Thank you.");
        System.out.println("Do you want to provide a mail corpus file? (Y/N)");

        do{

            goodInput = true;

            line = br.readLine();
            if(!line.equals("Y") && !line.equals("N")){
                goodInput = false;
                System.out.println("Please use Y for \"yes\" and N for \"no\".");
                System.out.println("Try again: do you want to provide a mail corpus?");
            }

        } while (!goodInput);

        if(line.equals("N")){
            mcList = new MailCorpusList();
        }else{
            System.out.println("Please provide the name of your file:");
            line = br.readLine();
            mcList = new MailCorpusList(line);
        }

        System.out.println("Good.");
        System.out.println("Now how many groups do you want to generate?");

        do{
            try{
                goodInput = true;
                groupsNumber = Integer.parseInt(br.readLine());
            } catch (NumberFormatException e){
                goodInput = false;
                System.err.println("You must provide an integer. This is not an integer.");
                System.out.print("Please try again: ");
            }
        } while (!goodInput);


        createGroups();

        System.out.println("Now we successfully created " + groupsNumber + " groups with the information you provided.");

        for(Group group : groupList){
            Random random = new Random();
            int randomNumber = random.nextInt(mcList.getMailCorpuses().size());
            MailCorpus mc = mcList.getMailCorpuses().get(randomNumber);
            System.out.println("What subject do you want for this prank?");
            System.out.println(mc.getMailCorpus());
            line = br.readLine();
            pranks.add(createPrank(group, line, mc));
        }

        System.out.println("Good. All you pranks have been successfully created. Do you want to list them? (Y/N)");
        do{

            goodInput = true;

            line = br.readLine();
            if(!line.equals("Y") && !line.equals("N")){
                goodInput = false;
                System.out.println("Please use Y for \"yes\" and N for \"no\".");
                System.out.println("Try again: do you want to list your pranks?");
            }

        } while (!goodInput);

        if(line.equals("N")){
            return pranks;
        }else{
            for(Mail prank : pranks){
                System.out.println(prank + "\n\n");
            }
        }


        return pranks;
    }


    public void save(){
        victimsList.save();
        mcList.save();
    }

    private void createGroups(){
        for(int i = 0; i < groupsNumber; ++i){
            groupList.add(new Group(victimsList));
        }
    }

    private Mail createPrank(Group group, String subject, MailCorpus mc){

        return new Mail(group.getSender(), victimsList.getVictims(), subject, mc);
    }


    private void loadVictims(String filename) {

    }

    private void loadVictims(Victim v) {
        victimsList.add(v);
    }
}











