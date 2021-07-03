/*
-----------------------PROBLEM--------------------------------
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
If target is not found in the array, return [-1, -1].
You must write an algorithm with O(log n) runtime complexity.

Example 1:

	Input: nums = [5,7,7,8,8,10], target = 8
	Output: [3,4]

Example 2:

	Input: nums = [5,7,7,8,8,10], target = 6
	Output: [-1,-1]

Example 3:

	Input: nums = [], target = 0
	Output: [-1,-1]

----------------------SOLUTION---------------------------------
Use extended binary search. We are using binary search to find the target element & then expand our left & right pointers.
---------------------------------------------------------------
*/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return new int[]{-1,-1};
        int left = 0, right = nums.length - 1 ;
        int mid = left + (right- left)/2;
        // The logic is same for peak finding, finding pivot in rotated sorted array & finding element in a sorted array using binary search.
        while(left < right){
            mid = left + (right- left)/2;
            // basic binary search logic to check if our current element is smaller than target then search in the right subarray
            if(nums[mid] < target)
                left = mid+1;
            else 
                right = mid;
        }
        // At the end the right & left element will point to the same index. So u can either use right || left here.
        if( nums[left] != target)
            return new int[]{-1,-1};
        // point to our current element & expand using 2 pointers in both the direction to find the range.
        while(left >= 0 && nums[left] == target)
            left--;
        while(right < nums.length && nums[right] == target)
            right++;
        return new int[]{left+1, right-1};
    }
}    
