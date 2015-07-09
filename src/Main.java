/**
 * Created by kkp on 03.07.15.
 */
public class Main {

    public static void main(String[] args) throws FormatterException {
        Formatter form = new Formatter();
        StringInputStream in = new StringInputStream(args[0]);
        StringOutputStream out = new StringOutputStream();

        try {
            form.check(in,out,new Editor[]{ new SpaceDeller() });
        } catch (FormatterException e) {
            //e.printStackTrace();
        }

        System.out.print(out.getResult());

    }

}
