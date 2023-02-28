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
    static final Integer cellWidth = 5;
    static final Pattern validPattern = Pattern.compile("(\\s*-*\\d+\\s*),(\\s*-*\\d+\\s*)");
    
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
        this.body = this.getDesk();
    }

    private Integer[][] getDesk(){
        Integer[][] out = new Integer[this.width][this.height];
        for (int i = 0; i < this.height; i++) {
            if ((i == 0) || (i == this.height-1)){
                for (int j = 0; j < this.width; j++) {
                    out[j][i] = -2;
                }}
            else{
                out[0][i] = -2;
                out[this.width-1][i] = -2;
                for (int q = 1; q < this.width-1; q++) {
                    out[q][i] = 0;
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
                this.body[w][h] = -2;
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
        else if (this.body[w][h] == -2){
            System.out.println("Там стена.");
        }
        else {
            this.entryPoint[0] = w;
            this.entryPoint[1] = h;
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
        else if (this.body[w][h] == -2){
            System.out.println("Там стена.");
        }
        else if ((w == this.entryPoint[0]) && (h == this.entryPoint[1]) ){
            System.out.println("Это точка входа. Вариант пропускаю, но ЗаЧеМ.");
            this.body[w][h] = -1;
            correct = true;
        }
        else {
            this.destination[0] = w;
            this.destination[1] = h;
            this.body[w][h] = -1;
            correct = true;
        }}
        
    }

    void drawRoute(){
        Integer[][] copy = new Integer[this.width][this.height];
        for (int i = 0; i < copy.length; i++) {
            for (int j = 0; j < copy.length; j++) {
                copy[i][j] = this.body[i][j];
            }
        }
        waveNode p = new waveNode(
            copy[this.entryPoint[0]][this.entryPoint[1]],
        this.entryPoint[0],this.entryPoint[1]);
        
        System.out.println();

    }

}