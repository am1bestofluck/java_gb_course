

/**
 * main
 */
public class Main {

    public static void main(String[] args) {
        cWriter a = new cWriter(cWriter.randomize_incoming(constants.arraysize),constants.fileIn);
        a.write_in();
        cWriter b = new cWriter(new Integer[]{0,1,2}, constants.fileOut);
        b.write_in();
    }
}