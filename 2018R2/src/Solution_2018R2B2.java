import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution_2018R2B2 {

  static int max;
  static int count;
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int T = in.nextInt();

    for (int t = 1; t <= T; t++) {
        max = 0;
        int R = in.nextInt();
        int B = in.nextInt();
        Set<Juggler> set = new HashSet<>();
        assignJugglers(set, R, B);




        System.out.println("Case: #" + t + ": " + max + " count: " + count);
        //break;
    }
  }

  static void assignJugglers(Set<Juggler> set, int remainingR, int remainingB) {
    //System.out.println(remainingR + " " + remainingB + " " + set.size());
    count++;
      if (remainingR == 0 && remainingB == 0) {max = Math.max(set.size(), max); return;}
      for (int i = 0; i <= remainingR; i++) {
          for (int j = 0; j <= remainingB; j++) {
              Juggler jug = new Juggler(i, j);
              if (i + j != 0 && !set.contains(jug)) {
                  set.add(jug);
                  assignJugglers(set, remainingR - i, remainingB - j);
                  set.remove(jug);
              }
          }
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
}