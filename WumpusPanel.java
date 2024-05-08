import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class WumpusPanel extends JPanel implements KeyListener {
    public static final int PLAYING = 0;
    public static final int DEAD = 1;
    public static final int WON = 2;

    private int status;

    private int time = 0;

    private WumpusPlayer player;

    private WumpusMap map;

    private BufferedImage buffer;
    boolean cheatMode = false;


    private File file;
    JTextField messages = new JTextField("");


    public WumpusPanel() {

        map = new WumpusMap();
        addKeyListener(this);
        player = new WumpusPlayer();
        setSize(500, 900);
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
        map.createMap();
    }

    public void paint(Graphics g) {
        //System.out.println(map.getLadderC());
        //System.out.println(player.getRowPosition());

        //super.paint(g);
        int playerRow1= map.getLadderC() ;
        int columnRow1 = map.getLadderR() ;

        int playerRow = (map.getLadderC() + 1) * 50;
        int columnRow = (map.getLadderR() + 1) * 50;
        if(time == 0)
        {
            map.getSquare(playerRow1, columnRow1).setVisited(true);
            time++;
        }
        File file = new File("C:\\Users\\K1328854\\Downloads\\Images-20240425T183203Z-001\\Images\\black.GIF");
        try {
            buffer = ImageIO.read(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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

        int a = 1;
        for(int x =0;x<10;x++)
        {
            a *= 50;
            for(int y =0;y<10;y++)
            {
                if(map.getSquare(x, y).getVisited())
                {
                    try {
                        File file1 = new File("C:\\Users\\K1328854\\Downloads\\Images-20240425T183203Z-001\\Images\\Floor.gif");
                        buffer = ImageIO.read(file1);
                    } catch (IOException e) {
                        e.printStackTrace();

                    }
                    g.drawImage(buffer, a, (y+1)*50, this);
                }
                if(map.getSquare(x, y).getPit() && map.getSquare(x, y).getVisited())
                {
                    File file1 = new File("C:\\Users\\K1328854\\Downloads\\Images-20240425T183203Z-001\\Images\\pit.gif");
                    try {
                        buffer = ImageIO.read(file1);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    g.drawImage(buffer, a, (y+1)*50, this);
                }
                if(map.getSquare(x, y).getBreeze() && map.getSquare(x, y).getVisited())
                {
                    File file1 = new File("C:\\Users\\K1328854\\Downloads\\Images-20240425T183203Z-001\\Images\\breeze.gif");
                    try {
                        buffer = ImageIO.read(file1);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    g.drawImage(buffer, a, (y+1)*50, this);
                }
                if(map.getSquare(x, y).getDeadWumpus() && map.getSquare(x, y).getVisited())
                {
                    File file1 = new File("C:\\Users\\K1328854\\Downloads\\Images-20240425T183203Z-001\\Images\\deadwumpus.GIF");
                    try {
                        buffer = ImageIO.read(file1);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    g.drawImage(buffer, a, (y+1)*50, this);
                }
                if(map.getSquare(x, y).getPit() && map.getSquare(x, y).getVisited())
                {
                    File file1 = new File("C:\\Users\\K1328854\\Downloads\\Images-20240425T183203Z-001\\Images\\gold.gif");
                    try {
                        buffer = ImageIO.read(file1);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    g.drawImage(buffer, a, (y+1)*50, this);
                }
                if(map.getSquare(x, y).getLadder() && map.getSquare(x, y).getVisited())
                {
                    File file1 = new File("C:\\Users\\K1328854\\Downloads\\Images-20240425T183203Z-001\\Images\\ladder.gif");
                    try {
                        buffer = ImageIO.read(file1);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    g.drawImage(buffer, a, (y+1)*50, this);
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
        if(player.getDirection() == WumpusPlayer.NORTH) {


            try {
                File file1 = new File("C:\\Users\\K1328854\\Downloads\\Images-20240425T183203Z-001\\Images\\playerUp.png");
                buffer = ImageIO.read(file1);
            } catch (IOException e) {
                e.printStackTrace();

            }
            g.drawImage(buffer, playerRow, columnRow, this);
        }
        if(player.getDirection() == WumpusPlayer.SOUTH) {


            try {
                File file1 = new File("C:\\Users\\K1328854\\Downloads\\Images-20240425T183203Z-001\\Images\\playerDown.png");
                buffer = ImageIO.read(file1);
            } catch (IOException e) {
                e.printStackTrace();

            }
            g.drawImage(buffer, playerRow, columnRow, this);
        }
        if(player.getDirection() == WumpusPlayer.WEST) {


            try {
                File file1 = new File("C:\\Users\\K1328854\\Downloads\\Images-20240425T183203Z-001\\Images\\playerLeft.png");
                buffer = ImageIO.read(file1);
            } catch (IOException e) {
                e.printStackTrace();

            }
            g.drawImage(buffer, playerRow, columnRow, this);
        }
        if(player.getDirection() == WumpusPlayer.EAST) {


            try {
                File file1 = new File("C:\\Users\\K1328854\\Downloads\\Images-20240425T183203Z-001\\Images\\playerRight.png");
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
        try {
            File file1 = new File("C:\\Users\\K1328854\\Downloads\\Images-20240425T183203Z-001\\Images\\arrow.gif");
            buffer = ImageIO.read(file1);
        } catch (IOException e) {
            e.printStackTrace();

        }
        g.drawImage(buffer, 10, 630, this);

        //setting up message box
        messages.setText("You bump into a ladder");


    }

    public void keyPressed(KeyEvent e) {

    }

    public void keyReleased(KeyEvent e) {

    }

    public void keyTyped(KeyEvent e) {
        System.out.println("GETTING HERE");
        //System.out.println(e.getKeyChar());
        if (e.getKeyChar() == 'w') {
            player.setDirection(0);
            player.setRowPosition(player.getRowPosition() - 1);
            //System.out.println("W");
        }
        if (e.getKeyChar() == 'a') {
            player.setDirection(1);
            player.setRowPosition(player.getColPosition() - 1);
            //System.out.println("A");
        }
        if (e.getKeyChar() == 's') {
            player.setDirection(2);
            player.setRowPosition(player.getRowPosition() + 1);
            //System.out.println("S");
        }
        if (e.getKeyChar() == 'd') {
            player.setDirection(3);
            player.setRowPosition(player.getColPosition() + 1);
            //System.out.println("D");
        }
        if (e.getKeyChar() == 'n') {
            reset();
        }
        if (e.getKeyChar() == '*') {
            if (cheatMode == false) {
                cheatMode = true;
                repaint();
            } else {
                cheatMode = false;
                repaint();
            }
        }



    }
    public void addNotify ()
    {
        super.addNotify();
        requestFocus();
    }
}