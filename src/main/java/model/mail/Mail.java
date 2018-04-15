package model.mail;

import data.MailCorpus;

import java.util.List;

public class Mail {
    private String subject;
    private MailCorpus body;

    private Person from;
    private List<Person> to;


    public Mail(Person from, List<Person> to, String subject, String body){
        this.from = from;
        this.to = to;
        this.body = new MailCorpus(body);
        this.subject = subject;
    }

    public String getBody() {
        return subject;
    }

    public void setBody(String subject) {
        this.subject = subject;
    }

    public MailCorpus getSubject() {
        return body;
    }

    public void setSubject(String body) {
        this.body = new MailCorpus(body);
    }

    public Person getFrom() {
        return from;
    }

    public void setFrom(Person from) {
        this.from = from;
    }

    public List<Person> getTo() {
        return to;
    }

    public void setTo(List<Person> to) {
        this.to = to;
    }

    public String toString(){
        String tos = "";
        for(Person address : getTo()){
            tos += address.getEmailAdress() + ", ";
        }
        tos = tos.substring(0, tos.length()-2);
        return ("From: " + getFrom().getEmailAdress() + "\nTo: " + tos + "\nSubject: " + getSubject() + "\r\n\r\n" + getBody());
    }
}
