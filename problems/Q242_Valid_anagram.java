
/*
----------------------------------------------------PROBLEM---------------------------------------

Given two strings s and t, return true if t is an anagram of s, and false otherwise.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Example 1:

    Input: s = "anagram", t = "nagaram"
    Output: true

Example 2:

    Input: s = "rat", t = "car"
    Output: false
 
---------------------------------------------------------------------------------------------------
---------------------------------SOLUTION----------------------------------------------------------
Simply check if both the strings contain same number of characters or not.
The easiest way is to keep this count in an array of length 26, which keeps count of every character. 

---------------------------------------------------------------------------------------------------
*/


class Solution {
    public boolean isAnagram(String s, String t) {
        int[] arr = new int[26];
        int[] arr2 = new int[26];

        Arrays.fill(arr,0);
        for(char x: s.toCharArray()){
            arr[x-'a']++;
        }
        for(char x: t.toCharArray()){
            arr2[x-'a']++;
        }
        for(int i=0;i< 26;i++)
            if(arr[i] != arr2[i])
                return false;
        return true;
    }
}