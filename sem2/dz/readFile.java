package sem2.dz;

import java.util.Hashtable;
import java.util.regex.Pattern;
/**
 * readFile - вынимаем аргументы из input.txt
 */
public class readFile {
    static final char[] keys = new char[]{'a','b'};
    public static void main(String[] args) {
        
    }
    public static String[] extractLines(String filepath)
    {
        String[]out  = new String[]{"asd"};
        return out;
    }
    public static Hashtable<Character, String> parseArgs(String[] lines)
    {
        Hashtable<Character, String> out = new Hashtable<Character, String>();
        out.put(keys[0], null);
        out.put(keys[1], null);
        int index = 0;
        while (out.containsValue(null)) {
            try {
                index++;
                
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("File doesn't meet contract");
                System.exit(0);
    
            }
            index ++;
            }
        }
        return out;
    }
}