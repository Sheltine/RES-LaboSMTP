package model.prank;

import data.MailCorpus;
import data.MailCorpusList;
import data.Victim;
import data.VictimsList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.logging.Logger;

public class PrankGenerator {

    protected static final Logger LOG = Logger.getLogger(PrankGenerator.class.getName());

    private static VictimsList victimsList;
    private static MailCorpusList mcList;

    private List<Prank> pranks;

    public PrankGenerator(String filenameVictims, String filenameMailCorpuses) {
        victimsList = new VictimsList( filenameVictims );
        mcList = new MailCorpusList( filenameMailCorpuses );



    }
    public PrankGenerator() {
        victimsList = new VictimsList();
        mcList = new MailCorpusList();

    }

    public void generate() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Welcome in our generator of pranks. First, select");
        String s = br.readLine();
        System.out.print("Enter Integer:");
        try {
            int i = Integer.parseInt(br.readLine());
        } catch (NumberFormatException nfe) {
            System.err.println("Invalid Format!");
        }
    }
    public void save(){
        victimsList.save();
        mcList.save();
    }


    private void loadVictims(String filename) {

    }

    private void loadVictims(Victim v) {
        victimsList.add(v);
    }
}











