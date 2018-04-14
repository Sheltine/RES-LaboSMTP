package model.prank;

import model.mail.Group;

public class PrankGenerator {
    private final int NB_MIN_RECEIVER = 2;
    private Group group;
    public PrankGenerator(Group group){
        this.group = group;
    }
}
