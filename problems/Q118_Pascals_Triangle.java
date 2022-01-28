/*
----------------------------------------------------PROBLEM---------------------------------------
Given an integer numRows, return the first numRows of Pascal's triangle.
In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

Example 1:

    Input: numRows = 5
    Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

Example 2:

    Input: numRows = 1
    Output: [[1]]
---------------------------------------------------------------------------------------------------
---------------------------------SOLUTION----------------------------------------------------------

    Keep reference for the previous row alive & iterate for every row.
---------------------------------------------------------------------------------------------------
*/

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<Integer> row = new ArrayList<Integer>();
        row.add(1);
        List<List<Integer>> res = new ArrayList<>();
        res.add(row);
        if(numRows == 1)
            return res;
        row = new ArrayList<>();
        row.add(1);
        row.add(1);
        res.add(row);
        if(numRows == 2)
            return res;
        int j=0;
        List<Integer> prev = row;
        for(int i=3;i<=numRows;i++){
            row = new ArrayList<>();
            row.add(1);
            j=0;
            while(j < prev.size()-1){
                row.add(prev.get(j) + prev.get(j+1));
                j++;
            }
            row.add(1);
            res.add(row);
            prev = row;
        }
        return res;
    }
}