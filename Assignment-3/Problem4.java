
public class Problem4 {

	public static int indexpoint(int[] A)
	{
		// Given a sorted array of n distinct integers A[], find out whether there is an index i such that A[i] = i.
		// complete the method indexpoint() here
		// O(log n) expected
		// O(n) or slower will be graded out of 5 points
		// feel free to change the return type, parameters, etc.
		
		int start = 0;
		int end = (A.length - 1);
		while (start <= end) {
			int mid = ((start + end)/2);
			if (A[mid] == mid) {
				return mid;
			}
			else if (mid > A[mid])
				start = (mid + 1);
			else if (mid < A[mid])
				end = (mid - 1);
		}
		return -1;
	}
	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// test your indexpoint() method here
		
		int[] testarray1 =  {-10, -5, 0, 3, 7};
		int[] testarray2 =  {0, 2, 5, 8, 17};
		int[] testarray3 =  {-10, -5, 3, 4, 7, 9};
		int[] testarray4 =  {-3, 0, 1, 2, 3, 5};
		int[] testarray5 =  {-20, -15, -10, -5, 0};

		System.out.println("A[i] = i at index "+ indexpoint(testarray1));
		// 3 expected
		System.out.println("A[i] = i at index "+ indexpoint(testarray2));
		// 0 expected
		System.out.println("A[i] = i at index "+ indexpoint(testarray3));
		// -1 expected
		System.out.println("A[i] = i at index "+ indexpoint(testarray4));
		// 5 expected
		System.out.println("A[i] = i at index "+ indexpoint(testarray5));
		// -1 expected

		
	}

}
