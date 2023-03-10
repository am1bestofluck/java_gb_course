
/**
 * waveNode
 */
public class waveNode {
    waveNode parent;
    waveNode leftNeighboor;
    waveNode rightNeighboor;
    waveNode upperNeighboor;
    waveNode bottomNeighboor;
    Boolean visited = false;
    Boolean edited = false;

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

    // public void traverseOnTree(waveNode currentNode,waveNode destination, Integer counter, waveNode[][] desk){
    //         System.out.println(counter);
    //         if (counter == 4320){
    //             System.out.println("qwe");
    //         }

    //     if (currentNode.bottomNeighboor != null) {
    //         if (currentNode.bottomNeighboor.value == constants.destinationValue){
    //             currentNode.bottomNeighboor.value = counter+1;
    //         return;}
    //         if (currentNode.bottomNeighboor.value == constants.emptyCell){
    //             currentNode.bottomNeighboor.value = counter+1;}
    //         }
            
    //     if (currentNode.upperNeighboor != null) {
    //         if (currentNode.upperNeighboor.value == constants.destinationValue){
    //             currentNode.upperNeighboor.value = counter+1;
    //         return;}
    //         if (currentNode.upperNeighboor.value == constants.emptyCell){
    //             currentNode.upperNeighboor.value = counter+1;}
           
    //     }
    //     if (currentNode.leftNeighboor != null) {
    //         if (currentNode.leftNeighboor.value == constants.destinationValue){
    //             currentNode.leftNeighboor.value = counter+1;
    //         return;}
    //         if (currentNode.leftNeighboor.value == constants.emptyCell){
    //             currentNode.leftNeighboor.value = counter+1;}
    //         }
    //     if (currentNode.rightNeighboor != null) {
    //         if(currentNode.rightNeighboor.value == constants.destinationValue){
    //             currentNode.rightNeighboor.value = counter+1;
    //         return;}
    //         if(currentNode.rightNeighboor.value == constants.emptyCell){
    //             currentNode.rightNeighboor.value = counter+1;}
                

    //     if ((currentNode.bottomNeighboor != null)
    //     || (currentNode.upperNeighboor != null)
    //     || (currentNode.leftNeighboor != null)
    //     || (currentNode.rightNeighboor != null)){

    //     if (currentNode.bottomNeighboor != null) {
    //         traverseOnTree(currentNode.bottomNeighboor,destination, ++counter,desk);
    //     }
    //     if (currentNode.upperNeighboor != null) {
    //         traverseOnTree(currentNode.upperNeighboor, destination, ++counter,desk);
    //     }
    //     if (currentNode.leftNeighboor != null) {
    //         traverseOnTree(currentNode.leftNeighboor, destination, ++counter,desk);
    //     }
    //     if (currentNode.rightNeighboor != null) {
    //         traverseOnTree(currentNode.rightNeighboor,destination, ++counter,desk);
    //     }
    //     }
    //     else if (currentNode.value == 0 && counter != 1);
    //     {
    //         return;
    //     }

    //     }
    //     else return;
            
    //     }

    public void traverseOnTree( 
        waveNode currentNode,waveNode destination,
         Integer counter, waveNode[][] desk) throws InterruptedException{
            // сначала условие выхода.

            // currentNode.value = counter;
            // System.out.println();
            currentNode.visited = true;
            // for (int i = 0; i < desk.length; i++) {
            //     for (int j = 0; j < desk.length; j++) {
            //         System.out.print(String.format("%5d",desk[i][j].value));

            //     }
            //     System.out.println();
            // }
            if (currentNode.bottomNeighboor != null) {
                if (!currentNode.bottomNeighboor.visited){
                    if (!currentNode.bottomNeighboor.edited)
                        {currentNode.bottomNeighboor.value = counter+1;
                        currentNode.bottomNeighboor.edited = true;}}
                if (currentNode.bottomNeighboor.equals(destination)){
                    System.out.println("bottom");
                    throw new InterruptedException ("Мы тут закончили!");
                }
            }
            if (currentNode.upperNeighboor != null) {
                if(!currentNode.upperNeighboor.visited){
                    if( !currentNode.upperNeighboor.edited){
                        {currentNode.upperNeighboor.value = counter+1;
                        currentNode.upperNeighboor.edited = true;}}}
                if (currentNode.upperNeighboor.equals(destination)){
                    System.out.println("upper");
                    throw new InterruptedException ("Мы тут закончили!");}
            }
            if (currentNode.leftNeighboor != null) {
                if(!currentNode.leftNeighboor.visited){
                    if(!currentNode.leftNeighboor.edited)
                        {currentNode.leftNeighboor.value = counter +1;
                        currentNode.leftNeighboor.edited = true;}}
                if (currentNode.leftNeighboor.equals(destination)){
                    System.out.println("left");
                    throw new InterruptedException ("Мы тут закончили!");}
            }
            if (currentNode.rightNeighboor != null) {
                if(!currentNode.rightNeighboor.visited){
                    if (!currentNode.rightNeighboor.edited){
                        currentNode.rightNeighboor.value = counter+1;
                        currentNode.rightNeighboor.edited=true;}}
                if (currentNode.rightNeighboor.equals(destination)){
                    System.out.println("right");
                    throw new InterruptedException ("Мы тут закончили!");}
            }
            counter ++;
            
            if (currentNode.bottomNeighboor != null) {
                if (
                    !currentNode.bottomNeighboor.visited
                    // currentNode.bottomNeighboor.value == constants.emptyCell
                // || currentNode.bottomNeighboor.value != counter
                )
                { 
                System.out.println("recursion bottom");
                traverseOnTree(currentNode.bottomNeighboor, destination, counter, desk);
                }
            }
            if (currentNode.upperNeighboor != null) {
                if (
                    !currentNode.upperNeighboor.visited
                    // currentNode.upperNeighboor.value == constants.emptyCell
                // || currentNode.upperNeighboor.value != counter
                ){
                System.out.println("recusion top");
                traverseOnTree(currentNode.upperNeighboor, destination, counter, desk);}
            }
            if (currentNode.leftNeighboor != null) {
                if (
                    !currentNode.leftNeighboor.visited
                    // currentNode.leftNeighboor.value == constants.emptyCell
                // || currentNode.leftNeighboor.value != counter

                )
                {System.out.println("recursion left");
                traverseOnTree(currentNode.leftNeighboor, destination, counter, desk);}
            }
            if (currentNode.rightNeighboor != null) {
                if(
                    !currentNode.rightNeighboor.visited
                    // currentNode.rightNeighboor.value == constants.emptyCell
                // || currentNode.rightNeighboor.value != counter
                ){
                    System.out.println("recursion right");
                traverseOnTree(currentNode.rightNeighboor, destination, counter, desk);}
            }


         }
    
    public void traverseOnTree_queue(){}
        }