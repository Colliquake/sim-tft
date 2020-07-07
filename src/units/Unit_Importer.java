package units;

import java.util.ArrayList;

public class Unit_Importer implements Unit_Data_Sheet {
    ArrayList<Unit_Info> units;
    public Unit_Importer(){
        ArrayList<String> lines=new ArrayList<>();
        int lastLine=0;

        for (int i=0; i<SHEET.length()-1; i++){
            if (SHEET.substring(i,i+1).equalsIgnoreCase("\n")){
                lines.add(SHEET.substring(lastLine,i));
                lastLine=i+1;
            }
        }
        lines.add(SHEET.substring(lastLine,SHEET.length()));
        units=new ArrayList<>();
        for (String s: lines){
            units.add(new Unit_Info(s));
        }
        for (Unit_Metadata u : units){
            System.out.println(u.getInfo());
        }
    }

    public ArrayList<Unit_Info> getUnits() {
        return units;
    }
}
