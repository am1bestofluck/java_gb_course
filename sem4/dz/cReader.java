import java.util.ArrayList;
import java.util.Scanner;


/**
 * cReader
 */
public class cReader {
    public Integer[] content;

    public static void main(String[] args) {
        // if 
    }
    public cReader(String path){
        ArrayList<Integer> tmp = new ArrayList<Integer>(); 
        Scanner main = new Scanner(path);
        while (main.hasNextLine()) {
            String OnlyGetOnce = main.nextLine();
            try{tmp.add(Integer.valueOf(OnlyGetOnce));}
            catch( NumberFormatException numb)
            {
                System.out.println(String.format("Can't parse! {%s}", OnlyGetOnce));
            }
        }
        this.content = (Integer[]) tmp.toArray();
    }
}