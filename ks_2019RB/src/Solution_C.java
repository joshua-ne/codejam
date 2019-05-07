import java.util.*;
import java.io.*;

public class Solution_C {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int N = in.nextInt();
      int S = in.nextInt();
      int[] tks = new int[N + 1];
      for (int j = 1; j <= N; j++) {
        tks[j] = in.nextInt();
      }
      int res = chooseTK(tks, 1, N, S);


      //output result
      System.out.println("Case #" + i + ": " + res);
      break;

    }
  }

  static int chooseTK(int[] tks, int start, int end, int S) {
    if (start == end) return 1;
    int curMax = 0;
    for (int i  = start; i <= end; i++) {
      Map<Integer, Integer> map = new HashMap<>();
      int counter = 0;
      for (int j = i; j <= end; j++) {
        if (!map.containsKey(tks[j])) {
          map.put(tks[j], 1);
          counter++;
          curMax = Math.max(curMax, counter);
        } else {
          if (map.get(tks[j]) == Integer.MAX_VALUE) {continue;}
          map.put(tks[j], map.get(tks[j]) + 1);
          counter++;
          if (map.get(tks[j]) > S) {
            counter -= map.get(tks[j]);
            map.put(tks[j], Integer.MAX_VALUE);
          }
          curMax = Math.max(curMax, counter);
        }

        System.out.println("i: " + i + ", j: " + j + ", counter: " + counter + ", curMax: " + curMax);
      }
    }
    return curMax;
  }



}