/*
----------------------------------------------------PROBLEM---------------------------------------

Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

Example 1:

    Input: s = "leetcode"
    Output: 0

Example 2:

    Input: s = "loveleetcode"
    Output: 2

Example 3:

    Input: s = "aabb"
    Output: -1

---------------------------------------------------------------------------------------------------
---------------------------------SOLUTION----------------------------------------------------------

 2 Solutions:
    1. Use a hashmap & keep a character count. Then check from the 0th index, the first element having count = 1 would be the answer.
    2. Keep an array of 26 characters. Which would use the same functionality as of a hashmap. The algo is same but lookup would be fast which makes it an optimized method.

---------------------------------------------------------------------------------------------------
*/


// Method 1 
class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> hs = new HashMap<>();
        for(char x: s.toCharArray()){
            hs.merge(x,1, (k,v) -> v+1);
        }
        int i=0;
        for(char x : s.toCharArray()){
            if(hs.get(x) <= 1) return i;
            i++;
        }
        return -1;
    }
}

// Method 2 : Optimised 
class Solution {
    public int firstUniqChar(String s) {
        // HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int[] arr =new int[26];
        for(char x: s.toCharArray()){
            arr[x-'a']++;
        }
        int i=0;
        for(char x:s.toCharArray()){
            if(arr[x-'a'] == 1)
                return i;
            i++;
        }                         
            return -1;
    }
}