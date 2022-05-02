package s14;
public class GridPath {
  //============================================================
  // Min Path Problem : Recursive version
  //============================================================
  public static int minPath(int [][] t) {
    return minPath(t, t.length-1, t[0].length-1);
  }
  public static int minPath(int [][] t, int i, int j) {
    if (i <0 || j <0) return Integer.MAX_VALUE/2;
    if (i==0 && j==0) return t[0][0];
    int a = minPath(t, i-1, j  );
    int b = minPath(t, i,   j-1);
    if (b<a) a=b;
    return a+t[i][j];
  }
  //============================================================
  // Min Path Problem : Dynamic Programming version
  //============================================================
  public static int minPathDyn(int [][] t) {
    // TODO 
    return 0;
  }
  //============================================================
  // Small Main
  //============================================================
  public static void main (String [] args) {
    int [][] t = {
        {2,2,6,7},
        {3,8,5,9},
        {2,1,8,2},
        {4,2,3,5}
    };
    System.out.println(minPath(t));
    System.out.println(minPathDyn(t));
  }
}
