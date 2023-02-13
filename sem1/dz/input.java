import java.util.Scanner;

/**
 * У Меня будет свой инпут с еденицей и нулями!
 */
public class input {

    public static String input_(String invite) {
        Scanner iScanner = new Scanner(System.in);
        System.out.print(invite);
        String out = iScanner.nextLine();
        // next(); - читает первое слово!
        // iScanner.close();
        return out;
    }
    

    public static void main (String[] args) {
     
        String  shout_it= input_("input stuff");
        System.out.println(shout_it);
        String try_more = input_(shout_it);
        System.out.println(try_more);

    }
    }
    


