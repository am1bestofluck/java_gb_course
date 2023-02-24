

// package sem4.dz;

/**
 * pyrSort
 */
public class pyrSorted {
    BinSearchTree base;
    BinSearchTree sorted;
    public static void main(String[] args) {
        
        }
    public pyrSorted (BinSearchTree base){
        this.base = base;
    }
    private void inLinePyramidicSort(){
        this.sorted = this.base;
    }
    public BinSearchTree ps() {
        // BinSearchTree sorted = new BinSearchTree()
        this.inLinePyramidicSort();
        return this.sorted;
    }
}