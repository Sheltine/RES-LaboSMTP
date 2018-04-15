package smtp;

import com.sun.media.sound.InvalidDataException;
import model.mail.Mail;
import model.mail.Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Logger;

public class SmtpClient implements ISmtpClient {

    protected static final Logger LOG = Logger.getLogger(SmtpClient.class.getName());
    protected BufferedReader is;
    protected PrintWriter os;
    protected Socket socket;

    /**
     * Connect to server
     * @param server
     * @throws IOException
     */
    public void connect(String server) throws IOException {
        socket = new Socket(server, DEFAULT_PORT);
        is = new BufferedReader( new InputStreamReader( socket.getInputStream() ) );
        os = new PrintWriter( socket.getOutputStream() );

        LOG.info("Connected to server " + server + " on port " + DEFAULT_PORT + "." );
        String response;
        while((!((response = is.readLine()).substring(0,3)).equals("220"))){
            LOG.info(response);
        }
        LOG.info(response);
        LOG.info("CONNECTED");
    }

    /**
     * Disconnect from server
     * @throws IOException
     */
    public void disconnect() throws IOException {
        is.close();
        os.close();
        socket.close();
        LOG.info("Disconnected from server.");
    }

    /**
     * Sends a mail to server
     * @param mail to send
     * @throws IOException
     */
    public void sendMail(Mail mail) throws IOException {

        // Notifying the server that we want to send an email
        os.print(EHLO_CMD + "johanna\r\n");
        LOG.info(EHLO_CMD + "johanna");
        os.flush();

        String response = is.readLine();

        // Getting server response
        while(!response.substring(0,6).equals(RSP_OK) ){
            response = is.readLine();
            LOG.info(response);
        }

        // Sending email writer
        os.print(FROM_CMD + mail.getFrom().getEmailAdress() + "\r\n");
        LOG.info(FROM_CMD + mail.getFrom().getEmailAdress());
        os.flush();

        checkBadResponse(RSP_OK);

        // Sending email recipients one by one
        for(Person to : mail.getTo()){
            System.out.println(to.getEmailAdress());
            os.print(TO_CMD + to.getEmailAdress() + "\r\n");
            os.flush();
            checkBadResponse(RSP_OK);
        }

        // Notifying the server we'll be sending mail data
        os.print(DATA_CMD + "\r\n");
        os.flush();
        LOG.info(is.readLine()  );

        // Sending mail header and body
        os.print(mail.toString() + "\r\n");
        os.flush();

        // Notifying the server we finished sending data
        os.print(ENDMAIL_CMD + "\r\n");
        os.flush();

        checkBadResponse(RSP_OK);

        // Quitting
        os.print(QUIT_CMD + "\r\n");
        os.flush();

        checkBadResponse(RSP_BYE);

    }

    /**
     * Checks if server response is as expected
     * @param expected
     * @throws IOException
     */
    private void checkBadResponse(String expected) throws IOException{
        String rep;
        if(!(rep = is.readLine()).equals(expected)) {
            throw new InvalidDataException("Invalid data provided");
        }
        System.out.println(rep);
    }

}
