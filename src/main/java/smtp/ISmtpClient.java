package smtp;

import model.mail.Mail;

import java.io.IOException;

public interface ISmtpClient {

    public final static int DEFAULT_PORT = 25;

    public static final String EHLO_CMD    = "EHLO ";
    public static final String FROM_CMD    = "MAIL FROM: ";
    public static final String TO_CMD      = "RCPT TO: ";
    public static final String DATA_CMD    = "DATA";
    public static final String ENDMAIL_CMD = ".";
    public static final String QUIT_CMD    = "quit";

    public static final String RSP_OK      = "250 ";
    public static final String RSP_XRDST   = "250 XRDST";


    public static final String RSP_BYE     = "221 Bye";
    public static final String RSP_ERROR   = "500 Error: bad syntax";


    public void connect(String server) throws IOException;
    public void disconnect() throws IOException;
    public void sendMail(Mail mail) throws IOException;
}
