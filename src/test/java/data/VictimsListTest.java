package data;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class VictimsListTest {
    private final List<Victim> DATA = new ArrayList<Victim>(Arrays.asList(new Victim("toto"), new Victim("johanna"), new Victim("yohann")));
    private final List<Victim> DATA2 = new ArrayList<Victim>(Arrays.asList(new Victim("johanna.melly@heig-vd.ch"), new Victim("yohann.meyer@heig-vd.ch"), new Victim("johannamelly@gmail.com")));

    @Test
    public void itShouldBePossibleToCreateAVictimList() throws Exception {
        VictimsList vL1 = new VictimsList();
        vL1.add(DATA.get(0));
        VictimsList vl2 = new VictimsList(DATA.get(0));
        Assert.assertEquals(vL1.getVictims(), vl2.getVictims());

    }

    @Test
    public void iSBPToSave() throws Exception {
        VictimsList vl1 = new VictimsList(DATA.get(0));
        vl1.add(DATA.get(1));
        vl1.add(DATA.get(2));

        vl1.save();
        vl1.close();
        System.out.println( vl1.getVictims());
        Assert.assertEquals(DATA, vl1.getVictims());

    }

    @Test
    public void iSBPToSave2() throws Exception {
        VictimsList vl1 = new VictimsList("victims.json");
        vl1.save();
        vl1.close();
        System.out.println( vl1.getVictims());
        Assert.assertEquals(DATA2, vl1.getVictims());

    }


}