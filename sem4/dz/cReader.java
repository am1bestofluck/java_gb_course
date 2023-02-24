import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * cReader
 */
public class cReader {
    public Integer[] content;

    public static void main(String[] args) {
        cReader test = new cReader(constants.fileIn);
        System.out.println(test.content);
    }
    public cReader(String path){
        ArrayList<Integer> tmp = new ArrayList<Integer>(); 
        try {
            Scanner main = new Scanner(new File(path));
            while (main.hasNextLine()) {
                String OnlyGetOnce = main.nextLine();
                try{
                    tmp.add(Integer.valueOf(OnlyGetOnce));
                } catch( NumberFormatException numb)
                    {
                        System.out.println(String.format("Can't parse! {%s}", OnlyGetOnce));
                    }
            }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    this.content = new Integer[tmp.size()];
    for (int i = 0; i < tmp.size(); i++) {
        content[i] = tmp.get(i);
    }
    System.out.println("");
}
}