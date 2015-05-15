import java.util.Random;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
/**
 * Write a description of class Dot here.
 * 
 * @author Saayujh Ramanathan
 * @version (a version number or a date)
 */
public class Dot
{
    // instance variables - replace the example below with your own
    private int dir;
    private int x,y;
    private int speed = 4;
    private int diameter;

    private Random gen = new Random();
    /**
     * Constructor for objects of class Dot
     */
    public Dot()
    {
        dir = gen.nextInt(8);
        diameter = 30;
        x = gen.nextInt(500-diameter);
        y = gen.nextInt(200-diameter);
    }

    public void move()
    {
        if (dir == 0)
        {
            x += speed;
        }
        else if (dir == 1)
        {
            x += speed;
            y -= speed;
        }
        else if (dir == 2)
        {
            y -= speed;
        }
        else if (dir == 3)
        {
            x -= speed;
            y -= speed;
        }
        else if (dir == 4)
        {
            x -= speed;
        }
        else if (dir == 5)
        {
            x -= speed;
            y += speed;
        }
        else if (dir == 6)
        {
            y += speed;
        }
        else if (dir == 7)
        {
            x += speed;
            y += speed;
        }

        if (x < 0)
        {
            if (dir == 3)
                dir = 5;
            else if (dir == 4)
                dir = 0;
            else if (dir == 5)
                dir = 7;
        }
        else if (y < 0)
        {
            if (dir == 3)
                dir = 5;
            else if (dir == 2)
                dir = 6;
            else if (dir == 1)
                dir = 7;
        }
        else if (x > 500 - diameter)
        {
            if (dir == 1)
                dir = 3;
            else if (dir == 0)
                dir = 4;
            else if (dir == 7)
                dir = 5;
        }
        else if (y > 200 - diameter)
        {
            if (dir == 7)
                dir = 1;
            else if (dir == 6)
                dir = 2;
            else if (dir == 5)
                dir = 3;
        }
    }

    public Rectangle getRect()
    {
        return new Rectangle(x,y,diameter,diameter);
    }

    public void draw(Graphics g)
    {
        g.setColor(Color.YELLOW);
        g.fillRect(x,y,diameter,diameter);
    }
}
