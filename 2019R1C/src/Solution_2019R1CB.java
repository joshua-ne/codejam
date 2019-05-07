import java.util.*;
import java.io.*;

public class Solution_2019R1CB {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();  
        int F = in.nextInt();
        for (int i = 1; i <= t; ++i) { 

			String res = "";
			int count = 0;
        	OUT:
        	for (int j = 0; j < 5 && count < 495; j++){
				int[] counts = new int[]{120,120,120,120,120};
        		for (int k = 0; k < 119 && count < 495; k++) {
        			//if (j == 4 && k == 119) break OUT;
        			System.out.println(count);
        			System.out.flush();
        			char c = in.next().charAt(0);
        			counts[c - 'A']--;
        			count++;
        		}

        		for (int k = 0; k < 5; k++) {
        			if (counts[k] > 0) res = res + ('A' + k);
				}
        	}

        	System.out.println(res);
        	System.out.flush();

        	String s = in.next();

            
        }
    }

    
}