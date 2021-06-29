/*
----------------------------------------PROBLEM---------------------
https://www.geeksforgeeks.org/move-negative-numbers-beginning-positive-end-constant-extra-space

You are given an Array & you have to move all the negative elements at the beginning & Positives at the end.
Here order of elements does NOT matter.

Input : [-1, 2, 3, 4, -3, -6, -9, -10, 100, -200]
Output: [-1, -200, -10, -9, -3, -6, 4, 3, 100, 2]
---------------------------------------------------------------------
--------------------------SOLUTION-----------------------------------
The idea is to use 2 pointer method. 
1. Using internal while loops -- > The left pointer stops at a positive value, right stops at a negative value & then swap. Do it while left < right
2. Using if else clause --> There could be diff conditions:
	a. arr[left] & arr[right] both are negative  -> increment left.
	b. arr[left] is negative & arr[right] is positive -> left++ & right-- ( Ideal case )
	c.arr[left] is positive & arr[right] is negative -> swap bcz they are not at their right place & left++ & right--.
	d. arr[left] is positive & arr[right] is positive -> decrement right.
---------------------------------------------------------------------
*/
import java.io.*;
import java.util.Arrays;
class Solution {
	public static void main (String[] args) {
		int[] arr = new int[]{-1,2,3,4,-3,-6,-9,-10,100,-200};
	    int n = arr.length;
	   System.out.println(moveAllNegativeElementsAtBeginning(arr, n));
	    
	}
	
	public static String moveAllNegativeElementsAtBeginning(int[] arr, int n){
	    int left =0, right = n-1;
	    while(left < right){
	        if(arr[left] < 0 && arr[right] < 0){
	            left++;
	        }else if(arr[left] < 0 && arr[right] > 0){
	            left++; right--;
	        }else if(arr[left] > 0 && arr[right] < 0){
	            int tmp = arr[left];
	            arr[left] = arr[right];
	            arr[right] = tmp;
	            left++; right--;
	        }else if(arr[left] > 0 && arr[right] > 0){
	            right--;
	        }
	        
	    }
	        return Arrays.toString(arr);
	   
	}
}