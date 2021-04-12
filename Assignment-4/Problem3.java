
public class Problem3 {

	public static int squareroot(int x)
	{
		// given a positive integer x, return square root of x
		// if x is not a perfect square, return the floor of its square root
		// complete the method squareroot() here
		// O(log n) expected
		// O(n) or slower will be graded out of 5 points
		// feel free to change the return type or parameters
	
		int result = -1;

		int start = 0;
		int end = x/2;

		while (start <= end) {
			int mid = ((start + end)/2);
			int sqr = (mid * mid);

			if (x == sqr) {
				return mid;
			}
			else if (x > sqr) {
				start = mid + 1;
				result = mid;
			}
			else
				end = mid - 1;
		}
		return result;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// test your count() method here
		
		int x1 = 8;
		// 2
		int x2 = 5;
		// 2
		int x3 = 17;
		// 4
		int x4 = 25;
		// 5
		int x5 = 0;
		// 0 
		int x6 = -1;
		// -1
		int x7 = 2;
		// 1

		System.out.println("The square root of " + x1 + " is " + squareroot(x1));
		System.out.println("The square root of " + x2 + " is " + squareroot(x2));
		System.out.println("The square root of " + x3 + " is " + squareroot(x3));
		System.out.println("The square root of " + x4 + " is " + squareroot(x4));
		System.out.println("The square root of " + x5 + " is " + squareroot(x5));
		System.out.println("The square root of " + x6 + " is " + squareroot(x6));
		System.out.println("The square root of " + x7 + " is " + squareroot(x7));
		
	}

}
