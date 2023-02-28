/**
 * waveNode
 */
public class waveNode {
    waveNode parent;
    waveNode leftNeigboor;
    waveNode rightNeghboor;
    waveNode upperNeigboor;
    waveNode bottomNeighboor;

    Integer value;
    Integer ox;
    Integer oy;

    public static void main(String[] args) {
    }

    public waveNode(Integer value_i){
        this.value= value_i;
    }
}