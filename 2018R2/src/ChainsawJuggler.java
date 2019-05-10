import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class ChainsawJuggler {
  int R;
  int B;
  private List<int[]> sets;
  private Map<Status, Integer> dp;
  private int res;

  private ChainsawJuggler(int r, int b) {
    B = b;
    R = r;
    sets = new ArrayList<>();
    for (int i = 0; i < B; i++) {
      for (int j = 0; j < R; j++) {
        sets.add(new int[]{i, j});
      }
    }
    dp = new HashMap<>();
    /*
    for (int k = 0; k < sets.size(); k++) {
      for (int i = 0; i < B; i++) {
        for (int j = 0; j < R; j++) {
          dp.put(new Status(k, i, j), 0);
        }
      }
    }
    */
    res = 0;
  }

  void solve(){
    res = solve(new Status(sets.size() - 1, B, R)) - 1;
  }

  int solve(Status status) {
    int optimal;
    if (status.b == 0 && status.r == 0) optimal = 0;
    else if (status.v == 0) optimal = 1;
    else if (dp.containsKey(status)) optimal = dp.get(status);
    else {
      if (status.b - sets.get(status.v)[0] >= 0 && status.r - sets.get(status.v)[1] >= 0)
        optimal = Math.max(solve(new Status(status.v - 1, status.b, status.r)), 1 + solve(new Status(status.v - 1, status.b - sets.get(status.v)[0], status.r - sets.get(status.v)[1])));
      else
        optimal = solve(new Status(status.v - 1, status.b, status.r));
      
    }
    dp.put(status, optimal);
    return optimal;
  }

  void printDP() {
    for (Status s : dp.keySet()) {
        System.out.println(s.toString() + " , optimal: " + dp.get(s));
    }
  }



  class Status {
    int v;
    int b;
    int r;
    Status (int _v, int _b, int _r) {
      v = _v;
      b = _b;
      r = _r;
    }
    public int hashCode() {
      int hash = 7;
      return hash = v + r + b + v * r * b;
    }

    public boolean equals(Object o) {
      if (this == o) return true;
      if (this.getClass() != o.getClass()) return false;
      Status s = (Status) o;
      return this.v == s.v && this.r == s.r && this.b == s.b;
    }

    public String toString() {
        return "Status: v = " + v + " , b = " + b + " , r = " + r; 
    }
  }
s
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int T = in.nextInt();
    for (int t = 1; t <= T; t++) {
      int R = in.nextInt();
      int B = in.nextInt();
      ChainsawJuggler cj = new ChainsawJuggler(R, B);
      cj.solve();
      System.out.println("Case: #" + t + ": " + cj.res);
      //cj.printDP();
    }

  }
}