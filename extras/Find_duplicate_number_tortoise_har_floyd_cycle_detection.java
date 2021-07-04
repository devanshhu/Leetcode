/*
------------------------------------PROBLEM------------------------------
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
There is only one repeated number in nums, return this repeated number.
You must solve the problem without modifying the array nums and uses only constant extra space.

 

Example 1:

	Input: nums = [1,3,4,2,2]
	Output: 2

Example 2:

	Input: nums = [3,1,3,4,2]
	Output: 3

Example 3:

	Input: nums = [1,1]
	Output: 1

Example 4:

	Input: nums = [1,1,2]
	Output: 1
 

Constraints:

	1 <= n <= 105
	nums.length == n + 1
	1 <= nums[i] <= n
	All the integers in nums appear only once except for precisely one integer which appears two or more times.
-------------------------------------------------------------------------------
----------------------------------SOLUTION-------------------------------------
 There could be 4 diff solutions:
 	1. If we can use extra O(n) space, use Set. When a collision occurs, return the number.
 	2. If we can modify the current array:
 		i) sort the array & iteratively check neighbors. If found same, return the element.
 		ii) Second approach uses a bit of exceptional recursion. For ex. if u have this array
 			[  3, 4, 5, 2, 4, 1].
 				Starting from index[0].We encountered 3. We will go to 3 & multiply it by -1. Then we go to index[ num[3] ] & multiply it by -1.
 				recursively do that until you find a negative element, upon multiplying which to -1, u get a positive ans. return this no.

 	3.if the array is IMMUTABLE:
 		We can use the tortoise & hare algo( Floyds cycle detection algorithm), which is used to detect cycle in a graphs.
		WHY CYCLE DETECTION ?
			here we are using indeices & their values. Since we know there is a duplicate element, we know there will be a node to which 2 diff nodes will point.
			hence we can use cycle detection. Now we dont know which is the node where cycle starts. This algo at the end gives the node at which the cycle will start.
			Which is gonna be our answer.
 		
		ALGO:
	 		-> Take 2 pointers, fast & slow.
	 		-> Fast runs at twice the speed of slow ptr. When they both meet. Stop the first loop.
			-> place the fast pointer to the start & then increment both pointer by 1 until they are equal. 
			-> When they are equal they are pointing to a single node. Which is our answer. return either fast or slow ptr.
--------------------------------------------------------------------------------
*/


class Solution{
	public int findDuplicate(int[] nums){
		int slow= nums[0];
		int fast = nums[0];

		// using do while bcz it will make us iterate atleast once.
		do{
			slow = nums[slow];
			fast = nums[nums[fast]];
		}while(fast != slow);

		// Now we are inside the cycle. to find the start node of cycle, place fast pointer to start & increment both fast & slow until they meet.

		fast = nums[0];
		while(slow != fast){
			slow = nums[slow];
			fast = nums[fast];
		}
		return fast; // or u can return slow. They both are pointing to the same node.
	}
}