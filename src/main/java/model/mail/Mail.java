package model.mail;

import java.util.List;

public class Mail {
    private String body;
    private String subject;
    private Person from;
    private List<Person> to;


    public Mail(Person from, List<Person> to, String subject, String body){
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
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
