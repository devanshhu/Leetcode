
/*
----------------------------------------------------PROBLEM---------------------------------------
You are given an integer array nums. You want to maximize the number of points you get by performing the following operation any number of times:

Pick any nums[i] and delete it to earn nums[i] points. Afterwards, you must delete every element equal to nums[i] - 1 and every element equal to nums[i] + 1.
Return the maximum number of points you can earn by applying the above operation some number of times.

 

Example 1:

Input: nums = [3,4,2]
Output: 6
Explanation: You can perform the following operations:
- Delete 4 to earn 4 points. Consequently, 3 is also deleted. nums = [2].
- Delete 2 to earn 2 points. nums = [].
You earn a total of 6 points.
Example 2:

Input: nums = [2,2,3,3,3,4]
Output: 9
Explanation: You can perform the following operations:
- Delete a 3 to earn 3 points. All 2's and 4's are also deleted. nums = [3,3].
- Delete a 3 again to earn 3 points. nums = [3].
- Delete a 3 once more to earn 3 points. nums = [].
You earn a total of 9 points.

---------------------------------------------------------------------------------------------------
---------------------------------SOLUTION----------------------------------------------------------
DP : 
	Bottom-UP :  we can either take a number or not. If we dont take the number we calculate the gain from next number
				If we take the number we take the gain from the current number & then from the 2nd element from current position.
				
---------------------------------------------------------------------------------------------------

*/

class Solution {

    HashMap<Integer, Integer> map;
    int points;
    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        this.points = 0;
        int max = Integer.MIN_VALUE;
        this.map = new HashMap<>();
        for(int i=0;i< nums.length;i++){
            this.map.put(nums[i], this.map.getOrDefault(nums[i], 0) + nums[i] );
            max = Math.max(max, nums[i]);
        }
        
        int[] total = new int[max + 1];
        total[1] = this.map.getOrDefault(1,0);
        
        for(int num = 2; num < total.length; num++){
            int gain = this.map.getOrDefault(num, 0);
            total[num] = Math.max( total[num-1], total[num-2]+gain);
        }
        
        return total[max];
        
        
    }
  
}