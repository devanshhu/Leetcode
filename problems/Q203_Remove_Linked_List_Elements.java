
/*
----------------------------------------------------PROBLEM---------------------------------------
Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.

 

Example 1:


    Input: head = [1,2,6,3,4,5,6], val = 6
    Output: [1,2,3,4,5]

Example 2:

    Input: head = [], val = 1
    Output: []

Example 3:

    Input: head = [7,7,7,7], val = 7
    Output: []
 
---------------------------------------------------------------------------------------------------
---------------------------------SOLUTION----------------------------------------------------------


---------------------------------------------------------------------------------------------------
*/


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
    public ListNode removeElements(ListNode head, int val) {
      if(head == null || ( head != null && head.next == null && head.val == val) )
          return null;
        ListNode prev = head;
        ListNode curr = head.next;
        while(curr != null){
            if(curr.val == val){
                prev.next = curr.next;
                curr = curr.next;
            }else{
            prev = curr;
            curr = curr.next;
            }
        }
        while(head != null && head.val == val)
            head = head.next;
        return head;
    }
}