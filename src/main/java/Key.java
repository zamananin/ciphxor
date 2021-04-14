import java.util.Arrays;
import java.util.Objects;

public class Key {
    private int[] bytes;
    private int length;

    public int[] getBytes() {
        return bytes;
    }

    public int getLength() {
        return length;
    }

    public Key(String s){
        int l = s.length();
        length = l / 2 + l % 2;
        if (!s.matches("[0-9A-F]+")) throw new IllegalArgumentException("Key must be a hexadecimal number");

        bytes = new int[length];

        int p = l % 2;

        if (p == 0) bytes[0] = (hexToByte( s.charAt( 0 ) ) * 16 + hexToByte( s.charAt( 1 ) ));
        else bytes[0] = hexToByte( s.charAt( 0 ) );

        for (int i = 1; i < length; i++) {
            int j = i * 2 - p;
            bytes[i] = (hexToByte( s.charAt( j ) ) * 16 + hexToByte( s.charAt( j + 1 ) ));
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Key key = (Key) o;
        return length == key.length && Arrays.equals(bytes, key.bytes);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(length);
        result = 31 * result + Arrays.hashCode(bytes);
        return result;
    }

    private static int hexToByte(char c) {
        String digits = "0123456789ABCDEF";
        return digits.indexOf(c);
    }
}
