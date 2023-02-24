import java.nio.file.Paths;

/**
 * constants
 */
public class constants {

    public static final Integer arraysize = 100000;
    public static final Integer maxNum = arraysize*2;

    private static final String fileIn_ = "in.txt";
    private static final String fileOut_ = "out.txt";
    private static final String explictPath = "\\sem4\\dz\\";

    public static final String fileIn = (String.valueOf(
        Paths.get(System.getProperty("user.dir"))
    .getFileName()).equals( "java_gb_course")
    )? String.join("",
    new String[]{
        String.valueOf(Paths.get(System.getProperty("user.dir"))), 
        constants.explictPath,fileIn_}): fileIn_;

    public static final String fileOut = (String.valueOf(
        Paths.get(System.getProperty("user.dir"))
    .getFileName()).equals( "java_gb_course")
    )? String.join("",
    new String[]{
        String.valueOf(Paths.get(System.getProperty("user.dir"))), 
        constants.explictPath,fileOut_}): fileOut_;
    public static void main(String[] args) {
        
    }
}