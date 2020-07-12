package items;

import main.Common_Variables;
import units.Unit;

import java.util.ArrayList;

public class Item_Effects implements Common_Variables {


    public void equipItems(Unit inp, int a, int b, int c){
        addItem(inp,a);
        addItem(inp,b);
        addItem(inp,c);
    }
    public void equipItems(Unit inp, int a, int b){
        addItem(inp,a);
        addItem(inp,b);
    }
    public void equipItems(Unit inp, int a){
        addItem(inp,a);
    }

    public void addItem(Unit inp, int index){        //only changes the totalItemID, doesn't do anything yet
       inp.addItemID(ICODES[index]);
        changeStats(inp, ICODES[index]);

    }


    public void changeStats(Unit inp, int ID){
        switch (ID){
            case 2:// battlecastplating
                break;
            case 3:
                inp.addHP(200);
                break;
            case 5:  // bork
                break;
            case 7:
                break;
            case 11:// bluebuff - implement minMana variable
                break;
            case 13:
                break;
            case 17: // bramblevest
                break;
            case 19:  // celestialorb
                break;
            case 23:// chaliceofpower
                break;
            case 29:
                inp.mr+=(25);
                break;
            case 31:// darkstarsheart
                break;
            case 37:// deathblade - implement keeping track of kills during combat
                break;
            case 41:  // dragonsclaw - check if dclaw effect is same as increasing MR
                break;
            case 43: // forceofnature - implement maxteamsize
                break;
            case 47:// frozenheart - implement checkfornearbyenemies
                break;
            case 53: // giantslayer - (increase the amount of damage a target takes)
                break;
            case 59:   // gloves
                break;
            case 61:  //guardianangel
                break;
            case 67:  //guinsoos
                break;
            case 71://hoj
                break;
            case 73: //gunblade
                break;
            case 79://infiltratorstalons
                break;
            case 83: //infinityedge
                break;
            case 89://ionicspark
                break;
            case 97: //jeweledgauntlet
                break;
            case 101: //lastwhisper
                break;
            case 103://locket
                break;
            case 107:    //ludens
                break;
            case 109:  //morello
                break;
            case 113: //protectorschestguard
                break;
            case 127:  //quicksilver
                break;
            case 131://rabadons
                break;
            case 137://rfc
                break;
            case 149:  //redbuff
                break;
            case 151:  //redemption
                break;
            case 157://rod
                break;
            case 163:    //runaanshurricane
                break;
            case 167:  //shroud
                break;
            case 173:     //spatula
                break;
            case 179:    //shojin
                break;
            case 181:  //starguardianscharm
                break;
            case 191://statikkshiv
                break;
            case 193:   //sword
                break;
            case 197:  //swordbreaker
                break;
            case 199:   //tear
                break;
            case 211:   //thiefsgloves
                break;
            case 223:   //titansresolve
                break;
            case 227:  //trapclaw
                break;
            case 229://vest
                break;
            case 233: //warmogs
                break;
            case 239:  //zekesherald
                break;
            case 241: //zephyr
                break;
            case 251:  //zzrot
                break;
        }

    }
}
