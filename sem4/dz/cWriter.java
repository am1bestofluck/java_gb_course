// package sem4.dz;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
/**
 * cWriter
 */
public class cWriter {
    String Path;
    Integer[] content;

    public static void main(String[] args) {
    }
    public cWriter(Integer[] stuff, String filePath){
        this.Path = filePath;
        this.content = stuff;
    }

    public static Integer[] randomize_incoming( Integer size){
        Random Unique = new Random();
        Integer[] out = new Integer[size];
        for (int i = 0; i < out.length; i++) {
            out[i] = (Unique.nextBoolean())?  i+constants.arraysize+1 : i;
        }
        return out;

    }
    public void write_in(){
        String filePath = this.Path;
        try {
        FileWriter in_txt = new FileWriter(filePath,false);
        in_txt.write("");
        for (Integer integer : this.content) {
            in_txt.append(String.valueOf(integer));
            in_txt.append("\n");
            
        }
        in_txt.flush();
        in_txt.close();

    } catch (IOException e){
            e.getStackTrace();
    }
    }
}