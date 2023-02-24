

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
        // BinSearchTree bst = new BinSearchTree(extracted);
        // bst.node.traverseInOrder(bst.node);
        System.out.println(node_);//джава почему ты убираешь мусор так яростно
        cWriter b = new cWriter(extracted, constants.fileOut);
        b.write_in();
    }
}