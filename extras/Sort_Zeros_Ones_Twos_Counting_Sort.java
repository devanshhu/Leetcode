/*
-----------------------------PROBLEM---------------------------------
https://practice.geeksforgeeks.org/problems/sort-an-array-of-0s-1s-and-2s4231
Given an array of size N containing only 0s, 1s, and 2s; sort the array in ascending order.

Input:  [0, 2, 1, 2, 0]
Output: [0, 0, 1, 2, 2] 
     
---------------------------------------------------------------------
----------------SOLUTION--------------------------------------------
The algorithm is called counting sort & it could be extended to any K, given it only contains element from a range [0 - K].
Count the frequency of elements in the array & then in next iteration place the elements in the original input array. If X occurs n times we should place X n times in the array.
--------------------------------------------------------------------
*/


class Solution
{
    public static void sort012(int a[], int n)
    {
        int[] count = new int[3];
        Arrays.fill(count,0);
        for(int x: a)
            count[x]++;
        int curr=0;
        // System.out.println(Arrays.toString(count));
        for(int i=0;i<3;i++){
            while(count[i]-- > 0 && curr < a.length){
                a[curr++] = i;
            }
        }
    }    
}
