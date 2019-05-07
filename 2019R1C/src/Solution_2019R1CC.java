import java.util.*;
import java.io.*;


public class Solution_2019R1CC {
    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  
        for (int i = 1; i <= t; ++i) { 
            int R = in.nextInt();
            int C = in.nextInt();

            char[][] board = new char[R][C];
            for (int j = 0; j < R; j++) {
                String row = in.next();
                for (int k = 0; k < C; k++) {
                    board[j][k] = row.charAt(k);
                }
            }

            //print(board);
            //move(board, 1, 1, 'H');
            //print(board);

            int count = 0;
            for (Move m : checkBoard(board)) {

                if (win(board, m)) {count++;}
                //else System.out.println("Not win!");
            }

            System.out.println("Case #" + i + ": " + count);

        }
    }

    static boolean win(char[][] board, Move m) {
        int R = board.length;
        int C = board[0].length;
        char[][] newBoard = new char[R][C];
        for (int j = 0; j < R; j++) {
            for (int k = 0; k < C; k++) {
                newBoard[j][k] = board[j][k];
            }
        }
        move(newBoard, m.position.x, m.position.y, m.bac);
        Set<Move> set = checkBoard(newBoard);
        //System.out.println(m.position.x + " " + m.position.y + " " + m.bac);
        //System.out.println(set.size());
        //print(newBoard);
        if (set.size() == 0) return true;
        for (Move m2 : set) {
            if (win(newBoard, m2)) return false;
        }
        return true;
    }

    private static Set<Move> checkBoard(char[][] board) {
        Set<Move> available = new HashSet<>();
        int R = board.length;
        int C = board[0].length;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] != '.') {continue;}
                if (checkMove(board, i, j, 'H')) {
                    Move m = new Move(i, j, 'H');
                    available.add(m);
                }

                if (checkMove(board, i, j, 'V')) {
                    Move m = new Move(i, j, 'V');
                    available.add(m);
                }
            }
        }



        return available;
    }

    static boolean checkMove(char[][] board, int i, int j, char c) {
    	int tmp;
        if (c == 'H') {
        	tmp = j;
            while (tmp > 0) {
                tmp--;
                if (board[i][tmp] == 'H' || board[i][tmp] == 'V') break;
                if (board[i][tmp] == '#') return false;
            }
            tmp = j;
            while (tmp < board[0].length - 1) {
                tmp++;
                if (board[i][tmp] == 'H' || board[i][tmp] == 'V') break;
                if (board[i][tmp] == '#') return false;
            }
        }


        if (c == 'V') {
        	tmp = i;
            while (tmp > 0) {
                tmp--;
                if (board[tmp][j] == 'H' || board[tmp][j] == 'V') break;
                if (board[tmp][j] == '#') return false;
            }
            tmp = i;
            while (tmp < board.length - 1) {
                tmp++;
                if (board[tmp][j] == 'H' || board[tmp][j] == 'V') break;
                if (board[tmp][j] == '#') return false;
            }
        }

        return true;
    }

    static void print(char[][] board) {
    	for (int i = 0; i < board.length; i++) {
    		for (int j = 0; j < board[0].length; j++) {
    			System.out.print(board[i][j] + " ");
    		}
    		System.out.println();
    	}
    }


    static void move(char[][] board, int i, int j, char c) {
    	board[i][j] = c;
    	int tmp;
        if (c == 'H') {
        	tmp = j;
            while (tmp > 0) {
                tmp--;
                if (board[i][tmp] == 'H' || board[i][tmp] == 'V') break;
                if (board[i][tmp] == '.') board[i][tmp] = 'H';
            }

            tmp = j;
            while (tmp < board[0].length - 1) {
                tmp++;
                if (board[i][tmp] == 'H' || board[i][tmp] == 'V') break;
                if (board[i][tmp] == '.') board[i][tmp] = 'H';
            }
        }


        if (c == 'V') {
        	tmp = i;
            while (tmp > 0) {
                tmp--;
                if (board[tmp][j] == 'H' || board[tmp][j] == 'V') break;
                if (board[tmp][j] == '.') board[tmp][j] = 'V';
            }
            tmp = i;
            while (tmp < board.length - 1) {
                tmp++;
                if (board[tmp][j] == 'H' || board[tmp][j] == 'V') break;
                if (board[tmp][j] == '.') board[tmp][j] = 'V';
            }
        }
    }

    static class Position {
        int x;
        int y;

        public int hashCode(){
            int hash = 7;
            return hash + x + y + x * y;
        }

        public boolean equals(Object o) {
            if (this == o) return true;
            if (this.getClass() != o.getClass()) return false;
            Position p = (Position) o;
            return (this.x == p.x && this.y == p.y);
        }

        public Position(int i, int j) {
            x = i;
            y = j;
        }
    }

    static class Move {
        Position position;
        char bac;

        public int hashCode(){
            int hash = 7;
            return hash + position.x + position.y + position.x * position.y + (int) bac;
        }

        public boolean equals(Object o) {
            if (this == o) return true;
            if (this.getClass() != o.getClass()) return false;
            Move m = (Move) o;
            return (this.position.equals(m.position) && this.bac == m.bac);
        }

        public Move(int i, int j, char c) {
            position = new Position(i, j);
            bac = c;
        }
    }

    
}