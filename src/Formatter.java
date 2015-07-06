

/**
 * Created by kkp on 03.07.15.
 */

public class Formatter {

    public Formatter() throws FormatterException {
    }

    public void check(InputStream in, OutputStream out) throws FormatterException {
        char symbol;
        Editor styler = new JavaCodeStyler();
        while(!in.isEnd()){
            try {
                symbol = in.read();
            } catch (StreamException e) {
                throw new FormatterException();
            }
            String result ;

            result = styler.edit(symbol);

            out.write(result);
        }
    }

}

