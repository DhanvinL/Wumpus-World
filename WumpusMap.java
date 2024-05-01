import java.lang.reflect.Array;
import java.util.ArrayList;

public class WumpusMap
{
    public static final int NUM_ROWS = 10;
    public static int NUM_COLUMNS  = 10;

    public static int NUM_PITS = 10;

    private WumpusSquare[][] grid = new WumpusSquare[10][10];
    private int ladderC;
    private int ladderR;
    public WumpusMap(){
        createMap();
    }
    public void createMap()
    {
        //1 is pit
        //2 is breeze
        ArrayList<Integer> xUsed = new ArrayList<>();
        ArrayList<Integer> yUsed = new ArrayList<>();
        boolean go = true;
        int randX = 0;
        int randY = 0;
        int count = 1;
        while(count <11)
        {
            for(int y = 0;y<9;y++)
            {
                randX = 0 + (int)(Math.random() * ((9 - 0) + 1));
                randY = 0 + (int)(Math.random() * ((9 - 0) + 1));
               while(!xUsed.contains(randX) && !yUsed.contains(randY))
               {
                   randX = 0 + (int)(Math.random() * ((9 - 0) + 1));
                   randY = 0 + (int)(Math.random() * ((9 - 0) + 1));
               }


                xUsed.add(randX);
                yUsed.add(randY);
                grid[randX][randY] = new WumpusSquare();
                grid[randX][randY]
            }
            count++;
        }

    }
    public int getLadderC()
    {
        return ladderC;
    }
    public int getLadderR()
    {
        return ladderR;
    }
    public WumpusSquare getSquare(int col, int row)
    {
        return grid[col][row];
    }
    public String toString()
    {
        return "";
    }


}
