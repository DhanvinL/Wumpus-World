import javax.swing.*;
import java.util.ArrayList;

public class WumpusFrame extends JFrame
{
    WumpusPanel wumpusPanel = new WumpusPanel();
    public WumpusFrame()
    {
        setSize(500,500);
        setLayout(null);
        add(wumpusPanel);

    }
    public void createMap()
    {
        ArrayList<Integer> rows = new ArrayList<Integer>();
        ArrayList<Integer> cols = new ArrayList<Integer>();

        for(int i = 0; i < 9; i++){
            int randomRow = (int) (Math.random() * ((9)));
            int randomCol = (int) (Math.random() * ((9)));
            if(rows.contains(randomRow) )
            System.out.println(randomRow);
            System.out.println(randomCol + "\n");
        }
        /*for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[0].length; c++){

            }
        }*/
    }


}
