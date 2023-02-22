/**
 * программа максимум: распарсить страничку из интернета, достать все числа из
 * неё в виде массива и уже его сортировать
 * С одной стороны числа достал, с другой там служебные символы =\.
 */
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.nio.file.Path;
import java.nio.file.Paths;

public class init_collection {
    public static final String unsortedPath = "unsorted.txt";
    public static final String sortedPath = "sorted.txt";
    public static final String defaultPath = 
    "https://github.com/am1bestofluck/java_gb_course";
    public static void main(String[] args) {
        String pathFile_in = unsortedPath;
        Path extractPwd = Paths.get(System.getProperty("user.dir"));
            if (String.valueOf(extractPwd.getFileName()).equals("java_gb_course")){
                pathFile_in = System.getProperty("user.dir")+ "\\sem3\\dz\\"
                + unsortedPath;
            }
        URL webPath = null;
        try {
            if (args.length == 1 ){
                webPath = new URL(args[0]);
            }
            else {
                webPath = new URL(defaultPath);
            }
        } catch (MalformedURLException urle) {
            System.out.println("Мразотная джава!");
            System.out.println("Требует обработать исключение которое");
            System.out.println("теоретически МОЖЕТ выстрелить");
            System.out.println("Строчки должны быть однострочными потому что ");
            System.out.println("The Java feature 'Text Blocks' is only available with source level 15 and above");
            System.out.println("Между \"быть джавистом\" и быть N. ВЫБЕРУ ВТОРОЕ ВСЕГДА");

            urle.getStackTrace();
        }
        try {
            Scanner readPage = new Scanner(webPath.openStream());
            StringBuffer pile = new StringBuffer();
            while (readPage.hasNext()) {
                pile.append(readPage.next());
            }
            readPage.close();

            FileWriter temp = new FileWriter(pathFile_in,false);
            temp.flush();
            String tmp = pile.toString();
            Pattern maskDigits = Pattern.compile("-?\\d+");
            Matcher extractDigits = maskDigits.matcher(tmp);
            while (extractDigits.find()){
                temp.append(String.format("%s ",extractDigits.group(0)));
            }
            System.out.println("");
                
            }
        catch(IOException ioe) {
            ioe.getStackTrace();
        }


    }


}