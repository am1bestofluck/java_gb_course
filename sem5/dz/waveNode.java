

/**
 * waveNode
 */
public class waveNode {
    waveNode parent;
    waveNode leftNeighboor;
    waveNode rightNeighboor;
    waveNode upperNeighboor;
    waveNode bottomNeighboor;

    Integer value;
    Integer ox;
    Integer oy;

    public static void main(String[] args) {
    }

    public waveNode(Integer value_i){
        this.value= value_i;
    }
    public  waveNode[] getNeigboors(){
        System.out.println(String.format("this.value = %d", this.value));
        waveNode[] out = new waveNode[]{null,null,null,null};
        if (this.leftNeighboor!= null){
            System.out.println(String.format("left value: %d",
            this.leftNeighboor.value));
            out[0] = this.leftNeighboor;
        }
        if (this.rightNeighboor!= null){
            System.out.println(String.format("right value: %d",
            this.rightNeighboor.value));
            out[1] = this.rightNeighboor;
        }
        if (this.upperNeighboor!= null){
            System.out.println(String.format("upper value: %d",
            this.upperNeighboor.value));
            out[2] = this.upperNeighboor;
        }
        if (this.bottomNeighboor!= null){
            System.out.println(String.format("lower value: %d",
            this.bottomNeighboor.value));
            out[3] = this.bottomNeighboor;
        }
        return out; 
    }
    // public void tryAddNeighboor(String side, Integer value){
    //     if (value == constants.border) {
    //         return;
    //     }
    //     if (side.equals(constants.top)){
    //         this.bottomNeighboor = 

    //     else if(side.equals(constants.bottom)){
    //         System.out.println();}
    //     else if (side.equals(constants.left)){
    //         System.out.println();
    //     }
    //     else if (side.equals(constants.right)){
            
    //     }
    //     }
    public void traverseOnTree(waveNode currentNode, Integer counter){
        if (currentNode != null){
            if (currentNode.bottomNeighboor != null) {
                if (currentNode.bottomNeighboor.value == constants.emptyCell){
                    currentNode.bottomNeighboor.value = counter;
                    System.out.println(currentNode.bottomNeighboor.value);
                    traverseOnTree(currentNode.bottomNeighboor, ++counter);

                }
            }
        if (currentNode.upperNeighboor != null) {
            if (currentNode.upperNeighboor.value == constants.emptyCell){
                currentNode.upperNeighboor.value = counter;
                System.out.println(currentNode.upperNeighboor.value);
                traverseOnTree(currentNode.upperNeighboor, ++counter);
            }
        }
        if (currentNode.leftNeighboor != null) {
            if (currentNode.leftNeighboor.value == constants.emptyCell){
                currentNode.leftNeighboor.value = counter;
                System.out.println(currentNode.leftNeighboor.value);
                traverseOnTree(currentNode.leftNeighboor, ++counter);
            
        }}
        if (currentNode.rightNeighboor != null) {
            if(currentNode.rightNeighboor.value == constants.emptyCell){
                currentNode.rightNeighboor.value = counter;
                System.out.println(currentNode.rightNeighboor);
                traverseOnTree(currentNode.rightNeighboor,++ counter);
            
        }}
        
    }
}
}