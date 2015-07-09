/**
 * Created by kkp on 03.07.15.
 */
public class JavaCodeStyler implements Editor {

    Editor[] editors;
    public JavaCodeStyler(Editor[] newEditors) {
        editors = newEditors;
    }

    @Override
    public boolean checkOnEdit(char symbol) {
        return false;
    }

    @Override
    public String edit(char symbol) {
        String result = String.valueOf(new char[]{symbol});
        for(Editor editor:editors){
            if(editor.checkOnEdit(symbol))result = editor.edit(symbol);
        }
        return String.valueOf(result);

    }


}
