
/*
-----------------------PROBLEM--------------------------------
You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.

---------------------------------------------------------------

----------------------SOLUTION---------------------------------
Simply use Binary search.	
---------------------------------------------------------------
*/

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        if (n == 0)
            return 0;
        if(n == 1)
            return 1;
        if(n == 2)
            return isBadVersion(2) && !isBadVersion(1) ? 2: 1;
        int mid = n/2, beg = 1 , last = n;
        while(beg < last){
            mid = beg + (last - beg)/2;
            // if our current version is bad, then it implies previous versions are also bad, hence the ans lies left of the current element.
            if(isBadVersion(mid)){
                last = mid;
            }else{
                beg = mid+1;
            }
        }
        return beg;
    }
}