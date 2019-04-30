import java.util.*;
import java.io.*;
public class Solution_2019R1BA {
    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  
        for (int i = 1; i <= t; ++i) {
            int P = in.nextInt();
            int Q = in.nextInt();
            People[] people = new People[P];
            for (int j = 0; j < P; j++) {
                people[j] = new People(in.nextInt(), in.nextInt(), in.next().charAt(0));
                //System.out.println(people[j].toString());
            }


            int[] X = new int[Q + 1];
            int[] Y = new int[Q + 1];

            for (People p : people) {
                if (p.d == 'N') {
                    for (int y = p.y + 1; y <= Q; y++){
                        Y[y]++;
                    }
                }

                if (p.d == 'S') {
                    for (int y = p.y - 1; y >= 0; y--){
                        Y[y]++;
                    }
                }

                if (p.d == 'E') {
                    for (int x = p.x + 1; x <= Q; x++){
                        X[x]++;
                    }
                }

                if (p.d == 'W') {
                    for (int x = p.x - 1; x >= 0; x--){
                        X[x]++;
                    }
                }
            }

            int maxXInd = 0;
            int maxYInd = 0;
            int maxX = X[maxXInd];
            int maxY = Y[maxYInd];

            for (int k = 0; k <= Q; k++){
                if (X[k] > maxX) {
                    maxXInd = k;
                    maxX = X[k];
                }

                if (Y[k] > maxY) {
                    maxYInd = k;
                    maxY = Y[k];
                }
            }

            System.out.println("Case #" + i + ": " + maxXInd + " " + maxYInd);
        }
    }

    static class People {
        int x, y;
        char d;
        People(int x, int y, char d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }

        public String toString() {
            return (x + " " + y + " " + String.valueOf(d));
        }
    }
}