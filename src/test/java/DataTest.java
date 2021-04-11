import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataTest {
    @Test
    public void data() {
        assertEquals(new Key("BAB"), new Data().onlyOneKey("BAB", null));
        assertEquals(new Key("BAB"), new Data().onlyOneKey(null, "BAB"));

    }
}