
/*
-----------------------------------------------PROBLEM------------------------------
https://practice.geeksforgeeks.org/problems/kadanes-algorithm-1587115620

Write an efficient program to find the sum of contiguous subarray within a one-dimensional array of numbers that has the largest sum. This problem is also known as KADANE's Algorithm.

Example 1:

	Input:
		N = 5
		arr[] = {1,2,3,-2,5}
	Output:
		9
	Explanation:
		Max subarray sum is 9 of elements (1, 2, 3, -2, 5) which is a contiguous subarray.

Example 2:

	Input:
		N = 4
		arr[] = {-1,-2,-3,-4}
	Output:
		-1
	Explanation:
		Max subarray sum is -1 of element (-1)
-------------------------------------------------------------------------------------
----------------------------------------------SOLUTION-------------------------------
The most efficient solution is: at every iteration check which one is larger -> the current element or localMaxima + current element.
Whichever is larger becomes the next localMaxima. At every point also compare globalMaxima && localMaxima. Whichever is larger, store it in globalMaxima
At the end return globalMaxima;
-------------------------------------------------------------------------------------
*/

class Solution{

    int maxSubarraySum(int arr[], int n){
    
        if(n < 1)
        	return 0;
        int localMaxima = arr[0];
        int globalMaxima  = arr[0];
        for(int i = 1; i < arr.length; i++){
            localMaxima = Math.max(arr[i], localMaxima + arr[i]);
            globalMaxima = Math.max(localMaxima, globalMaxima);
        }
        return maxSum;
    }
}