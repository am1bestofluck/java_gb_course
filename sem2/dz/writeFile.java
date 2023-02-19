import java.io.File;
import java.io.FileWriter;
/**
 * writeFile
 */
public class writeFile {
    public static void main(String[] args) {
        try{
            File outtxt = new File(args[0]);
            if (!outtxt.createNewFile()) {
                System.out.println("Wont overwrite anything. Shutting down.");
                System.exit(0);
            }
            try{
                FileWriter write_output = new FileWriter(outtxt,true);
                write_output.write(args[1],0,args[1].length());
                write_output.close();
            }
            catch(Exception write_ex)
            {
                System.out.println("error while writing to file.");
                outtxt.delete();
                System.exit(0);    
            }


        }
        catch(Exception e)
        {
            System.out.println("error while creating file.");
            System.exit(0);
        }
    }

    
}