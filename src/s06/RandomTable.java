package s06;
import java.util.Random;
import java.util.Arrays;

public class RandomTable {
  static Random r = new Random();
  // ------------------------------------------------------------
  public static short[] randomTable(short m, short n) {
    short[] result=null;

    // TODO 
    // PSEUDOCODE : 
    //     create an empty set
    //     while the set has less than m elements
    //       add to the set a randomly chosen element  
    //     with an iterator, copy the entire set into an array
    //     sort the array
    Arrays.sort(result);
    return result;
  }
  // ------------------------------------------------------------
  static void testRandomTable(short m, short n) {
    short[] s = randomTable(m, n);
    int i;
    if (m != s.length)
      throw new RuntimeException("Size of array is not correct");
    if (s.length>0 && s[0]<0)
      throw new RuntimeException("Elements must be in [0..n[");
    for (i = 0; i < s.length - 1; i++) {
      if (s[i] >= s[i + 1])
        throw new RuntimeException(
            "Array should be sorted and contain distinct numbers\n["
            + stringFromArray(s) + "]");
    }
    System.out.println("\nTest passed successfully !");
    for (i=0; i<m; i++)
      System.out.print(" "+s[i]);
  }
  // ------------------------------------------------------------
  static String stringFromArray(short[] s) {
    String str = "";
    for (int i = 0; i < s.length; i++) {
      str = str + s[i] + " ";
    }
    return str;
  }
  // ------------------------------------------------------------
  public static void main(String [] args) {
    short m=10; 
    short n=50;
    if (args.length == 2) {
      m=Short.parseShort(args[0]);
      n=Short.parseShort(args[1]);
    }
    testRandomTable(m, n);
  }
}
