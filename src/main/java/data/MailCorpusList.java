package data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@JsonIgnoreProperties({"LOG","reader","writer", "FILENAME_DEFAULT"})
public class MailCorpusList {
    protected static final Logger LOG = Logger.getLogger(MailCorpusList.class.getName());

    private static final String FILENAME_DEFAULT = "MailCorpuses.txt";
    private List<MailCorpus> mailCorpuses;
    private BufferedReader reader;
    private PrintWriter writer;


    public MailCorpusList(String filename){

        mailCorpuses = new ArrayList<MailCorpus>();
        try {
            File f = new File( filename);
            f.createNewFile();

            reader = new BufferedReader(new FileReader( filename ));
            writer = new PrintWriter(new BufferedWriter(new FileWriter( FILENAME_DEFAULT )));

            //Wouhouuuuuuuuu
            /* https://stackoverflow.com/questions/28977308/read-all-lines-with-bufferedreader
             *
             */
            if(f.length() != 0) {
                String lines = reader.lines().collect(Collectors.joining());
                mailCorpuses = JsonObjectMapper.parseJsonArray(lines, MailCorpus.class);
               // mailCorpuses = JsonObjectMapper.parseJsonArray(reader.lines().collect(Collectors.joining()), MailCorpus.class);
            }


        }catch(Exception e){
            LOG.log(Level.SEVERE, "Exception; ", e );


        }
    }
    public MailCorpusList(){
        this(FILENAME_DEFAULT);
    }


    public MailCorpusList(List<MailCorpus> mailCorpus){
        this();
        add(mailCorpus);
    }
    public MailCorpusList(MailCorpus mailCorpus){
        this() ;
        add( mailCorpus );
    }

    public List<MailCorpus> getMailCorpuses() {
        return mailCorpuses;
    }

    public void setMailCorpuses(List<MailCorpus> mailCorpuses) {
        this.mailCorpuses = mailCorpuses;
    }

    public void add(MailCorpus mc){
        mailCorpuses.add(mc);
    }

    public void add(List<MailCorpus> mailCorpus) {

        mailCorpuses.addAll(mailCorpus);
    }

    public void save() {
        try {
            writer.println(JsonObjectMapper.toJson(this.getMailCorpuses()));
            writer.flush();

            System.out.println("Saved!");
            System.out.println("Reading content: " + reader.lines().collect(Collectors.joining()));

        }catch(JsonProcessingException e){
            LOG.severe(e.getMessage());
        }
        LOG.info("saved list");

    }

    public boolean eraseList(){
        File file = new File( FILENAME_DEFAULT );
        if(file.delete() )
            return true;
        return false;
    }

    public void close() throws IOException{
        reader.close();
        writer.close();

    }
}
