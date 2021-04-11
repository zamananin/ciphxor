import java.io.File;

public class Data{
    String inputName;
    String outputName;
    Key key;

    public Data(){}
    public Data(String inputName, String outputName, String keyC, String keyD) {
        this.inputName = inputName;
        if (outputName == null)
            outputName = inputName.replace(".", "Changed.");
        this.outputName = outputName;
        this.key = onlyOneKey(keyC, keyD);
    }

    public Key onlyOneKey(String keyC, String keyD) {
        if ((keyC == null) == (keyD == null)) {
            System.out.println("Use correct form [-c key] [-d key] inputName.txt [-o outputName.txt]");
            System.exit(1);
        }
        if (keyD == null) return new Key(keyC);
        else return new Key(keyD);
    }
}
