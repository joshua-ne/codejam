import java.util.*;
import java.io.*;

public class Solution_A {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
    	int N = in.nextInt();
    	int Q = in.nextInt();
    	in.nextLine();
    	char[] block = in.nextLine().toCharArray();
        List<int[]> tableList = new ArrayList<>();
        tableList.add(new int[26]);
        int[] table = new int[26];
        for (int j = 0; j < N; j++) {
            table[(block[j] - 'A')]++;
            tableList.add(table.clone());
        }



    	int count = 0;

    	for (int j = 0; j < Q; j++){
    	  int left = in.nextInt();
    	  int right = in.nextInt();

          if (checkP(tableList.get(left - 1), tableList.get(right))) count++;

        }
      
      //output result
      System.out.println("Case #" + i + ": " + count);
      
    }
  }

  static boolean checkP(int[] t1, int[] t2) {
    int sum = 0;
    for (int i = 0; i < 26; i++) {
      sum += ((t2[i] - t1[i]) % 2 == 0 ? 0 : 1);
      if (sum == 2) return false;
    }
    return true;

  }
}