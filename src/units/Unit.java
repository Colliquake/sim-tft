package units;

import com.sun.javafx.geom.Vec2f;
import main.Board;
import main.Common_Variables;
import main.Main;

import java.awt.*;
import java.util.ArrayList;

public class Unit implements Common_Variables {
    Unit_Info ui;
    Board b;
    int x,y,index;
    boolean ally;
    int star;
    int[] hp;
    int[] mana;
    float dmg,as,crit;
    int def,mr,ar;
    int targetIndex=-1;
    int tx,ty;
    Vec2f pos;

    public Unit(Unit_Info ui, Board b, int x, int y, int[][] team, boolean ally,int index,int star){
        b.m[(ally)?x:b.m.length-1-x][(ally)?b.m[0].length-1-y:y]=index;
        this.ui=ui;
        this.ally=ally;
        this.b=b;
        this.index=index;
        this.x=x;this.y=y;
        tx=x;ty=y;
        pos=b.getTilePos(x,y);
        this.star=star;
        hp=new int[]{ui.mhp[star-1],ui.mhp[star-1]};
        dmg=ui.dmg[star-1];
        mana=new int[]{ui.mana[0],ui.mana[1]};
        as=ui.as;
        crit=ui.crit;
        def=ui.def;
        mr=ui.mr;
        ar=ui.ar;
    }

    public void paintUnit(int x, int y, Graphics gfx,int size){
        gfx.setColor((ally)?Color.BLUE:Color.RED);
        gfx.fillOval(x-size/2,y-size/2,size,size);
        gfx.setColor(Color.LIGHT_GRAY);
        gfx.fillOval(x-size/2+5,y-(size/2)+5,size-10,size-10);
        gfx.setColor(Color.BLACK);
        gfx.drawString(ui.n,x-(int)(size*.35),y-10);

    }

}
