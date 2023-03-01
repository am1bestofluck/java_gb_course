

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
    
}