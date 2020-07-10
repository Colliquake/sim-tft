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
    public int[] hp;
    int[] mana;
    float dmg,as,crit;
    int def,mr,ar;
    int targetIndex=-1;
    int tx,ty;
    float atimer;
    float ap=100;
    float critmult=2;
    public Vec2f pos;
    Vec2f hexPos,tHexPos;
    float ms=550;
    float[] moveTimer=new float[]{0,0};
    int[] tt; // TEAM TRAITS
    float[] chronotimer=new float[]{100000,100000};
    boolean dead=false;


    public Unit(Unit_Info ui, Board b, int x, int y, int[] teamtraits, boolean ally,int index,int star){
        b.m[(ally)?x:b.m.length-1-x][(ally)?b.m[0].length-1-y:y]=index+1;
        x=(ally)?x:b.m.length-1-x;
        y=(ally)?b.m[0].length-1-y:y;
        this.tt=teamtraits;
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
        applyTraitStatBonuses(teamtraits);
        mana[0]=mana[1];
        hp[0]=hp[1];
        atimer=1/as;
        chronotimer[0]=chronotimer[1];
    }
    public void applyTraitStatBonuses(int[] teamtraits){
        if (teamtraits[1]>=2){
            mr+=(teamtraits[1]>=4)?120:50;
        }if (teamtraits[6]>=2){
            ap+=(teamtraits[6]>=4)?((teamtraits[6]>=6)?75:45):20;
        }if (teamtraits[7]>=2&&ui.tcode%TCODES[7]==0){
            if (teamtraits[7]<4){
                def+=125;
            }else if (teamtraits[7]<6){
                def+=300;
            }else {
                def+=1000;
            }
        }if (teamtraits[8]>=2&&ui.tcode%TCODES[8]==0){
            if (teamtraits[8]<4){
                hp[1]+=350;
            }else {
                hp[1]+=600;
            }
        }if (teamtraits[16]>=2&&ui.tcode%TCODES[16]==0){
            if (teamtraits[8]<4){
                chronotimer[1]=8;
            }else if(teamtraits[16]<6){
                chronotimer[1]=3.5f;
            }else if(teamtraits[16]<8){
                chronotimer[1]=1.5f;
            }else{
                chronotimer[1]=.75f;
            }
        }if (teamtraits[17]>=3&&ui.tcode%TCODES[17]==0){
            if (teamtraits[17]>=6){
                hp[1]+=550;
                dmg+=70;
            }else {
                hp[1]+=300;
                dmg+=35;
            }
        }if (teamtraits[20]>=3&&ui.tcode%TCODES[20]==0){
            mana[1]-=30;
        }
    }

    public void paintUnit(Graphics gfx,int sx, int sy){
        if (hp[0]<=0){return;}
        gfx.setColor((ally)?Color.BLUE:Color.RED);
        gfx.fillOval(sx+(int)pos.x-ts/2,sy+(int)pos.y-ts/2,ts,ts);
        gfx.setColor(Color.LIGHT_GRAY);
        gfx.fillOval(sx+(int)pos.x-ts/2+5,sy+(int)pos.y-(ts/2)+5,ts-10,ts-10);
        gfx.setColor(Color.BLACK);
        gfx.drawString(ui.n,sx+(int)pos.x-(int)(ts*.35),sy+(int)pos.y-10);
        gfx.fillRect(sx+(int)pos.x-ts/2+5,sy+(int)pos.y-(ts/2)+60,ts-10,30);
        gfx.setColor(Color.RED);
        gfx.fillRect(sx+(int)pos.x-ts/2+5,sy+(int)pos.y-(ts/2)+60,(int)((ts-10)*(float)hp[0]/hp[1]),15);
        gfx.setColor(Color.BLUE);
        gfx.fillRect(sx+(int)pos.x-ts/2+5,sy+(int)pos.y-(ts/2)+75,(int)((ts-10)*(float)mana[0]/mana[1]),15);
    }
    public void paintTarget(Graphics gfx,int sx, int sy){
        if (hp[0]<=0){return;}
        if (targetIndex==-1){return;}
        gfx.setColor((ally)?Color.BLUE:Color.RED);
        gfx.drawLine(sx+(int)pos.x,sy+(int)pos.y, sx+(int)b.units[targetIndex].pos.x,sy+(int)b.units[targetIndex].pos.y);
    }

    public void killDarkStar(){
        if (ui.tcode%TCODES[15]!=0){return;}
    }

    public void update(float delta, boolean overtime){
        if (hp[0]<=0){ if (b.m[x][y]==index+1){killDarkStar();b.m[x][y]=0;}return;}
        chronotimer[0]-=delta;
        if (chronotimer[0]<=0){
            chronotimer[0]=chronotimer[1];
            as+=.15f;
        }
        if (tx!=x||ty!=y){
            move(delta);
        }else {
            if (targetIndex == -1) {
                int closest = b.getClosestIndex(this);
                if (b.units[closest].isTargetable(this)) {
                    targetIndex = closest;
                    update(delta, overtime);
                }else {
                    setTargetLoc(closest);
                    //update(delta);
                }
            } else {
                if (b.units[targetIndex].isTargetable(this)) {
                    atimer -= (!overtime)? delta:delta*3;
                    if (atimer < 0) {
                        b.units[targetIndex].takeDamage(dmg, Math.random() < crit, critmult, tt[9]!=0);
                        atimer = 1 / as;
                    }
                } else {
                    targetIndex = -1;
                    atimer = 1 / as;
                    update(delta, overtime);
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

    public int takeDamage(float dmg, boolean crit, float critdmg, boolean magic){
        if (crit){dmg*=critdmg;}
        float rdmg=dmg*(100f/(100f+((magic)?mr:ar)));
        int managain=(int)(Math.round(.06*rdmg));if (managain>40){managain=40;}
        addMana(managain);
        hp[0]-=(int)rdmg;
        return (int)rdmg;
    }

    public void addMana(int amt){
        mana[0]+=amt;
        if (mana[0]>mana[1]){mana[0]=mana[1];}
    }
}
