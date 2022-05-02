package s07;
import java.util.Arrays;

public class Ex1AboutMinimum {

  public static int min1(int[] t) { 
    // TODO (this could be a helper method, with a separate recursive method)
    return 0; 
  }

  public static int min2(int[] t) { 
    // TODO (this could be a helper method, with a separate recursive method)
    return 0;
  }

  //-------------------------------------------------------------------------
  
  @FunctionalInterface 
  interface MinFunction {
    int min(int[] t);
  }
  
  static void checkTestCase(int[] t, MinFunction mf) {
    int[] t1 = Arrays.copyOf(t, t.length);
    int observed = mf.min(t1);
    if(!Arrays.equals(t, t1)) 
      throw new IllegalStateException("The input array is modified!");
    int expected = Arrays.stream(t).min().getAsInt();
    if(observed != expected) 
      throw new IllegalStateException("Bad result: " + observed
          + " instead of " + expected + " in " + Arrays.toString(t));
  }
  
  private static void tinyMinTest() {
    int[][] samples = {
        {3, 4, 5},
        {5, 4, 3},
        {4, 3, 5},
        {-1, -9},
        {-9, -1},
        {8}
    };
    for(int[] u: samples) {
      checkTestCase(u, Ex1AboutMinimum::min1);
      checkTestCase(u, Ex1AboutMinimum::min2);
    }
    System.out.print("End of tiny test.");
  }

  public static void main(String [] args) {
    int[] t = {4, 3, 2, 6, 8, 7};
    System.out.println(min1(t));
    System.out.println(min2(t));
    tinyMinTest();
  }

}
