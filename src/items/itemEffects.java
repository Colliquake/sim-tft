package items;

import java.util.Scanner;
import units.Unit;

public class itemEffects {
    String[] ITEMS= new String[]{"BattlecastPlating", "Belt", "BladeOfTheRuinedKing", "Bloodthirster", "BlueBuff", "Bow", "BrambleVest", "Celestial Orb",
        "ChalicOfPower", "Cloak", "DarkStarsHeart", "Deathblade", "DragonsClaw", "ForceOfNature", "FrozenHeart", "GiantSlayer", "Gloves",
        "GuardianAngel", "GuinsoosRageblade", "HandOfJustice", "HextechGunblade", "InfiltratorsTalons", "InfinityEdge",
        "IonicSpark", "JeweledGauntlet", "LastWhisper", "LocketOfTheIronSolari", "LudensEcho", "Morellonomicon",
        "ProtectorsChestguard", "Quicksilver", "RabadonsDeathcap", "RapidFirecannon", "RebelMedal", "RedBuff",
        "Redemption", "Rod", "RunaansHurricane", "ShroudOfStillness", "Spatula", "SpearOfShojin", "StarGuardiansCharm", "StatikkShiv", "Sword",
        "SwordBreaker", "Tear", "ThiefsGloves", "TitansResolve", "TrapClaw", "Vest", "WarmogsArmor", "ZekesHerald", "Zephyr", "ZzRotPortal"};
    int[] ICODES= new int[]{2,3,5,7,11,13,17,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,97,101,103,107,109,113,127,131,
        137,139,149,151,157,163,167,173,179,181,191,193,197,199,211,223,227,229,233,239,241,251};



    public void equipItems(Unit inp){
        String usr= "";
        while(usr!= "q"|| inp.getItemCount()< 3){
            Scanner scan= new Scanner(System.in);
            System.out.println("Enter item to equip on "+ inp.getName()+" or enter 'q' to quit");
            usr= scan.nextLine();
            addingItemIDs(inp, usr);
            inp.incrementItemCount();
        }
        if(inp.getItemCount()> 0){
            changeStats(inp, inp.getTotalItemID());
        }
    }

    public void addingItemIDs(Unit inp, String str){        //only changes the totalItemID, doesn't do anything yet
        if(str== "BattlecastPlating"){
            inp.addItemID(2);
        }
        if(str== "Belt"){
            inp.addItemID(3);
        }
        if(str== "BladeOfTheRuinedKing"){
            inp.addItemID(5);
        }
        if(str== "Bloodthirster"){
            inp.addItemID(7);
        }
        if(str== "BlueBuff"){
            inp.addItemID(11);
        }
        if(str== "Bow"){
            inp.addItemID(13);
        }
        if(str== "BrambleVest"){
            inp.addItemID(17);
        }
        if(str== "CelestialOrb"){
            inp.addItemID(19);
        }
        if(str== "ChaliceOfPower"){
            inp.addItemID(23);
        }
        if(str== "Cloak"){
            inp.addItemID(29);
        }
        if(str== "DarkStarsHeart"){
            inp.addItemID(31);
        }
        if(str== "Deathblade"){
            inp.addItemID(37);
        }
        if(str== "DragonsClaw"){
            inp.addItemID(41);
        }
        if(str== "ForceOfNature"){
            inp.addItemID(43);
        }
        if(str== "FrozenHeart"){
            inp.addItemID(47);
        }
        if(str== "GiantSlayer"){
            inp.addItemID(53);
        }
        if(str== "Gloves"){
            inp.addItemID(59);
        }
        if(str== "GuardianAngel"){
            inp.addItemID(61);
        }
        if(str== "GuinsoosRageblade"){
            inp.addItemID(67);
        }
        if(str== "HandOfJustice"){
            inp.addItemID(71);
        }
        if(str== "HextechGunblade"){
            inp.addItemID(73);
        }
        if(str== "InfiltratorsTalons"){
            inp.addItemID(79);
        }
        if(str== "InfinityEdge"){
            inp.addItemID(83);
        }
        if(str== "IonicSpark"){
            inp.addItemID(89);
        }
        if(str== "JeweledGauntlet"){
            inp.addItemID(97);
        }
        if(str== "LastWhisper"){
            inp.addItemID(101);
        }
        if(str== "LocketOfTheIronSolari"){
            inp.addItemID(103);
        }
        if(str== "LudensEcho"){
            inp.addItemID(107);
        }
        if(str== "Morellonomicon"){
            inp.addItemID(109);
        }
        if(str== "ProtectorsChestguard"){
            inp.addItemID(113);
        }
        if(str== "Quicksilver"){
            inp.addItemID(127);
        }
        if(str== "RabadonsDeathcap"){
            inp.addItemID(131);
        }
        if(str== "RapidFirecannon"){
            inp.addItemID(137);
        }
        if(str== "RebelMedal"){
            inp.addItemID(139);
        }
        if(str== "RedBuff"){
            inp.addItemID(149);
        }
        if(str== "Redemption"){
            inp.addItemID(151);
        }
        if(str== "Rod"){
            inp.addItemID(157);
        }
        if(str== "RunaansHurricane"){
            inp.addItemID(163);
        }
        if(str== "ShroudOfStillness"){
            inp.addItemID(167);
        }
        if(str== "Spatula"){
            inp.addItemID(173);
        }
        if(str== "SpearOfShojin"){
            inp.addItemID(179);
        }
        if(str== "StarGuardiansCharm"){
            inp.addItemID(181);
        }
        if(str== "StatikkShiv"){
            inp.addItemID(191);
        }
        if(str== "Sword"){
            inp.addItemID(193);
        }
        if(str== "SwordBreaker"){
            inp.addItemID(197);
        }
        if(str== "Tear"){
            inp.addItemID(199);
        }
        if(str== "ThiefsGloves"){
            inp.addItemID(211);
        }
        if(str== "TitansResolve"){
            inp.addItemID(223);
        }
        if(str== "TrapClaw"){
            inp.addItemID(227);
        }
        if(str== "Vest"){
            inp.addItemID(229);
        }
        if(str== "WarmogsArmor"){
            inp.addItemID(233);
        }
        if(str== "ZekesHerald"){
            inp.addItemID(239);
        }
        if(str== "Zephyr"){
            inp.addItemID(241);
        }
        if(str== "ZzRotPortal"){
            inp.addItemID(251);
        }
    }

    public void changeStats(Unit inp, int ID){
        if(ID% 2== 0){      //TODO: battlecastplating  
            
        }
        if(ID% 3== 0){
            inp.addHP(200);
        }
        if(ID% 5== 0){      //TODO: bork
            
        }
        if(ID% 7== 0){
            inp.addLifesteal((float).45);
        }
        if(ID% 11== 0){     //TODO: bluebuff - implement minMana variable
            
        }
        if(ID% 13== 0){
            inp.increaseAS((float).15);
        }
        if(ID% 17== 0){     //TODO: bramblevest
            
        }
        if(ID% 19== 0){     //TODO: celestialorb
            
        }
        if(ID% 23== 0){     //TODO: chaliceofpower
            
        }
        if(ID% 29== 0){
            inp.addMR(25);
        }
        if(ID% 31== 0){     //TODO: darkstarsheart
            
        }
        if(ID% 37== 0){     //TODO: deathblade - implement keeping track of kills during combat
            
        }
        if(ID% 41== 0){     //TODO: dragonsclaw - check if dclaw effect is same as increasing MR
            
        }
        if(ID% 43== 0){     //TODO: forceofnature - implement maxteamsize
            
        }
        if(ID% 47== 0){     //TODO: frozenheart - implement checkfornearbyenemies
            
        }
        if(ID% 53== 0){     //TODO: giantslayer - (increase the amount of damage a target takes)
            
        }
        if(ID% 59== 0){     //TODO: gloves
            
        }
        if(ID% 61== 0){     //guardianangel
            
        }
        if(ID% 67== 0){     //guinsoos
            
        }
        if(ID% 71== 0){     //hoj
            
        }
        if(ID% 73== 0){     //gunblade
            
        }
        if(ID% 79== 0){     //infiltratorstalons
            
        }
        if(ID% 83== 0){     //infinityedge
            
        }
        if(ID% 89== 0){     //ionicspark
            
        }
        if(ID% 97== 0){     //jeweledgauntlet
            
        }
        if(ID% 101== 0){     //lastwhisper
            
        }
        if(ID% 103== 0){     //locket
            
        }
        if(ID% 107== 0){     //ludens
            
        }
        if(ID% 109== 0){     //morello
            
        }
        if(ID% 113== 0){     //protectorschestguard
            
        }
        if(ID% 127== 0){     //quicksilver
            
        }
        if(ID% 131== 0){     //rabadons
            
        }
        if(ID% 137== 0){     //rfc
            
        }
        if(ID% 139== 0){     //rebelmedal
            
        }
        if(ID% 149== 0){     //redbuff
            
        }
        if(ID% 151== 0){     //redemption
            
        }
        if(ID% 157== 0){     //rod
            
        }
        if(ID% 163== 0){     //runaanshurricane
            
        }
        if(ID% 167== 0){     //shroud
            
        }
        if(ID% 173== 0){     //spatula
            
        }
        if(ID% 179== 0){     //shojin
            
        }
        if(ID% 181== 0){     //starguardianscharm
            
        }
        if(ID% 191== 0){     //statikkshiv
            
        }
        if(ID% 193== 0){     //sword
            
        }
        if(ID% 197== 0){     //swordbreaker
            
        }
        if(ID% 199== 0){     //tear
            
        }
        if(ID% 211== 0){     //thiefsgloves
            
        }
        if(ID% 223== 0){     //titansresolve
            
        }
        if(ID% 227== 0){     //trapclaw
            
        }
        if(ID% 229== 0){     //vest
            
        }
        if(ID% 233== 0){     //warmogs
            
        }
        if(ID% 239== 0){     //zekesherald
            
        }
        if(ID% 241== 0){     //zephyr
            
        }
        if(ID% 251== 0){     //zzrot
            
        }
    }


}