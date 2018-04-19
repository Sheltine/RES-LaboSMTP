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

public class PrankTest {
    private final List<Victim> DATA = new ArrayList<Victim>(Arrays.asList(new Victim("toto"), new Victim("johanna"), new Victim("yohann")));
    @Test(expected = IllegalArgumentException.class)
    public void aListWithLessThan3PeopleShouldBeRefused() {
        //List<Victim> victims = new ArrayList<>(Arrays.asList(new Victim("Jessica"), new Victim("Sandrine")));
        //VictimsList victimsList = new VictimsList("twoVictims.json");
        PrankGenerator PG = new PrankGenerator("twoVictimsFile.json", "MailCorpuses.txt");
    }

    @Test
    public void weShouldBeAbleToCreateAPrankGenerator() {
        //List<Victim> victims = new ArrayList<>(Arrays.asList(new Victim("Jessica"), new Victim("Sandrine")));
        VictimsList victimsList = new VictimsList("twoVictimsFile.json");;
        PrankGenerator PG = new PrankGenerator("twoVictimsFile.json", "MailCorpuses.txt");
    }
}
