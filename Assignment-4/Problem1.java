
public class Problem1 {

	public static int count(double[] A, double x)
	{
		// given sorted array A, and a value x, return the number of times x occurs in A
		// complete the method count() here
		// O(log n) expected
		// O(n) or slower will be graded out of 5 points
		// feel free to change the return type, parameters, etc.
		
		int start = 0;
		int end = A.length - 1;
		
		// When the Key is 0, it Searches for the Lowest Value
		int firstOccurance = BinarySearch(A, x, start, end, 0);
		// When the Key is 1, it Searches for the Highest Value
		int lastOccurance = BinarySearch(A, x, start, end, 1);

		if (lastOccurance <= -1)
			return -1;

		// Calculating Total Occurances
		int totalOccurances = (lastOccurance - firstOccurance + 1);
		return totalOccurances;
		
	}

		public static int BinarySearch(double [] A, double x, int start, int  end, int key) {

			int val = -1;
			while (start < end){
				int mid = ((start + end)/2);
				if (A[mid] == x) {
					val = mid;
					if (key == 1)
						start = mid + 1;
					else
						end = mid;
				}
				else if (A[mid] < x)
					start = mid + 1;
				else
					end = mid;
			}
			return val;
		}

	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// test your count() method here
		double[] testarray = {1.3, 2.1, 2.1, 2.1, 2.1, 6.7, 7.5, 7.5, 8.6, 9.0};
		double t1 = 2.1;
		double t2 = 7.5;
		double t3 = 1.3;
		double t4 = -1;
		double t5 = 25.5;

		System.out.println(t1+" appears "+ count(testarray, t1) + " times");
		// 4
		System.out.println(t2+" appears "+ count(testarray, t2) + " times");
		// 2
		System.out.println(t3+" appears "+ count(testarray, t3) + " times");
		// 1
		System.out.println(t4+" appears "+ count(testarray, t4) + " times");
		// -1
		System.out.println(t5+" appears "+ count(testarray, t5) + " times");
		// -1
		
		
	}

}
