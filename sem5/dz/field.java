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
    public static void main(String[] args) {
        field yep = new field(10,10);
        Integer[][] a = yep.body;
        yep.setWalls();
        System.out.println("");
        
    }
    public field(int wid, int hei){
        this.width = wid;
        this.height = hei;
        this.body = this.getDesk();
    }
    public Integer[][] getDesk(){
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
        Pattern validPattern = Pattern.compile("(\\s*\\d+\\s*),(\\s*\\d+\\s*)");
        String inputPrompt =String.join(" ", new String[]{
            "Ставим стены, в формате \"x,y\".",
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
                Integer w= Integer.parseInt(tryParse.group(1));
                Integer h = Integer.valueOf(tryParse.group(2));
                if(  (w >= this.width) || (h >= this.height)){
                    System.out.println("Не попадаем в размерность. Выходим.");
                    more = false;
                    break;

            }
            else {
                this.body[w][h] = -2;}
        }
        else {
            System.out.println("Мгм.");
            break;
        }

        }
    return;
    }

    }