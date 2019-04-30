import java.util.*;
import java.util.stream.Collectors;

class Jren {
	public static void main(String[] args) {
		int[] nums = new int[]{1,2,3,4,5};
		printArray(nums);
	}



	public static void printArray(int[] nums) {
		System.out.println(Arrays.stream(nums).boxed().collect(Collectors.toList()));
	}
}
