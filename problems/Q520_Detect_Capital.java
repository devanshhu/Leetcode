
/*
----------------------------------------------------PROBLEM---------------------------------------
We define the usage of capitals in a word to be right when one of the following cases holds:

All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital, like "Google".
Given a string word, return true if the usage of capitals in it is right.

Example 1:

    Input: word = "USA"
    Output: true

Example 2:

    Input: word = "FlaG"
    Output: false

---------------------------------------------------------------------------------------------------
---------------------------------SOLUTION----------------------------------------------------------
The solution is quite simple. Count the number of capital letters in the word.
There could be only three scenarios where we need to return true:
    1. There are no capital letters. ( x == 0)
    2. All letters are capital. Here count of capital letters would be same as the length of string ( x == word.length() )
    3. First letter is capital. We just need to check for x == 1 & first character is uppercase !

    That's it !! 

---------------------------------------------------------------------------------------------------

class Solution {
    public boolean detectCapitalUse(String word) {
        int x = 0;
        for(char c : word.toCharArray()){
            if(Character.isUpperCase(c)) x++;
        }
        return x == word.length() || x == 0 || ( x == 1 && Character.isUpperCase(word.charAt(0)) );
    }
}