import com.sun.xml.internal.ws.util.StringUtils;

/**
 * Created by kkp on 03.07.15.
 */
public class JavaCodeStyler implements Editor {

    char[] triggers = new char[]{' ','\n',';','{','}'} ;//[0] [1] [2] [3] [4]
    int spaceCount;
    int symbolCount;
    boolean wasSpace;
    boolean isNewString;

    public JavaCodeStyler() {
        this.wasSpace = false;
        this.spaceCount = 0;
        this.isNewString = true;
        this.symbolCount = 0;
    }

    @Override
    public boolean checkOnEdit(char symbol) {
        for(char trigger:triggers){
            if(symbol == trigger)return true;
        }
        return false;
    }

    @Override
    public String edit(char symbol) {
        String result = String.valueOf(new char[]{symbol});
        //And I don't know what to do with it
        if (isNewString) {
            if (symbol == triggers[0] || symbol == triggers[1]){
                result = String.valueOf("");
            }else if (symbol == triggers[3]) {
                changeSpaceCount(4);
                result = result.concat("\n");
            }else if (symbol == triggers[4]) {
                changeSpaceCount(-4);
                result = "";
                result = result.concat(new String(new char[spaceCount]).replace("\0", " "));
                result = result.concat(String.valueOf(triggers[4]));
                result = result.concat("\n");
            }else{
                isNewString = false;
                wasSpace = false;
                result = new String(new char[spaceCount]).replace("\0"," ").concat(result);
            }
        }
        else{
            if ((symbol == triggers[0] && wasSpace) || symbol == triggers[1]) result = String.valueOf("");
            else if (symbol == triggers[0] && !wasSpace){
                wasSpace = true;
            }else if (symbol == triggers[2]){
                isNewString = true;
                result = result.concat("\n");
            }else if (symbol == triggers[3]){
                changeSpaceCount(4);
                isNewString = true;
                result = result.concat("\n");
            }else if (symbol == triggers[4]){
                changeSpaceCount(-4);
                isNewString = true;
                result = "\n";
                result = result.concat(new String(new char[spaceCount]).replace("\0", " "));
                result = result.concat(String.valueOf(triggers[4]));
                result = result.concat("\n");
            }else wasSpace = false;
        }
        return String.valueOf(result);
    }

    private void changeSpaceCount(int space){
        spaceCount+=space;
    }

}
