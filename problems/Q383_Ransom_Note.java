/*
----------------------------------------------------PROBLEM---------------------------------------

Given two strings ransomNote and magazine, return true if ransomNote can be constructed from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.

 

Example 1:

    Input: ransomNote = "a", magazine = "b"
    Output: false

Example 2:

    Input: ransomNote = "aa", magazine = "ab"
    Output: false

Example 3:

    Input: ransomNote = "aa", magazine = "aab"
    Output: true
 
---------------------------------------------------------------------------------------------------
---------------------------------SOLUTION----------------------------------------------------------

 Since we need to create ransomNote from magazine, we only need to check if the occurence of any letter in magazine is less than that of in ransomNote.
---------------------------------------------------------------------------------------------------
*/

class Solution {
    public boolean canConstruct(String ransomNot, String magazin) {
        int r[] = new int[26];
        int m[] = new int[26];
        char[] ransomNote= ransomNot.toCharArray();
        char[] magazine = magazin.toCharArray();
        int i=0;
        for(i=0;i<26;i++){
            r[i]=0;
            m[i]=0;
        }
        for(i=0;i< ransomNote.length;i++)
            r[ransomNote[i]-'a']++;
        for(i=0;i<magazine.length;i++)
            m[magazine[i]-'a']++;
        for(i=0;i<26;i++){
            if(r[i] > m[i])
                return false;
        }
        return true;
    }
}