
/*package data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.*;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@JsonIgnoreProperties({"LOG","reader","writer", "FILENAME_DEFAULT"})
public class IJsonListToFile<T> {
     static final Logger LOG = Logger.getLogger(IJsonListToFile.class.getName());

     static final String FILENAME_DEFAULT = "ListOut.txt";
     List<T> dataList = null;
     BufferedReader reader = null;
     PrintWriter writer = null;


    public <T> IJsonListToFile(String filename){
        try {
            reader = new BufferedReader(new FileReader( filename ));
            writer = new PrintWriter(new BufferedWriter(new FileWriter( FILENAME_DEFAULT )));

            //Wouhouuuuuuuuu
            /* https://stackoverflow.com/questions/28977308/read-all-lines-with-bufferedreader
             *
             *

            dataList = JsonObjectMapper.parseJsonArray( reader.lines().collect(Collectors.joining()), T  );



        }catch(Exception e){
            LOG.severe(e.getMessage());


        }
    }
    public IJsonListToFile(){
        this(FILENAME_DEFAULT);
    }


    public IJsonListToFile(List<MailCorpus> mailCorpus){
        this();
        add(mailCorpus);
    }
    public IJsonListToFile(MailCorpus mailCorpus){
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

    public void save() throws JsonProcessingException{

        writer.println(JsonObjectMapper.toJson( this));
        writer.flush();
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
*/