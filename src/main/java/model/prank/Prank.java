package model.prank;

import model.mail.Person;

import java.util.List;

public class Prank {
    private List<Person> victims;
    private Person sender;
    private String mail;
    public Prank(List<Person> victims, Person sender, String mail){
        this.mail = mail;
        this.sender = sender;
        this.victims = victims;
    }
}
