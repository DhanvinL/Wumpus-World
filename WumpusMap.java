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
        int randomRow = (int) (Math.random() * ((9)));
        int randomCol = (int) (Math.random() * ((9)));
        for(int i = 0; i < 9; i++){
            System.out.println(randomRow);
            System.out.println(randomCol + "\n");

        }
        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[0].length; c++){

            }
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
