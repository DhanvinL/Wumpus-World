import java.util.Random;

public class WumpusMap {
    public static final int NUM_ROWS = 10;
    public static final int NUM_COLUMNS = 10;
    public static final int NUM_PITS = 10;

    private WumpusSquare[][] grid;
    private int ladderC;
    private int ladderR;

    public WumpusMap() {
        createMap();
    }

    public void createMap() {
        grid = new WumpusSquare[NUM_ROWS][NUM_COLUMNS];

        for (int i = 0; i < NUM_ROWS; i++) {
            for (int j = 0; j < NUM_COLUMNS; j++) {
                grid[i][j] = new WumpusSquare();
            }
        }

        for (int i = 0; i < NUM_PITS; i++) {
            int col = (int)(Math.random() * ((9 - 0) + 1));

            int row = (int)(Math.random() * ((9 - 0) + 1));

            grid[row][col].setPit(true);
            setBreezes(row, col);
        }

        int goldCol, goldRow;
        do {
            goldCol = (int)(Math.random() * ((9 - 0) + 1));
            goldRow = (int)(Math.random() * ((9 - 0) + 1));
        } while (grid[goldRow][goldCol].getPit());
        grid[goldRow][goldCol].setGold(true);

        int wumpusCol, wumpusRow;
        do {
            wumpusCol = (int)(Math.random() * ((9 - 0) + 1));
            wumpusRow = (int)(Math.random() * ((9 - 0) + 1));
        } while (grid[wumpusRow][wumpusCol].getPit() || grid[wumpusRow][wumpusCol].getGold());
        grid[wumpusRow][wumpusCol].setWumpus(true);
        setStenches(wumpusRow, wumpusCol);

        do {
            ladderC = (int)(Math.random() * ((9 - 0) + 1));
            ladderR = (int)(Math.random() * ((9 - 0) + 1));
        } while (grid[ladderR][ladderC].getPit() || grid[ladderR][ladderC].getWumpus() || grid[ladderR][ladderC].getGold());
        grid[ladderR][ladderC].setLadder(true);
    }

    private void setBreezes(int row, int col) {

            if (row > 0) grid[row - 1][col].setBreeze(true);
            if (row < NUM_ROWS - 1) grid[row + 1][col].setBreeze(true);
            if (col > 0) grid[row][col - 1].setBreeze(true);
            if (col < NUM_COLUMNS - 1) grid[row][col + 1].setBreeze(true);

    }

    private void setStenches(int row, int col) {
        if(!grid[row][col].getPit() && !grid[row][col].getStench()) {

            if (row > 0) grid[row - 1][col].setStench(true);
            if (row < NUM_ROWS - 1) grid[row + 1][col].setStench(true);
            if (col > 0) grid[row][col - 1].setStench(true);
            if (col < NUM_COLUMNS - 1) grid[row][col + 1].setStench(true);
        }
    }

    public int getLadderC() {
        return ladderC;
    }

    public int getLadderR() {
        return ladderR;
    }

    public WumpusSquare getSquare(int col, int row) {
        if (col < 0 || col >= NUM_COLUMNS || row < 0 || row >= NUM_ROWS)
            return null;
        return grid[row][col];
    }
    public String toString() {
        String a = "";
        int v = 0;
        int i =0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if(grid[row][col].getPit())
                {
                    a += "P" ;
                    v++;
                }
                else if (grid[row][col].getGold())
                {
                    a += "G" ;
                    i++;

                }
                else if(grid[row][col].getLadder())
                {
                    a += "L";

                } else if (grid[row][col].getWumpus()) {
                    a += "W";

                } else{
                    a += "*";
                }



            }
            a += "\r\n";
        }
        a += "The pit number is " + i  + "The gold number is "  +v;
        return a;
    }


}
