import java.io.*;

public class Ciphering {
    public static void ciphering(String inputName, String outputName, Key key) throws Exception{
        File inputFile = new File(inputName);
        File outputFile = new File(outputName);



        try (InputStream input = new FileInputStream(inputFile);
             OutputStream output = new FileOutputStream(outputFile)) {
            int a = input.read();
            int i = 0;
            while (a > 0){
                output.write(a ^ key.bytes[i]);

                a = input.read();
                if (i == key.length - 1) i = 0;
                else i++;
            }
        }

//        int a = input.read();
//        int i = 0;
//        while (a > 0){
//            output.write(a ^ key.bytes[i]);
//
//            a = input.read();
//            if (i == key.length - 1) i = 0;
//            else i++;
//        }
//
//        input.close();
//        output.close();
    }
}