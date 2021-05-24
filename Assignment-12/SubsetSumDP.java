public class SubsetSumDP {
	
	public static boolean subsetSum(int[] A, int x, int n) {
		
		boolean[][] Sum = new boolean[x + 1][n + 1];
		// Complete the function from here
		// Feel free to change the return type and parameters
		// Implement the dynamic programming Subset Sum Algorithm
		// Return true if there exists a subset in A with sum = x
		// Hint: Follow the pseudocode of subsetSum in the slides
        for (int i = 0; i <= n; i++)
            Sum[0][i] = true;


            for (int i = 1; i <= x; i++)
                Sum[i][0] = false;


            for (int i = 1; i <= x; i++) {
                for (int j = 1; j <= n; j++) {
                    Sum[i][j] = Sum[i][j - 1];
                        if (i >= A[j - 1])
                            Sum[i][j] = Sum[i][j]
                                || Sum[i - A[j - 1]][j - 1];
    }
    }
    return Sum[x][n];
	}

	public static void main(String[] args) {
		
		int[] A = {1,3,5,2,8};
		int n = A.length;
		int x = 9;
		
		System.out.println("There exists a subset in A[] with sum = " + x + " : " + subsetSum(A, x, n));
		// Expected output: true
	}

}
