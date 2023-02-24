/**
 * https://www.baeldung.com/java-binary-tree#:~:text=A%20binary%20tree%20is%20a,in%20the%20right%20sub%2Dtree.
 */
public class BinSearchNode {
    BinSearchNode root;
    int value;
    BinSearchNode left;
    BinSearchNode right;

    public BinSearchNode(Integer value){
        this.value = value;
        right = null;
        left = null;
    }
    
    private BinSearchNode addRecursive(BinSearchNode current, int value) {
        if (current == null) {
            return new BinSearchNode(value);
        }
    
        if (value < current.    value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        } else {
            // value already exists
            return current;
        }
    
        return current;
    }
    public void add(int value) {
        root = addRecursive(root, value);
    }
    
    public void traverseInOrder(BinSearchNode node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(" " + node.value);
            traverseInOrder(node.right);
        }
    }
    public static void main(String[] args) {
    //     BinSearchNode bt = new BinSearchNode(0);

    // bt.add(6);
    // bt.add(4);
    // bt.add(8);
    // bt.add(3);
    // bt.add(5);
    // bt.add(7);
    // bt.add(9);
    // System.out.println(bt);
    // return bt;
        
    }

}