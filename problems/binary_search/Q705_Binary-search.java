/*
-----------------------PROBLEM--------------------------------

Implement binary search to search for an element in an array. If element is not found, return -1;

---------------------------------------------------------------

----------------------SOLUTION---------------------------------

Use binary search algo, which divides the space in half in every iteration. 
NOTE : Left should be assigned to mid+1 & right to mid. Trick to remember, the right bound is usually excluded, so if we are doing right = mid, we essentially are doing a decrement to current mid. & with left we are already doing mid+1. Hence the solution will always conclude at some point.

---------------------------------------------------------------
*/
class Solution {
    public int search(int[] nums, int target) {
        int left =0, right = nums.length;
        while(left < right ){
            int mid = (left + right)/ 2;
            
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] < target)
                left = mid+1;
            else 
                right = mid;
        }
        return -1;
    }
}