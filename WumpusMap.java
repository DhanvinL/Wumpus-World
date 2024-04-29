public class WumpusMap
{
    public static final int NUM_ROWS = 10;
    public static int NUM_COLUMNS  = 10;

    public static int NUM_PITS = 10;

    private WumpusSquare[][] grid = new WumpusSquare[10][10];
    private int ladderC;
    private int ladderR;
    public WumpusMap(){

    }
    public void createMap()
    {

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
