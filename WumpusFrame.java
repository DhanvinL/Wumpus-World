import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class WumpusFrame extends JFrame
{
    WumpusPanel wumpusPanel = new WumpusPanel();
    public WumpusFrame()
    {
        setVisible(true);
        setSize(575,800);
        setLayout(null);
        add(wumpusPanel);

    }
}