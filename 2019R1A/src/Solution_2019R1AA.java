import java.util.*;
import java.io.*;
public class Solution_2019R1AA {
    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  
        for (int i = 1; i <= t; ++i) {

            int R = in.nextInt();
            int C = in.nextInt();

            int count = 0;
            List<Point> path = new ArrayList<>();

            Set<Point> availablePoints = new HashSet<>();
            for (int j = 1; j < R + 1; j++) {
                for (int k = 1; k < C + 1; k++) {
                    availablePoints.add(new Point(j, k));
                }
            }
            Set<Point> GavailablePoints = new HashSet<>(availablePoints);

            path = jump(i, R, C, availablePoints,GavailablePoints, path, count, null);

            if (path != null) {
                System.out.println("Case #" + i + ": " + "POSSIBLE" );
	            for (Point p : path) {
	                System.out.println(p.r + " " + p.c);
	            }
            } else {
            	System.out.println("Case #" + i + ": "  + "IMPOSSIBLE");
            }      
        }
    }

    private static List<Point> jump(int i, int R, int C, Set<Point> availablePoints,Set<Point> GavailablePoints, List<Point> path, int count, Point prev) {

        if (count == R * C) {return path;}
        if (availablePoints.isEmpty()) {return null;}


        for (Point next : availablePoints) {

            List<Point> curPath = new ArrayList<>(path);
            curPath.add(next);
            GavailablePoints.remove(next);
            Set<Point> curAvailable = new HashSet<>(GavailablePoints);

            for (Point p : GavailablePoints) {
                if (curPath.contains(p) || p.r == next.r || p.c == next.c || p.r - p.c == next.r - next.c || p.r + p.c == next.r + next.c) {
                    curAvailable.remove(p);
                }
            }

            List<Point> tmp = jump(i, R, C, curAvailable,GavailablePoints, curPath, count + 1, next);
            if (tmp != null) {
            	return tmp;
            } else {GavailablePoints.add(next);}

        }
        return null;
    }

    static class Point {
        int r;
        int c;
        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public boolean equals(Object p) {
            if (p == this) return true;
            if (p == null) return false;
            if (! (p instanceof Point)) return false;
            Point point = (Point)p;
            return (this.r == point.r && this.c == point.c);
        }
    }
} 