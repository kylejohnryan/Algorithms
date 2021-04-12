
public class Problem1 {

	public static int count(double[] A, double x)
	{
		// given sorted array A, and a value x, return the number of times x occurs in A
		// complete the method count() here
		// O(log n) expected
		// O(n) or slower will be graded out of 5 points
		// feel free to change the return type, parameters, etc.

		/*
		int count = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] == x) {
				count++;
			}
		}
		return count;
		*/
		int result = -1;
		int start = 0;
		int end = (A.length - 1);
		while (start <= end) {
			int mid = ((start + end)/2);
			if (x == A[mid]){
				result = mid;
			}
			else if (x > A[mid])
				start = (mid + 1); 
			else if (x < A[mid])
				end = (mid - 1);
			}
		return result;
	}


	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// test your count() method here
		
		double[] testarray = {1.3, 2.1, 2.1, 2.1, 2.1, 6.7, 7.5, 7.5, 8.6, 9.0};
		double t1 = 2.1;
		double t2 = 7.5;
		double t3 = 1.3;
		System.out.println(t1+" appears "+ count(testarray, t1) + " times");
		//4
		System.out.println(t2+" appears "+ count(testarray, t2) + " times");
		//2
		System.out.println(t3+" appears "+ count(testarray, t3) + " times");
		//1
		
		
	}

}
