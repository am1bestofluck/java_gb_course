import java.io.FileWriter;

/**
 * toFile
 */
public class toFile {

    public static void main(String[] args) {
    }
public void write_(String filename, String content){
    FileWriter obj = new FileWriter(filename,false);
    obj.write(content);
    obj.close();
}
}