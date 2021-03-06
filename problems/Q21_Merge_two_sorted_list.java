
/*
----------------------------------------------------PROBLEM---------------------------------------
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

 

Example 1:


	Input: list1 = [1,2,4], list2 = [1,3,4]
	Output: [1,1,2,3,4,4]

Example 2:

	Input: list1 = [], list2 = []
	Output: []

Example 3:

	Input: list1 = [], list2 = [0]
	Output: [0]

---------------------------------------------------------------------------------------------------
---------------------------------SOLUTION----------------------------------------------------------

The idea is to create a new list then merge the results as if we are merging an array.
Use false head approach to keep reference of the new result list.
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        ListNode head = new ListNode(0);
        ListNode p = head;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val ){
                p.next = l1;
                l1 = l1.next;
            }else{
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if(l1 == null)
            p.next = l2;
        if(l2 == null)
            p.next = l1;
        
        return head.next;
    }
}