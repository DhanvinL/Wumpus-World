import javax.swing.*;

public class WumpusFrame extends JFrame
{
    WumpusPanel wumpusPanel = new WumpusPanel();
    public WumpusFrame()
    {
        setSize(500,500);
        setLayout(null);
        add(wumpusPanel);

    }


}
