
public class Problem3
{

public static Max2ndMax dcfindmax2ndmax(int[] A, int i, int j)
	{
		// Complete this method to find max and 2nd max in an array A
		// At most 3n/2-2 comparisons
		// Algorithms that make more than 3n/2-2 comparisons will be scored out of 5 points
		// Complete the code from here
		// Feel free to change method type, parameters

		Max2ndMax pair = new Max2ndMax();
                if(i == j) {
                        pair.max = A[i];
                        pair.max2nd = -1;
                        return pair;
                }
                int mid = (i + j)/2;
                Max2ndMax pair1 = dcfindmax2ndmax(A, i, mid);
                Max2ndMax pair2 = dcfindmax2ndmax(A, mid+1, j);
                if (pair1.max > pair2.max) {                                 
                        pair.max = pair1.max;
                        pair.max2nd = Math.max(pair2.max, pair1.max2nd);
                } 
				else if (pair2.max > pair1.max) {          
                        pair.max = pair2.max;
                        pair.max2nd = Math.max(pair1.max, pair2.max2nd);
                } 
				else {                                                            
                        pair.max = pair1.max;
                        pair.max2nd = Math.max(pair.max2nd, pair2.max2nd);
                }
                return pair;
        } 

	public static void main(String[] args) {
		// TODO Auto-generated method
		int[] givenarray = {100,2,3,4,5,6,7,67,2,32};	
		 
		// Test your method
		Max2ndMax pair = new Max2ndMax();
		pair = dcfindmax2ndmax(givenarray, 0, givenarray.length-1);
		int max2nd = pair.max2nd;
		int max = pair.max;

		System.out.println("The max and 2ndmax of the given array are "+ max + " and "+max2nd+".");
		// Your method should return 100 and 67


                int[] givenarray2 = {100};	
		// Test your method
		pair = dcfindmax2ndmax(givenarray2, 0, givenarray2.length-1);
		max2nd = pair.max2nd;
		max = pair.max;

		System.out.println("The max and 2ndmax of the given array are "+ max + " and "+max2nd+".");
		// Your method should return 100 and -1

                int[] givenarray3 = {5, 1};	
		// Test your method
		pair = dcfindmax2ndmax(givenarray3, 0, givenarray3.length-1);
		max2nd = pair.max2nd;
		max = pair.max;

		System.out.println("The max and 2ndmax of the given array are "+ max + " and "+max2nd+".");
		// Your method should return 5 and 1
	
	}
	
	
}