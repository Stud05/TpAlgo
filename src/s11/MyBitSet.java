package s11;

public class MyBitSet {
    // ------------------------------------------------------------
    private int[] buffer;
    private static final short NB_OF_BITS = 32;
    private static final int DEFAULT_CAPACITY = 100;

    // ------------------------------------------------------------
    public MyBitSet() {
        this(DEFAULT_CAPACITY);
    }

    public MyBitSet(int capacity) {
        buffer = new int[1 + (capacity / NB_OF_BITS)];
    }

    public void set(int bitIndex, boolean value) {  // bitIndex >= 0
        int bitValue = (1 << bitIndex % NB_OF_BITS);
        int index = bitIndex / NB_OF_BITS;
        checkSize(index); // Check if there is still free space
        if (value) {
            buffer[index] |= bitValue;
        } else {
            buffer[index] &= ~bitValue;
        }
    }

    public void set(int bitIndex) {
        set(bitIndex, true);
    }

    public void clear(int bitIndex) {
        set(bitIndex, false);
    }

    // ------------------------------------------------------------
    // ------------------------------------------------------------
    // ensures that that array cell exists
    // (re-dimensions the array if necessary)
    private void checkSize(int arrayIndex) {
        if (arrayIndex < buffer.length) return;
        int f = 1 + arrayIndex / buffer.length;
        int[] aux = new int[f * buffer.length]; // or new int[arrayIndex+1] if
        for (int j = 0; j < buffer.length; j++)    // we choose the minimal size
            aux[j] = buffer[j];
        buffer = aux;
        assert arrayIndex < buffer.length;
    }

    public boolean get(int bitIndex) {
        if (size() < bitIndex) {
            return false;
        }
        int index = bitIndex / NB_OF_BITS;
        checkSize(index);
        int bitValue = (1 << bitIndex % NB_OF_BITS);
        return (buffer[index] & bitValue) != 0;
    }

    public void and(MyBitSet o) {
        if (this == o) {
            return;
        }
        checkSize(o.buffer.length);
        for (int i = 0; i < o.buffer.length; i++) {
            buffer[i] &= o.buffer[i];
        }
    }

    public void or(MyBitSet o) {
        if (this == o) {
            return;
        }
        checkSize(o.buffer.length);
        for (int i = 0; i < o.buffer.length; i++) {
            buffer[i] |= o.buffer[i];
        }
    }

    public void xor(MyBitSet o) {
        if (this == o) {
            return;
        }
        checkSize(o.buffer.length);
        for (int i = 0; i < o.buffer.length; i++) {
            buffer[i] ^= o.buffer[i];
        }
    }

    public int size() { // crt capacity, total nb of bits
        return buffer.length * NB_OF_BITS;
    }

    public int length() { // highest bit "on" + 1
        int n = 0;
        for (int i = 0; i < buffer.length * NB_OF_BITS; i++)
            if (get(i)) n = i + 1;
        return n;
    }

    public int nextSetBit(int fromIndex) {  // -1 if none
        if (size() <= fromIndex) {
            return -1;
        }
        if (get(fromIndex)) {
            return fromIndex;
        }
        return nextSetBit(fromIndex + 1);
    }

    public int cardinality() {  // nb of bits set to true
        int temp = 0;
        for (int i = 0; i < size(); i++) {
            if (get(i)) {
                temp++;
            }
        }
        return temp;
    }

    public String toString() {
        String r = "{";
        for (int i = 0; i < buffer.length * NB_OF_BITS; i++)
            if (get(i))
                if (r.length() == 1) r += i;
                else r += "," + i;
        return r + "}";
    }

    // ------------------------------------------------------------
    public static void main(String[] args) {
        MyBitSet a = new MyBitSet(100);
        ok(a.length() == 0);
        System.out.println(a);
        a.set(4);
        ok(a.get(4));
        ok(!a.get(3));
        a.clear(4);
        a.clear(5);
        a.set(6);
        ok(!a.get(4));
        ok(a.get(6));
        ok(!a.get(5));
        System.out.println(a);
    }

    static void ok(boolean b) {
        if (b) return;
        throw new RuntimeException("property not verified: ");
    }
}
