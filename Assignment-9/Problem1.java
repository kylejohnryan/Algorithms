import java.util.Arrays;

public class Problem1 {

	
	public static void threeway(int[] A)
	{
		//complete the code from here
		//given an array A[], write a function that re-arrange elements in A[] that pivot and //elements=pivot are placed in the middle, elements < pivot are on the left handside
		// elements > pivot are on the right handside.
		//in-place, O(n) expected
		int pivot = A[0];
		int left = 0;
		int right = A.length - 1;

		for (int i = 0; i < A.length; i++) {
			if (A[i] < pivot) {
				int temp = A[i];
				A[i] = A[left];
				A[left] = temp;
				left++;
			}
		}
		for (int j = A.length - 1; j >= 0; j--) {
			if (A[j] > pivot) {
				int temp = A[j];
				A[j] = A[right];
				A[right] = temp;
				right--;
			}
		}

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method
		int[] testarray={1, 2, 2, 2, 6, 1, 7, 0, -5, 2, 8, 1, 3, 1, 1};
		// Test your method
		threeway(testarray);
		System.out.println(Arrays.toString(testarray));
		// Your method should output {0, -5, 1, 1, 1, 1, 1, 2, 2, 6, 7, 2, 2, 8, 3}
		// with all elements = pivot next to pivot elements<pivot on the left, >pivot on the right

		int[] testarray2={1, 1, 1, 1, 1, 1};
		// Test your method
		threeway(testarray2);
		System.out.println(Arrays.toString(testarray2));
		// Your method should output {1, 1, 1, 1, 1, 1}
		// with all elements = pivot next to pivot elements<pivot on the left, >pivot on the right
	}
}