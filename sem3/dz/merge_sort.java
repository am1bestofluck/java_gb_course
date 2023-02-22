import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;

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
        
        List<Long> content = parseLine(pathFile_in);
        List<Long> answer = mergeSort(content);
        inFile(answer, pathFile_out);
    }


    public static List<Long> parseLine(String pathFile)
    {
        List<Long> out = new ArrayList<Long>();
        StringBuffer tmp = new StringBuffer();
        try {
            
            Scanner reader = new Scanner(new File(pathFile));
            while (reader.hasNextLine()){
                tmp.append(reader.nextLine());
            }
            String[] literals = tmp.toString().split(" ", tmp.toString().length());
            for (String string : literals) {
                try {
                    out.add(Long.valueOf(string));
                } catch (NumberFormatException e) {
                    System.out.print("! ");
                    System.out.println(string);
                }
                
            }
        } 
        catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.out.println("System.getProperty(\"user.dir\");");
            System.getProperty("user.dir");
                        }
        
        return out;
 
    }
    public static List<Long> ms(List<Long> in)
    {
        if (in == null){
            return null;
        }
        
        if (in.size() == 0 || in.size() == 1)
        {
            return in;
        }
        List<Long> Left = Collections.EMPTY_LIST;
        List<Long> Right = Collections.EMPTY_LIST;
        try{
        Left = ms(in.subList(0, in.size()/2));}
        catch( NullPointerException e)
        {
            System.out.println("");
        }
        try{
        Right =ms(in.subList(in.size()/2, in.size()));}
        catch (NullPointerException e)
        {
            System.out.println("");
        }
        Integer n =0, m =0, k = 0;
        Long[] tmp = new Long[Left.size()+Right.size()];
        
        
        while (n < Left.size() && m < Right.size()){
            if (Left.get(n) <= Right.get(m))
            {
                tmp[k] = Left.get(n);
                n++;
            }
            else{
                tmp[k] = Right.get(m);
                m++;
            }
            k++;
        }


        while (n< Left.size()-1) {
            tmp [k] = Left.get(n);
            n++;
            k++;
        }
        while (m< Right.size()-1) {
            tmp [k] = Left.get(m);
            m++;
            k++;}

        in = Arrays.asList(tmp);
        return in;
    }
    


    public static List<Long> mergeSort(List<Long> in){
        List<Long> out = ms(in);
        //сначала дробим массив на равные части;
        //потом сортируем части(рекурсивно?)
        //потом поэлементно собираем последний массив из отсортированных
        return out;

    }
    public static void inFile(Object content, String fileName){
        if ( !(content instanceof ArrayList) && !(content instanceof String) &&
        !(content instanceof List)){
            throw new UnsupportedOperationException("Not implemented");
        }
        StringBuilder writeThis = new StringBuilder();
        for (Object i: (List<Object>)content){
            writeThis.append(i.toString());
            writeThis.append("\n");
        }
        try{
            FileWriter temp = new FileWriter(fileName,true);
            temp.append(writeThis.toString());
            temp.flush();
            temp.close();

    }
        catch (IOException eof)
        {
            eof.getStackTrace();
        }
        catch (Exception e)
        {
            e.getStackTrace();
        }
        System.out.println("");
    }
}