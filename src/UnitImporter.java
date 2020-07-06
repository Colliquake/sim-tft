import java.util.ArrayList;

public class UnitImporter implements Unit_Data{
    ArrayList<Unit> units;
    public UnitImporter(){
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
            units.add(new Unit(s));
        }
        for (Unit u : units){
            System.out.println(u.getInfo());
        }
    }

    public ArrayList<Unit> getUnits() {
        return units;
    }
}
