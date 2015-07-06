/**
 * Created by kkp on 03.07.15.
 */
public class StringInputStream implements  InputStream{

    private String stream;
    private int index;

    public StringInputStream(String s){
        stream = s;
        index = 0;
    }

    @Override
    public char read() throws StreamException{
        if(!isEnd()){
            return stream.charAt(index++);
        }else {
            throw new StreamException();
        }
    }

    @Override
    public boolean isEnd() {
        return index == stream.length();
    }
}
