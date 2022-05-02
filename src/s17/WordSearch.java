package s17;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WordSearch {

  private final char[][] board;
  private final String[] words;

  public WordSearch() {
    this("words.txt", "puz.txt");
  }
  
  public WordSearch(String wordsFilename, String boardFilename) {
    System.out.println( "Reading files..." );
    String[] words = new String[0];
    char[][] board = new char[0][0];
    try {
      board = readBoard(boardFilename);
      words = readWords(wordsFilename);
    } catch(IOException e) {
      System.err.println("problem while reading file..." );
      System.err.println(e);
      e.printStackTrace();
    }
    this.board = board;
    this.words = words;
  }

  /**
   * Routine to solve the word search puzzle.
   * Performs checks in all eight directions.
   * @return number of matches
   */
  public int solvePuzzle() {
    if(words.length == 0) return 0;
    int matches = 0;
    int nRows=board.length, nColumns=board[0].length;
    for(int r = 0; r < nRows; r++)
      for(int c = 0; c < nColumns; c++)
        for(int rd = -1; rd <= 1; rd++)
          for(int cd = -1; cd <= 1; cd++)
            if(rd != 0 || cd != 0)
              matches += solveDirection(r, c, rd, cd);
    return matches;
  }

  /**
   * Search the grid from a starting point and direction.
   * @return number of matches
   */
  private int solveDirection(int baseRow,  int baseCol, 
                             int rowDelta, int colDelta) {
    String str = "";
    int numMatches = 0;
    int nRows=board.length, nColumns=board[0].length;
    for(int i = baseRow, j=baseCol;
        i >= 0 && j >= 0 && i < nRows && j < nColumns;
        i += rowDelta, j += colDelta) {
      str += board[i][j];
      int searchResult = prefixSearch(words, str);
      if( ! words[searchResult].startsWith(str))
        break;
      if( words[searchResult].equals(str) ) {
        numMatches++;
        System.out.println("Found " + str + " at " + baseRow + 
                      " " + baseCol + " to " + i + " " + j);
      }
    }
    return numMatches;
  }

  /**
   * Performs the binary search for word search
   * using one comparison per level.
   * Assumes a and n are OK.
   * @param a the sorted array of strings.
   * @param x the string to search for.
   * @return last position examined;
   *     this position either matches x, or x is
   *     a prefix of the mismatch, or there is no
   *     word for which x is a prefix.
   */
  private static int prefixSearch(String[] a, String x) {
    int low = 0;
    int high = a.length - 1;
    while(low < high) {
      int mid = (low + high) / 2;
      if (a[mid].compareTo(x) < 0)
        low = mid + 1;
      else
        high = mid;
    }
    return low;
  }

  private String readNonEmptyLine(BufferedReader br) throws IOException {
    String line = br.readLine();
    while(line!=null && line.length()==0)
      line = br.readLine();
    return line;
  }
  
  /**
   * Routine to read the grid.
   * Checks to ensure that the grid is rectangular.
   */
  private char[][] readBoard(String filename) throws IOException {
    try(FileReader r = new FileReader(filename);
        BufferedReader wordStream = new BufferedReader(r);
        ) {
      List<String> list = new ArrayList<>();
      String line = readNonEmptyLine(wordStream);
      if(line==null) return new char[0][0];
      int lineLen=line.length();
      while(line != null) {
        if(line.length() != lineLen) {
          System.out.println("board not rectangular... skipping");
          break;
        }
        list.add(line);
        line = readNonEmptyLine(wordStream);
      }
      char[][] t = new char[list.size()][lineLen];
      for(int i=0; i<t.length; i++) {
        for(int j=0; j<lineLen; j++) {
          t[i][j] = list.get(i).charAt(j);
        }
      }
      return t;
    }
  }

  /**
   * Routine to read the dictionary and sort it.
   */
  private String[] readWords(String filename) throws IOException {
    try(FileReader r = new FileReader(filename);
        BufferedReader wordStream = new BufferedReader(r);
        ) {
      List<String> list = new ArrayList<>();
      String line = wordStream.readLine();
      while(line != null) {
        list.add(line);
        line = wordStream.readLine();
      }
      Collections.sort(list);
      return list.toArray(new String[0]);
    }
  }
  
  // ------------------------------------------------------------
  // Cheap main
  public static void main( String [ ] args ) {
    WordSearch p = new WordSearch();
    System.out.println("Solving...");
    int nMatches = p.solvePuzzle();
    System.out.println("\n*** Total matches: " + nMatches);
  }
}
