/**
 * рисуем карту по волновому алгоритму;
 */

import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;
import java.util.prefs.BackingStoreException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class field {
    public static final String font_red="\u001B[31m";
    public static final String font_green = "\u001B[32m";
    public static final String font_blue="\u001B[34m";
    public static final String font_black = "\u001B[30m";
    public static final String font_white = "\u001B[37m";
    Integer width;
    Integer height;
    Integer[][] body;
    Integer [] entryPoint = new Integer[]{0,0};
    Integer [] destination = new Integer[]{0,0};
    waveNode[][] travelMap;
    static final Pattern validPattern = Pattern.compile("(\\s*-*\\d+\\s*),(\\s*-*\\d+\\s*)");
    
    

    private Hashtable<String,Integer> map_ = new Hashtable<String, Integer>(){{}};
    
    public static void main(String[] args) {
        
        field yep = new field(constants.sizeOfDesk,constants.sizeOfDesk);
        yep.showLegend();
        yep.setWalls();
        // yep.ShowDesk("дефолтная доска");
        yep.SetRoutePoints();
        yep.ShowDesk("Доска с финишем:");
        yep.convertToTree();
        yep.ShowDesk("маршрут");
        yep.findWay();
        System.out.println("");
    }

    public field(int wid, int hei){
        this.width = wid;
        this.height = hei;
        this.body = this.initDesk();
    }

    private Integer[][] initDesk(){
        Integer[][] out = new Integer[this.width][this.height];
        for (int i = 0; i < this.height; i++) {
            if ((i == 0) || (i == this.height-1)){
                for (int j = 0; j < this.width; j++) {
                    out[j][i] = constants.border;
                }}
            else{
                out[0][i] = constants.border;
                out[this.width-1][i] = constants.border;
                for (int q = 1; q < this.width-1; q++) {
                    out[q][i] = constants.emptyCell;
                }
            }
            }
            
        return out;
    }
    
    public void setWalls(){
        String temp;
        String inputPrompt =String.join("\n", new String[]{
            "Ставим стены, в формате \"x,y\".",
            "Начало отсчёта - левый верхний угол.",
            String.format("\nx принадлежит [1,%d], y принадлежит [1,%d].",
            this.width-2,this.height-2),
            "Неадекватный ввод для завершения."
        });
        System.out.println(inputPrompt);
        Scanner sin = new Scanner(System.in);
        
        boolean more = true;
        while (more){
            temp = String.valueOf(sin.nextLine());
            Matcher tryParse = validPattern.matcher(temp);
            if (tryParse.find()){
                // если координаты внутри координат: парсим, ставим -2
                Integer h= Integer.parseInt(tryParse.group(1));
                Integer w = Integer.valueOf(tryParse.group(2));
                if(  ((w >= this.width) || (w < 0)) 
                || ((h >= this.height) || (h < 0))){
                    System.out.println("Не попадаем в размерность. Выходим.");
                    more = false;
                    break;

            }
            else {
                this.body[w][h] = constants.border;
            System.out.println("Ещё?");}
        }
        else {
            System.out.println("Мгм.");
            break;
        }

        }
    return;
    }

    public void ShowDesk(String comment){
        System.out.println(comment);
        StringBuilder normalizer;
        Integer[][] a = this.body;
        String prefix = new String();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j]==constants.border){
                    prefix = font_red;
                }
                else if (a[i][j] == constants.destinationValue){
                    prefix = font_green;
                }
                else if (a[i][j] == constants.startValue){
                    prefix = font_blue;
                }
                else if (a[i][j] == constants.emptyCell){
                    prefix = font_black;
                }
                normalizer = new StringBuilder();
                for (int k = 0; k < constants.cellWidth-String.valueOf(a[i][j]).length(); k++) {
                    normalizer.append(" ");
                }
                System.out.print(prefix + String.valueOf(a[i][j])+normalizer.toString());
            }
            System.out.println();
    }
    prefix = font_black;
    System.out.print(prefix+"");
    }

    public void SetRoutePoints(){
        // Integer[] out = new Integer[]{0,0};
        Scanner sin = new Scanner(System.in);
        String temp ="";
        Matcher ParseIt;
        String prompt_start = String.format(
            "%s в формате \"x,y\", x принадлежит [1,%d], y принадлежит [1,%d]",
            "Отправная точка",this.width-2,this.height-2);
        String prompt_fin = String.format(
            "%s в формате \"x,y\", x принадлежит [1,%d], y принадлежит [1,%d]",
            "Конечная точка",this.width-2,this.height-2);
        boolean correct = false;
        while (!correct){
            System.out.println(prompt_start);//1
            temp = sin.nextLine();
        
        ParseIt = validPattern.matcher(temp);
        if (!ParseIt.find())
        {
            continue;
        }
        Integer h= Integer.parseInt(ParseIt.group(1));
        Integer w = Integer.valueOf(ParseIt.group(2));
        if(
        ((w > this.width-1) || (w < 1)) 
        || ((h > this.height-1)) || (h < 1))
        {
            System.out.println("Не попадаем в размерность.");}
        else if (this.body[w][h] == constants.border){
            System.out.println("Там стена.");
        }
        else {
            this.entryPoint[0] = w;
            this.entryPoint[1] = h;
            this.body[w][h] = constants.startValue;
            correct = true;
        }
    }
        correct = false;
        while (!correct){
            System.out.println(prompt_fin);//1
            temp = sin.nextLine();
        
        ParseIt = validPattern.matcher(temp);
        if (!ParseIt.find())
        {
            continue;
        }
        Integer h= Integer.parseInt(ParseIt.group(1));
        Integer w = Integer.valueOf(ParseIt.group(2));
        if(
        ((w > this.width-1) || (w < 1)) 
        || ((h > this.height-1)) || (h < 1))
        {
            System.out.println("Не попадаем в размерность.");}
        else if (this.body[w][h] == constants.border){
            System.out.println("Там стена.");
        }
        else if ((w == this.entryPoint[0]) && (h == this.entryPoint[1]) ){
            System.out.println("Это точка входа. Вариант пропускаю, но ЗаЧеМ.");
            this.body[w][h] = constants.destinationValue;
            correct = true;
        }
        else {
            this.destination[0] = w;
            this.destination[1] = h;
            this.body[w][h] = constants.destinationValue;
            correct = true;
        }}
        
    }

    void convertToTree(){
        // Integer tesst = 0;
        this.travelMap = new waveNode[this.width][this.height];
        for (int i = 0; i < this.travelMap.length; i++) {
            for (int j = 0; j < this.travelMap[i].length; j++) {
                this.travelMap[i][j] = new waveNode(body[i][j]);
                // this.travelMap[i][j] = new waveNode(tesst);
                // System.out.print(tesst);
                // System.out.print(" ");
                // tesst++;
            }
            // System.out.println();
        }
        if ((width <3) || (height <3)) { 
            return;} // потом об этом подумаю
        //знакомим соседей по углам
        //  сз
        // this.travelMap[1][1].bottomNeighboor = this.travelMap[2][1];
        this.travelMap[1][1].bottomNeighboor = (this.travelMap[2][1].value == constants.border)? null: this.travelMap[2][1];
        this.travelMap[1][1].rightNeighboor = (this.travelMap[1][2].value == constants.border)? null:this.travelMap[1][2];

        //  юз
        this.travelMap[this.height-2][1].upperNeighboor
         = (this.travelMap[this.height-3][1].value == constants.border)? null:this.travelMap[this.height-3][1] ;
        this.travelMap[this.height-2][1].rightNeighboor
         = (this.travelMap[this.height-2][2].value == constants.border)? null:this.travelMap[this.height-2][2] ;

        //  св
        this.travelMap[1][this.width-2].leftNeighboor 
        = (this.travelMap[1][this.width-3].value == constants.border)? null:this.travelMap[1][this.width-3];
        this.travelMap[1][this.width-2].bottomNeighboor
         = (this.travelMap[2][this.width-2].value == constants.border)? null:this.travelMap[2][this.width-2];

        // юв
        this.travelMap[this.width-2][this.height-2].upperNeighboor
        = (this.travelMap[this.width-3][this.height-2].value == constants.border)? null
         : this.travelMap[this.width-3][this.height-2];
        this.travelMap[this.width-2][this.height-2].leftNeighboor
        = (this.travelMap[this.width-2][this.height-3].value == constants.border)? null
         : this.travelMap[this.width-2][this.height-3];
        //знакомим соседей по краям

        //  верхний край
        for (int i = 2; i < this.width-2; i++) {
            this.travelMap[1][i].bottomNeighboor = 
            (this.travelMap[2][i].value == constants.border)? null
            : this.travelMap[2][i];
            this.travelMap[1][i].leftNeighboor =
            (this.travelMap[1][i-1].value == constants.border)? null
            : this.travelMap[1][i-1];
            this.travelMap[1][i].rightNeighboor =
            (this.travelMap[1][i+1].value == constants.border)? null
            : this.travelMap[1][i+1];
        }
        //  нижний край
        for (int i = 2; i < this.height-2; i++) {
            this.travelMap[this.height-2][i].upperNeighboor
             = (this.travelMap[this.height-3][i].value == constants.border)? null
            : this.travelMap[this.height-3][i];
            this.travelMap[this.height-2][i].leftNeighboor 
            = (this.travelMap[this.height-2][i-1].value == constants.border)? null
            : this.travelMap[this.height-2][i-1];
            this.travelMap[this.height-2][i].rightNeighboor
             = (this.travelMap[this.height-2][i+1].value == constants.border)? null
            : this.travelMap[this.height-2][i+1];
        }
        //  правый край
        for (int i = 2; i < this.height-2; i++) {
            this.travelMap[i][this.width -2].upperNeighboor
             = (this.travelMap[i][this.width -1].value == constants.border)? null
             :this.travelMap[i][this.width -1];
            this.travelMap[i][this.width -2].leftNeighboor
             = (this.travelMap[i][this.width -3].value == constants.border)? null
             :this.travelMap[i][this.width -3];
            this.travelMap[i][this.width -2].bottomNeighboor
             = (this.travelMap[i][this.width -1].value == constants.border)? null
             : this.travelMap[i][this.width -1];
        }
        //  левый край
        for (int i = 2; i < this.travelMap.length-2; i++) {
            this.travelMap[i][1].upperNeighboor
             = (this.travelMap[i-1][1].value == constants.border)? null
             : this.travelMap[i-1][1];
            this.travelMap[i][1].rightNeighboor
             = (this.travelMap[i][2].value == constants.border)? null
             : this.travelMap[i][2];
            this.travelMap[i][1].bottomNeighboor
             = (this.travelMap[i+1][1].value == constants.border)? null
             : this.travelMap[i+1][1];}
//08/05/ dr stas
        // знакомим мид
        for (int i = 3; i < this.width-3; i++) {
            for (int j = 3; j < this.height-3; j++) {
                this.travelMap[i][j].upperNeighboor
                 = (this.travelMap[i-1][j].value == constants.border)? null
                 : this.travelMap[i-1][j];
                this.travelMap[i][j].bottomNeighboor
                 = (this.travelMap[i+1][j].value == constants.border)? null
                 : this.travelMap[i+1][j];
                this.travelMap[i][j].leftNeighboor
                 = (this.travelMap[i][j-1].value == constants.border)? null
                 : this.travelMap[i][j-1];
                this.travelMap[i][j].rightNeighboor
                 = (this.travelMap[i][j+1].value == constants.border)? null
                 : this.travelMap[i][j+1];
            }
        }
        System.out.println("nwc");
        waveNode[] test = this.travelMap[1][1].getNeigboors();
        // System.out.println("вк");
        // waveNode[] test = this.travelMap[1][2].getNeigboors();
        // System.out.println("нк");
        // test = this.travelMap[this.travelMap.length-2][2].getNeigboors();
        // System.out.println("пк");
        // test = this.travelMap[1][this.travelMap[0].length-3].getNeigboors();
        // System.out.println("лк");
        // test = this.travelMap[2][1].getNeigboors();
        // System.out.println("мид");
        // test = this.travelMap[5][5].getNeigboors();
        
        System.out.println();

    }
   
    void findWay(){
        waveNode start = this.travelMap[this.entryPoint[0]][this.entryPoint[1]];
        waveNode finish = this.travelMap[this.destination[0]][this.destination[1]];
        Integer counter = 0;
        Integer cells_with_values =0;
        for (int i = 0; i < body.length; i++) {
            for (int j = 0; j < body.length; j++) {
                if (this.travelMap[i][j].value != constants.border){
                    cells_with_values ++;
                }
            }
        }
        System.out.println(cells_with_values);
        try{
        start.traverseOnTree(start,finish,counter,this.travelMap);}
        catch (InterruptedException e){
            System.out.println("break recursion?");
        }
        catch (StackOverflowError q)
        {
            System.out.println(" эхх :(");
        }
        catch (Exception r){
            System.out.println(r.toString());
        }
        System.out.println("out!");
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                System.out.print(this.travelMap[i][j].value);
                System.out.print(" ");

            }
            System.out.println();
        }
        System.out.println();
        
    }
    
    public void showLegend(){
        this.map_.put("Стены",constants.border);
        this.map_.put("Финиш",constants.destinationValue);
        this.map_.put("Старт", constants.startValue);
        this.map_.put("Вакантное", constants.emptyCell);
        for ( Map.Entry<String,Integer> item : this.map_.entrySet()) {
            System.out.println(
                String.format("%s: %d", item.getKey(),
                item.getValue()));
        }
    }

}