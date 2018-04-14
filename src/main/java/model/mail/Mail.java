package model.mail;

import java.util.List;

public class Mail {
    private String body;
    private String subject;
    private String from;
    private List<String> to;


    public Mail(String from, List<String> to, String subject, String body){
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

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public List<String> getTo() {
        return to;
    }

    public void setTo(List<String> to) {
        this.to = to;
    }

    public String toString(){
        return ("From: " + getFrom() + "\nTo: " + getTo() + "\nSubject: " + getSubject() + "\r\n\r\n" + getBody());
    }
}
