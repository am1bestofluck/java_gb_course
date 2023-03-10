package sem5.dz_att2;

import java.util.Scanner;

/**
 * Карта по которой будет сроиться граф
 */
public class map_s {
    square[][] body;
    //*Инитим доску */
    public map_s( int width , int height){
        this.body = new square[width][height];
        for (int i = 0; i < body.length; i++) {
            for (int j = 0; j < body.length; j++) {
                this.body[i][j] = new square(0);
            }
        }
    }
    /** ставим старт и финиш */ 
    private void setRoutePoints(){
        String[] tmp_str;
        Integer[] tmp = new Integer[2];
        Scanner in_ = new Scanner(System.in);
        boolean keepCatchingWalls = true;
        
        System.out.println("Input start coordinates(int,int)");
        String parseStart = in_.nextLine();
        tmp_str = parseStart.split(",");
        for (int i = 0; i < tmp_str.length; i++) {
            tmp[i] = Integer.valueOf(tmp_str[i]);
        }
        this.body[tmp[1]][tmp[0]].value = 1;
        System.out.println("Input destination coordinates(int,int)");
        String parseEnd = in_.nextLine();
        tmp_str = parseEnd.split(",");
        for (int i = 0; i < tmp_str.length; i++) {
            tmp[i] = Integer.valueOf(tmp_str[i]);
        }
        this.body[tmp[1]][tmp[0]].value = -1;
        try{
            while (keepCatchingWalls) {
                System.out.println("Add wall? Ctrl-c to stop");
                String parseWall = in_.nextLine();
                for (int i = 0; i < tmp_str.length; i++) {
                    tmp[i] = Integer.valueOf(tmp_str[i]);
                }
                this.body[tmp[1]][tmp[0]].value = -2;
            } 
        }
        catch(InterruptedException e)
        {
            System.out.println("got it!");
        }

    }

    public static void main(String[] args) {
        
    }
    }