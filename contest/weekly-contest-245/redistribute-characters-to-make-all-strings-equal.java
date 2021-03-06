/*
https://leetcode.com/contest/weekly-contest-245/problems/redistribute-characters-to-make-all-strings-equal/

--------------------PROBLEM------------------------------------------------------------------------
You are given an array of strings words (0-indexed).
In one operation, pick two distinct indices i and j, where words[i] is a non-empty string, and move any character from words[i] to any position in words[j].
Return true if you can make every string in words equal using any number of operations, and false otherwise.


Example 1:
    Input: words = ["abc","aabc","bc"]
    Output: true
    Explanation: Move the first 'a' in words[1] to the front of words[2],
    to make words[1] = "abc" and words[2] = "abc".
    All the strings are now equal to "abc", so return true.


Example 2:
    Input: words = ["ab","a"]
    Output: false
    Explanation: It is impossible to make all the strings equal using the operation.

---------------------------------------------------------------------------------------------------
*/
/*
--------------------------------Solution-------------------------------
The idea is to count the occurence of all the characters in the array. If all of them are divisible by array.length then it is guaranteed that after X operations we can make the strings equal. 
-----------------------------------------------------------------------
*/
class Solution {
    public boolean makeEqual(String[] words) {
        // Array to keep track of every character 
        int[] count = new int[26];
        for(String x: words){
            char[] arr = x.toCharArray();
            for(char y : arr)
                count[y-'a']++;
        }
        for(int i=0;i<26;i++)
        // If any character has its count not divisible by arr.length then we can't make all the string equal bcz there will be atleast 1 word which wont contain our current character.
            if(count[i]%words.length != 0)
                return false;
        return true;
    }
}