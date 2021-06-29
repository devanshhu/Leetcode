
/*
-----------------------------------------------PROBLEM------------------------------
Given an array, rotate the array by one position in clock-wise direction.
    
Input:   [1 2 3 4 5]
Output : [5 1 2 3 4] 
------------------------------------------------------------------------------------
-----------------------------------------------SOLUTION----------------------------
The solution could be extended to any K. here K = 1;
There are multiple solutions -
    1. Store last element in a variable. Iterate K times & move every element one step ahead. In the end of each iteration place the last element at the first position
    2. A 3 step intuitive solution
        a. Reverse the whole Array once
        b. Reverse the first k elements
        c. Reverse the rest of the elements.

--------------------------------------------------------------------------------------
*/

class Solution {
    
    public void rotate(long arr[], long n)
    {
        reverse(arr,0,n);
        // System.out.println(Arrays.toString(arr));
        reverse(arr, 1, n+1);
    }
    public static void reverse(long[] arr, long start, long end){    
      for(long i=start;i<(int)(end)/2;i++){
        //   System.out.println("Swapping " + arr[(int)i] + " , "+ arr[(int)(end-i-1)]);
            long tmp = arr[(int)i];
            arr[(int)i] = arr[(int)(end-i-1)];
            arr[(int)(end-i-1)] = tmp;
        }
    }
}