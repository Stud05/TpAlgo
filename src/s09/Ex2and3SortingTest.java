package s09;
import java.util.Arrays;

public class Ex2and3SortingTest {
  //----- Maybe you'll find that useful for ex. (3)... -------
  @FunctionalInterface interface ISorting {
    void sort(int[] t);
  }
  static final ISorting[] algos = {
      BuggySorting::sort00, BuggySorting::sort01,
      BuggySorting::sort02, BuggySorting::sort03,
      BuggySorting::sort04, BuggySorting::sort05,
      BuggySorting::sort06, BuggySorting::sort07,
      BuggySorting::sort08, BuggySorting::sort09,
      BuggySorting::sort10, BuggySorting::sort11,
      Arrays::sort
  };
 
  // for(ISorting a:algos) {
  //   ...
  //   a.sort(t);
  //   ...
  // }

  //=============================================================

  public static boolean isSortingResultCorrect(int[] orig, int[] sorted) {
    return false; // TODO
  }

  // Maybe you'll find such a method useful...
  private static int nbOfOccurrences(int[] t, int e) {
    return 0; // TODO (if useful)
  }

  // ------------------------------------------------------------
  public static void main(String [] args) {
    // ...
  }
}
