import java.util.*;
import java.io.*;

class CostumeChange {
  int[][] grid;
  int res;
  int N;

  CostumeChange(int[][] _grid) {
    grid = _grid;
    res = Integer.MAX_VALUE;
    N = grid.length;
  }

  void solve_bf() {
    int[][] gridSubset = new int[N][N];
    fillGrid(gridSubset, 0);
  }

  void fillGrid(int[][] gridSubset, int curIndex) {
    if (curIndex == N * N) {
      
      if (checkValid(gridSubset)) {
        res = Math.min(countZeros(gridSubset), res);
        if (countZeros(gridSubset) < 7) {
          //Jren.p(gridSubset);
          //Jren.p(countZeros(gridSubset));
          //Jren.p();
        }
      }

      return;
    }

    
    fillGrid(gridSubset, curIndex + 1);
    gridSubset[curIndex / N][curIndex % N] = grid[curIndex / N][curIndex % N];
    fillGrid(gridSubset, curIndex + 1);
    gridSubset[curIndex / N][curIndex % N] = 0;
  }


  boolean checkValid(int[][] grid) {
    //check each row
    //Jren.p(grid);Jren.p();
    for (int i = 0; i < N; i++) {
      Set<Integer> set = new HashSet<>();
      for (int j = 0; j < N; j++) {
        if (grid[i][j] != 0 && set.contains(grid[i][j])) return false;
        else set.add(grid[i][j]);
      }
    }

    for (int i = 0; i < N; i++) {
      Set<Integer> set = new HashSet<>();
      for (int j = 0; j < N; j++) {
        if (grid[j][i] != 0 && set.contains(grid[j][i])) return false;
        else set.add(grid[j][i]);
      }
    }

    return true;
  }

  int countZeros(int[][] grid) {
    int count = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (grid[i][j] == 0) count++;
      }
    }
    return count;
  }

  void solve() {
    Map<Integer, Set<int[]>> conflictMap = new HashMap<>();
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        int count = countConflict(i, j);
        if (conflictMap.containsKey(count)) {conflictMap.get(count).add(new int[]{i, j});}
        else {conflictMap.put(count, new HashSet<int[]>()); conflictMap.get(count).add(new int[]{i, j});}
      }
    }

    int[][] newGrid = new int[N][N];

    List<Integer> keyList = new ArrayList<>(conflictMap.keySet());
    Collections.sort(keyList);
    for (int i : keyList) {
      //Jren.p("# of conflits: " + i);
      //Jren.p(conflictMap.get(i));
      for (int[] curPosition : conflictMap.get(i)) {
        int x = curPosition[0];
        int y = curPosition[1];
        int cur = grid[x][y];
        newGrid[x][y] = cur;
        if (!checkValid(newGrid)) {
          newGrid[x][y] = 0;
        }
      }
    }

    res = countZeros(newGrid);
    //Jren.p(newGrid);
        

  }

  int countConflict(int row, int col) {
    int count = 0;
    for (int i = 0; i < N; i++) {
      if (col != i && grid[row][i] == grid[row][col]) count++;
    }

    for (int i = 0; i < N; i++) {
      if (row != i && grid[i][col] == grid[row][col]) count++;
    }



    return count;
  }

  boolean checkValid(int cur, int row, int col, int[][] grid) {
    for (int i = 0; i < N; i++) {
      if (grid[row][i] == cur) return false;
    }

    for (int i = 0; i < N; i++) {
      if (grid[i][col] == cur) return false;
    }
    return true;
  }



  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
      int T = in.nextInt();
      Jren.p("start");
      for (int t = 1; t <= T; t++) {
        int N = in.nextInt();
        int[][] grid = new int[N][N];
        for (int i = 0; i < N; i++) {
          for (int j = 0; j < N; j++) {
            grid[i][j] = in.nextInt();
          }
        }

        CostumeChange cc = new CostumeChange(grid);
        cc.solve_bf();
        System.out.println("Case #" + t + ": " + cc.res);

        CostumeChange cc2 = new CostumeChange(grid);
        cc2.solve();
        System.out.println("Case #" + t + ": " + cc2.res);
        if(cc.res != cc2.res) {
          Jren.p(t);
          Jren.p(grid);
          Jren.p();

        }
        //else Jren.p("0");
      }

      Jren.p("finished");
  }
}