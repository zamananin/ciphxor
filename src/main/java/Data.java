import java.io.File;

public class Data{
    private String inputName;
    private String outputName;
    private Key key;

    public String getInputName() {
        if (inputName.isEmpty())
            return null;
        else return inputName;
    }

    public String getOutputName() {
        if (outputName.isEmpty())
            return null;
        else return outputName;
    }

    public Key getKey() {
        return key;
    }

    public Data(){}
    public Data(String inputName, String outputName, String keyC, String keyD) throws Exception {
        this.inputName = inputName;
        if (outputName == null)
            outputName = inputName.replace(".", "Changed.");
        this.outputName = outputName;
        this.key = onlyOneKey(keyC, keyD);
    }

    public Key onlyOneKey(String keyC, String keyD) throws Exception {
        if ((keyC == null) == (keyD == null)) {
            throw new Exception("Use correct form [-c key] [-d key] inputName.txt [-o outputName.txt]");
//            System.out.println("Use correct form [-c key] [-d key] inputName.txt [-o outputName.txt]");
//            System.exit(1);
        }
        if (keyD == null) return new Key(keyC);
        else return new Key(keyD);
    }


}
