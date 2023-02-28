/**
 * рисуем карту по волновому алгоритму;
 */

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
    
    public static void main(String[] args) {
        field yep = new field(12,12);
        yep.setWalls();
        yep.ShowDesk("дефолтная доска");
        yep.SetRoutePoints();
        yep.ShowDesk("Доска с финишем");
        yep.drawRoute();
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
            this.width-1,this.height-1),
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
            "Отправная точка",this.width-1,this.height-1);
        String prompt_fin = String.format(
            "%s в формате \"x,y\", x принадлежит [1,%d], y принадлежит [1,%d]",
            "Конечная точка",this.width-1,this.height-1);
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
        waveNode[][] grid = new waveNode[this.width][this.height];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                grid[i][j] = new waveNode(body[i][j]);
            }
        }
        if ((width <2) || (height <2)) { 
            return;} // потом об этом подумаю
        //знакомим соседей по углам
        //  сз
        grid[0][0].bottomNeighboor = grid[1][0];
        grid[0][0].rightNeghboor = grid[0][1];
        
        //  юз
        grid[0][this.height-1].upperNeigboor = grid[0][this.height-2];
        grid[0][this.height-1].rightNeghboor = grid[1][this.height-1];

        //  св
        grid[this.width-1][0].leftNeigboor = grid[this.width-2][0];
        grid[this.width-1][0].bottomNeighboor = grid[this.width-1][1];

        // юв
        grid[this.width-1][this.height-1].upperNeigboor= grid[this.width-1][this.height-2];
        grid[this.width-1][this.height-1].leftNeigboor= grid[this.width-2][this.height-1];
        //знакомим соседей по краям

        //  верхний край
        for (int i = 1; i < this.width-1; i++) {
            grid[1][i].bottomNeighboor = grid[2][i];
            grid[1][i].leftNeigboor =grid[1][i-1];
            grid[1][i].rightNeghboor =grid[1][i+1];
        }
        //  нижний край
        for (int i = 1; i < this.width-1; i++) {
            grid[this.height-2][i].upperNeigboor = grid[this.height-1][i];
            grid[this.height-2][i].leftNeigboor =grid[this.height-1][i-1];
            grid[this.height-2][i].rightNeghboor =grid[this.height-1][i+1];
        }
        //  правый край
        for (int i = 1; i < grid.length-1; i++) {
            grid[this.width-2][i].upperNeigboor = grid[this.width-2][i-1];
            grid[this.width-2][i].leftNeigboor = grid[this.width-3][i];
            grid[this.width-2][i].bottomNeighboor = grid[this.width-2][i+1];
        }
        //  левый край
        for (int i = 1; i < grid.length-1; i++) {
            grid[1][i].upperNeigboor = grid[1][i-1];
            grid[1][i].rightNeghboor = grid[2][i];
            grid[1][i].bottomNeighboor = grid[1][i+1];}

        //знакомим мид
        for (int i = 2; i < this.width-2; i++) {
            for (int j = 2; j < this.height-2; j++) {
                grid[i][j].upperNeigboor=grid[i][j-1];
                grid[i][j].bottomNeighboor=grid[i][j+1];
                grid[i][j].leftNeigboor=grid[i-1][j];
                grid[i][j].rightNeghboor=grid[i+1][j];
            }
        }

        System.out.println();

    }

}