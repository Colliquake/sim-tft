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
    int x,y;
    public int index;
    public boolean ally;
    int star;
    int[] hp;
    int[] mana;
    float dmg,as,crit;
    int def,mr,ar;
    int targetIndex=-1;
    int tx,ty;
    float atimer;
    float critmult=2;
    public Vec2f pos;
    Vec2f hexPos,tHexPos;
    float ms=550;
    float[] moveTimer=new float[]{0,0};


    public Unit(Unit_Info ui, Board b, int x, int y, int[][] team, boolean ally,int index,int star){
        b.m[(ally)?x:b.m.length-1-x][(ally)?b.m[0].length-1-y:y]=index+1;
        x=(ally)?x:b.m.length-1-x;
        y=(ally)?b.m[0].length-1-y:y;
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
        atimer=1/as;
    }

    public void paintUnit(int x, int y, Graphics gfx,int size){
        gfx.setColor((ally)?Color.BLUE:Color.RED);
        gfx.fillOval(x-size/2,y-size/2,size,size);
        gfx.setColor(Color.LIGHT_GRAY);
        gfx.fillOval(x-size/2+5,y-(size/2)+5,size-10,size-10);
        gfx.setColor(Color.BLACK);
        gfx.drawString(ui.n,x-(int)(size*.35),y-10);
    }
    public void paintUnit(Graphics gfx,int sx, int sy){
        gfx.setColor((ally)?Color.BLUE:Color.RED);
        gfx.fillOval(sx+(int)pos.x-ts/2,sy+(int)pos.y-ts/2,ts,ts);
        gfx.setColor(Color.LIGHT_GRAY);
        gfx.fillOval(sx+(int)pos.x-ts/2+5,sy+(int)pos.y-(ts/2)+5,ts-10,ts-10);
        gfx.setColor(Color.BLACK);
        gfx.drawString(ui.n,sx+(int)pos.x-(int)(ts*.35),sy+(int)pos.y-10);
    }

    public void update(float delta){
        if (tx!=x||ty!=y){
            move(delta);
        }else {
            if (targetIndex == -1) {
                int closest = b.getClosestIndex(this);
                if (b.units[closest].isTargetable(this)) {
                    targetIndex = closest;
                    update(delta);
                }else {
                    setTargetLoc(closest);
                    //update(delta);
                }
            } else {
                if (b.units[targetIndex].isTargetable(this)) {
                    atimer -= delta;
                    if (atimer < 0) {
                        takeDamage(dmg, Math.random() < crit, critmult);
                        atimer = 1 / as;
                    }
                } else {
                    targetIndex = -1;
                    atimer = 1 / as;
                    update(delta);
                }
            }
        }
    }
    public void move(float delta){
        moveTimer[0]-=delta;
        pos.x=hexPos.x*(moveTimer[0]/moveTimer[1])+tHexPos.x*((moveTimer[1]-moveTimer[0])/moveTimer[1]);
        pos.y=hexPos.y*(moveTimer[0]/moveTimer[1])+tHexPos.y*((moveTimer[1]-moveTimer[0])/moveTimer[1]);
        if (moveTimer[0]<=0){b.m[x][y]=0;x=tx;y=ty;}

    }
    public void setTargetLoc(int tindex){
        hexPos=b.getTilePos(x,y);
        float mult=ts/b.units[tindex].pos.distance(pos);
        Vec2f newp=new Vec2f(pos.x+(mult*(b.units[tindex].pos.x-pos.x)),pos.y+(mult*(b.units[tindex].pos.y-pos.y)));
        int[] closest=b.getClosestTile(newp);//TODO : THIS METHOD MEANS THAT TECHNICALLY UNITS COULD JUMP OVER EACH OTHER IF ALL SURROUNDING TILES ARE BLOCKED
        tx=closest[0];ty=closest[1];
        b.m[tx][ty]=index+1;
        System.out.println(ui.n+" moving from "+x+", "+y+" to "+tx+", "+ty);
        tHexPos=b.getTilePos(tx,ty);
        moveTimer[1]=hexPos.distance(tHexPos)*ARSCALE/ms;
        moveTimer[0]=moveTimer[1];
    }

    public boolean isTargetable(Unit attacker){
        if (hp[0]<=0){return false;}
        return pos.distance(attacker.pos)*ARSCALE<=attacker.ar;
    }

    public void takeDamage(float dmg, boolean crit, float critdmg){
        if (crit){dmg*=critdmg;}
        float rdmg=dmg*(100f/(100f+ar));
        int managain=(int)(Math.round(.06*rdmg));if (managain>40){managain=40;}
        hp[0]-=(int)rdmg;
    }

}
