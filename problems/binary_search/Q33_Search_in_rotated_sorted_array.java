
/*
-----------------------PROBLEM--------------------------------
There is an integer array nums sorted in ascending order (with distinct values).
Prior to being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
Given the array nums after the rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
You must write an algorithm with O(log n) runtime complexity.

 

Example 1:
	Input: nums = [4,5,6,7,0,1,2], target = 0
	Output: 4

Example 2:
	Input: nums = [4,5,6,7,0,1,2], target = 3
	Output: -1

Example 3:
	Input: nums = [1], target = 0
	Output: -1
---------------------------------------------------------------

----------------------SOLUTION---------------------------------
There are 2 steps involved in finding the ans. 
	1. We first need to find the pivot, where our array is rotated.
	2. Then we we need to check if the element at our pivot is smaller than the last element, If it is our ans lies in the second half of the array. else we will go for the first half & apply binary search there. 
	
---------------------------------------------------------------
*/

class Solution {
	public int search(int[] nums, int target) {
		if(nums == null || nums.length == 0)
			return -1;
		int left = 0, right = nums.length-1;
        // Slight modification to find our pivot. 
		while(left < right){
			int mid = left + (right - left) / 2;
            // inserted this to fast fwd the process, just in case our target number is encountered. Not part of the real algo to find pivot position.
			if(nums[mid] == target)
				return mid;
            // At every iteration,check if [mid] is greater than [right], then our pivot position is at right of current  mid.
            // [4,5,6,7,0,1,2]
            //  ^     ^     ^
            //  |     |     |
            //  l     m     r
			if(nums[mid] > nums[right]){
				left = mid+1;
			}
            // If [mid] is smaller than [right], then our pivot element is at the left of current mid
			else{
				right = mid;
			} 
		}


		int start = left;
		left =0; right = nums.length-1;
        // Now we check if our current element is in the second half, for that we check if it is between start & right indices.
        //If yes we place left pointer at our start position i.e. pivot position.
		if(target >= nums[start] && target <= nums[right]){
			left = start;
		}else{
			right = start;
		}
        // Simply binary search between the left & right index & return the answer.
		return binarySearch(nums, left, right, target);
	}

	public int binarySearch(int nums[], int start, int end, int target){
		while(start <= end){
			int mid = start + (end - start) / 2;
			if(nums[mid] ==  target)
				return mid;
			else if(nums[mid] < target)
				start = mid+1;
			else
				end = mid-1;
		}
		return -1;
	}

}