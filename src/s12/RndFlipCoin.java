package s12;
import java.util.Random;
public class RndFlipCoin {
  public static void main(String [] args) {
    int nbOfExperiments = 100000;
    int n=100, m=27;
    Random r = new Random();
    testFlipCoin(r, m, n, nbOfExperiments);
  }
  // ------------------------------------------------------------
  public static boolean flipCoin(Random r, int m, int n) {
    return false; // TODO
  }
  //============================================================
  static void testFlipCoin(Random r, int m, int n, int nbOfTests) {
    System.out.printf("With m=%d / n=%d \n", m, n);
    int nbOfTrue = 0;
    for (int i = 0; i < nbOfTests; i++) {
      if (flipCoin(r, m, n))
        nbOfTrue++;
    }
    System.out.println("There was " + nbOfTrue + " TRUE among " + nbOfTests +
                       " flips of coin");
  }
}
