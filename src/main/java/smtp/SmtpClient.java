package smtp;

import com.sun.media.sound.InvalidDataException;
import model.mail.Mail;

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

    public void connect(String server, int port) throws IOException {
        socket = new Socket(server, port);
        is = new BufferedReader( new InputStreamReader( socket.getInputStream() ) );
        os = new PrintWriter( socket.getOutputStream() );

        LOG.info("Connected to server " + server + " on port " + port + "." );
        is.readLine();

    }

    public void disconnect() throws IOException {
        is.close();
        os.close();
        socket.close();
        LOG.info("Disconnected from server.");
    }

    public void sendMail(Mail mail) throws IOException {
        os.println(EHLO_CMD);
        os.flush();
        String response;
        while((response=is.readLine()) != null){
            LOG.info(response);
        }

        os.println(FROM_CMD + mail.getFrom());
        os.flush();

        checkBadResponse(RSP_OK);

        os.println(TO_CMD + mail.getTo());
        os.flush();

        checkBadResponse(RSP_OK);

        os.println(DATA_CMD + mail.toString());
        os.flush();
        os.println(ENDMAIL_CMD);
        os.flush();

        checkBadResponse(RSP_OK);

        os.println(QUIT_CMD);
        os.flush();

        checkBadResponse(RSP_BYE);

    }

    private void checkBadResponse(String expected) throws IOException{
        if(!is.readLine().equals(expected)){
            throw new InvalidDataException("Invalid data provided");
        }
    }

}
