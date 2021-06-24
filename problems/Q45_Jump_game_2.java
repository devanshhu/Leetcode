/*
---------------------------------------PROBLEM--------------------------------
Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
Each element in the array represents your maximum jump length at that position.
Your goal is to reach the last index in the minimum number of jumps.
You can assume that you can always reach the last index.

Example 1:

	Input: nums = [2,3,1,1,4]
	Output: 2
	Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:

	Input: nums = [2,3,0,1,4]
	Output: 2

-------------------------------------------------------------------------------
------------------------------SOLUTION-----------------------------------------
The idea is to keep track of max reach we can get to for every index.
	for every element check:
		find max of current reach(des) & (current index + nums[i]) & assign to des. Thus for last index traversed, we will have max reach in des
		if pos == i that means we have exhausted our reach & we need to jump. give pos the value of des for longest react & jump++    

	return jump;

-------------------------------------------------------------------------------

*/

class Solution {
    public int jump(int[] nums) {
        int pos=0, des=0, jump =0;
        for(int i=0;i< nums.length - 1;i++){
            des = Math.max(des, i + nums[i]);
            if(pos == i){
                pos = des;
                jump++;
             
            }
        }
        return jump;
	}
}