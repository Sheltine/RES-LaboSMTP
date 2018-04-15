
import data.Victim;
import data.VictimsList;
import model.prank.PrankGenerator;

import java.security.spec.ECField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class Main {

    protected static final Logger LOG = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        try {
            LOG.info("Application Start");

           // List<String> x = new ArrayList<>(Arrays.asList("xyz", "abc"));
            VictimsList vL;


           // PrankGenerator pg = new PrankGenerator();
          //  pg.generate();


            LOG.info("Application End");
        }catch(Exception e){
            LOG.severe( "The application as encoutered an exception. Stopping.");
            LOG.severe( e.getMessage() );
        }

    }
}
