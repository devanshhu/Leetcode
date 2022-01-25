/*
----------------------------------------------------PROBLEM---------------------------------------

Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
A subarray is a contiguous part of an array.

Example 1:

    Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
    Output: 6
    Explanation: [4,-1,2,1] has the largest sum = 6.

Example 2:

    Input: nums = [1]
    Output: 1

Example 3:

    Input: nums = [5,4,-1,7,8]
    Output: 23

---------------------------------------------------------------------------------------------------
---------------------------------SOLUTION----------------------------------------------------------

KADANE's Algorithm:
    2 steps only:
        1. for every element check if adding the current element creates a bigger element.
        2. If current sum is greater than globalSum => globalSum = currentSum ( localMax in our code )
---------------------------------------------------------------------------------------------------
*/
class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 0)
            return 0;
        int i=1, localMax = nums[0] , globalMax= nums[0];
        while(i < nums.length){
            localMax = Math.max(nums[i], localMax+nums[i]);
            globalMax = Math.max(localMax, globalMax);
                i++;                
        }
        return globalMax;
    }
}