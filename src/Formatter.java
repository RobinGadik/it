import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by kkp on 03.07.15.
 */
public class Formatter {

    public Formatter() {
    }

    byte[] someAction(int symbol){
        return new byte[]{};
    }

    public void check(InputStream in, OutputStream out) throws IOException {
        int symbol;
        while ((symbol = in.read()) != -1){
            out.write(someAction( symbol));
        }
    }

}

