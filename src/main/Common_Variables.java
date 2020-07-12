package main;

import units.Unit;
import units.Unit_Importer;
import units.Unit_Info;

import java.util.ArrayList;

public interface Common_Variables {
    String[] TRAITS=new String[]{"Blademaster","Mystic","Protector","Blaster","Infiltrator","Sniper","Sorcerer","Vanguard","Brawler","Paragon","Starship",
            "ManaReaver","Demolitionist","Mercenary","Battlecast","DarkStar","Chrono","Cybernetic","StarGuardian","Celestial","Astro","SpacePirate","MechPilot"};
    int[] TCODES=new int[]{2,3,5,7,11,13,17,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,97,101};
    ArrayList<Unit_Info> UNITS=(new Unit_Importer()).getUnits();
    float ARSCALE=1.5f;
    int ts=90;
    String[] ITEMS= new String[]{"BattlecastPlating", "Belt", "BladeOfTheRuinedKing", "Bloodthirster", "BlueBuff", "Bow", "BrambleVest", "Celestial Orb",
            "ChalicOfPower", "Cloak", "DarkStarsHeart", "Deathblade", "DragonsClaw", "ForceOfNature", "FrozenHeart", "GiantSlayer", "Gloves",
            "GuardianAngel", "GuinsoosRageblade", "HandOfJustice", "HextechGunblade", "InfiltratorsTalons", "InfinityEdge",
            "IonicSpark", "JeweledGauntlet", "LastWhisper", "LocketOfTheIronSolari", "LudensEcho", "Morellonomicon",
            "ProtectorsChestguard", "Quicksilver", "RabadonsDeathcap", "RapidFirecannon", "RebelMedal", "RedBuff",
            "Redemption", "Rod", "RunaansHurricane", "ShroudOfStillness", "Spatula", "SpearOfShojin", "StarGuardiansCharm", "StatikkShiv", "Sword",
            "SwordBreaker", "Tear", "ThiefsGloves", "TitansResolve", "TrapClaw", "Vest", "WarmogsArmor", "ZekesHerald", "Zephyr", "ZzRotPortal"};
    int[] ICODES= new int[]{2,3,5,7,11,13,17,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,97,101,103,107,109,113,127,131,
            137,139,149,151,157,163,167,173,179,181,191,193,197,199,211,223,227,229,233,239,241,251};

    /*
    * I realize this section is kinda incomprehensible, so heres a brief explanation of what this is:
    * To avoid having to run string checks on every trait a character has every time you need to check if a unit has a specific trait, I devised this method
    * Each trait is connected to a specific prime number, and every character has a trait code which is the product of all the prime numbers representing their traits
    * For example, a blademaster & mystic unit would have the code 2*3=6
    * This means that every time you need to check if a unit has a particular trait, you can just use this:
    * if( unit.tcode # 3 == 0 )
    * Just replace the 3 with the code corresponding to a particular trait, or if you're lazy use:
    * if (unit.tcode % GETTCODE("blademaster") == 0)
    * */
    default int GETTCODE(String s){
        for (int i=0; i<TRAITS.length; i++){
            if (s.equalsIgnoreCase(TRAITS[i])){
                return TCODES[i];
            }
        }
        return 1;
    }
    default int GETTINDEX(String s){
        for (int i=0; i<TRAITS.length; i++){
            if (s.equalsIgnoreCase(TRAITS[i])){
                return i;
            }
        }
        return 1;
    }
    default ArrayList<Integer> getFactors(int num){
        int rem=num;
        ArrayList<Integer> factors=new ArrayList<>();
        for (int i=2; i<num;i++){
            if (rem%i==0){
                factors.add(i);
                rem=rem/i;
                if (rem==1){
                    return factors;
                }
            }
        }
        return factors;
    }
}
