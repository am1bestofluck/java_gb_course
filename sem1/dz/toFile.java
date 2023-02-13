import java.io.File;
import java.io.FileWriter;

/**
 * toFile
 */
public class toFile {

    public static void main(String[] args) {
    }
public static void write_(String filename, String content){
    File file_ = new File(filename);
    try{
    FileWriter obj = new FileWriter(file_,false);
    obj.write(content);
    obj.close();
    }
    catch (Exception e)
    {
        System.out.println("done!");
    }

}
}