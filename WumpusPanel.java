import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class WumpusPanel extends JPanel implements KeyListener
{
    public static final int PLAYING = 0;
    public static final int DEAD = 1;
    public static final int WON = 2;

    private int status;

    private WumpusPlayer player;

    private WumpusMap map;

    private BufferedImage buffer;

    private File file;

    JTextArea inventoryTitle = new JTextArea("Inventory");

    public WumpusPanel()
    {

        map = new WumpusMap();
        player = new WumpusPlayer();
        setSize(500,900);
        setLayout(null);
        /*try{
            File file = new File("C:\\Users\\K1328854\\Downloads\\Images-20240425T183203Z-001\\Images\\black.GIF");
            buffer = ImageIO.read(file);
        }
        catch(IOException e){
            e.printStackTrace();

        }

        */
        inventoryTitle.setBounds(10,550,250,50);
        inventoryTitle.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 20));
        add(inventoryTitle);
        reset();


    }
    public void reset()
    {
        status = PLAYING;
        map.createMap();
    }
    public void paint(Graphics g)
    {
        //System.out.println(map.getLadderC());
        //System.out.println(player.getRowPosition());

        //super.paint(g);
        File file = new File("C:\\Users\\K1328854\\Downloads\\Images-20240425T183203Z-001\\Images\\black.GIF");
        try {
            buffer = ImageIO.read(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (buffer != null) {
            int a = 0;
            for(int i = 1; i <= 100; i++) {
                if(i >= 1 && i <= 10) {
                    if(i == 1){
                        a = 50;
                    }
                    g.drawImage(buffer, a, 50, this);
                    a += 50;
                }
                if(i >= 11 && i <= 20){
                    if(i == 11){
                        a = 50;
                    }
                    g.drawImage(buffer, a, 100, this);
                    a += 50;
                }
                if(i >= 21 && i <= 30){
                    if(i == 21){
                        a = 50;
                    }
                    g.drawImage(buffer, a, 150, this);
                    a += 50;
                }
                if(i >= 31 && i <= 40){
                    if(i == 31){
                        a = 50;
                    }
                    g.drawImage(buffer, a, 200, this);
                    a += 50;
                }
                if(i >= 41 && i <= 50){
                    if(i == 41){
                        a = 50;
                    }
                    g.drawImage(buffer, a, 250, this);
                    a += 50;
                }
                if(i >= 51 && i <= 60){
                    if(i == 51){
                        a = 50;
                    }
                    g.drawImage(buffer, a, 300, this);
                    a += 50;
                }
                if(i >= 61 && i <= 70){
                    if(i == 61){
                        a = 50;
                    }
                    g.drawImage(buffer, a, 350, this);
                    a += 50;
                }
                if(i >= 71 && i <= 80){
                    if(i == 71){
                        a = 50;
                    }
                    g.drawImage(buffer, a, 400, this);
                    a += 50;
                }
                if(i >= 81 && i <= 90){
                    if(i == 81){
                        a = 50;
                    }
                    g.drawImage(buffer, a, 450, this);
                    a += 50;
                }
                if(i >= 91 && i <= 100){
                    if(i == 91){
                        a = 50;
                    }
                    g.drawImage(buffer, a, 500, this);
                    a += 50;
                }
            }
        }

        //inventory
        //g.drawImage(buffer, 0, 570, this);


        //floor
        int playerRow = (map.getLadderC() + 1) * 50;
        int columnRow = (map.getLadderR() + 1) * 50;
        try{
            File file1 = new File("C:\\Users\\K1328854\\Downloads\\Images-20240425T183203Z-001\\Images\\Floor.gif");
            buffer = ImageIO.read(file1);
        }
        catch(IOException e){
            e.printStackTrace();

        }
        g.drawImage(buffer, playerRow, columnRow, this);

        //ladder
        try{
            File file1 = new File("C:\\Users\\K1328854\\Downloads\\Images-20240425T183203Z-001\\Images\\ladder.gif");
            buffer = ImageIO.read(file1);
        }
        catch(IOException e){
            e.printStackTrace();

        }
        g.drawImage(buffer, playerRow, columnRow, this);

        //playerDown
        try{
            File file1 = new File("C:\\Users\\K1328854\\Downloads\\Images-20240425T183203Z-001\\Images\\playerDown.png");
            buffer = ImageIO.read(file1);
        }
        catch(IOException e){
            e.printStackTrace();

        }
        g.drawImage(buffer, playerRow, columnRow, this);

        //inventory
        g.fillRect(10,600,250,100);



    }
    public void keyPressed(KeyEvent e)
    {

    }
    public void keyReleased(KeyEvent e)
    {

    }
    public void keyTyped(KeyEvent e)
    {

    }
    public void addNotify()
    {
        super.addNotify();
        requestFocus();
    }






}