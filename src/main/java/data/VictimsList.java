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
    private List<Victim> victims;
    private BufferedReader reader;
    private PrintWriter writer;


    public VictimsList(String filename){

        victims = new ArrayList<>();

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
            if(f.length() != 0) {
                String lines = reader.lines().collect(Collectors.joining());
                victims = JsonObjectMapper.parseJsonArray(lines, Victim.class);
                //System.out.println("mail: " + victims.get(0).getMail());
            }else{
                victims = createFakeVictimsList();
            }

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

    private List<Victim> createFakeVictimsList(){
        List<Victim> victims = new ArrayList<>();
        victims.add(new Victim("johanna.melly@heig-vd.ch"));
        victims.add(new Victim("yohann.meyer@heig-vd.ch"));
        victims.add(new Victim("johannamelly@gmail.com"));
        return victims;
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
            System.out.println("Saving...");
            writer.println(JsonObjectMapper.toJson(this.getVictims()));
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
