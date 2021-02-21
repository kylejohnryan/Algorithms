// This Code is Authored by: Kyle Ryan
// 21 February 2021
// CMPT435-620 Algorithms Design and Analysis 

import java.util.Hashtable;

public class Problem2 {

	
	
	public static int missingnumber(int[] A, int B[])
	{
		/*
		There is an array A[] that consists of n integers and these integers are not in any particular order. There are no duplicates in A[]. There is another array B[] that contains the same set of elements as A[], but one element is missing.
		Output: Find the missing integer.
		Design an algorithm that solves this problem.
		*/
		
		/*
		Input: A[], B[]
		A[]: Consists of n Integers, No Particular Order
		B[]: Consists of n-1 Integers, No Particular Order
		Output: The Missing Integer of B[]
		*/

		// Complete this Method
		int val = ' ';

		// Creating a Hashtable and Inserting All Elements of B
		Hashtable<Integer, Integer> H = new Hashtable<Integer, Integer>(B.length);
		for (int i = 0; i < B.length; i++) {
			H.put(i, B[i]);
		}

		// For Loop Executes for All Values of A[]
		for (int i = 0; i < A.length; i++) {
			if (H.contains(A[i]) == false) {
				val = A[i];
			}
		}
		return val;
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Test your majority method
		
		int[] testarray1 = {5, 7, 10, 9, 23, 1, 13, 100};
		
		int[] testarray2 = {100, 7, 5, 13, 1, 9, 10};
		
		System.out.println("The missing number in testarray2 "+ missingnumber(testarray1, testarray2));
		// expected output: 23

		int[] testarray3 = {5, 7, 10, 9, -8, 1, 13, 100};
		
		int[] testarray4 = {100, 7, 5, 13, 1, 9, 10};
		
		System.out.println("The missing number in testarray2 "+ missingnumber(testarray3, testarray4));
		
	}

}
