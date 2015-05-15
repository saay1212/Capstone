import java.awt.Font;
import java.awt.Graphics;
import java.awt.Color;
import java.util.Scanner;
import java.io.*;
import java.awt.Image;
import javax.swing.ImageIcon;
/**
 * Write a description of class Score here.
 * 
 * @author (Saayujh Ramanathan) 
 * @version (a version number or a date)
 */
public class Score
{
    private int current;

    public void update()
    {
        current++;
    }

    public void gameOver(Graphics g)
    {
        g.setFont(new Font("Chalkduster", Font.PLAIN, 24));
        g.setColor(Color.GREEN);
        g.drawString("Score: " + current, 35, 175);
        ImageIcon icon = new ImageIcon("gameover.png");
        Image GO = icon.getImage();
        icon = new ImageIcon("logo.png");
        Image skull = icon.getImage();
        //         int high = 0;
        //         try
        //         {
        //             File f = new File("highscore.txt");
        //             Scanner scan = new Scanner(f);
        //             high = scan.nextInt();
        //             if (current > high)
        //             {
        //                 PrintWriter w = new PrintWriter(f);
        //                 w.println(current);
        //                 w.close();
        //                 high = current;
        //             }
        //             scan.close();
        //         }
        //         catch (Exception e){}
        g.drawImage(GO,100,-90,null);
        g.drawImage(skull,20,10,null);
        //g.drawString("High Score: " + high, 200, 120);
    }

    public void draw(Graphics g)
    {
        g.setFont(new Font(null, Font.BOLD, 12));
        g.setColor(Color.GREEN);
        g.drawString("Score: " + current + " seconds", 10, 20);
    }
}
