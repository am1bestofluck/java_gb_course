import java.util.ArrayList;
import java.util.List;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.io.FileWriter;
import java.io.IOException;
/**
 * merge_sort
 */

public class merge_sort {
    public static String pathFile_in = init_collection.unsortedPath;
    public static String pathFile_out = init_collection.sortedPath;
    public static void main(String[] args) {
        init_collection.main(new String[]{});
        
        Path extractPwd = Paths.get(System.getProperty("user.dir"));
            if (String.valueOf(extractPwd.getFileName()).equals("java_gb_course")){
                pathFile_in = System.getProperty("user.dir")+ "\\sem3\\dz\\"
                + init_collection.unsortedPath;
                pathFile_out = System.getProperty("user.dir")+ "\\sem3\\dz\\"
                + init_collection.sortedPath;                
            }
        ArrayList<Long> content = parseLine(pathFile_in);
        ArrayList<Long> answer = mergeSort(content);
        inFile(answer, pathFile_out);
    }


    public static ArrayList<Long> parseLine(String pathFile)
    {
        ArrayList<Long> out = new ArrayList<Long>();
        StringBuffer tmp = new StringBuffer();
        try {
            
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
    public static void inFile(Object content, String fileName){
        if ( !(content instanceof ArrayList) && !(content instanceof String)){
            throw new UnsupportedOperationException("Not implemented");
        }
        StringBuilder writeThis = new StringBuilder();
        for (Object i: (List<Object>)content){
            writeThis.append(i.toString());
            writeThis.append(" ");
        }
        try{
            FileWriter temp = new FileWriter(fileName,false);
            temp.flush();
            temp.append(writeThis);
    }
        catch (IOException eof)
        {
            eof.getStackTrace();
        }
        System.out.println("");

    }
}