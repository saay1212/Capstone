import java.awt.Graphics;
import java.awt.Color;
import java.awt.Rectangle;
/**
 * Write a description of class Player here.
 * 
 * @author Saayujh Ramanathan
 * @version (a version number or a date)
 */
public class Player
{
    private int x,y;
    private int diameter;
    /**
     * Constructor for objects of class Player
     */
    public Player()
    {
        x = 245;
        y = 95;
        diameter = 10;
    }

    public void moveUp()
    {
        if (y > 0)
            y -= 5;
    }
    public void moveDown()
    {
        if (y < 185)
            y += 5;
    }
    public void moveRight()
    {
        if (x < 490)
            x += 5;
    }
    public void moveLeft()
    {
        if (x > 0)
            x -= 5;
    }
    
    public Rectangle getRect()
    {
        return new Rectangle(x,y,diameter,diameter);
    }
    
    public Rectangle getBigRect()
    {
        return new Rectangle(x-30,y-30,diameter+60,diameter+60);
    }
    
    public void draw(Graphics g)
    {
        g.setColor(Color.RED);
        g.fillRect(x,y,diameter,diameter);
    }
}
