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
        Long[] content = parseLine(pathFile_in);
        sort_gfg(content,0,content.length-1);
        // List<Long> content_ = (List<Long>) content;
        // Long[] answer = mergeSort(content);
        inFile(content, pathFile_out);
    }


    public static Long[] parseLine(String pathFile)
    {
        Long[] array_default = new Long[]{};
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
                array_default = new Long[out.size()];
                for (int i = 0; i < out.size(); i++) {
                    array_default[i] = out.get(i); 
                }
                
            }
        } 
        catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.out.println("System.getProperty(\"user.dir\");");
            System.getProperty("user.dir");
                        }
        
        return array_default;
 
    }
    public static void merge_gfg(Long arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
  
        /* Create temp arrays */
        Long L[] = new Long[n1];
        Long R[] = new Long[n2];
  
        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
  
        /* Merge the temp arrays */
  
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
  
        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
  
        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
  
    // Main function that sorts arr[l..r] using
    // merge()
    public static void sort_gfg(Long arr[], int l, int r)
    {
        if (l < r) {
            // Find the middle point
            int m = l + (r - l) / 2;
  
            // Sort first and second halves
            sort_gfg(arr, l, m);
            sort_gfg(arr, m + 1, r);
  
            // Merge the sorted halves
            merge_gfg(arr, l, m, r);
        }
    }

    // public static Long[] ms(Long[] in)
    // {
    //     if (in.length == 0 || in.length == 1)
    //     {
    //         return in;
    //     }
    //     Long[] Left;
    //     Left = ms(System.arraycopy(in, 0, Left,in.length/2, in.length/2));
    //     Long[] Right = new Long[]{};
    //     Integer n =0, m =0, k = 0;
    //     Long[] tmp = new Long[Left.length+Right.length];
    //     while (n < Left.length && m < Right.length){
    //         if (Left[n] <= Right[m])
    //         {
    //             tmp[k] = Left[n];
    //             n++;
    //         }
    //         else{
    //             tmp[k] = Right[m];
    //             m++;
    //         }
    //         k++;
    //     }
    //     while (n< Left.length) {
    //         tmp [k] = Left[n];
    //         n++;
    //         k++;
    //     }
    //     while (m< Right.length) {
    //         tmp [k] = Left[m];
    //         m++;
    //         k++;
    //     }
        
    //     return tmp;
    // }
    


    // public static Long[] mergeSort(Long[] in){
    //     Long[] out = ms(in);
    //     //сначала дробим массив на равные части;
    //     //потом сортируем части(рекурсивно?)
    //     //потом поэлементно собираем последний массив из отсортированных
    //     return out;

    // }
    public static void inFile(Object content, String fileName){
        if ( !(content instanceof ArrayList) && !(content instanceof String) &&
        !(content instanceof List) && !(content instanceof Object[])){
            throw new UnsupportedOperationException("Not implemented");
        }
        StringBuilder writeThis = new StringBuilder();
        if (content instanceof Long[]) {
            Long[] content_ = (Long[]) content;
            // content = Arrays.toString(content);
            for (int i = 0; i < content_.length; i++) {
                writeThis.append(content_[i]);
                writeThis.append("\n");}
        }
        else{
        for (Object i: (List<Object>)content){
            writeThis.append(i.toString());
            writeThis.append("\n");
        }}
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