
public class Problem1 {

    public static MinMax findmaxdiff (int[] A, int minDiff, int maxDiff) {

        // Complete the method to find the maximum difference between points in A[]
		// so that the larger value appears after the smaller value in A[]
		// feel free to change the return type, parameters
		// Full credit (30 points) will be awarded for a divide-and-conquer algorithm that is O(n). 
		// Algorithms that are NOT divide-and-conquer or slower than O(n) will be scored out of 5 points.

        MinMax lSplit, rSplit, diffTemp = new MinMax();
        int mid = (minDiff + maxDiff) / 2;

        if (maxDiff != (minDiff + 1)) {
            if (maxDiff == minDiff) {
                diffTemp.diffNum = 0;
                diffTemp.minNum = A[minDiff];
                diffTemp.MaxNum = A[minDiff];
                return diffTemp;
            }
            
            lSplit = findmaxdiff(A, minDiff, mid);
            rSplit = findmaxdiff(A, mid + 1, maxDiff);

            diffTemp.MaxNum = rSplit.MaxNum;
            diffTemp.minNum = lSplit.minNum;
            diffTemp.diffNum = diffTemp.MaxNum - diffTemp.minNum;

            if (lSplit.diffNum <= diffTemp.diffNum) {
                if (rSplit.diffNum > diffTemp.diffNum) {
                    diffTemp.diffNum = rSplit.diffNum;
                }
            } 
            else {
                diffTemp.diffNum = Math.max(lSplit.diffNum, rSplit.diffNum);
            }

            diffTemp.MaxNum = Math.max(rSplit.MaxNum, lSplit.MaxNum);
            diffTemp.minNum = Math.min(rSplit.minNum, lSplit.minNum);

            return diffTemp;
        } 
        else {
            if (A[minDiff] >= A[maxDiff]) {
                diffTemp.diffNum = 0;
                diffTemp.MaxNum = A[minDiff];
                diffTemp.minNum = A[maxDiff];

            } 
            else {
                diffTemp.diffNum = A[maxDiff] - A[minDiff];
                diffTemp.MaxNum = A[maxDiff];
                diffTemp.minNum = A[minDiff];
            }
            return diffTemp;
        }
    }


    public static void main(String[] args) {

        MinMax distance;

        int[] testarray1 = {2, 3, 10, 6, 4, 8, 1};
        distance = findmaxdiff(testarray1, 0, testarray1.length-1);
        System.out.println("The Distance Between the Max and Min is: " + distance.diffNum);
        // Expected Difference: 8

        int[] testarray2 = {7, 9, 1, 6, 3, 2};
        distance = findmaxdiff(testarray2, 0, testarray2.length-1);
        System.out.println("The Distance Between the Max and Min is: " + distance.diffNum);
        // Expected Difference: 5

        int[] testarray3 = {4, 5};
        distance = findmaxdiff(testarray3, 0, testarray3.length-1);
        System.out.println("The Distance Between the Max and Min is: " + distance.diffNum);
        // Expected Difference: 1

        int[] testarray4 = {9};
        distance = findmaxdiff(testarray4, 0, testarray4.length-1);
        System.out.println("The Distance Between the Max and Min is: " + distance.diffNum);
        // Expected Difference: 0

        int[] testarray5 = {-5, -4};
        distance = findmaxdiff(testarray5, 0, testarray5.length-1);
        System.out.println("The Distance Between the Max and Min is: " + distance.diffNum);
        // Expected Difference: 1

    }
}