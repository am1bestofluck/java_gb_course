import java.util.ArrayList;

/**
 * main
 */
public class Main {

    public static void main(String[] args) {
        BinSearchNode node_ = null;
        cWriter a = new cWriter(cWriter.randomize_incoming(constants.arraysize),constants.fileIn);
        a.write_in();
        cReader test = new cReader(constants.fileIn);
        Integer[] extracted = test.content;
        if (extracted.length == 0) {
            System.out.println("No data extracted");
            System.exit(0);
        }
        else{
            node_ = new BinSearchNode(extracted[0]);
            if (extracted.length >1) {
                for (int i = 1; i < extracted.length; i++) {
                    node_.add(extracted[i]);
                
                }
                System.out.println("");
            }
        }
        node_.grabValues(node_);
        Integer[] tmp = new Integer[node_.sortedRecursionCheckout.size()];
        for (int i = 0; i < node_.sortedRecursionCheckout.size(); i++) {
            tmp[i] = node_.sortedRecursionCheckout.get(i);
        }
        /* ТО что джава убирает переменные которые объявлены внутри цикла
         * это уже трудно объяснимо.
         * Но она убирает их даже если они объявлены снаружи, если на них
         *  в дальнейшем нет ссылок ._. 
        */
        cWriter b = new cWriter(tmp, constants.fileOut);
        b.write_in();
    }
}