import java.util.*;
import java.io.*;

public class Solution_2017R1AA {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int r = in.nextInt();
      int c = in.nextInt();
      in.nextLine();
      char[][] cake = new char[r][c];

      //read in the cake's initial status
      for (int j = 0; j < r; j++) {
        String row = in.nextLine();
        cake[j] = row.toCharArray();
      }

      split(cake, 0, 0, r - 1, c - 1);

      //output result
      System.out.println("Case #" + i + ": " );
      for (int j = 0; j < r; j++) {
        System.out.println(new String(cake[j]));
      }
    }
  }

  static void split(char[][] cake, int ulRow, int ulCol, int drRow, int drCol) {

    int[] checkRes = {-1, -1, -1, -1};
    //return the cooridnate of any two letters, if there are more than one letters in the region
    checkLetter(cake, ulRow, ulCol, drRow, drCol, checkRes);
    //System.out.println("CheckRes: "+checkRes[0] + " " + checkRes[1] + " " +checkRes[2] + " " +checkRes[3] + " " );
    if (checkRes[2] == -1) {
      //System.out.println("only one letter in the region:" + "(" + ulRow + ", " + ulCol +")"+ "(" + drRow + ", " + drCol +")");
      fillCake(cake, ulRow, ulCol, drRow, drCol);
    } else if (checkRes[0] == checkRes[2]) {
      // two points have same row number, divide vertically
      int vertSplitPoint = checkRes[1] > checkRes[3] ? checkRes[3] : checkRes[1];
      //System.out.println("spliting vertically at cloumn: " + vertSplitPoint);
      split(cake, ulRow, ulCol, drRow, vertSplitPoint);
      split(cake, ulRow, vertSplitPoint + 1, drRow, drCol);
    } else {
      //two points not in the same row divide horizontally
      int horiSplitPoint = checkRes[0] > checkRes[2] ? checkRes[2] : checkRes[0];
      //System.out.println("spliting horizontally at row: " + horiSplitPoint);
      split(cake, horiSplitPoint + 1, ulCol, drRow, drCol);
      split(cake, ulRow, ulCol, horiSplitPoint, drCol);
    }
  }

  private static void checkLetter(char[][] cake, int ulRow, int ulCol, int drRow, int drCol, int[] checkRes) {
    int count = 0;
    OUT:
    for (int i = ulRow; i <= drRow; i++) {
      for (int j = ulCol; j <= drCol; j++) {
        if (cake[i][j] != '?') {
          checkRes[count] = i;
          checkRes[count + 1] = j;
          count += 2;
        }
        if (count == 4) break OUT;
      }
    }
  }

  private static void fillCake(char[][] cake, int ulRow, int ulCol, int drRow, int drCol) {
    char letterToFill = '?';
    OUT:
    for (int i = ulRow; i <= drRow; i++) {
      for (int j = ulCol; j <= drCol; j++) {
        if (cake[i][j] != '?') {
          letterToFill = cake[i][j];
          break OUT;
        }
      }
    }
    for (int i = ulRow; i <= drRow; i++) {
      for (int j = ulCol; j <= drCol; j++) {
        cake[i][j] = letterToFill;
      }
    }
  }
}
