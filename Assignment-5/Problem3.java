
public class Problem3 {

	
	public static int where(char[] A, String s, int j)
	{
		// Complete this method to find the rightmost occurence of a string s in an array A[]
		// Feel free to change the type or parameters of this method
		// A recursive methd is expected. A non-recursive method will be scored out of 5 points.

		char [] strToChar = s.toCharArray();
		int i = strToChar.length - 1;

		if (j >= A.length)
			return -1;
		
		while (i > -1 && j > 0) {
			if (strToChar[i] == A[j]) {
				i--;
			}
			else
				where(A, s, j-=1);
		}
		return j;


	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method
		char[] givenarray = {'a', 'y', 'e', 's', 'w', 'y', 'e', 's', 'v', 'h', 'e'};
		// Test your method
		System.out.println("The rightmost occurence of 'yes' in the given array is at index "+ where(givenarray, "yes", givenarray.length - 1));
		// Your method should return 5

		char[] givenarray2 = {'a', 'y', 'e', 's', 'w', 'y', 'e', 's', 'v', 'h', 'e', 'y', 'y', 'y'};
		// Test your method
		System.out.println("The rightmost occurence of 'yes' in the given array is at index "+ where(givenarray2, "yes", givenarray2.length - 1));
		// Your method should return 5

		char[] givenarray3 = {'a', 'l', 'g', 'o', 'r', 'i', 't', 'h', 'm', 's', 'i', 's', 'f', 'u', 'n'};
		// Test your method
		System.out.println("The rightmost occurence of 'algorithms' in the given array is at index "+ where(givenarray3, "yes", givenarray2.length - 1));
		// Your method should return 0

		char[] givenarray4 = {'n', 'o'};
		// Test your method
		System.out.println("The rightmost occurence of 'algorithms' in the given array is at index "+ where(givenarray4, "yes", givenarray2.length - 1));
		// Your method should return -1
		
	}
}

