import java.util.*;

class Test {



	public static void main(String[] args) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(1,2);
		map.put(2,3);
		map.put(4,5);
		int[] s = new int[3];
		s = map.keySet().toArray();
		Jren.p(s);
	}
}