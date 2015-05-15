import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Image;

/**
 * Write a description of class BoxComponent here.
 * 
 * @author Saayujh Ramanathan
 * @version (a version number or a date)
 */
public class BoxComponent extends JComponent implements ActionListener,KeyListener

{
    /** description of instance variable x (add comment for each instance variable) */
    private Player player;
    private ArrayList<Dot> dots = new ArrayList<Dot>();
    private Score score;
    private Timer tm;
    private Graphics g;
    private Image back;

    private int fps;
    private int dotcount = 0;
    private int scorec = 0;

    private boolean up=false,down=false,right=false,left=false;
    private boolean check = false;
    /**
     * Default constructor for objects of class BoxComponent
     */
    public BoxComponent()
    {
        fps = 20;
        super.paintComponent(g);
        score = new Score();
        player = new Player();
        //for (int i = 0; i < 15; i++)
            dots.add(new Dot());
        tm = new Timer(fps, this);
        ImageIcon icon = new ImageIcon("back.jpg");
        back = icon.getImage();
    }

    public void paintComponent(Graphics g)
    {
        g.drawImage(back,0,0,this);
        if (!check)
        {
            for (int i = 0; i < dots.size(); i++)
                dots.get(i).draw(g);
            player.draw(g);
            score.draw(g);
            tm.start();
        }
        else
        {
            score.gameOver(g);
        }
    }

    public void actionPerformed(ActionEvent e)
    {
        for (int i = 0; i < dots.size(); i++)
        {
            if (dots.get(i).getRect().intersects(player.getRect()))
                check = true;
        }
        if (!check)
        {
            dotcount++;
            scorec++;
            for (int i = 0; i < dots.size(); i++)
                dots.get(i).move();
            if (dotcount % (fps * 3) == 0)
            {
                dots.add(new Dot());
                if (dots.get(dots.size()-1).getRect().intersects(player.getBigRect()))
                    dots.remove(dots.size()-1);
                dotcount = 0;
            }
            if (scorec % (1000/fps) == 0)
                score.update();
            if (up)
                player.moveUp();
            if (down)
                player.moveDown();
            if (left)
                player.moveLeft();
            if (right)
                player.moveRight();
        }
        repaint();
    }

    public void keyPressed(KeyEvent e)
    {
        if (e.getKeyCode() == KeyEvent.VK_UP)
            up = true;
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
            left = true;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            right = true;
        if (e.getKeyCode() == KeyEvent.VK_DOWN)
            down = true;
    }

    public void keyReleased(KeyEvent e)
    {
        if (e.getKeyCode() == KeyEvent.VK_UP)
        {
            up = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            left = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            right = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN)
        {
            down = false;
        }

    }

    public void keyTyped(KeyEvent e){}

}
