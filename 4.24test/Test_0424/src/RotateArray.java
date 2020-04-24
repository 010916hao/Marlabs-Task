import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class RotateArray {
	

//void Reverse(int* array, int p, int q)
//{
//	for (; p<q; p++, q--)
//	{
//		int temp = array[q];
//		array[q] = array[p];
//		array[p] = temp;
//	}
//}
// 
//void RightShift(int* array,int n, int k)
//{
//	k %= n;
//	Reverse(array, 0, n - k - 1);
//	Reverse(array, n - k, n - 1);
//	Reverse(array, 0, n - 1);

	public static void reverse(int[] arr, int p, int q) {
		for ( ; p < q; p ++, q--) {
			int temp = arr[p];
			arr[p] = arr[q];
			arr[q] = temp;
		}
	}
	
	public static void rightShift(int[] arr, int N, int K) {
		K = K % N;
		reverse(arr, 0, N - K - 1);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		System.out.println("###########################");
		reverse(arr, N - K, N - 1);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		reverse(arr, 0, N - 1);
		System.out.println("###########################");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
		RotateArray.rightShift(arr, 8, 8);
	}
}
