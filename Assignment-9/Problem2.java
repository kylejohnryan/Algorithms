import java.util.*;

public class Problem2 {

	public static int partition(int[] A, int s, int e)
	{
		// Partition(A, s, e) selects the leftmost element A[s] as the pivot
		// Modify the function so that it chooses the pivot as the median of three elements randomly selected from the array.
		// Output the three elements randomly selected
		// Output the pivot finally selected

		List<Integer> RandomElementList = new ArrayList<>();
		int selectedPivot = 0;
        int k = 0;

		while (k < 3) {
			Random ran = new Random();
			int randomNumber = ran.nextInt(A.length);

			int randomArrayElement = A[randomNumber];
            RandomElementList.add(randomArrayElement);
			k++;
		}
		selectedPivot = (GetMedianElement(RandomElementList));

		System.out.println("Here are the Random Elements: " + RandomElementList);
		System.out.println("Here is the Pivot Selected: " + selectedPivot);

		int pivot = A[selectedPivot]; 
		int i = s + 1; 
		int j = e;

		while(i <= j) {	
			while(i < e && A[i] < pivot) 
				i = i + 1;
		
			while(j > s && A[j] >= pivot) 
				j = j - 1;
			
			if (i >= j) 
				break;
			swap(A, i, j);	
		}
		swap(A, s, j);
		return j;
	}
	
	public static void swap(int A[], int i, int j)
	{
		int temp = A[i];
		A[i]  = A[j];
		A[j] = temp;
	}

	public static int GetMedianElement(List<Integer> RandomElementList)
    {
        Collections.sort(RandomElementList);
        int size = RandomElementList.size();
        int middle = size / 2;
        if ((size % 2) == 0) {
            return (RandomElementList.get(middle - 1) + RandomElementList.get(middle))/2;
        }
        else {
            return RandomElementList.get(middle);
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method
		int[] testarray = { 1, 2, 2, 2, 6, 1, 7, 0, -5, 2, 8, 1, 3, 1, 1 };
		// Test your method
		//int p = partition(testarray, 0, testarray.length - 1 );
		partition(testarray, 0, testarray.length - 1 );
		System.out.println(Arrays.toString(testarray));

		int[] testarray2 = {-5, -4, 0, 1, 2, 3, 4, 5};
		// Test your method
		//int p = partition(testarray, 0, testarray.length - 1 );
		partition(testarray2, 0, testarray2.length - 1 );
		System.out.println(Arrays.toString(testarray2));
	}
}