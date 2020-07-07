package units;

import java.util.ArrayList;
import main.Common_Variables;
public abstract class Unit_Metadata implements Common_Variables {
    String n;
    int[] mhp,mana;
    float[] dmg;
    int def,mr,ar,cost;
    float crit,as;
    ArrayList<String> traits;
    int tcode;

    public Unit_Metadata(String d){
        ArrayList<String> v=new ArrayList<>();
        int last=0;
        for (int i=0; i<d.length()-1; i++){ if (d.substring(i,i+1).equalsIgnoreCase("\t")){ v.add(d.substring(last,i));last=i+1; } }
        v.add(d.substring(last,d.length()));
        n=v.get(0);
        cost=getInt(v.get(1));
        mhp=new int[]{getInt(v.get(2)),getInt(v.get(3)),getInt(v.get(4))};
        mana=new int[]{getInt(v.get(5)),getInt(v.get(6))};
        dmg=new float[]{Float.parseFloat(v.get(7)),Float.parseFloat(v.get(8)),Float.parseFloat(v.get(9))};
        def=getInt(v.get(10));
        mr=getInt(v.get(11));
        ar=getInt(v.get(12));
        as=Float.parseFloat(v.get(13));
        crit=Float.parseFloat(v.get(14));
        traits=new ArrayList<>();
        for (int i=15; i<v.size(); i++){ traits.add(v.get(i)); }
        tcode=1;
        for (String s: traits){tcode=tcode*GETTCODE(s);}
    }

    public int getInt(String s){
        if (s.equalsIgnoreCase("-")){return 0;}
        return Integer.parseInt(s);
    }

    public String getInfo(){
        String d=n+" is a ";
        boolean f=true;
        for (String s: traits){
            d=(f)?d+s+" ":d+"and "+s+" ";f=false;
        }
        d+="("+tcode+") | HP = "+mhp[0]+" / "+mhp[1]+" / "+mhp[2]+" | Mana = "+mana[0]+" / "+mana[1];
        d+=" | DMG = "+dmg[0]+" / "+dmg[1]+" / "+dmg[2]+" | ";
        d+=" | DEF = "+def+" | MR = "+mr+" | AR = "+ar+" | AS = "+as+" | CRIT = "+crit;
        return d;
    }
}
