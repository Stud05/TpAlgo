package s09;
public class IntStack {
  private int[] buf;     
  private int top;  // growing downwards
  public IntStack() { this(10); } 
  public IntStack(int initialCapacity) {
    buf = new int[initialCapacity]; 
    top = initialCapacity;
  } 
  public boolean isEmpty() {
    return top == buf.length; 
  }
  public int pop() {
    int e = buf[top];  
    top++; 
    return e;
  }
  public void push(int x) { 
    checkSize(); 
    top--; 
    buf[top] = x; 
  }
  private void checkSize() {
    int n = buf.length;
    if (top == 0) { 
      int[] t = new int[2*n];
      for (int i=0; i<n; i++) 
        t[i+n] = buf[i];
      buf = t;
      top = n;
    }
  }
  // ----------------------------------------------------------------------
  static boolean isBuggy01() {
    IntStack s = new IntStack();
    s.push(9);
    if (s.pop() != 9) return true;
    if (!s.isEmpty()) return true;
    return false;
   }
  
  static boolean isBuggy02() {
    IntStack s = new IntStack();
    s.push(9); s.push(5);
    if (s.isEmpty()) return true;
    return false;
   } 
  
  static boolean isBuggy03() {
    IntStack s = new IntStack();
    s.push(6); s.push(5); 
    s.pop();   s.push(8);
    if (s.pop() != 8) return true;
    if (s.isEmpty())  return true;
    return false;
   }

  // ----------------------------------------------------------------------
  public static void main(String [] args) {
    System.out.println(isBuggy01());
    System.out.println(isBuggy02());
    System.out.println(isBuggy03());
  }
}
