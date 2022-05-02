package s14;
public class MakeChange {
  //============================================================
  // Change Problem : Recursive Version
  //============================================================
  public static int makeChangeRec(int k, int[] coins) {
    int minCoins = k+1;  // greater than any valid result
    if (k==0) return 0;
    for (int c:coins) {                          //
      if (k-c < 0) continue;                     //
      int subResult = makeChangeRec(k-c, coins); //
      minCoins = Math.min(minCoins, subResult);  //
    }                                            //
    return minCoins + 1;
  }
  //============================================================
  // Change Problem : Dynamic Programming Version
  //============================================================
  public static int makeChangeDyn(int k0, int[] coins) {
    int[] makeChangeSol = new int[k0+1];
    makeChangeSol[0] = 0;
    for (int k=1; k<=k0; k++) {
      int minCoins = k0+1; // greater than any valid result
      for (int c:coins) {                         //
        if (k-c < 0) continue;                    //
        int subResult = makeChangeSol[k-c];       //
        minCoins = Math.min(minCoins, subResult); //
      }                                           //
      makeChangeSol[k] = minCoins + 1;
      //System.out.println(k + "  " + (minCoins+1));
    }
    return makeChangeSol[k0];
  }
  
  public static int makeChangeRecRec(int k, int[] coins) {
    return mkCh(k, coins.length-1, coins);
  }

  // lcc means "Last Candidate Coin index"
  private static int mkCh(int k, int lcc, int[] coins) {
    if (lcc<0 || k <0) return INFINITE;
    if (k==0) return 0;
    int a =     mkCh(k,            lcc-1, coins); // without lcc
    int b = 1 + mkCh(k-coins[lcc], lcc,   coins); // using   lcc
    return Math.min(a, b);
  }
  private static final int INFINITE = Integer.MAX_VALUE/2;

  //============================================================
  // Main
  //============================================================
  public static void main(String [] args) {
    int coins[] = {1, 2, 5, 10, 21, 25};
    int [] t = {12,19,21,46,63};
    for (int i=0; i<t.length; i++) {
      //int r = makeChangeDyn(t[i], coins);
      //int r = makeChangeRec(t[i], coins);
      int r = makeChangeRecRec(t[i], coins);
      System.out.println(t[i]+ " change in "+r+" coins");
    }
  }
}
