
public class Problem2 {
	
	public static void intersection(int[] s1, int[] s2)
	{
		// Complete the intersection() method to output
		// elements that occur in both s1 and s2
		// feel free to change method type and parameters
		// Full credit will awarded to algorithms O(n) and in-place
		
		int i = 0;
		int j = 0;
		int previous = i - 1;

		while (i < s1.length && j < s2.length) {
			if (s1[i] == s2[j] && s2[j] != previous) {
				System.out.println(s1[i]);
				previous = s1[i];
				i++;
				j++;
			}
			else if (s1[i] < s2[j]) 
				i++;
			else
				j++;
		}
	}
				
		public static void union(int[] s1, int[] s2)
	{
		// Complete the union() method to output
		// the union s1 and s2
		// feel free to change method type and parameters
		// Full credit will awarded to algorithms O(n) and in-place

		int i = 0;
		int j = 0;
		int previous = i - 1;

        while (i < s1.length && j < s2.length) {
            if (s1[i] < s2[j]) {
                if(s1[i] != previous) {
                    System.out.println(s1[i]);
                    previous = s1[i];
                }
                i++;
            }
            else if (s2[j] < s2[i]) {
                if (s2[j] != previous) {
                    System.out.println(s2[j]);
                    previous = s2[j];
                }
                j++;
            }
            else {
                if(s2[j] != previous) {
                    System.out.println(s2[j]);
                    previous = s2[j];
                }
                j++;
            }
        }
		
		if (i < s1.length && s1[i] != previous) {
			System.out.println(s1[i]);
			previous = s1[i];
			i++;
		}
		if (j < s2.length && s2[j] != previous) {
			System.out.println(s2[j]);
			previous = s2[j];
			j++;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Test your intersection() method here
		int[] testarray1 = {0, 0, 0, 1, 2, 3, 97, 98};
		int[] testarray2 = {0, 1, 2, 3, 4, 4, 10, 98, 100, 100};

		
		System.out.println("intersection of testarray1 and testarray2: ");
		intersection(testarray1,testarray2);
		//should output 0, 1, 2, 3, 98
		System.out.println("union of testarray1 and testarray2: ");
		union(testarray1,testarray2);
		//should output 0, 1, 2, 3, 4, 10, 97, 98, 100

		
		int[] testarray3 = {-5, 0, 5};
		int[] testarray4 = {0, 1, 5};

		System.out.println("intersection of testarray1 and testarray2: ");
		intersection(testarray3,testarray4);
		//should output 0, 5
		System.out.println("union of testarray1 and testarray2: ");
		union(testarray3,testarray4);
		//should output -5, 0, 1, 5
		
	}

}
