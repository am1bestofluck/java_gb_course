//ctrlc ctrlv =\ 
//https://javatutorial.net/display-text-and-graphics-java-jframe/

import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class drawText extends JPanel{
    public void paint(Graphics g){
        g.drawString("why hello",63, 38);
    }
    
    public static void main(String[] args){
        JFrame frame= new JFrame("копипаста с javatutorial.net");    
        frame.getContentPane().add(new drawText());
        frame.setSize(250, 150);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);        
    }
}