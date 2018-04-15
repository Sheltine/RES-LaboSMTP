package data;

public class Victim {
    private String mail;

    public Victim(){}

    public Victim(String mail){
        this.mail = mail;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString(){
        return mail;
    }
}
