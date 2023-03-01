/**
 * рисуем карту по волновому алгоритму;
 */

import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class field {
    
    Integer width;
    Integer height;
    Integer[][] body;
    Integer [] entryPoint = new Integer[]{0,0};
    Integer [] destination = new Integer[]{0,0};
    static final Pattern validPattern = Pattern.compile("(\\s*-*\\d+\\s*),(\\s*-*\\d+\\s*)");
    
    static final Integer cellWidth = 5;
    private final Integer border = -3;
    private final Integer emptyCell = -2;
    private final Integer startValue = 0;
    private final Integer destinationValue = -1;

    private Hashtable<String,Integer> map_ = new Hashtable<>(){{}};
    
    public static void main(String[] args) {
        
        field yep = new field(6,6);
        yep.showLegend();
        yep.setWalls();
        yep.ShowDesk("дефолтная доска");
        yep.SetRoutePoints();
        yep.ShowDesk("Доска с финишем:");
        yep.drawRoute();
        yep.ShowDesk("маршрут");
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
                    out[j][i] = border;
                }}
            else{
                out[0][i] = border;
                out[this.width-1][i] = border;
                for (int q = 1; q < this.width-1; q++) {
                    out[q][i] = emptyCell;
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
                this.body[w][h] = border;
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
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                normalizer = new StringBuilder();
                for (int k = 0; k < cellWidth-String.valueOf(a[i][j]).length(); k++) {
                    normalizer.append(" ");
                }
                System.out.print(String.valueOf(a[i][j])+normalizer.toString());
            }
            System.out.println();
    }
    }

    public void SetRoutePoints(){
        Integer[] out = new Integer[]{0,0};
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
        else if (this.body[w][h] == border){
            System.out.println("Там стена.");
        }
        else {
            this.entryPoint[0] = w;
            this.entryPoint[1] = h;
            this.body[w][h] = startValue;
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
        else if (this.body[w][h] == border){
            System.out.println("Там стена.");
        }
        else if ((w == this.entryPoint[0]) && (h == this.entryPoint[1]) ){
            System.out.println("Это точка входа. Вариант пропускаю, но ЗаЧеМ.");
            this.body[w][h] = destinationValue;
            correct = true;
        }
        else {
            this.destination[0] = w;
            this.destination[1] = h;
            this.body[w][h] = destinationValue;
            correct = true;
        }}
        
    }

    void drawRoute(){
        // Integer tesst = 0;
        waveNode[][] grid = new waveNode[this.width][this.height];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = new waveNode(body[i][j]);
                // grid[i][j] = new waveNode(tesst);
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
        grid[1][1].bottomNeighboor = grid[2][1];
        grid[1][1].rightNeighboor = grid[1][2];

        //  юз
        grid[this.height-2][1].upperNeighboor = grid[this.height-3][1];
        grid[this.height-2][1].rightNeighboor = grid[this.height-2][2];

        //  св
        grid[1][this.width-2].leftNeighboor = grid[1][this.width-3];
        grid[1][this.width-2].bottomNeighboor = grid[2][this.width-2];

        // юв
        grid[this.width-2][this.height-2].upperNeighboor
        = grid[this.width-3][this.height-2];
        grid[this.width-2][this.height-2].leftNeighboor
        = grid[this.width-2][this.height-3];
        //знакомим соседей по краям

        //  верхний край
        for (int i = 2; i < this.width-2; i++) {
            grid[1][i].bottomNeighboor = grid[2][i];
            grid[1][i].leftNeighboor =grid[1][i-1];
            grid[1][i].rightNeighboor =grid[1][i+1];
        }
        //  нижний край
        for (int i = 2; i < this.height-2; i++) {
            grid[this.height-2][i].upperNeighboor = grid[this.height-3][i];
            grid[this.height-2][i].leftNeighboor =grid[this.height-2][i-1];
            grid[this.height-2][i].rightNeighboor =grid[this.height-2][i+1];
        }
        //  правый край
        for (int i = 2; i < this.height-2; i++) {
            grid[i][this.width -2].upperNeighboor = grid[i][this.width -1];
            grid[i][this.width -2].leftNeighboor = grid[i][this.width -3];
            grid[i][this.width -2].bottomNeighboor = grid[i][this.width -1];
        }
        //  левый край
        for (int i = 2; i < grid.length-2; i++) {
            grid[i][1].upperNeighboor = grid[i-1][1];
            grid[i][1].rightNeighboor = grid[i][2];
            grid[i][1].bottomNeighboor = grid[i+1][1];}
//08/05/ dz stas
        // знакомим мид
        for (int i = 3; i < this.width-3; i++) {
            for (int j = 3; j < this.height-3; j++) {
                grid[i][j].upperNeighboor=grid[i-1][j];
                grid[i][j].bottomNeighboor=grid[i+1][j];
                grid[i][j].leftNeighboor=grid[i][j-1];
                grid[i][j].rightNeighboor=grid[i][j+1];
            }
        }
        // System.out.println("вк");
        // waveNode[] test = grid[1][2].getNeigboors();
        // System.out.println("нк");
        // test = grid[grid.length-2][2].getNeigboors();
        // System.out.println("пк");
        // test = grid[1][grid[0].length-3].getNeigboors();
        // System.out.println("лк");
        // test = grid[2][1].getNeigboors();
        // System.out.println("мид");
        // test = grid[5][5].getNeigboors();
        
        System.out.println();

    }
    public void showLegend(){
        this.map_.put("Стены:",this.border);
        this.map_.put("Финиш:",this.destinationValue);
        this.map_.put("Старт", this.startValue);
        this.map_.put("Вакантное", this.emptyCell);
        for ( var item : this.map_.entrySet()) {
            System.out.println(
                String.format("%s: %d", item.getKey(),
                item.getValue()));
        }
    }

}