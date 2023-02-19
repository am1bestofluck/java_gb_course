import java.util.ArrayList;
import java.util.Hashtable;


/**
 * pow_wo_pow
 */
public class pow_wo_pow {

    public static String outputPath = "out.txt"; 
    public static void main(String[] args) {
        String inputFileName = readFile.inputFileName;
        ArrayList<String> lines = readFile.extractLines(inputFileName);
        Hashtable<Character, String>  args_out = readFile.parseArgs(lines);
        Double answer = math_part(args_out);
        writeFile.main(new String[]{outputPath,Double.toString(answer)});

        
    }
    public static Double math_part( Hashtable<Character, String> contract)
    {
        Double base = Double.valueOf(contract.get('a'));
        Double out = base;
        if (Double.valueOf(contract.get('b')) == 0) {
            out = 1.0;
        }
        else if ( Double.valueOf(contract.get('b')) > 0){
            for (int i = 0; i < Integer.parseInt(contract.get('b'))-1; i++) {
                out = out* base;
            } 

        }
        else {
            for (int i = 0; i < Integer.parseInt(contract.get('b'))-1; i++) {
                out = out* base;
            }
            out = 1/out;

        }
        System.out.println(out);
        return out;
    }
}