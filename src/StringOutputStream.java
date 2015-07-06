/**
 * Created by kkp on 03.07.15.
 */
public class StringOutputStream implements OutputStream {

    private StringBuilder result;

    public StringOutputStream(){
        result = new StringBuilder();
    }

    @Override
    public void write(String result) {
        this.result.append(result);
    }

    public String getResult(){
        return result.toString();
    }
}
