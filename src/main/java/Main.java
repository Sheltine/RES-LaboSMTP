
import data.Victim;
import data.VictimsList;
import model.mail.Mail;
import model.prank.PrankGenerator;
import smtp.SmtpClient;

import java.security.spec.ECField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class Main {

    protected static final Logger LOG = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        SmtpClient client = new SmtpClient();
        try {
            LOG.info("Application Start");

           // List<String> x = new ArrayList<>(Arrays.asList("xyz", "abc"));
           // client.connect("172.17.0.2");
            client.connect("smtp.heig-vd.ch");
            PrankGenerator prankGen = new PrankGenerator();
            List<Mail> pranks = prankGen.generate();
            //WANNA SEND ?
            for(Mail prank : pranks){
                client.sendMail(prank);
            }

            client.disconnect();

            LOG.info("Application End");
        }catch(Exception e){
            LOG.severe( "The application as encoutered an exception. Stopping.");
            LOG.severe( e.getMessage() );
        }

    }
}
