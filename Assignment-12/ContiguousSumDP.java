public class ContiguousSumDP {
	
	public static int MaximumSumContSubsequence(int[] A) {
		
		
		int[] Local_maximum =  new int[A.length];
		Local_maximum[0] = A[0];
		// Complete the function from here
		// Feel free to change the return type and parameters
		// Implement the dynamic programming Maximum Sum Contiguous Subsequence Algorithm
		// Return the maximum sum of contiguous subsequence in A[]
		// Hint: Follow the pseudocode of maximum sum of contiguous subsequence in Assignment 12

		for (int j = 1; j < Local_maximum.length; j++) {
			Local_maximum[j] = Math.max(Local_maximum[j - 1]+A[j - 1],A[j - 1]);
		}
		int result = Local_maximum[0];

		for (int j = 1; j < Local_maximum.length; j++) {
			if (result < Local_maximum[j])
				result = Local_maximum[j];
		}
		return result;
	}

	public static void main(String[] args) {
		
		int[] A = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		
		
		System.out.println("The maximum sum of contiguous subsequence in A[] = " +  MaximumSumContSubsequence(A) );
		//Given the array [−2,1,−3,4,−1,2,1,−5,4], the contiguous subarray [4,−1,2,1] has the largest sum = 6.
	}

}
