import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class WumpusPanel extends JPanel implements KeyListener
{
    public static final int PLAYING = 0;
    public static final int DEAD = 1;
    public static final int WON = 2;

    private int status;

    private WumpusPlayer player;

    private WumpusMap map;

    private BufferedImage buffer;


    public WumpusPanel()
    {
        setSize(500,500);
        setLayout(null);
    }
    public void reset()
    {
        status = PLAYING;

    }
    public void paint(Graphics g)
    {

    }
    public void keyPressed(KeyEvent e)
    {

    }
    public void keyReleased(KeyEvent e)
    {

    }
    public void keyTyped(KeyEvent e)
    {

    }
    public void addNotify()
    {
        super.addNotify();
        requestFocus();
    }






}
