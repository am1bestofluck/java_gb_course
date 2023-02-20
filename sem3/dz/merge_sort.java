import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * merge_sort
 */

public class merge_sort {

    public static void main(String[] args) {
        
    }
    public static ArrayList<Integer> parseLine(String pathFile)
    {
        ArrayList<Integer> out = new ArrayList<Integer>();
        StringBuffer tmp = new StringBuffer();
        try {
            Scanner reader = new Scanner(new File(pathFile)) 
            while (reader.hasNextLine()){
                tmp.append(reader.nextLine());
            }
            String[] literals = tmp.toString().split(" ", tmp.toString().length());
            
        } 
        catch (FileNotFoundException e) {
            System.out.println("File not found");
                System.exit(0);
        }
        return out;
    }
}