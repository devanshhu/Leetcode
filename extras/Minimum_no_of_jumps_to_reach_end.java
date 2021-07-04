/*
------------------------------------PROBLEM------------------------------
Given an array of N integers arr[] where each element represents the max number of steps that can be made forward from that element. 
Find the minimum number of jumps to reach the end of the array (starting from the first element).
 If an element is 0, then you cannot move through that element.
Note: Return -1 if you can't reach the end of the array.


Example 1:

	Input:
	N = 11 
	arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9} 
	Output: 3 
	Explanation: 
	First jump from 1st element to 2nd 
	element with value 3. Now, from here 
	we jump to 5th element with value 9, 
	and from here we will jump to last. 

Example 2:

	Input :
	N = 6
	arr = {1, 4, 3, 2, 6, 7}
	Output: 2 
	Explanation: 
	First we jump from the 1st to 2nd element 
	and then jump to the last element.
-------------------------------------------------------------------------------
----------------------------------SOLUTION-------------------------------------
The idea is to use 3 variables --> 
	maxReachable - keeps track of the maxReachable position from our current index, initialized to arr[0].
	step - represents the no. of steps we can take  from current index, initialized to arr[0].
	jump - keeps track of the no. of jumps, initialized with 1, since we need atleast 1 jump to reach the end.

	ALGO:
		for each element from 2nd to last element :
			if we have reached the last element return jump;
			decrease step count
			calculate maxReachable, if greater than current & (i + arr[i]) update to the max value.
			if step becomes 0: 
				we had to take a jump, jump++;
				if maxReach <= i , then we cannot go beyond our current element.( We are at i rn & we cannot go any further because maxReach <= i)
				reassign step to maxReach - i. this is the number of steps I can go beyond my current position.
--------------------------------------------------------------------------------
*/
class Solution{
    static int minJumps(int[] arr){
    	int n =arr.length;
    	int step = arr[0], jump=1, maxReach = arr[0];

    	// For each element from second to last.
    	for(int i=1; i < n;i++){

    		// If we have reached the last element return the no. of jumps;
    		if(i == n-1)
    			return jump;

    		// decrease steps at every iteration
    		step--;

    		// If we can reach farther( arr[i] + i ) than update our current reach 
    		maxReach = Math.max(maxReach, arr[i]+i);

    		// If steps are 0, then we need to jump 
    		if(step == 0){
    			jump++;

    			// if maxreach <= i, we cannot go beyond this index, hence return -1;
    			if(maxReach <= i)
    				return -1;
    			
    			// update steps to maxReach - current Index. i.e. the no. of steps I can take to reach maxReach position.
    			step = maxReach-i;
    		}

    	}
		return -1;
	}
}