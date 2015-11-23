package Business;

import com.db4o.Db4o;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.ta.TransparentPersistenceSupport;




/**
 *
 * @author praneet
 */
public class DB4OUtil {

   // private static final String FILENAME = "C:\\Users\\Praneet\\Documents\\NetBeansProjects\\Praneetsingh_Solanki_Final_Project\\DataBank.db4o"; // path to the data store
    
    private static final String FILENAME = "machineLearningDataSet.db4o";
    private static DB4OUtil dB4OUtil;
    
    public synchronized static DB4OUtil getInstance(){
        if (dB4OUtil == null){
            dB4OUtil = new DB4OUtil();
        }
        return dB4OUtil;
    }

    protected synchronized static void shutdown(ObjectContainer conn) {
        if (conn != null) {
            conn.close();
        }
    }

    private ObjectContainer createConnection() {
        try {

            EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
            config.common().add(new TransparentPersistenceSupport());
            //Controls the number of objects in memory
            config.common().activationDepth(Integer.MAX_VALUE);
            //Controls the depth/level of updation of Object
            config.common().updateDepth(Integer.MAX_VALUE);

            //Register your top most Class here
            config.common().objectClass(MachineLearning.class).cascadeOnUpdate(true); // Change to the object you want to save

            ObjectContainer db = Db4oEmbedded.openFile(config, FILENAME);
           //ObjectContainer db =Db4o.openFile(FILENAME);
            
            return db;
        } catch (Exception ex) {
            System.out.print(ex.getMessage());
        }
        return null;
    }

    public synchronized void storeSystem(MachineLearning machine) {
        ObjectContainer conn = createConnection();
        System.out.println("in db4o :" +machine.dataSet.entrySet());
        conn.store(machine);
        conn.commit();
        conn.close();
    }
    
    public MachineLearning retrieveSystem(){
        ObjectContainer conn = createConnection();
        ObjectSet<MachineLearning> systems = conn.query(MachineLearning.class); // Change to the object you want to save
        MachineLearning system=null;
       if (systems.size() == 0){
//     //       system = ConfigureASystem.configure();  // If there's no System in the record, create a new one
      return MachineLearning.getInstance();
       }
       else{
            //system = systems.get(0);
            system = systems.get(systems.size() - 1);
       }
        conn.close();
        return system;
    }
}
