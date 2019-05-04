import java.util.*;
import java.util.stream.*;

class Jren {
	static void p(String s) {
		System.out.println(s);
	}

	static void p() {
		System.out.println();
	}

	static void p(int[] nums) {
		System.out.println(Arrays.stream(nums).boxed().collect(Collectors.toList()).toString());
	}

	static void p_index(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			System.out.printf("%3d ", i);
		}
		p();

		for (int i : nums) {
			System.out.printf("%3d ", i);
		}
		p();
	}

	static void p_index(int[] nums, int k) {
		for (int i = 0; i < nums.length; i++) {
			System.out.printf("%" + k +"d ", i);
		}
		p();

		for (int i : nums) {
			System.out.printf("%" + k +"d ", i);
		}
		p();
	}

	public static void main(String[] args) {
		
	}
}