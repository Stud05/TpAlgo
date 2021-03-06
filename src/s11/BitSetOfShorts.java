package s11;

import java.util.BitSet;

public class BitSetOfShorts {
    final BitSet bs;
    static final short LOW = Short.MIN_VALUE;
    static final short HIGH = Short.MAX_VALUE;

    // ------------------------------------------------------------
    static int indexFromElt(short e) {
        return e - LOW;
    }

    static short eltFromIndex(int i) {
        return (short) (i + LOW);
    }

    // ------------------------------------------------------------
    public BitSetOfShorts() {
        bs = new BitSet(); // or: new BitSet(1 + HIGH - LOW);
    }

    // ------------------------------------------------------------
    public void add(short e) {
        bs.set(indexFromElt(e));
    }

    public void remove(short e) {
        bs.clear(indexFromElt(e));
    }

    public boolean contains(short e) {
        return bs.get(indexFromElt(e));
    }

    public BitSetOfShortsItr iterator() {
        return new BitSetOfShortsItr() {
            @Override
            public boolean hasMoreElements() {
                return bs.size() < index;
            }

            @Override
            public short nextElement() {
                return BitSetOfShorts.eltFromIndex(index++);
            }
        };

    }

    public void union(BitSetOfShorts s) {
        bs.or(s.bs);
    }

    public void intersection(BitSetOfShorts s) {
        bs.and(s.bs);

    }

    public int size() {
        return bs.cardinality();
    }

    public boolean isEmpty() {
        return bs.length() == 0;
    }

    public String toString() {
        String r = "{";
        BitSetOfShortsItr itr = iterator();
        if (isEmpty()) return "{}";
        r += itr.nextElement();
        while (itr.hasMoreElements()) {
            r += ", " + itr.nextElement();
        }
        return r + "}";
    }

    // ------------------------------------------------------------
    // ------------------------------------------------------------
    public static void main(String[] args) {
        BitSetOfShorts a = new BitSetOfShorts();
        BitSetOfShorts b = new BitSetOfShorts();
        short[] ta = {-3, 5, 6, -3, 9, 9};
        short[] tb = {6, 7, -2, -3};
        int i;
        for (i = 0; i < ta.length; i++) {
            a.add(ta[i]);
            System.out.println("" + a + a.size());
        }
        for (i = 0; i < tb.length; i++) {
            b.add(tb[i]);
            System.out.println("" + b + b.size());
        }
        a.union(b);
        System.out.println("" + a + a.size());
    }
}
