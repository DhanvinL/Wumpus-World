public class WumpusSquare
{
    private boolean gold;
    private boolean ladder;
    private boolean pit;
    private boolean breeze;
    private boolean wumpus;
    private boolean deadWumpus;
    private boolean stench;

    private boolean[][] visited;


    public WumpusSquare()
    {
        this.gold = false;
        this.ladder = false;
        this.pit = false;
        this.breeze = false;
        this.wumpus = false;
        this.deadWumpus = false;
        this.stench = false;
        this.visited = new boolean[10][10];
    }

    public boolean getGold()
    {
        return gold;
    }
    public boolean getLadder()
    {
        return ladder;
    }
    public boolean getPit()
    {
        return pit;
    }
    public boolean getBreeze()
    {
        return breeze;
    }
    public boolean getWumpus()
    {
        return wumpus;
    }
    public boolean getDeadWumpus()
    {
        return deadWumpus;
    }
    public boolean getStench()
    {
        return stench;
    }

    public String toString()
    {
        return "";
    }
    public void setGold(boolean a)
    {
        this.gold = a;
    }
    public void setLadder(boolean a)
    {
        this.ladder = a;
    }
    public void setPit(boolean a)
    {
        this.pit = a;
    }
    public void setBreeze(boolean a)
    {
        this.breeze = a;
    }

    public void setWumpus(boolean a)
    {
        this.wumpus = a;
    }
    public void setDeadWumpus(boolean a)
    {
        this.deadWumpus = a;
    }
    public void setStench(boolean a)
    {
        this.stench = a;
    }



}
