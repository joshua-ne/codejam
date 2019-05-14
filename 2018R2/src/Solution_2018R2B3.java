import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution_2018R2B3 {

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int T = in.nextInt();

    for (int t = 1; t <= T; t++) {
        int R = in.nextInt();
        int B = in.nextInt();
        int large = R >= B ? R : B;
        int small = (R + B) - large;
        int count = 0;

        int n = 1;
        while (small >= n * (n + 1) / 2) {
          small -= n * (n + 1) / 2;
          large -= n * (n + 1) / 2;
          count += n + 1;
          n++;
        }

        if (small + large >= n) {

        }



        Jren.p(n + " " + small + " " + large);

       



        System.out.println("Case: #" + t + ": " + " count: " + count);
        //break;
    }
  }

  
}