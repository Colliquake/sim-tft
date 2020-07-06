public interface Common_Variables {
    String[] TRAITS=new String[]{"Blademaster","Mystic","Protector","Blaster","Infiltrator","Sniper","Sorcerer","Vanguard","Brawler","Paragon","Starship",
            "ManaReaver","Demolitionist","Mercenary","Battlecast","DarkStar","Chrono","Cybernetic","StarGuardian","Celestial","Astro","SpacePirate","Valkyrie","MechPilot"};
    int[] TCODES=new int[]{2,3,5,7,11,13,17,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,97,101};
    /*
    * Brief explanation of what this is:
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
}
