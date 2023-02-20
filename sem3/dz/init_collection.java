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

public class init_collection {
    public static final String unsortedPath = "unsorted.txt";
    public static final String defaultPath = 
    "https://github.com/am1bestofluck/java_gb_course";
    public static void main(String[] args) {
        URL webPath = null;
        try {
            if (args.length == 1 ){
                webPath = new URL(args[0]);
            }
            else {
                webPath = new URL(defaultPath);
            }
        } catch (MalformedURLException urle) {
            System.out.println("""
                Мразотная джава! Требует обработать
                исключение которое теоретически МОЖЕТ выстрелить
                """);
            urle.getStackTrace();
        }
        try {
            Scanner readPage = new Scanner(webPath.openStream());
            StringBuffer pile = new StringBuffer();
            while (readPage.hasNext()) {
                pile.append(readPage.next());
            }
            readPage.close();

            FileWriter temp = new FileWriter(unsortedPath,false);
            temp.flush();
            String tmp = pile.toString();
            Pattern maskDigits = Pattern.compile("\\d+");
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