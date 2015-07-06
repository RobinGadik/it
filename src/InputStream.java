/**
 * Created by kkp on 03.07.15.
 */
public interface InputStream {
    char read() throws StreamException;
    boolean isEnd();
}
