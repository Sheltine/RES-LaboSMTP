package model.mail;

import data.MailCorpus;
import data.Victim;

import java.awt.image.VolatileImage;
import java.util.List;

public class Mail {
    private String subject;
    private MailCorpus body;

    private Victim from;
    private List<Victim> to;




    public Mail(Victim from, List<Victim> to, String subject, MailCorpus body){
        this.from = from;
        this.to = to;
        this.body = body;
        this.subject = subject;
    }

    public Mail(Victim from, List<Victim> to, String subject, String body){
        this(from, to, subject, new MailCorpus(body));
    }


    public String getSubject() {
        return subject;
    }

    public void setBody(String subject) {
        this.subject = subject;
    }

    public MailCorpus getBody() {
        return body;
    }

    public void setSubject(String body) {
        this.body = new MailCorpus(body);
    }

    public Victim getFrom() {
        return from;
    }

    public void setFrom(Victim from) {
        this.from = from;
    }

    public List<Victim> getTo() {
        return to;
    }

    public void setTo(List<Victim> to) {
        this.to = to;
    }

    public String toString(){
        String tos = "";
        for(Victim address : getTo()){
            tos += address.getMail() + ", ";
        }
        tos = tos.substring(0, tos.length()-2);
        return ("From: " + getFrom().getMail() + "\nTo: " + tos + "\nSubject: " + getSubject() + "\r\n\r\n" + getBody());
    }
}
