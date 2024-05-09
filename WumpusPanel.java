import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class WumpusPanel extends JPanel implements KeyListener {
    public static final int PLAYING = 0;
    public static final int DEAD = 1;
    public static final int WON = 2;

    private int status;
    ArrayList<String> inventoryItems = new ArrayList<>();

    private int time = 0;

    private WumpusPlayer player;
    boolean hit = false;
    private WumpusMap map;

    private BufferedImage buffer;
    boolean cheatMode = false;


    private File file;
    JTextField messages = new JTextField("");
    int playerRow = 0;
    int columnRow = 0;

    public WumpusPanel() {

        map = new WumpusMap();
        addKeyListener(this);
        player = new WumpusPlayer();
        setSize(675, 900);
        setLayout(null);
        /*try{
            File file = new File("C:\\Users\\K1328854\\Downloads\\Images-20240425T183203Z-001\\Images\\black.GIF");
            buffer = ImageIO.read(file);
        }
        catch(IOException e){
            e.printStackTrace();

        }

        */
        JTextField inventoryTitle = new JTextField(" Inventory:");
        inventoryTitle.setBounds(10, 600, 250, 20);
        inventoryTitle.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 19));
        add(inventoryTitle);

        JTextField messageBox = new JTextField(" Messages:");
        messageBox.setBounds(280, 600, 250, 20);
        messageBox.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 17));
        add(messageBox);

        messages.setBounds(280, 620, 250, 130);
        messages.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 17));
        messages.setBackground(Color.black);
        messages.setForeground(Color.CYAN);
        add(messages);

        reset();

    }

    public void reset() {
        status = PLAYING;
        inventoryItems.clear();
        time = 0;
        inventoryItems.add("arrow");

        map.createMap();
        player.setRowPosition(map.getLadderC());
        player.setColPosition(map.getLadderR());
    }

    public void paint(Graphics g) {
        //System.out.println(map.getLadderC());
        //System.out.println(player.getRowPosition());

        //super.paint(g);
        //player.getColPosition() is row
        // player.getRowPosition() is col
        if (!cheatMode && status == PLAYING) {

            System.out.println("The Ladder is on row: " + player.getColPosition() + ", The col is on " + player.getRowPosition());


            File file = new File("C:\\Users\\Dhanb\\Downloads\\Images-20240425T183203Z-001\\Images\\black.GIF");
            try {
                buffer = ImageIO.read(file);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (time == 0) {
                player.setRowPosition(map.getLadderC());
                player.setColPosition(map.getLadderR());
                playerRow = (map.getLadderC() + 1) * 50;
                columnRow = (map.getLadderR() + 1) * 50;
                map.getSquare(player.getRowPosition(), player.getColPosition()).setVisited(true);
                time++;

                if (buffer != null) {
                    int a = 0;
                    for (int i = 1; i <= 100; i++) {
                        if (i >= 1 && i <= 10) {
                            if (i == 1) {
                                a = 50;
                            }
                            g.drawImage(buffer, a, 50, this);
                            a += 50;
                        }
                        if (i >= 11 && i <= 20) {
                            if (i == 11) {
                                a = 50;
                            }
                            g.drawImage(buffer, a, 100, this);
                            a += 50;
                        }
                        if (i >= 21 && i <= 30) {
                            if (i == 21) {
                                a = 50;
                            }
                            g.drawImage(buffer, a, 150, this);
                            a += 50;
                        }
                        if (i >= 31 && i <= 40) {
                            if (i == 31) {
                                a = 50;
                            }
                            g.drawImage(buffer, a, 200, this);
                            a += 50;
                        }
                        if (i >= 41 && i <= 50) {
                            if (i == 41) {
                                a = 50;
                            }
                            g.drawImage(buffer, a, 250, this);
                            a += 50;
                        }
                        if (i >= 51 && i <= 60) {
                            if (i == 51) {
                                a = 50;
                            }
                            g.drawImage(buffer, a, 300, this);
                            a += 50;
                        }
                        if (i >= 61 && i <= 70) {
                            if (i == 61) {
                                a = 50;
                            }
                            g.drawImage(buffer, a, 350, this);
                            a += 50;
                        }
                        if (i >= 71 && i <= 80) {
                            if (i == 71) {
                                a = 50;
                            }
                            g.drawImage(buffer, a, 400, this);
                            a += 50;
                        }
                        if (i >= 81 && i <= 90) {
                            if (i == 81) {
                                a = 50;
                            }
                            g.drawImage(buffer, a, 450, this);
                            a += 50;
                        }
                        if (i >= 91 && i <= 100) {
                            if (i == 91) {
                                a = 50;
                            }
                            g.drawImage(buffer, a, 500, this);
                            a += 50;
                        }
                    }
                }
            }

            int a = 1;
            for (int x = 0; x < 10; x++) {
                a += 50;
                for (int y = 0; y < 10; y++) {

                    if (map.getSquare(x, y).getVisited()) {
                        try {
                            File file1 = new File("C:\\Users\\Dhanb\\Downloads\\Images-20240425T183203Z-001\\Images\\Floor.gif");
                            buffer = ImageIO.read(file1);
                        } catch (IOException e) {
                            e.printStackTrace();

                        }
                        g.drawImage(buffer, a, (y + 1) * 50, this);
                    }
                    if (map.getSquare(x, y).getWumpus() && map.getSquare(x, y).getVisited()) {
                        File file1 = new File("C:\\Users\\Dhanb\\Downloads\\Images-20240425T183203Z-001\\Images\\wumpus.gif");
                        try {
                            buffer = ImageIO.read(file1);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        g.drawImage(buffer, a, (y + 1) * 50, this);
                    }
                    if (map.getSquare(x, y).getStench() && map.getSquare(x, y).getVisited()) {
                        File file1 = new File("C:\\Users\\Dhanb\\Downloads\\Images-20240425T183203Z-001\\Images\\stench.gif");
                        try {
                            buffer = ImageIO.read(file1);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        g.drawImage(buffer, a, (y + 1) * 50, this);
                    }
                    if (map.getSquare(x, y).getPit() && map.getSquare(x, y).getVisited()) {
                        File file1 = new File("C:\\Users\\Dhanb\\Downloads\\Images-20240425T183203Z-001\\Images\\pit.gif");
                        try {
                            buffer = ImageIO.read(file1);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        g.drawImage(buffer, a, (y + 1) * 50, this);
                    }
                    if (map.getSquare(x, y).getBreeze() && map.getSquare(x, y).getVisited()) {
                        File file1 = new File("C:\\Users\\Dhanb\\Downloads\\Images-20240425T183203Z-001\\Images\\breeze.gif");
                        try {
                            buffer = ImageIO.read(file1);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        g.drawImage(buffer, a, (y + 1) * 50, this);
                    }
                    if (map.getSquare(x, y).getDeadWumpus() && map.getSquare(x, y).getVisited()) {
                        File file1 = new File("C:\\Users\\Dhanb\\Downloads\\Images-20240425T183203Z-001\\Images\\deadwumpus.GIF");
                        try {
                            buffer = ImageIO.read(file1);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        g.drawImage(buffer, a, (y + 1) * 50, this);
                    }
                    if (map.getSquare(x, y).getGold() && map.getSquare(x, y).getVisited()) {
                        File file1 = new File("C:\\Users\\Dhanb\\Downloads\\Images-20240425T183203Z-001\\Images\\gold.gif");
                        try {
                            buffer = ImageIO.read(file1);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        g.drawImage(buffer, a, (y + 1) * 50, this);
                    }
                    if (map.getSquare(x, y).getLadder() && map.getSquare(x, y).getVisited()) {
                        File file1 = new File("C:\\Users\\Dhanb\\Downloads\\Images-20240425T183203Z-001\\Images\\ladder.gif");
                        try {
                            buffer = ImageIO.read(file1);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        g.drawImage(buffer, a, (y + 1) * 50, this);
                    }

                }
            }
            System.out.println(map.toString());

            //inventory
            //g.drawImage(buffer, 0, 570, this);


            //floor


        /*
        try {
            File file1 = new File("C:\\Users\\K1328854\\Downloads\\Images-20240425T183203Z-001\\Images\\Floor.gif");
            buffer = ImageIO.read(file1);
        } catch (IOException e) {
            e.printStackTrace();

        }
        g.drawImage(buffer, playerRow, columnRow, this);

        //ladder
        try {
            File file1 = new File("C:\\Users\\K1328854\\Downloads\\Images-20240425T183203Z-001\\Images\\ladder.gif");
            buffer = ImageIO.read(file1);
        } catch (IOException e) {
            e.printStackTrace();

        }
        g.drawImage(buffer, playerRow, columnRow, this);


         */
            //playerDown
            if (player.getDirection() == WumpusPlayer.NORTH) {


                try {
                    File file1 = new File("C:\\Users\\Dhanb\\Downloads\\Images-20240425T183203Z-001\\Images\\playerUp.png");
                    buffer = ImageIO.read(file1);
                } catch (IOException e) {
                    e.printStackTrace();

                }
                g.drawImage(buffer, playerRow, columnRow, this);
            }
            if (player.getDirection() == WumpusPlayer.SOUTH) {


                try {
                    File file1 = new File("C:\\Users\\Dhanb\\Downloads\\Images-20240425T183203Z-001\\Images\\playerDown.png");
                    buffer = ImageIO.read(file1);
                } catch (IOException e) {
                    e.printStackTrace();

                }
                g.drawImage(buffer, playerRow, columnRow, this);
            }
            if (player.getDirection() == WumpusPlayer.WEST) {


                try {
                    File file1 = new File("C:\\Users\\Dhanb\\Downloads\\Images-20240425T183203Z-001\\Images\\playerLeft.png");
                    buffer = ImageIO.read(file1);
                } catch (IOException e) {
                    e.printStackTrace();

                }
                g.drawImage(buffer, playerRow, columnRow, this);
            }
            if (player.getDirection() == WumpusPlayer.EAST) {


                try {
                    File file1 = new File("C:\\Users\\Dhanb\\Downloads\\Images-20240425T183203Z-001\\Images\\playerRight.png");
                    buffer = ImageIO.read(file1);
                } catch (IOException e) {
                    e.printStackTrace();

                }
                g.drawImage(buffer, playerRow, columnRow, this);
            }


            //inventory
            g.fillRect(10, 600, 250, 150);

            //message box
            g.fillRect(280, 600, 270, 150);

            //adding default arrow
            if(inventoryItems.contains("arrow")) {
                try {
                    File file1 = new File("C:\\Users\\Dhanb\\Downloads\\Images-20240425T183203Z-001\\Images\\arrow.gif");
                    buffer = ImageIO.read(file1);
                } catch (IOException e) {
                    e.printStackTrace();

                }
                g.drawImage(buffer, 10, 630, this);
            }
            if(inventoryItems.contains("gold"))
            {
                try {
                    File file1 = new File("C:\\Users\\Dhanb\\Downloads\\Images-20240425T183203Z-001\\Images\\gold.gif");
                    buffer = ImageIO.read(file1);
                } catch (IOException e) {
                    e.printStackTrace();

                }
                g.drawImage(buffer, 100, 630, this);
            }

            //setting up message box
            if(hit)
            {
                messages.setText("You hear a scream.");
                hit = false;

            }
            else {
                if (player.getRowPosition() == map.getLadderC() && player.getColPosition() == map.getLadderR()) {
                    messages.setText("You bump into a ladder.");
                }
                if (map.getSquare(player.getRowPosition(), player.getColPosition()).getBreeze()) {
                    messages.setText("You feel a breeze.");
                }
                if (map.getSquare(player.getRowPosition(), player.getColPosition()).getStench()) {
                    messages.setText("You smell a stench.");
                }
                if (map.getSquare(player.getRowPosition(), player.getColPosition()).getGold()) {
                    messages.setText("You see a glimmer.");
                }
                if (map.getSquare(player.getRowPosition(), player.getColPosition()).getPit()) {
                    status = DEAD;
                    messages.setText("You fell down a pit to your death.");
                }
                if (map.getSquare(player.getRowPosition(), player.getColPosition()).getWumpus()) {
                    status = DEAD;

                    messages.setText("You are eaten by the Wumpus.");
                }
            }





        }
        if(cheatMode && status == PLAYING) {
            int a = 1;
            for (int x = 0; x < 10; x++) {
                a += 50;
                for (int y = 0; y < 10; y++) {


                    try {
                        File file1 = new File("C:\\Users\\Dhanb\\Downloads\\Images-20240425T183203Z-001\\Images\\Floor.gif");
                        buffer = ImageIO.read(file1);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    g.drawImage(buffer, a, (y + 1) * 50, this);

                    if (map.getSquare(x, y).getWumpus()) {
                        File file1 = new File("C:\\Users\\Dhanb\\Downloads\\Images-20240425T183203Z-001\\Images\\wumpus.gif");
                        try {
                            buffer = ImageIO.read(file1);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        g.drawImage(buffer, a, (y + 1) * 50, this);
                    }
                    if (map.getSquare(x, y).getStench()) {
                        File file1 = new File("C:\\Users\\Dhanb\\Downloads\\Images-20240425T183203Z-001\\Images\\stench.gif");
                        try {
                            buffer = ImageIO.read(file1);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        g.drawImage(buffer, a, (y + 1) * 50, this);
                    }
                    if (map.getSquare(x, y).getPit()) {
                        File file1 = new File("C:\\Users\\Dhanb\\Downloads\\Images-20240425T183203Z-001\\Images\\pit.gif");
                        try {
                            buffer = ImageIO.read(file1);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        g.drawImage(buffer, a, (y + 1) * 50, this);
                    }
                    if (map.getSquare(x, y).getBreeze()) {
                        File file1 = new File("C:\\Users\\Dhanb\\Downloads\\Images-20240425T183203Z-001\\Images\\breeze.gif");
                        try {
                            buffer = ImageIO.read(file1);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        g.drawImage(buffer, a, (y + 1) * 50, this);
                    }
                    if (map.getSquare(x, y).getDeadWumpus()) {
                        File file1 = new File("C:\\Users\\Dhanb\\Downloads\\Images-20240425T183203Z-001\\Images\\deadwumpus.GIF");
                        try {
                            buffer = ImageIO.read(file1);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        g.drawImage(buffer, a, (y + 1) * 50, this);
                    }
                    if (map.getSquare(x, y).getGold()) {
                        File file1 = new File("C:\\Users\\Dhanb\\Downloads\\Images-20240425T183203Z-001\\Images\\gold.gif");
                        try {
                            buffer = ImageIO.read(file1);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        g.drawImage(buffer, a, (y + 1) * 50, this);
                    }
                    if (map.getSquare(x, y).getLadder() ) {
                        File file1 = new File("C:\\Users\\Dhanb\\Downloads\\Images-20240425T183203Z-001\\Images\\ladder.gif");
                        try {
                            buffer = ImageIO.read(file1);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        g.drawImage(buffer, a, (y + 1) * 50, this);
                    }

                }
            }
            if(hit)
            {
                messages.setText("You hear a scream.");
                hit = false;

            }
            else {

                if (player.getRowPosition() == map.getLadderC() && player.getColPosition() == map.getLadderR()) {
                    messages.setText("You bump into a ladder.");
                }
                if (map.getSquare(player.getRowPosition(), player.getColPosition()).getBreeze()) {
                    messages.setText("You feel a breeze.");
                }
                if (map.getSquare(player.getRowPosition(), player.getColPosition()).getStench()) {
                    messages.setText("You smell a stench.");
                }
                if (map.getSquare(player.getRowPosition(), player.getColPosition()).getGold()) {
                    messages.setText("You see a glimmer.");
                }
                if (map.getSquare(player.getRowPosition(), player.getColPosition()).getPit()) {
                    messages.setText("You fell down a pit to your death.");
                }
                if (map.getSquare(player.getRowPosition(), player.getColPosition()).getWumpus()) {

                    messages.setText("You are eaten by the Wumpus.");
                }
                System.out.println(map.toString());
            }

            //inventory
            //g.drawImage(buffer, 0, 570, this);


            //floor


        /*
        try {
            File file1 = new File("C:\\Users\\K1328854\\Downloads\\Images-20240425T183203Z-001\\Images\\Floor.gif");
            buffer = ImageIO.read(file1);
        } catch (IOException e) {
            e.printStackTrace();

        }
        g.drawImage(buffer, playerRow, columnRow, this);

        //ladder
        try {
            File file1 = new File("C:\\Users\\K1328854\\Downloads\\Images-20240425T183203Z-001\\Images\\ladder.gif");
            buffer = ImageIO.read(file1);
        } catch (IOException e) {
            e.printStackTrace();

        }
        g.drawImage(buffer, playerRow, columnRow, this);


         */
            //playerDown
            if (player.getDirection() == WumpusPlayer.NORTH) {


                try {
                    File file1 = new File("C:\\Users\\Dhanb\\Downloads\\Images-20240425T183203Z-001\\Images\\playerUp.png");
                    buffer = ImageIO.read(file1);
                } catch (IOException e) {
                    e.printStackTrace();

                }
                g.drawImage(buffer, playerRow, columnRow, this);
            }
            if (player.getDirection() == WumpusPlayer.SOUTH) {


                try {
                    File file1 = new File("C:\\Users\\Dhanb\\Downloads\\Images-20240425T183203Z-001\\Images\\playerDown.png");
                    buffer = ImageIO.read(file1);
                } catch (IOException e) {
                    e.printStackTrace();

                }
                g.drawImage(buffer, playerRow, columnRow, this);
            }
            if (player.getDirection() == WumpusPlayer.WEST) {


                try {
                    File file1 = new File("C:\\Users\\Dhanb\\Downloads\\Images-20240425T183203Z-001\\Images\\playerLeft.png");
                    buffer = ImageIO.read(file1);
                } catch (IOException e) {
                    e.printStackTrace();

                }
                g.drawImage(buffer, playerRow, columnRow, this);
            }
            if (player.getDirection() == WumpusPlayer.EAST) {


                try {
                    File file1 = new File("C:\\Users\\Dhanb\\Downloads\\Images-20240425T183203Z-001\\Images\\playerRight.png");
                    buffer = ImageIO.read(file1);
                } catch (IOException e) {
                    e.printStackTrace();

                }
                g.drawImage(buffer, playerRow, columnRow, this);
            }


            //inventory
            g.fillRect(10, 600, 250, 150);

            //message box
            g.fillRect(280, 600, 270, 150);

            //adding default arrow
            if(inventoryItems.contains("arrow")) {
                try {
                    File file1 = new File("C:\\Users\\Dhanb\\Downloads\\Images-20240425T183203Z-001\\Images\\arrow.gif");
                    buffer = ImageIO.read(file1);
                } catch (IOException e) {
                    e.printStackTrace();

                }
                g.drawImage(buffer, 10, 630, this);
            }
            if(inventoryItems.contains("gold"))
            {
                try {
                    File file1 = new File("C:\\Users\\Dhanb\\Downloads\\Images-20240425T183203Z-001\\Images\\gold.gif");
                    buffer = ImageIO.read(file1);
                } catch (IOException e) {
                    e.printStackTrace();

                }
                g.drawImage(buffer, 100, 630, this);
            }
            //setting up message box

        }
    }

    public void keyPressed(KeyEvent e) {

    }

    public void keyReleased(KeyEvent e) {

    }

    public void keyTyped(KeyEvent e) {
        System.out.println("GETTING HERE");
        //System.out.println(e.getKeyChar());
        if (e.getKeyChar() == 'a') {

                if (map.getSquare(player.getRowPosition() - 1, player.getColPosition()) != null) {
                    player.setDirection(0);
                    System.out.println("The player Row position is: " + player.getRowPosition());
                    player.setRowPosition(player.getRowPosition() - 1);

                    player.setDirection(WumpusPlayer.WEST);
                    playerRow = (player.getRowPosition() + 1) * 50;
                    columnRow = (player.getColPosition() + 1) * 50;
                    map.getSquare(player.getRowPosition(), player.getColPosition()).setVisited(true);
                    repaint();
                }


            //System.out.println("W");
        }
        if (e.getKeyChar() == 'w') {
            if(map.getSquare(player.getRowPosition(),player.getColPosition()-1) != null) {
                player.setDirection(0);
                System.out.println("The player Row position is: " + player.getRowPosition());
                player.setColPosition(player.getColPosition() - 1);

                player.setDirection(WumpusPlayer.NORTH);
                playerRow = (player.getRowPosition() + 1) * 50;
                columnRow = (player.getColPosition() + 1) * 50;
                map.getSquare(player.getRowPosition(), player.getColPosition()).setVisited(true);
                repaint();
            }

            //System.out.println("A");
        }
        if (e.getKeyChar() == 's') {
            if(map.getSquare(player.getRowPosition(),player.getColPosition()+1) != null) {
                player.setDirection(0);
                System.out.println("The player Row position is: " + player.getRowPosition());
                player.setColPosition(player.getColPosition() + 1);

                player.setDirection(WumpusPlayer.SOUTH);
                playerRow = (player.getRowPosition() + 1) * 50;
                columnRow = (player.getColPosition() + 1) * 50;
                map.getSquare(player.getRowPosition(), player.getColPosition()).setVisited(true);
                repaint();
            }

            //System.out.println("S");
        }
        if (e.getKeyChar() == 'd') {
            if(map.getSquare(player.getRowPosition()+1,player.getColPosition()) != null) {
                player.setDirection(0);
                System.out.println("The player Row position is: " + player.getRowPosition());
                player.setRowPosition(player.getRowPosition() + 1);

                player.setDirection(WumpusPlayer.EAST);
                playerRow = (player.getRowPosition() + 1) * 50;
                columnRow = (player.getColPosition() + 1) * 50;
                map.getSquare(player.getRowPosition(), player.getColPosition()).setVisited(true);
                repaint();
            }

            //System.out.println("D");
        }
        if (e.getKeyChar() == 'n') {
            if(status != PLAYING)
                reset();
        }
        if (e.getKeyChar() == '*') {
            if (!cheatMode) {
                cheatMode = true;
                repaint();
            } else {
                time =0;
                cheatMode = false;
                repaint();
            }
        }
        if(e.getKeyChar() == 'c')
        {

            if(player.getRowPosition() == map.getLadderC() && player.getColPosition() == map.getLadderR())
            {
                if(inventoryItems.contains("gold"))
                {
                    messages.setText("You Win!");
                    status = WON;
                }
                else
                {
                    messages.setText("You need the Gold!");
                }
            }
        }
        if(e.getKeyChar() == 'p')
        {

            if(map.getSquare(player.getRowPosition(), player.getColPosition()).getGold())
            {

                    map.getSquare(player.getRowPosition(), player.getColPosition()).setGold(false);
                    messages.setText("You got Gold!");
                    inventoryItems.add("gold");

            }
            else
            {
                messages.setText("You need to find Gold!");
            }


        }
        if(e.getKeyChar() == 'n')
        {
            if(status == DEAD || status == WON)
            {
                repaint();
                reset();
            }
        }
        if(e.getKeyChar() == 'i')
        {
            player.setDirection(WumpusPlayer.NORTH);
            inventoryItems.remove("arrow");

            for(int x =player.getColPosition();x>=0;x--)
            {

                if(map.getSquare(player.getRowPosition(), x).getWumpus())
                {
                    System.out.println("YOU HIT THE WUMPUS");
                    map.getSquare(player.getRowPosition(), x).setWumpus(false);
                    map.getSquare(player.getRowPosition(), x).setDeadWumpus(true);
                    hit = true;
                    break;

                }
            }
            repaint();
        }
        if(e.getKeyChar() == 'j')
        {
            player.setDirection(WumpusPlayer.WEST);
            inventoryItems.remove("arrow");

            for(int x =player.getRowPosition();x>=0;x--)
            {

                if(map.getSquare(x, player.getColPosition()).getWumpus())
                {
                    System.out.println("YOU HIT THE WUMPUS");
                    map.getSquare(x, player.getColPosition()).setWumpus(false);
                    map.getSquare(x, player.getColPosition()).setDeadWumpus(true);
                    messages.setText("You hear a scream");
                    hit = true;
                    break;

                }
            }
            repaint();
        }
        if(e.getKeyChar() == 'k')
        {
            player.setDirection(WumpusPlayer.SOUTH);
            inventoryItems.remove("arrow");

            for(int x =player.getColPosition();x<10;x++)
            {

                if(map.getSquare(player.getRowPosition(), x).getWumpus())
                {
                    System.out.println("YOU HIT THE WUMPUS");
                    map.getSquare(player.getRowPosition(), x).setWumpus(false);
                    map.getSquare(player.getRowPosition(), x).setDeadWumpus(true);
                    messages.setText("You hear a scream");
                    hit = true;
                    break;

                }
            }
            repaint();
        }
        if(e.getKeyChar() == 'l') {
            player.setDirection(WumpusPlayer.WEST);
            inventoryItems.remove("arrow");

            for (int x = player.getRowPosition(); x < 10; x++) {

                if (map.getSquare(x, player.getColPosition()).getWumpus()) {
                    System.out.println("YOU HIT THE WUMPUS");
                    map.getSquare(x, player.getColPosition()).setWumpus(false);
                    map.getSquare(x, player.getColPosition()).setDeadWumpus(true);
                    messages.setText("You hear a scream");
                    hit = true;
                    break;

                }
            }
            repaint();

        }


    }
    public void addNotify ()
    {
        super.addNotify();
        requestFocus();
    }
}