public class Extracredit1 {

	public static int findkth(int[] A, int start, int end, int k)
	{
		// Implement the algorithm described in Extra Credit Assignment 1
		// to return the k_th largest element in A[]
		int pivot = partition(A, start, end);
		if (pivot == k - 1) {
			return A[pivot];
		}
		if (pivot < k -1) {
			return findkth(A, start + 1, end, k);
		}
		return findkth(A, start, end - 1, k);
	}	
	public static int partition(int[] A, int start, int end) {
		int i = start;
		int x = A[end];
		for (int j = start; j < end; j++) {
			if (A[j] > x) {
				int temp = A[i];
				A[i] = A[j];
				A[j] = temp;
				i++;
			}
		}
		int temp = A[i];
		A[i] = A[end];
		A[end] = temp;
		return i;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method
		int[] testarray = {7, 10, 4, 3, 20, 15};
		int k = 3;
		// Test your method
		int p = findkth(testarray, 0, testarray.length - 1, k);
		System.out.println("The "+ k+ "rd largest element is: " + p);
		// Expected output: 10

		k = 2;
		// Test your method
		p = findkth(testarray, 0, testarray.length - 1, k);
		System.out.println("The "+ k+ "rd largest element is: " + p);
		// Expected output: 15

		k = 4;
		// Test your method
		p = findkth(testarray, 0, testarray.length - 1, k);
		System.out.println("The "+ k+ "rd largest element is: " + p);
		// Expected output: 7

	}
}