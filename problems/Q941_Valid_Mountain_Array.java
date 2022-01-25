/*
----------------------------------------------------PROBLEM---------------------------------------

Given an array of integers arr, return true if and only if it is a valid mountain array.

Recall that arr is a mountain array if and only if:

arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]

Example 1:

	Input: arr = [2,1]
	Output: false

Example 2:

	Input: arr = [3,5,5]
	Output: false

Example 3:

	Input: arr = [0,3,2,1]
	Output: true

---------------------------------------------------------------------------------------------------
---------------------------------SOLUTION----------------------------------------------------------
	1. If array length is smaller than 3. It could never be a mountain array.
	2. Traverse the array while right element is greater. 
	3. If we are at the first or last element, The peak is at first or last element, return false.
	4. If the next element is equal to current element, return false as we need strictly increasing or decreasing array.
	5. Resume traverse while the right element is smaller than the current( decreasing sequence ). 
	6. The array is mountain only if we have reached the end of the array.  

---------------------------------------------------------------------------------------------------
class Solution {
    public boolean validMountainArray(int[] arr) {
	 // 1. If array length is smaller than 3. It could never be a mountain array. 
        if(arr.length <= 2)
            return false;
        int i=1;

	//2. Traverse the array while right element is greater. 
        while( i< arr.length && arr[i] - arr[i-1] > 0){
            i++;
        }

        //3. If we are at the first or last element, The peak is at first or last element, return false.
        if(i == 1 || i == arr.length)
            return false;

    //4. If the next element is equal to current element, return false as we need strictly increasing or decreasing array.
        if(i< arr.length && arr[i] - arr[i-1] == 0)
            return false;

    //5. Resume traverse while the right element is smaller than the current( decreasing sequence ). 
        while(i< arr.length && arr[i] - arr[i-1] < 0)
            i++;
            
	//6. The array is mountain only if we have reached the end of the array.  
        return i == arr.length;
            
    }
}