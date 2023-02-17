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
        System.out.println("");
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
        Pattern base = Pattern.compile(String.format("(^%c\\s+)(\\d+)", keys[0]),
         Pattern.CASE_INSENSITIVE);
        Pattern pow = Pattern.compile(String.format("(^%c\\s+)(\\d+)", keys[1]),
         Pattern.CASE_INSENSITIVE);
        while (out.containsValue("default")) {
            try {
                if (out.get(keys[0])=="default"){
                    Matcher findBase = base.matcher(lines.get(index));
                    if (findBase.find())
                    {
                        out.put(keys[0],findBase.group(2));
                        index++;
                        continue;
                    }
                    
                }
                if (out.get(keys[1])=="default"){
                    Matcher findPow = pow.matcher(lines.get(index));
                    if (findPow.find())
                    {

                        out.put(keys[1],findPow.group(2));
                    }
                }
                if (!out.containsValue("default")){
                    break;
                }
                else  {
                    index++;
                }
            } 
            catch (IndexOutOfBoundsException e) {
                System.out.println(String.format("File %s doesn't meet contract", inputFileName));
                System.exit(0);
    
            }
            }
        return out;
    }
}