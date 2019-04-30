import java.util.*;
import java.io.*;
public class Solution_2019R1BB {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int w = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int[] rings = new int[6];
            long[] ans = new long[w];
            for (int j = 0; j < w; j++) {
                System.out.println(j + 2);
                System.out.flush();
                ans[j] = in.nextLong();
            }

            rings[0] = (int)((ans[5] - ans[4]) / 64);
            rings[2] = (int)(ans[1] - ans[0] - 4 * rings[0]);
            rings[4] = (int)(ans[3] - ans[2] - 16 * rings[0]);
            rings[1] = (int)((ans[4] - 2 * ans[1] - 48 * rings[0]) / 4);
            rings[3] = (int)(ans[3] - ans[1] - 24 * rings[0] - 2 * rings[1] - rings[4]);
            rings[5] = (int)(ans[4] - ans[3] - 32 * rings[0] - 4 * rings[1] - 2 * rings[2]);

            for (int j = 0; j <= 5; j++) {
            	if (j < 5) System.out.print(rings[j] + " ");
            	else {
            		System.out.println(rings[j]);
            		System.out.flush();
            	}
            }
           

            int res = in.nextInt();
            
        }
    }
}