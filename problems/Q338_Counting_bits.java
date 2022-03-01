/*
----------------------------------------------------PROBLEM---------------------------------------

Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.

 

Example 1:

	Input: n = 2
	Output: [0,1,1]
Explanation:
	0 --> 0
	1 --> 1
	2 --> 10

Example 2:

	Input: n = 5
	Output: [0,1,1,2,1,2]
Explanation:
	0 --> 0
	1 --> 1
	2 --> 10
	3 --> 11
	4 --> 100
	5 --> 101
 
Constraints:

0 <= n <= 105
 
---------------------------------------------------------------------------------------------------
---------------------------------SOLUTION----------------------------------------------------------

---------------------------------------------------------------------------------------------------

*/

// On basis of nearest power of 2
class Solution {
    public int[] countBits(int n) {
        int[] arr = new int[n+1];
        arr[0]=0;
        if(n == 0)
            return arr;
        arr[1] =1;
        if(n==1)
            return arr;
        int pow=0;
        for(int i=1;i<n+1;i++){
          if((i & (i-1)) == 0){
              arr[i]=1;
              pow = i;
          }else{
              arr[i]=arr[i-pow] + arr[pow];
          }
        }
        return arr;
    }
}

// On the basis of odd even

class Solution {
    public int[] countBits(int num) {
        int[] arr = new int[num+1];
        if(num == 0)
            return new int[]{0};
        arr[0] = 0; arr[1] = 1;
        if(num == 1){
            return arr;
        }
        arr[2] = 1;
        if(num == 2){
            return arr;
        }
        for(int i=3;i< num+1;i++){
            if( i % 2  == 0)
                arr[i] = arr[i/2];
            else
                arr[i] = arr[i/2] +1 ;
        }   
        return arr;
    }
}