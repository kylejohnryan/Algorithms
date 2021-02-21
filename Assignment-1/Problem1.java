// This Code is Authored by: Kyle Ryan
// 21 February 2021
// CMPT435-620 Algorithms Design and Analysis

public class Problem1 {

	public static char findCM(char[] A)
	{
		/*
		Given an array A[], return the element in A[] that occurs the most number of consecutive times.
		If multiple elements appear consecutively the maximum number of times, you should return the element whose sequence comes first in the array. 
		If the array is Empty or Null, return an empty string ("").
		*/
		
		/*
		Input : A[]
		A[]   : Characters, with Duplicates
		Output: Character Repeated the Most Consecutively First, or Empty String if Array is Empty/Null
		*/
		

		char maxChar = Character.MIN_VALUE;
		char currentChar = Character.MIN_VALUE;
		int maxCharCount = 0;
		int charCount = 0;

		// For Loop Executes for All Values of A[]
		for (int i = 0; i < A.length; i++) {
			// If the Character Doesn't Change, Continue the Count
			if (A[i] == currentChar) {
				charCount++;
			}
			// If the Chracter Changes, Reset the Count and Current Character
			if (A[i] != currentChar) {
				currentChar = A[i];
				charCount = 1;
			}
			// If the Current Count Excedes the Max Count, Make that Character and Value the New Max
			if (charCount > maxCharCount){
				maxCharCount = charCount;
				maxChar = currentChar;
			}
		}
		// Returns the Character that Appeared the Most
		return maxChar;

	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		char[] A = {'g','g','h','d','d','d','e','e','a','b','c','g','g'};
				
		System.out.println("The Element That Occurs the Most Number of Consecutive Times for A: " + findCM(A));
		
		// Expected Output: d
		

		char[] B = {'m','a','r','i','s','t'};
		
		System.out.println("The Element That Occurs the Most Number of Consecutive Times for B: " + findCM(B));
		
		// Expected Output: m
		

		char[] C = {};
		
		System.out.println("The Element That Occurs the Most Number of Consecutive Times for C: " + findCM(C));
		
		// Expected Output: 

		
		char[] D = {'a','c','c','c','b','b','b','c','c','c','c'};
		
		System.out.println("The Element That Occurs the Most Number of Consecutive Times for D: " + findCM(D));

		// Expected Output: c

	}

}
