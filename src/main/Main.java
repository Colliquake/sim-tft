package main;

import units.Unit_Importer;
import units.Unit_Info;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Main extends Applet implements Common_Variables, Runnable, KeyListener {

    private final int WIDTH=1280, HEIGHT=900;
    private Thread thread;
    Graphics gfx;
    Image img;
    Board b;


    public void init(){//STARTS THE PROGRAM
        this.resize(WIDTH, HEIGHT);
        this.addKeyListener(this);
        b=new Board(this);
        img=createImage(WIDTH,HEIGHT);
        gfx=img.getGraphics();
        gfx.setFont(gfx.getFont().deriveFont(20f));
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


        b.update(.015f);
        repaint();//UPDATES FRAME
        try{ Thread.sleep(5); } //ADDS TIME BETWEEN FRAMES (FPS)
        catch (InterruptedException e) { e.printStackTrace();System.out.println("GAME FAILED TO RUN"); }//TELLS USER IF GAME CRASHES AND WHY
    } }


    public void keyPressed(KeyEvent e) {

    }
    public void keyReleased(KeyEvent e) {

    }
    public void keyTyped(KeyEvent e) { }

}