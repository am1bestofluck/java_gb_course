package sem2.dz;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * readFile - вынимаем аргументы из input.txt
 */
public class readFile {
    static final char[] keys = new char[]{'a','b'};
    static final String inputFileName = "in.txt";
    public static void main(String[] args) {
        var lines = extractLines(inputFileName);
        var args_out = parseArgs(lines); 
    }
    public static ArrayList<String> extractLines(String filepath)
    {
        ArrayList<String> out  = new ArrayList<>();
        try (Scanner reader = new Scanner(new File(filepath))) {
            while (reader.hasNextLine()){
                out.add(reader.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
                System.exit(0);
        }
        return out;
    }
    public static Hashtable<Character, String> parseArgs(ArrayList<String> lines)
    {
        Hashtable<Character, String> out = new Hashtable<Character, String>();
        out.put(keys[0], "default");
        out.put(keys[1], "default");// оказывается нельзя ложить null
        int index = 0;
        Pattern base = Pattern.compile("(^a\\s+)(\\d+)",
         Pattern.CASE_INSENSITIVE);
        Pattern pow = Pattern.compile("(^b\\s+)(\\d+)",
         Pattern.CASE_INSENSITIVE);
        Pattern value = Pattern.compile("\\d+");
        while (out.containsValue("default")) {
            try {
                if (out.get(keys[0])=="default"){
                    Matcher findBase = base.matcher(lines.get(index));
                    if (findBase.find())
                    {
                        System.out.println("match!");
                        index++;
                        continue;
                    }
                    
                }
                if (out.get(keys[1])=="default"){
                    Matcher findPow = pow.matcher(lines.get(index));
                    if (findPow.find())
                    {
                        System.out.println("match!");
                        // Pattern value = 
                    }
                }
                if (!out.containsValue("default")){
                    break;
                }
                else  {
                    index++;
                }
            } 
            catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("File doesn't meet contract");
                System.exit(0);
    
            }
            }
        return out;
    }
}