/*
----------------------------------------------------PROBLEM---------------------------------------

Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.

 

Example 1:

    Input: nums1 = [1,2,2,1], nums2 = [2,2]
    Output: [2,2]

Example 2:

    Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
    Output: [4,9]
    Explanation: [9,4] is also accepted.
---------------------------------------------------------------------------------------------------
---------------------------------SOLUTION----------------------------------------------------------

Sort the arrays
Take 2 pointers, one for each array. There could be 2 conditions :
 1. both pointers point to an element which has same number. Add this number to our list.
 2. One pointer points to smaller number. Increase the counter so that we move in hope of finding a bigger number which is equal to the pointer of second array.
    return the list.
---------------------------------------------------------------------------------------------------
*/
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0,j=0;
        ArrayList<Integer> al= new ArrayList<>();
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] == nums2[j]){
                al.add(nums1[i]); i++;j++;
            }else if(nums1[i] < nums2[j]){
                i++;
            }else{
                j++;
            }
        }
        return al.stream().mapToInt(l -> l).toArray();
    }
}
