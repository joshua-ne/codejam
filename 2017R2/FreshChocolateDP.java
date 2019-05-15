import java.util.*;
import java.io.*;

class FreshChocolateDP {

  int N, P;
  int[] groups;
  int sum;
  int[] remainderCounter;
  int res;
  PTuple pTuple;
  Map<Status, Integer> dp;

  FreshChocolateDP(int[] _groups, int _P) {
    groups = _groups;
    sum = 0;
    P = _P;
    N = groups.length;
    res = 0;
    remainderCounter = new int[P];
    for (int i = 0; i < N; i++) {
      remainderCounter[groups[i] % P]++;
      sum += groups[i];
    }
    dp = new HashMap<>();
    //Jren.p(remainderCounter);
    //Jren.p("jflwefsjf");
  }

  void solve_dp() {
    res = solve_dp(new Status(new PTuple(remainderCounter)));
    //Jren.p(dp.size());
    
    for(Status s : dp.keySet()) {
      /*
      Jren.p(dp.get(s));
      s.print();
      Jren.p();
      */
    }
    
  }

  int solve_dp(Status status) {
    
    if (status == new Status(new PTuple(P))) return 0;
    if (dp.containsKey(status)) return dp.get(status);
    //status.print();
    int res = 0;
    res += remainderCounter[0];
    for (int i = 1; i < P; i++) {
      if (status.pTuple.nums[i] > 0) {
        int[] curNums = status.pTuple.nums.clone();
        curNums[i]--;
        Status prevStatus = new Status(new PTuple(curNums));
        int increase = 0;
        if (i == 0 || (i != 0 && ((prevStatus.remainder) % P) == 0)) increase = 1;
        res = Math.max(res, increase + solve_dp(prevStatus));
      }
    }
    dp.put(status, res);
    return res;

  }












  class Status {
    PTuple pTuple;
    int remainder;

    Status(PTuple pTuple) {
      this.pTuple = pTuple;
      for (int i = 1; i < P; i++) {
        remainder += pTuple.nums[i] * i;
        remainder = remainder % P;
      }
    }

    public int hashCode() {
      int hash = 7;
      for (int i = 1; i < this.pTuple.nums.length; i++) {
        hash += this.pTuple.nums[i] * 31;
      }
      return hash;
    }

    public boolean equals(Object o) {
      if (this == o) return true;
      if (o.getClass() != this.getClass()) return false;
      Status s = (Status) o;
      return this.pTuple.equals(s.pTuple);
    }    

    public void print() {
      //Jren.p("remainder: " + remainder);
      //Jren.p(pTuple.nums);
    }
  }

  class PTuple {
    int[] nums;
    int P;
    PTuple(int p) {
      P = p;
      nums = new int[P];
    }
    PTuple(int[] _nums) {
      P = _nums.length;
      nums = _nums.clone();
    }
    public int hashCode() {
      int hash = 7;
      hash += 31 * P;
      for (int i : this.nums) {
        hash += i * 31;
      }
      return hash;
    }
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o.getClass() != this.getClass()) return false;
      PTuple p = (PTuple) o;
      if (this.P != p.P) return false;
      for (int i = 1; i < P; i++) {
        if (this.nums[i] != p.nums[i]) return false;
      }
      return true;
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
      FreshChocolateDP fc = new FreshChocolateDP(groups, P);
      fc.solve_dp();
      System.out.println("Case #" + t + ": " + fc.res);
    }
  }
}