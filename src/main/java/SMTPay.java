import com.sun.security.ntlm.Client;
import model.mail.Mail;
import model.mail.Person;
import smtp.SmtpClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SMTPay {
    public static void main(String[] args) {
        Person p1 = new Person("johannamelly@gmail.com");
        Person p2 = new Person("adresserandom@tamere.fr");
        Person p3 = new Person("johanna.melly@heig-vd.ch");

        List<Person> tos = new ArrayList<Person>();
        tos.add(p1);
        tos.add(p2);

        Mail newMail = new Mail(p3, tos, "Test, test", "Ceci est un test. J'aime le pain");

        SmtpClient client = new SmtpClient();
        try{
            System.out.println("Connexion...");
            client.connect("localhost");
            System.out.println("Envoi du mail...");
            client.sendMail(newMail);
            System.out.println("Déconnexion...");
            client.disconnect();

        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
}
