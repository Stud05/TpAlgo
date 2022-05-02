package s14;

import java.util.Arrays;

public class SubsetSum {
  //============================================================
  public static void main(String [] args) {
    int[] t={5,8,3};
    int max=20;
    System.out.println(Arrays.toString(t));
    System.out.println("Valid sums < "+max);
    for (int i=0; i<max; i++) {
      boolean r= subsetSumDyn(t,i);
      if (r) 
        System.out.print(i+" ");
    }
  }
  //============================================================
  // Subset Sum Problem : Dynamic Programming version
  //============================================================
  public static boolean subsetSumDyn(int[] t, int k0) {
    return true; // TODO 
  }
}
