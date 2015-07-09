/**
 * Created by kkp on 08.07.15.
 */
public class SpaceDeller implements Editor{

    private char[] spaceSymbols;
    private char[] delling;
    private char[] triggers;
    private boolean isNewString;
    private boolean wasSpace;

    public void setIsNewString(boolean isNewString) {
        this.isNewString = isNewString;
    }


    public void setDelling(char[] delling) {
        this.delling = delling;
    }

    public void setWasSpace(boolean wasSpace) {
        this.wasSpace = wasSpace;
    }

    public SpaceDeller(){
        setNewString();
        spaceSymbols = new char[]{' '};
        delling = new char[]{'\n'};
        triggers = new char[]{';', '{' , '}'};
    }

    public SpaceDeller(char[] spaceSymbols, char[] delling, char[] triggers, boolean isNewString, boolean wasSpace) {
        this.spaceSymbols = spaceSymbols;
        this.delling = delling;
        this.triggers = triggers;
        this.isNewString = isNewString;
        this.wasSpace = wasSpace;
    }

    public void setNewString(){
        isNewString = true;
        wasSpace = false;

    }

    @Override
    public boolean checkOnEdit(char symbol) {
        for(char trigger:triggers){
            if(symbol == trigger){
                setNewString();
                return false;
            }
        }
        for(int i = 0;i<spaceSymbols.length;i++) {
           if (symbol == spaceSymbols[i]){
                if (isNewString) return true;
                else if (wasSpace) return true;
                else {
                    setWasSpace(true);
                    return false;
                }
            }
        }
        for(int i = 0;i<delling.length;i++)if(symbol == triggers[i])return true;
        setWasSpace(false);
        setIsNewString(false);
        return false;
    }

    @Override
    public String edit(char symbol) {
        return "";
    }
}
