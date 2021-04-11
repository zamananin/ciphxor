import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class KeyTest {
    @Test
    public void constructor() {
        Key k1 = new Key("BEBEBEBABABA");
        assertEquals(6, k1.length);
        assertEquals(190, k1.bytes[0]);
        assertEquals(190, k1.bytes[2]);
        assertEquals(186, k1.bytes[3]);

        Key k2 = new Key("90BAB");
        assertEquals(3, k2.length);
        assertEquals(9, k2.bytes[0]);
        assertEquals(11, k2.bytes[1]);
        assertEquals(171, k2.bytes[2]);

        Key k3 = new Key("1");
        assertEquals(1, k3.length);
        assertEquals(1, k3.bytes[0]);
    }
}