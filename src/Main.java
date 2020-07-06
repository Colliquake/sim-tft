import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class Main extends Applet implements Runnable, KeyListener {

    private final int WIDTH=1280, HEIGHT=900;
    private Thread thread;
    Graphics gfx;
    Image img;
    ArrayList<Unit> units;
    Board b;


    public void init(){//STARTS THE PROGRAM
        this.resize(WIDTH, HEIGHT);
        this.addKeyListener(this);
        UnitImporter ui=new UnitImporter();
        units=ui.getUnits();
        b=new Board(this);
        img=createImage(WIDTH,HEIGHT);
        gfx=img.getGraphics();
        thread=new Thread(this);
        thread.start();
    }

    public void paint(Graphics g){
        gfx.setColor(Color.WHITE);//background
        gfx.fillRect(0,0,WIDTH,HEIGHT);


        b.paintBoard(gfx);

        g.drawImage(img,0,0,this);
    }

    public void update(Graphics g){ //REDRAWS FRAME
        paint(g);
    }

    public void run() { for (;;){//CALLS UPDATES AND REFRESHES THE GAME



        repaint();//UPDATES FRAME
        try{ Thread.sleep(15); } //ADDS TIME BETWEEN FRAMES (FPS)
        catch (InterruptedException e) { e.printStackTrace();System.out.println("GAME FAILED TO RUN"); }//TELLS USER IF GAME CRASHES AND WHY
    } }


    public void keyPressed(KeyEvent e) {

    }
    public void keyReleased(KeyEvent e) {

    }
    public void keyTyped(KeyEvent e) { }

}