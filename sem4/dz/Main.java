

/**
 * main
 */
public class Main {

    public static void main(String[] args) {
        cWriter a = new cWriter(cWriter.randomize_incoming(constants.arraysize),constants.fileIn);
        a.write_in();
        cReader test = new cReader(constants.fileIn);
        Integer[] asd = test.content;
        cWriter b = new cWriter(asd, constants.fileOut);
        b.write_in();
    }
}