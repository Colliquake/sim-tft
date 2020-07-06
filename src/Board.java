import java.awt.*;

public class Board implements Common_Variables {
    Main main;
    int[][] m;

    public Board(Main mn){
        this.main=mn;
        m=new int[7][6];
    }

    public void paintBoard(Graphics gfx){
        int sx=200,sy=100;
        int ts=90;
        for (int x=0; x<m.length; x++){
            for (int y=0; y<m[0].length; y++){
                gfx.setColor(Color.BLACK);
                gfx.fillRect(sx+((y%2==1)?ts/2:0)+ts*x,sy+y*ts,(int)(ts*.8f),(int)(ts*.8f));
                gfx.setColor(Color.WHITE);
                gfx.fillRect(sx+5+((y%2==1)?ts/2:0)+ts*x,sy+5+y*ts,(int)(ts*.8f)-10,(int)(ts*.8f)-10);
            }
        }
    }
}
