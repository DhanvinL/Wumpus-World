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
        //set all the squares to a wumpus square
        for(int x= 0;x<grid.length;x++)
        {
            for(int y =0;y<grid[0].length;y++)
            {
                grid[x][y] = new WumpusSquare();
            }
        }
        ArrayList<Integer> xUsed = new ArrayList<>();
        ArrayList<Integer> yUsed = new ArrayList<>();
        int randX = 0;
        int randY = 0;
        randX = 0 + (int)(Math.random() * ((9 - 0) + 1));
        randY = 0 + (int)(Math.random() * ((9 - 0) + 1));
        grid[randX][randY] = new WumpusSquare();
        grid[randX][randY].setPit(true);
        xUsed.add(randX);
        yUsed.add(randY);
        //setting the pits
        for(int y = 0;y<9;y++)
        {
            randX = 0 + (int)(Math.random() * ((9 - 0) + 1));
            randY = 0 + (int)(Math.random() * ((9 - 0) + 1));
            while(xUsed.contains(randX) && yUsed.contains(randY))
            {
                randX = 0 + (int)(Math.random() * ((9 - 0) + 1));
                randY = 0 + (int)(Math.random() * ((9 - 0) + 1));
            }
            xUsed.add(randX);
            yUsed.add(randY);
            grid[randX][randY].setPit(true);
        }

        //adding breezes
        for(int i =0;i< grid.length;i++)
        {
            for(int k = 0;k<grid[0].length;k++)
            {

                    if(grid[i][k].getPit())
                    {
                        if(i>0)
                        {
                            grid[i-1][k].setBreeze(true);
                        }
                        if(i<grid.length-1)
                        {
                            grid[i+1][k].setBreeze(true);
                        }
                        if(k>0)
                        {
                            grid[i][k-1].setBreeze(true);
                        }
                        if(k< grid.length-1)
                        {
                            grid[i][k+1].setBreeze(true);
                        }
                    }

            }
        }
        //adding the gold
        int randX1 = 0 + (int)(Math.random() * ((9 - 0) + 1));
        int randY1 = 0 + (int)(Math.random() * ((9 - 0) + 1));
        while(grid[randX1][randY1].getPit() && grid[randX1][randY1].getLadder())
        {
            randX1 = 0 + (int)(Math.random() * ((9 - 0) + 1));
            randY1 = 0 + (int)(Math.random() * ((9 - 0) + 1));
        }
        grid[randX1][randY1].setGold(true);

        //adding ladder
        int randX2 = 0 + (int)(Math.random() * ((9 - 0) + 1));
        int randY2 = 0 + (int)(Math.random() * ((9 - 0) + 1));
        while(grid[randX2][randY2].getPit() && grid[randX2][randY2].getLadder() && grid[randX2][randY2].getGold())
        {
            randX2 = 0 + (int)(Math.random() * ((9 - 0) + 1));
            randY2 = 0 + (int)(Math.random() * ((9 - 0) + 1));
        }
        grid[randX2][randY2].setLadder(true);
        ladderC = randY2;
        ladderR = randX2;

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
    public String toString() {
        String a = "";
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if(grid[row][col].getLadder())
                {
                    a += "L" ;
                }
                else if (grid[row][col].getGold())
                {
                    a += "G" ;

                }
                else if(grid[row][col].getPit())
                {
                    a += "P";

                }
                else{
                    a += "*";
                }



            }
            a += "\r\n";
        }
        return a;
    }

}
