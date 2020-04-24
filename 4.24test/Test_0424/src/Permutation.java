import java.util.HashSet;

public class Permutation {

	
	public static boolean isPermutation(int[] arr, int N) {
		
		HashSet<Integer> set = new HashSet<>();
		for (int i : arr) {
			set.add(i);
		}
		if (set.size() < N)
			return false;
		for (int i = 1; i <= N ; i++) {
			if(!set.contains(i))
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		int[] arr = {4, 2, 1, 3, 6, 5, 7, 10, 8};
		System.out.println(Permutation.isPermutation(arr, arr.length));
	}
}
