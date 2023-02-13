package sem1;
import java.util.Random;
import java.util.ArrayList;
/**
 * extract_even_numbers
 */
public class extract_even_numbers {

    public static void main(String[] args) {
        byte[] test = createArray(50);
        for (int i : test) {
            System.out.print(i + " ");
        }
        System.out.println();
        ArrayList<Byte> response = readArray(test);
        for (int i = 0; i < response.size(); i++) {
            System.out.print(response.get(i)+ " ");
        }

    }

    public static byte[] createArray(int size){//andFill

        // задаём рандомный массив
        byte[] out = new byte[size];
        Random rn = new Random();
       for (int i = 0; i < out.length; i++) {
           rn.nextBytes(out);
       }
        return out;
    }

    public static ArrayList<Byte> readArray (byte[]array_i){

        ArrayList<Byte> tmp = new ArrayList<Byte>();

        for (byte b : array_i) {
            if (b%2 ==0) {
                tmp.add(b);              
            }
        }
        // byte[] out = tmp.toArray();

        return tmp;

    }
}   


// 20 здесь будет число
// 22 дай новое число отттуда