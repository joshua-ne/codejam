import java.util.*;
import java.io.*;

public class Solution_B {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int N = in.nextInt();
      List<Stone> stones = new ArrayList<>();

      for (int j = 0; j < N; j++) {
        stones.add(new Stone(in.nextInt(), in.nextInt(), in.nextInt()));
      }

      int res = 0;

      stones.sort((o1, o2) -> (o2.L - o1.L));

      for (int j = 0; j < N; j++) {

      }
      System.out.println("Case #" + i + ": " + res);
      
    }
  }


}

class Stone {
  int S, E, L;
  public Stone(int S, int E, int L) {
    this.S = S;
    this.E = E;
    this.L = L;
  }
}