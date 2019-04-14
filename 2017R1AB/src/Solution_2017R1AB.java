import java.util.*;
import java.io.*;

public class Solution_2017R1AB {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

        for (int i = 1; i <= t; ++i) {

            int numIngredient = in.nextInt();
            int numPackage = in.nextInt();

            //read the recipe in a intp[]
            int[] recipe = new int[numIngredient];
            for (int j = 0; j < numIngredient; j++) {
              recipe[j] = in.nextInt();
            }

            //read in the packge info
            int[][] packages = new int[numIngredient][numPackage];
            for (int j = 0; j < numIngredient; j++) {
                for (int k = 0; k < numPackage; k++) {
                    packages[j][k] = in.nextInt();
                }
            }

            int res;
            res = calculate(numIngredient, numPackage, recipe, packages);

            System.out.println("Case #" + i + ": " + res);

            /*
            System.out.println("Case #" + i + ": " );
            System.out.println("Number of ingredients: " + numIngredient);
            System.out.println("Number of packages for each: " + numPackage);

            System.out.println("recipe: ");
            for (int j = 0; j < numIngredient; j++) {
                System.out.print(recipe[j] + " --- ");
            }
            System.out.println();

            System.out.println("packages: ");
            for (int j = 0; j < numIngredient; j++) {
                for (int k = 0; k < numPackage; k++) {
                  System.out.print( packages[j][k] + " --- ");
                }
                System.out.println();
            }
            */
        }
     }

     private static int calculate(int numIngredient, int numPackage, int[] recipe, int[][] packages) {


        return 0;
     }
}