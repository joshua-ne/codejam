import java.util.*;
import java.io.*;
public class Solution_2019R1AB {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {

        	int N = in.nextInt();
        	in.nextLine();

        	String[] words = new String[N];
        	for (int j = 0; j < N; j++) {
        	    words[j] = in.nextLine();
            }

            CharNode root = new CharNode(' ');
            for (int j = 0; j < N; j++) {
               String word = words[j];
               CharNode wordChain = buildChainFromWord(word, 1);
               addWordChainToNode(root, wordChain);
            }

            int res = countUnpaired(root);
            System.out.println("Case #" + i + ": " + (N - res) );
            //printTree(root, 0);
            //System.out.println();
        }
    }

    private static int countUnpaired(CharNode node) {
        if (node == null) return 0;

        int r = 0;
        for (CharNode n : node.subNodes.values()) {
            r += countUnpaired(n);
        }

        if (node.isWord) r += 1;
        if (node.letter != ' ' && r >= 2) r -= 2;

        return r;

        
    }

    private static CharNode buildChainFromWord(String word, int offset) {
        if (offset == word.length() + 1) {
            return null;
        }
        CharNode node = new CharNode(word.charAt(word.length() - offset));
        node.wordNum = 1;
        if (offset == word.length()){
            node.isWord = true;
        }
        CharNode tmp = buildChainFromWord(word, offset + 1);
        node.next = tmp;
        if (tmp != null) node.subNodes.put(tmp.letter, tmp);
        return node;
    }


    private static void addWordChainToNode(CharNode node, CharNode word) {

        if(word == null) {
            node.wordNum++;
            node.isWord = true;
            return;}

        if (node.subNodes.containsKey(word.letter)) {
            node.wordNum++;
            addWordChainToNode(node.subNodes.get(word.letter), word.next);
        } else {
            node.subNodes.put(word.letter, word);
            node.wordNum++;
        }
    }

    private static void printTree(CharNode root, int level) {
    	for (int i = 0; i < level; i++){
    		System.out.print(' ');
    	}
        System.out.print(root.letter + " " + root.wordNum);
        System.out.println();
        for (CharNode node : root.subNodes.values()) {
            printTree(node, level + 1);
        }
    }


    static class CharNode {
        char letter;
        Map<Character, CharNode> subNodes;
        CharNode next;
        boolean isWord;
        int wordNum;

        CharNode(char letter) {
            this.letter = letter;
            this.subNodes = new HashMap<>();
            this.next = null;
            this.isWord = false;
            this.wordNum = 0;
        }

        @Override
        public boolean equals(Object o) {
            if (o == this) return true;
            if (o == null || o.getClass() != this.getClass()) return false;
            CharNode cN = (CharNode) o;
            return cN.letter == this.letter;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            int tmp = (int) this.letter;
            return hash + tmp * tmp;
        }
    }
} 