package data;
import model.mail.Mail;
import model.mail.Person;
import model.prank.PrankGenerator;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MailCorpusTest {
    private final MailCorpus mailCorpus = new MailCorpus("Ce contenu est le même.");
    @Test
    public void weShouldBeAbleToCreateAMailCorpusFromFile() throws IOException {
        MailCorpusList mailCorpusList = new MailCorpusList("mailCorpusTest.json");
        mailCorpusList.save();
        mailCorpusList.close();
        MailCorpus identicalContent = mailCorpusList.getMailCorpuses().get(0);
        Assert.assertEquals(mailCorpus, identicalContent);
    }
}
