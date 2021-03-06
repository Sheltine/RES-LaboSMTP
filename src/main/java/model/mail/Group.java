package model.mail;

import data.Victim;
import data.VictimsList;

import java.util.Random;

public class Group {
    private VictimsList victims;

    public VictimsList getVictims() {
        return victims;
    }

    public Victim getSender() {
        return sender;
    }

    private Victim sender;

    public Group(VictimsList victims, Victim sender){
        this.victims = victims;
        this.sender = sender;
        //System.out.println(victims.getVictims().size());
        /*
        if(this.victims.getVictims().contains(sender)){
            this.victims.getVictims().remove(sender);
        }
        */
    }

    public Group(VictimsList victims){
        this(victims, victims.getVictims().get(new Random().nextInt(victims.getVictims().size())));
    }



}
