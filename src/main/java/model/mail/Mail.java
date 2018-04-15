package model.mail;

import data.MailCorpus;

import java.util.List;

public class Mail {
    private String subject;
    private MailCorpus body;
    private String from;
    private List<String> to;


    public Mail(String from, List<String> to, String body, String subject){
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
