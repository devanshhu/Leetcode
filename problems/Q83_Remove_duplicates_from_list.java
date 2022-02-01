
/*
----------------------------------------------------PROBLEM---------------------------------------

Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.

 

Example 1:
	Input: head = [1,1,2]
	Output: [1,2]

Example 2:
	Input: head = [1,1,2,3,3]
	Output: [1,2,3]


 
---------------------------------------------------------------------------------------------------
---------------------------------SOLUTION----------------------------------------------------------


---------------------------------------------------------------------------------------------------
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head, prev = head;
        while(curr != null){
            while(curr != null && curr.val == prev.val)
                curr = curr.next;
            prev.next = curr;
            prev = curr;
        }
        return head;
    }
}