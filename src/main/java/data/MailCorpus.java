package data;

import model.mail.Mail;

/***
 * This class provide a definition for the corpus of an mail,
 * to (de)serialize data.
 * Used in MailCorpusList
 */
public class MailCorpus {

    private String mailCorpus;

    public MailCorpus(){};

    public MailCorpus( String mc){
        mailCorpus = mc;
    }

    public String getMailCorpus() {
        return mailCorpus;
    }

    public void setMailCorpus(String mailCorpus) {
        this.mailCorpus = mailCorpus;
    }

    @Override
    public String toString(){
        return mailCorpus;
    }
}
