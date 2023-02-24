import java.util.ArrayList;

/**
 * https://www.baeldung.com/java-binary-tree#:~:text=A%20binary%20tree%20is%20a,in%20the%20right%20sub%2Dtree.
 */
public class BinSearchNode {
    public ArrayList<Integer> sortedRecursionCheckout = new ArrayList<Integer>();
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
    
        if (value < current.value) {
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

    public void grabValues( 
    BinSearchNode node) {
        if (node != null) {
            grabValues( node.left);
            this.sortedRecursionCheckout.add(node.value);
            grabValues(node.right);
        }

    }
    public Integer[] returnSorted( BinSearchNode node){
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        if (node != null) {
            traverseInOrder(node.left);
            tmp.add(node.value);
            traverseInOrder(node.right);
            tmp.add(node.value);
        }
        
        Integer[] out = new Integer[tmp.size()];
        for (int i = 0; i < tmp.size(); i++) {
            out[i] = tmp.get(i);
        }
        
        return out;
    }
    public static void main(String[] args) {
        
    }

}