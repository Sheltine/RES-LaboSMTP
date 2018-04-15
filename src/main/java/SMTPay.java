import com.sun.security.ntlm.Client;
import model.mail.Mail;
import smtp.SmtpClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SMTPay {
    public static void main(String[] args) {

        List<String> tos = new ArrayList<String>();
        tos.add("johannamelly@gmail.com");
        Mail newMail = new Mail("johanna.melly@heig-vd.ch", tos, "Test, test", "Ceci est un test. J'aime le pain");

        SmtpClient client = new SmtpClient();
        try{
            System.out.println("Connexion...");
            client.connect("172.17.0.2");
            System.out.println("Envoi du mail...");
            client.sendMail(newMail);
            System.out.println("Déconnexion...");
            client.disconnect();

        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
}
