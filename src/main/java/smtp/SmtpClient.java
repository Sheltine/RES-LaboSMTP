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

    public void disconnect() throws IOException {
        is.close();
        os.close();
        socket.close();
        LOG.info("Disconnected from server.");
    }

    public void sendMail(Mail mail) throws IOException {

        os.print(EHLO_CMD + "johanna\r\n");
        LOG.info(EHLO_CMD + "johanna");
        os.flush();
        String response = is.readLine();
       // System.out.println("coucou");

        while(!response.substring(0,6).equals(RSP_OK) ){
            response = is.readLine();
            LOG.info(response);
        }
        //System.out.println("thisis : " + is.readLine());

        //System.out.println("coucou2");

        os.print(FROM_CMD + mail.getFrom() + "\r\n");
        LOG.info(FROM_CMD + mail.getFrom());
        os.flush();

        checkBadResponse(RSP_OK);


        for(String to : mail.getTo()){
            os.print(TO_CMD + to + "\r\n");
            os.flush();
            checkBadResponse(RSP_OK);
        }

        os.print(DATA_CMD + "\r\n");
        os.flush();
        LOG.info(is.readLine()  );
        os.print(mail.toString() + "\r\n");
        os.flush();
        os.print(ENDMAIL_CMD + "\r\n");
        os.flush();

        checkBadResponse(RSP_OK);

        os.print(QUIT_CMD + "\r\n");
        os.flush();

        checkBadResponse(RSP_BYE);

    }

    private void checkBadResponse(String expected) throws IOException{
        String rep;
        if(!(rep = is.readLine()).equals(expected)) {
            throw new InvalidDataException("Invalid data provided");
        }
        System.out.println(rep);
    }

}
