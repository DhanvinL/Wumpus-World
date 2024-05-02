import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class WumpusFrame extends JFrame
{
    WumpusPanel wumpusPanel = new WumpusPanel();
    public WumpusFrame()
    {
        setVisible(true);
        setSize(800,800);
        setLayout(null);
        add(wumpusPanel);
        paint(new Graphics());
    }
    public void paint(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0,500,800,300);
    }
}
