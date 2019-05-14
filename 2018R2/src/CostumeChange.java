import java.util.*;
import java.io.*;

class CostumeChange {
  int[][] grid;
  int res;
  int N;

  CostumeChange(int[][] _grid) {
    grid = _grid;
    res = 0;
    N = grid.length;
  }

  void solve() {
    int[][] newGrid = new int[N][N];
    int count = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        int cur = grid[i][j];
        if (checkValid(cur, i, j, newGrid)) {
          newGrid[i][j] = cur;
          count++;
        }
      }
    }
    res = N * N - count;
  }

  boolean checkValid(int cur, int row, int col, int[][] grid) {
    for (int i = 0; i < col; i++) {
      if (grid[row][i] == cur) return false;
    }

    for (int i = 0; i < row; i++) {
      if (grid[i][col] == cur) return false;
    }
    return true;
  }



  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
      int T = in.nextInt();
      for (int t = 1; t <= T; t++) {
        int N = in.nextInt();
        int[][] grid = new int[N][N];
        for (int i = 0; i < N; i++) {
          for (int j = 0; j < N; j++) {
            grid[i][j] = in.nextInt();
          }
        }

        CostumeChange cc = new CostumeChange(grid);
        cc.solve();
        System.out.println("Case #" + t + ": " + cc.res);
      }
  }
}