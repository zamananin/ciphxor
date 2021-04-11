import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CipheringTest {

    @Test
    void ciphering() throws Exception{
        String f1 = "src\\test\\testFiles\\f1.txt";
        String f2 = "src\\test\\testFiles\\f2.txt";
        String f3 = "src\\test\\testFiles\\f3.txt";
        Key k = new Key("1");
        Ciphering.ciphering(f1, f2, k);
        Ciphering.ciphering(f2, f3, k);

        InputStream s1 = new FileInputStream(f1);
        InputStream s2 = new FileInputStream(f3);
        int a = s1.read();
        int b = s2.read();
        do {
            assertEquals(a, b);
            a = s1.read();
            b = s2.read();
        } while (a != -1 || b != -1);

        s1.close();
        s2.close();
        File fl2 = new File(f2);
        fl2.delete();
        File fl3 = new File(f3);
        fl3.delete();
    }
}