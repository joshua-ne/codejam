import java.util.*;
import java.io.*;

public class Solution_2018R2A {
    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  
        for (int i = 1; i <= t; ++i) { 
        	int C = in.nextInt();
        	int[] res = new int[C];
        	for (int j = 0; j < C; j++) {
        		res[j] = in.nextInt();
        	}
        	int R = 1;
        	String[] ans;
        	if (res[0] != 0 && res[C - 1] != 0) {

        		//finalPos store the position of the ith ball after finishing
        		int[] finalPos = new int[C];

        		for (int j = 0, k = 0; j < C; j++) {
        			int cur = res[j];
        			while (cur > 0) {
        				finalPos[k++] = j;
        				cur--;
        			}
        		}

        		Jren.p(finalPos);
        		for (int j = 0; j < C; j++) {
        			R = Math.max(R, Math.abs(finalPos[j] - j) + 1);
        		}

        		ans = new String[R];
        		
        		for (int j = 0; j < R - 1; j++) {
        			char[] row = new char[C];
        			for (int k = 0; k < C; k++) {
        				if (finalPos[k] == k) {
        					if (row[k] == '\u0000') row[k] = '.';
        				} else if (finalPos[k] < k) {
        					finalPos[k]++;
        					row[k] = '.';
        					row[k - j] = '/';
        					
        				} else {
        					finalPos[k]--;
        					if (row[k] == '\u0000') row[k] = '.';
        					row[k + j] = '\\';
        				}
        			}
        			ans[j] = new String(row);
        		}

        		StringBuilder sb = new StringBuilder();
        		for (int j = 0; j < C; j++) {
        			sb.append(".");
        		}
        		ans[R - 1] = sb.toString();

        		System.out.println("Case #" + i + ": " + R);
				for(String s : ans) {
					System.out.println(s);
				}

        	
			} else {
				System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
			}

			
            
        }
    }

    

    
}