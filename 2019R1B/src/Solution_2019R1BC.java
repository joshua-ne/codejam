import java.util.*;
import java.io.*;
public class Solution_2019R1BC {
    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  
        for (int i = 1; i <= t; ++i) {
        	int N = in.nextInt();
        	int K = in.nextInt();
        	int[] C = new int[N];
        	int[] D = new int[N];
        	for (int j = 0; j < N; j++) {
        	    C[j] = in.nextInt();
            }
            for (int j = 0; j < N; j++) {
                D[j] = in.nextInt();
            }

            int count = 0;

            for (int l = 0; l < N; l++) {
                int subCount = 0;
                int maxC = C[l];
                int maxD = D[l];
        	    for (int r = l; r < N; r++) {
        	        maxC = Math.max(maxC, C[r]);
        	        maxD = Math.max(maxD, D[r]);
        	        if (Math.abs(maxC - maxD) <= K) subCount++;
                }
                //System.out.println(subCount);
                count += subCount;
            }
            System.out.println("Case #" + i + ": " + count);
            //break;
        }
    }

    
}