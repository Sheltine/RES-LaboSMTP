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
        Assert.assertEquals(mailCorpus.getMailCorpus(), identicalContent.getMailCorpus());
    }

    @Test
    public void shouldBeAbleToGenerateJsonRepresentation() throws IOException {
        MailCorpusList mailCorpusList = new MailCorpusList();
        mailCorpusList.add(mailCorpus);
        mailCorpusList.add(mailCorpus);

        mailCorpusList.save();
        mailCorpusList.close();

        Assert.assertEquals(mailCorpus, mailCorpusList.getMailCorpuses().get(0));

    }

    @Test
    public void shouldDeserialize() throws IOException {
        MailCorpusList mailCorpusList = new MailCorpusList("mailCorpus.json");
        mailCorpusList.save();
        mailCorpusList.close();


        MailCorpus identicalContent = mailCorpusList.getMailCorpuses().get(0);
        Assert.assertEquals("J'aime le pain.", identicalContent.getMailCorpus());

    }
}
