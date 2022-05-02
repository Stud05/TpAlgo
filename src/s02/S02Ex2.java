
package s02;

public class S02Ex2 {

  static long a(int n) {
    long sum = 0;
    for(int i=3; i<2*n; i++) 
      sum++;
    return sum;
  }

  static long b(int n) {
    long sum = 0;
    for(int i=0; i<n; i++)
      for(int j=0; j<n; j++)
        sum++;
    return sum;
  }

  static long c(int n) {
    long sum = 0;
    for(int i=0; i<n; i++)
      sum++;
    for(int j=0; j<n; j++)
      sum++;
    return sum;
  }

  static long d(int n) {
    long sum = 0;
    for(int i=0; i<n; i++)
      for(int j=0; j<n*n; j++)
        sum ++;
    return sum;
  }

  static long e(int n) {
    long sum = 0;
    for(int i=0; i<n; i++) 
      for(int j=0; j<i; j++)
        sum ++;
    return sum;
  }

  static long f(int n) {
    long sum = 0;
    for(int i=0; i<5; i++) {
      for (int j=0; j<i; j++)
        sum++;
    }
    return sum;
  }

  static long g(int n) {
    long sum = 0;
    int i = n;
    while(i>0) {
      int j = n;
      while(j>1) {
        sum++;
        j--;
      }
      i = i/2;
    }
    return sum;
  }

  static long h(int n) {
    long sum = 0;
    int i=1; int j=1;
    while(j<=n) {
      i = i+1;
      if (i>=n) { j=j+10; i=1;}
      sum++;
    }
    return sum;
  }

  static long i(int n) {
    long sum = 0;
    for(int i=0; i < n*n; i=i+2)
      for(int j=1; j*j < n ; j++) 
        if (j % 3 == 0) 
          sum++;
    for (int k=1; k < 2*n; k=2*k)
      sum++; 
    return sum;
  }

  static long j(int n) {
    long sum = 0;
    for(int i=0; i<n; i++) {
      for(int j=0; j<i; j++)
        if(j % i == 0)           // (3)
          for(int k=(n-1)*n; k<n*n; k++)
            if (j > 0)           // (5)
              sum ++;
    }
    return sum;
  }

  //--------------------------------------------
  public static void main(String[] args) {
    System.out.println(a(10));
  }

}
