package main;

import com.sun.javafx.geom.Vec2f;
import com.sun.org.apache.regexp.internal.RE;
import units.Unit;

import java.awt.*;
import java.util.ArrayList;

public class Board implements Common_Variables {
    Main main;
    public int[][] m;
    int[][] t1;
    int[][] t2;
    ArrayList<Unit> t1u;
    ArrayList<Unit> t2u;
    public Unit[] units;
    float elapsedTime=0;
    int[][] teamTraits;

    public Board(Main mn){
        this.main=mn;
        m=new int[7][6];
        int ts1=4,ts2=4;
        t1=randomTeam(ts1);
        t2=randomTeam(ts2);
        t1u=new ArrayList<>();
        t2u=new ArrayList<>();
        units=new Unit[ts1+ts2];
        teamTraits=new int[][]{getTraits(t1),getTraits(t2)};
        int i=0;
        for (int[] u: t1){
            units[i]=new Unit(UNITS.get(u[0]),this,u[1],u[2],teamTraits[0],true,i, u[6]);
            t1u.add(units[i]);
            i++;
        }
        for (int[] u: t2){
            units[i]=new Unit(UNITS.get(u[0]),this,u[1],u[2],teamTraits[1],false, i,u[6]);
            t2u.add(units[i]);
            i++;
        }
    }
    public int[] getTraits(int[][] team){
        int[] traits=new int[TRAITS.length];
        ArrayList<Integer> unique=new ArrayList<>();
        String tstring=" ";
        for (int[] u:team){
            if (!tstring.contains(" "+u[0]+" ")){
                tstring=tstring+" "+u[0]+" ";
                unique.add(u[0]);
            }
        }
        System.out.println(unique);
        for (int e: unique){
            for (String s:UNITS.get(e).traits){
                traits[GETTINDEX(s)]++;
            }
        }
        return traits;
    }
    public int[][] randomTeam(int size){
        int[][] t=new int[size][];
        for (int i=0; i<size; i++){
            t[i]=getUnitArray((int)(Math.random()*UNITS.size()),i,0,0,0,0, 2);
        }
        return t;
    }
    public int[] getUnitArray(int unit, int x, int y, int i1, int i2, int i3, int star){// I know this method is pointless, it's just an easy way for me to remember the data format
        return new int[]{unit,x,y,i1,i2,i3,star};
    }
    public Vec2f getTilePos(int x, int y){
        float ts=this.ts;
        return new Vec2f(((y%2==1)?ts/2:0)+ts*x+(ts*.4f),y*ts+(int)(ts*.4f));
    }

    public void update(float delta){
        if (t1u.size()==0||t2u.size()==0){return;}
        elapsedTime+=delta;
        /*  TODO : OVERTIME MODE
            After 30 seconds into every battle, URF Overtime kicks in and speeds things up for 15 seconds.
                 × 3 attack speed.
                100% increased ability power.
                66% reduced crowd control duration.
                66% healing and shielding reduction.
        * */
        for (Unit u:units){
            u.update(delta,elapsedTime>30);
        }
        for (int i=0; i<t1u.size(); i++){
            if (t1u.get(i).hp[0]<=0){
                t1u.remove(i);
                i--;
            }
        }for (int i=0; i<t2u.size(); i++){
            if (t2u.get(i).hp[0]<=0){
                t2u.remove(i);
                i--;
            }
        }

    }

    public void paintBoard(Graphics gfx){
        int sx=200,sy=100;

        for (int x=0; x<m.length; x++){
            for (int y=0; y<m[0].length; y++){
                gfx.setColor(Color.BLACK);
                gfx.fillRect(sx+((y%2==1)?ts/2:0)+ts*x,sy+y*ts,(int)(ts*.8f),(int)(ts*.8f));
                gfx.setColor(Color.WHITE);
                gfx.fillRect(sx+5+((y%2==1)?ts/2:0)+ts*x,sy+5+y*ts,(int)(ts*.8f)-10,(int)(ts*.8f)-10);
                if (m[x][y]!=0){
                    //units[m[x][y]-1].paintUnit(sx+((y%2==1)?ts/2:0)+ts*x+(int)(ts*.4),sy+y*ts+(int)(ts*.4),gfx,ts);
                }
            }
        }
        gfx.setColor(Color.BLACK);
        for (int i=0; i<2; i++){
            int y=100;
            int x=50+820*i;
            for (int t=0; t<teamTraits[i].length; t++){
                if (teamTraits[i][t]>0){
                    gfx.drawString(teamTraits[i][t]+" "+TRAITS[t],x,y);
                    y+=50;
                }
            }
        }
        //System.out.println(units.length);
        for (Unit u:units){
            u.paintUnit(gfx,sx,sy);
        }
        for (Unit u:units){
            u.paintTarget(gfx,sx,sy);
        }
        gfx.setColor(Color.BLACK);
        if (elapsedTime>30){gfx.setColor(Color.RED);}
        gfx.drawString("Elapsed Time : "+(Math.round(elapsedTime*10)/10f),sx,sy-50);
    }

    public int getClosestIndex(Unit u){
        ArrayList<Unit> enemies=(u.ally)?t2u:t1u;
        int closest=0;
        float d=10000000;
        for (Unit u1: enemies){
            float dist=u1.pos.distance(u.pos);
            if (dist<d){
                closest=u1.index;
                d=dist;
            }
        }
        return closest;
    }

    /*
    *  -   -   5   0
    *    -   4   x   1  (y%2==1)
    *  -   -   3   2
    * */
    public int getXinDir(int x, int y, int d){
        if (d==1){return x+1; }
        else if (d==4){return x-1;}
        if (y%2==1&&(d==0||d==2)){
            return x+1;
        }else if(y%2==0&&(d==3||d==5)){
            return x-1;
        }
        return x;
    }
    public int getYinDir(int x, int y, int d){
        if (d==0||d==5){return y-1;}
        if (d==3||d==2){return y+1;}
        return y;
    }

    public int[] getClosestTile(Vec2f p){//TODO : THIS METHOD IS VERY INEFFICIENT, AND I WILL REWORK IT LATER
        int[] c=new int[]{0,0};
        float dist=10000000;
        /*for (int y=(int)Math.floor(p.y/ts)-1;y<=((int)Math.ceil(p.y/ts))+1; y++) {
            for (int x=(int)Math.floor((p.x-((y%2==1)?ts/2:0))/ts)-1;x<=((int)Math.ceil((p.x-((y%2==1)?ts/2:0))/ts))+1; x++){
                float d=p.distance(getTilePos(x,y));
                if (d<dist){
                    dist=d;
                    c[0]=x;c[1]=y;
                }
            }
        }*/
        for (int y=0;y<6; y++) {
            for (int x=0;x<7; x++){
                if (m[x][y]!=0){continue;}
                float d=p.distance(getTilePos(x,y));
                if (d<dist){
                    dist=d;
                    c[0]=x;c[1]=y;
                }
            }
        }

        return c;
    }

}
