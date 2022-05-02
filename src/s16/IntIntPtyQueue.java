package s16;
import java.util.Random;

import s10.IntQueueChained;

public class IntIntPtyQueue {
  private final IntQueueChained[] fifoQueues;
  //        or: IntQueueArray  [] fifoQueues;
  // ...

  // priorities will be in [0 .. nPriorities-1]
  public IntIntPtyQueue(int nPriorities) {
    fifoQueues = null;
    // TODO 
  }

  public boolean isEmpty() {
    return false; // TODO 
  }

  // PRE: 0 <= pty < nPriorities
  public void enqueue(int elt, int pty) {
    // TODO 
  }

  // strongest pty present in the queue.
  // PRE: ! isEmpty()
  public int consultPty() {
    return 0; // TODO 
  }

  // elt with strongest (=smallest) pty.  
  // PRE: ! isEmpty()
  public int consult() {
    return 0; // TODO 
  }

  // elt with strongest (=smallest) pty.  
  // PRE: ! isEmpty()
  public int dequeue() {
    return 0; // TODO 
  }
  // ------------------------------------------------------------
  // ------------------------------------------------------------
  // ------------------------------------------------------------
  public static void main(String[] args) {
    Random r = new Random();
    long seed = r.nextInt(1000);
    r.setSeed(seed);
    System.out.println("Using seed "+seed);
    int n = 10000;
    if (args.length == 1) 
      n = Integer.parseInt(args[0]);
    int p, e;
    IntIntPtyQueue pq = new IntIntPtyQueue(n);
    for(int i=0; i<10*n; i++) {
      p = r.nextInt(n); pq.enqueue(p, p);
    }
    e = Integer.MIN_VALUE;
    for (int i=0; i<10*n; i++) {
      p = pq.dequeue(); ok (p>=e); e=p;
    }
    ok(pq.isEmpty());
    for(int i=0; i<10*n; i++) {
      p = r.nextInt(n); pq.enqueue(p, p);
      p = r.nextInt(n); pq.enqueue(p, p);
      pq.dequeue();
    }
    e = Integer.MIN_VALUE;
    while(!pq.isEmpty()) {
      p = pq.dequeue(); ok (p>=e); e=p;
    }
    System.out.println("Test passed successfully");
  }
  // ------------------------------------------------------------
  static void ok(boolean b) {
    if (b) return;
    throw new RuntimeException("property not verified: ");
  }
}

