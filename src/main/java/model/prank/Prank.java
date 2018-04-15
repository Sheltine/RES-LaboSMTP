package model.prank;

import data.Victim;
import model.mail.Mail;

import java.util.ArrayList;
import java.util.List;

public class Prank {
    private Mail mail;
    private Victim sender;
    private List<Victim> receivers;

    public Prank(Mail m, List<Victim> v){
        mail = m;
        sender = v.get(0);
        receivers = new ArrayList<Victim>(v);
        receivers.remove(0);
    }

    public Prank(Mail m, Victim s, List<Victim> r){
        mail = m;
        sender = s;
        receivers = new ArrayList<Victim>(r);
    }


    /************GETTER AND SETTERS ***********/
    public Mail getMail() {
        return mail;
    }

    public void setMail(Mail mail) {
        this.mail = mail;
    }

    public Victim getSender() {
        return sender;
    }

    public void setSender(Victim sender) {
        this.sender = sender;
    }

    public List<Victim> getReceivers() {
        return receivers;
    }

    public void setReceivers(List<Victim> receivers) {
        this.receivers = receivers;

    }
}
