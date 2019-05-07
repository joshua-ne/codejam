import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution_2018R2B {

  static int max;
  static Set<Configure> configSet;
  static int count;
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int T = in.nextInt();

    for (int t = 1; t <= T; t++) {
        max = 0;
        int R = in.nextInt();
        int B = in.nextInt();
        Set<Juggler> set = new HashSet<>();
        configSet = new HashSet<>();
        //configSet.add(new Configure(new HashSet<Juggler>(set), R, B));
        assignJugglers(set, R, B);




        System.out.println("Case: #" + t + ": " + max + " count: " + count);
        //break;
    }
  }

  static void assignJugglers(Set<Juggler> set, int remainingR, int remainingB) {
    //System.out.println(remainingR + " " + remainingB + " " + set.size());
    count++;
    Configure c = new Configure(new HashSet<Juggler>(set), remainingR, remainingB);
    c.print();
    Jren.p();
    	configSet.add(c);
      if (remainingR == 0 && remainingB == 0) {max = Math.max(set.size(), max); return;}
      for (int i = 0; i <= remainingR; i++) {
          for (int j = 0; j <= remainingB; j++) {
              Juggler jug = new Juggler(i, j);
              if (i + j != 0 && !set.contains(jug)) {
                  set.add(jug);
                  if (!configSet.contains(new Configure(new HashSet<Juggler>(set), remainingR - i, remainingB - j))) assignJugglers(set, remainingR - i, remainingB - j);
                  set.remove(jug);
              }
          }
      }

  }

  static boolean symmetric(Set<Juggler> s1, Set<Juggler> s2) {
  	if (s1.size() != s2.size()) {return false;}
  	else {
  		for (Juggler j : s1) {
  			if (!s2.contains(new Juggler(j.blue, j.red))) return false;
  		}
  		return true;
  	}
  }

  static class Juggler {
      int blue;
      int red;

      Juggler(int r, int b){
          red = r;
          blue = b;
      }

      public int hashCode() {
          int hash = 7;
          return hash + blue + red + (blue - red);
      }

      public boolean equals(Object o) {
          if (this == o) return true;
          if (this.getClass() != o.getClass()) return false;
          Juggler j = (Juggler) o;
          return (this.blue == j.blue && this.red == j.red);
      }
  }

  static class Configure {
      int remainingB;
      int remainingR;
      Set<Juggler> set;

      Configure(Set<Juggler> set, int remainingR, int remainingB){
         this.remainingR = remainingR;
         this.remainingB = remainingB;
         this.set = set;
      }

      public int hashCode() {
          int hash = 7;
          return hash + remainingB + remainingR + (remainingB - remainingR);
      }

      public boolean equals(Object o) {
          if (this == o) return true;
          if (this.getClass() != o.getClass()) return false;
          Configure j = (Configure) o;
          return (this.remainingR == j.remainingR && this.remainingB == j.remainingB && j.set.equals(this.set)) || (this.remainingB == j.remainingR && this.remainingR == j.remainingB && symmetric(this.set, j.set));
      }

      public void print() {
      	Jren.p ("remainingR: " + remainingR + ", remainingB: " + remainingB);
      	for (Juggler j : set) {
      		Jren.p("Red: " + j.red + ", Blue: " + j.blue);
      	}
      }
  }
}