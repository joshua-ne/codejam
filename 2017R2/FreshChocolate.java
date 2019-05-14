import java.util.*;
import java.io.*;

class FreshChocolate {
  int N, P;
  int[] groups;
  int res;

  FreshChocolate(int[] _groups, int _P) {
    groups = _groups;
    P = _P;
    N = groups.length;
    res = 0;
  }

  void solve_small() {
    int[] remaiderCounter = new int[P];
    for (int i = 0; i < N; i++) {
      remaiderCounter[groups[i] % P]++;
    }

    Jren.p(remaiderCounter);

    if (P == 2) {
      res = remaiderCounter[0] + remaiderCounter[1] / 2 + remaiderCounter[1] % 2;
    }

    if (P == 3) {
      res += remaiderCounter[0];
      if (remaiderCounter[1] == remaiderCounter[2]) {
        res += remaiderCounter[1];
      }
      else if (remaiderCounter[1] > remaiderCounter[2]) {
        res += remaiderCounter[2]; 
        remaiderCounter[1] -= remaiderCounter[2];
        res += remaiderCounter[1] / 3 + (remaiderCounter[1] % 3 == 0 ? 0 : 1);
      } 
      else {
        res += remaiderCounter[1];
        remaiderCounter[2] -= remaiderCounter[1];
        res += remaiderCounter[2] / 3 + (remaiderCounter[2] % 3 == 0 ? 0 : 1);
      }
    }



    if (P == 4) {
      res += remaiderCounter[0];
      remaiderCounter[0] = 0;
      res += remaiderCounter[2] / 2;
      remaiderCounter[2] = remaiderCounter[2] % 2;
      int tmp = Math.min(remaiderCounter[1], remaiderCounter[3]);
      res += tmp;
      remaiderCounter[1] -= tmp;
      remaiderCounter[3] -= tmp;
      Jren.p(remaiderCounter);
      if (remaiderCounter[2] == 0) {
        if (remaiderCounter[1] != 0) {
          res += remaiderCounter[1] / 4 + (remaiderCounter[1] % 4 == 0 ? 0 : 1);
        }
        if (remaiderCounter[3] != 0) {
          res += remaiderCounter[3] / 4 + (remaiderCounter[3] % 4 == 0 ? 0 : 1);
        }
      } else {
        // remainerCounter[2] == 1
        if (remaiderCounter[1] != 0) {
          if (remaiderCounter[1] <= 2) {res += 1;}
          else {
            remaiderCounter[1] -= 2;
            res++;
            res += remaiderCounter[1] / 4 + (remaiderCounter[1] % 4 == 0 ? 0 : 1);
          }
        }

        if (remaiderCounter[3] != 0) {
          if (remaiderCounter[3] <= 2) {res += 1;}
          else {
            remaiderCounter[3] -= 2;
            res++;
            res += remaiderCounter[3] / 4 + (remaiderCounter[3] % 4 == 0 ? 0 : 1);
          }
        }
      }
    }
  }






  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int T = in.nextInt();
    for (int t = 1; t <= T; t++) {
      int N = in.nextInt();
      int P = in.nextInt();
      int[] groups = new int[N];
      for (int i = 0; i < N; i++) {
        groups[i] = in.nextInt();
      }
      FreshChocolate fc = new FreshChocolate(groups, P);
      fc.solve_small();
      System.out.println("Case #" + t + ": " + fc.res);
    }
  }
}