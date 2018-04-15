package data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@JsonIgnoreProperties({"LOG","reader","writer", "FILENAME_DEFAULT"})
public class VictimsList {

    protected static final Logger LOG = Logger.getLogger(VictimsList.class.getName());

    private static final String FILENAME_DEFAULT = "victimes.txt";
    private List<Victim> victims = new ArrayList<>();
    private BufferedReader reader;
    private PrintWriter writer;


    public VictimsList(String filename){
        try {

            File f = new File( filename);
          //  boolean newFile = f.createNewFile();
        //    LOG.info("created new file: " + newFile);

            reader = new BufferedReader(new FileReader( filename ));
            writer = new PrintWriter(new BufferedWriter(new FileWriter( FILENAME_DEFAULT )));

            //Wouhouuuuuuuuu
            /* https://stackoverflow.com/questions/28977308/read-all-lines-with-bufferedreader
             *
             */
       //     if(!newFile)
                victims = JsonObjectMapper.parseJsonArray( reader.lines().collect(Collectors.joining()),  Victim.class );



        }catch(Exception e){
            LOG.log(Level.SEVERE, "Exception; ", e );


        }

    }
    public VictimsList(){
        this(FILENAME_DEFAULT);
    }

    public VictimsList(List<Victim> victims){
        this();
        add(victims);
    }
    public VictimsList(Victim victim){
        this() ;
        add( victim );
    }

    public List<Victim> getVictims() {
        return victims;
    }

    public void add(Victim v){

        victims.add(v);
    }

    public void add(List<Victim> v) {

        victims.addAll(v);
    }

    public void save() {

        try {
            writer.println(JsonObjectMapper.toJson(this));
            writer.flush();
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
