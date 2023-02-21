import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.nio.file.Paths;
import java.nio.file.Path;
/**
 * merge_sort
 */

public class merge_sort {

    public static void main(String[] args) {
        ArrayList<Long> content = parseLine(init_collection.unsortedPath);
    }


    public static ArrayList<Long> parseLine(String pathFile)
    {
        ArrayList<Long> out = new ArrayList<Long>();
        StringBuffer tmp = new StringBuffer();
        try {
            Path extractPwd = Paths.get(System.getProperty("user.dir"));
            if (String.valueOf(extractPwd.getFileName()).equals("java_gb_course")){
                pathFile = System.getProperty("user.dir")+ "\\sem3\\dz\\"+ pathFile;
            }
            Scanner reader = new Scanner(new File(pathFile));
            while (reader.hasNextLine()){
                tmp.append(reader.nextLine());
            }
            String[] literals = tmp.toString().split(" ", tmp.toString().length());
            for (String string : literals) {
                out.add(Long.valueOf(string));
            }
        } 
        catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.out.println("System.getProperty(\"user.dir\");");
            System.getProperty("user.dir");
                        }
        
        return out;
 
    }
    public static ArrayList<Long> mergeSort(ArrayList<Long> in){
        ArrayList<Long> out = in;
        return out;

    }
}