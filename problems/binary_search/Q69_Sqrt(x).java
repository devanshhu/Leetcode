
/*
-----------------------PROBLEM--------------------------------
Given a non-negative integer x, compute and return the square root of x.
Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.
Note: You are not allowed to use any built-in exponent function or operator, such as pow(x, 0.5) or x ** 0.5.

Example 1:
        Input: x = 4
        Output: 2

Example 2:
    Input: x = 8
    Output: 2
    Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.
---------------------------------------------------------------

----------------------SOLUTION---------------------------------
Using binary search we can solve this problem by trying all numbers from 1 to x/2. 

---------------------------------------------------------------
*/

class Solution {
    public int mySqrt(int x) {
        if(x < 2)
            return x;
        // take numbers from 1 to (x/2).
        long sqr,left =1, right = x >> 1;
        while(left < right ){
            // Please note that we are dividing (right - left ) & not the whole expression.
            long mid =( left + (right - left)/2) ;
            sqr = mid * mid;
            if(sqr == (long)x)
                return (int)mid;
            else if(sqr < x )
                left = mid+1;
            else right = mid-1;
        }
        // We are here that implies the number is not a perfect square root. 
            sqr = left * left ;
        // hence we will check if current left's square is smaller than x then we return left, else we return left -1.
        // ex. for x= 8, we will get left = 2 at this step. We will check if we are not exceeding x we return current number, else return left -1 
            return (int)(sqr <= (long)(x) ? left : left-1);
    }
}

