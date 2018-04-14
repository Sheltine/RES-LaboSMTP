package model.mail;

public class Mail {
    private String body;
    private String subject;
    private String from;
    private String to;

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

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }


    public String toString(){
        return ("From: " + getFrom() + "\nTo: " + getTo() + "\nSubject: " + getSubject() + "\n\n" + getBody());
    }
}
