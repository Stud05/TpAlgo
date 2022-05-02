package s08;
public class RLExos {
  //----------------------------------------------------------------
  //--- Exercises, S08 :
  //----------------------------------------------------------------
  /* append: adds an element at the end of the list. 
             append("abcd", 'z') gives "abcdz"                    */
              
  public static CharRecList append(CharRecList l, char e) {
     return null; // TODO...
  }
  //----------------------------------------------------------------
  /* concat: concatenates two lists. 
             concat("abcd", "xyz") gives "abcdxyz"               */
  public static CharRecList concat(CharRecList l, CharRecList r) {
    return null; // TODO...
  }
  //----------------------------------------------------------------
  /* replaceEach : changes every occurrence of a certain element. 
              replaceEach("bcabcaxy", 'a', 'b') gives "bcbbcbxy"  */
  public static CharRecList replaceEach(CharRecList l, char old, char by) {
    return null; // TODO...
  }
  //----------------------------------------------------------------
  /* consultAt: returns the element at index i (counting from zero). 
                consultAt("abcde", 3) gives 'd'                   */
  public static char consultAt(CharRecList l, int index) {
    return 'a'; // TODO...
  }
  //----------------------------------------------------------------
  /* isEqual: whether both lists have the same content (in same order). 
              isEqual("abc", "abc")  is true
              isEqual("abc", "bca")  is false
              isEqual("abc", "abcd") is false                     */
  public static boolean isEqual(CharRecList a, CharRecList b) {
    return false; // TODO...
  }
  //----------------------------------------------------------------
  /* isSuffix: whether suff is a suffix of l. 
               isSuffix("abcd", "bcd")  is true
               isSuffix("abcd", "bc")   is false
               isSuffix("abcd", "")     is true
               isSuffix("abcd", "abcd") is true                   */
  public static boolean isSuffix(CharRecList l, CharRecList suff) {
    return false; // TODO...
  }

  //----------------------------------------------------------------
  //--- Examples from course slides:
  //----------------------------------------------------------------
  public static int sizeOf(CharRecList l) {
    if (l.isEmpty()) 
      return 0;
    return 1 + sizeOf(l.tail());
  }
  //----------------------------------------------------------------
  public static CharRecList inverse(CharRecList l) {
    if (l.isEmpty()) 
      return l;
    return append(inverse(l.tail()), l.head());
  }
  //----------------------------------------------------------------
  public static boolean isMember(CharRecList l, char e) {
    if (l.isEmpty()) 
      return false;
    if (e == l.head())
      return true;
    return isMember(l.tail(), e);
  }
  //----------------------------------------------------------------
  public static CharRecList smaller(CharRecList l, char e) {
    if (l.isEmpty()) 
      return l;
    if ( l.head() < e )
      return smaller(l.tail(), e).withHead(l.head());
    return smaller(l.tail(), e);
  }
  //----------------------------------------------------------------
  public static CharRecList greaterOrEqual(CharRecList l, char e) {
    if (l.isEmpty()) 
      return l;
    if ( l.head() < e )
      return greaterOrEqual(l.tail(), e);
    return greaterOrEqual(l.tail(), e).withHead(l.head());
  }
  //----------------------------------------------------------------
  public static CharRecList quickSort(CharRecList l) {
    CharRecList left, right;
    if (l.isEmpty()) 
      return l;
    left  =        smaller(l.tail(), l.head());
    right = greaterOrEqual(l.tail(), l.head());
    left  = quickSort(left);
    right = quickSort(right);
    return concat(left, right.withHead(l.head()));
  }
  //----------------------------------------------------------------
  //----------------------------------------------------------------
  //----------------------------------------------------------------
  public static void main(String [] args) {
    CharRecList l = CharRecList.EMPTY_LIST;
    CharRecList m = CharRecList.EMPTY_LIST;
    l = l.withHead('c').withHead('d').withHead('a').withHead('b');
    m = m.withHead('t').withHead('u').withHead('v');

    System.out.println("list l : "+ l);
    System.out.println("list m : "+ m);

    System.out.println( "quickSort(l) : "+           quickSort(l)   );
    System.out.println( "append(l,'z') : "+          append(l,'z')  );
    System.out.println( "concat(l,m) : "+            concat(l,m)    );
    System.out.println( "replaceEach(l,'a','z') : "+ replaceEach(l,'a','z') );
    System.out.println( "consultAt(l,2) : "+         consultAt(l,2) );
    //...
  }


}
