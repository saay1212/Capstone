import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 

/**
 * Write a description of class BoxViewer here.
 * 
 * @author Saayujh Ramanathan
 * @version (a version number or a date)
 */
public class BoxViewer
{
    private JFrame frame;
    private BoxComponent box;
    
    /**
     * Default constructor for objects of class FlappyViewer
     */
    public BoxViewer()
    {
        box = new BoxComponent();
        frame = new JFrame();
        frame.add(box);
        frame.addKeyListener(box);
        frame.setTitle("Box Game");
        frame.setSize(500,217);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        box.repaint();
    }
    
    public static void main(String[] args)
    {
        BoxViewer view = new BoxViewer();
    }

}