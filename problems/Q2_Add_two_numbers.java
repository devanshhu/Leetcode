/*
----------------------------------------------------PROBLEM---------------------------------------
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example 1:
    Input: l1 = [2,4,3], l2 = [5,6,4]
    Output: [7,0,8]
    Explanation: 342 + 465 = 807.

Example 2:

    Input: l1 = [0], l2 = [0]
    Output: [0]

Example 3:

    Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
    Output: [8,9,9,9,0,0,0,1]

---------------------------------------------------------------------------------------------------
---------------------------------SOLUTION----------------------------------------------------------
The idea is to pad Zeros at the end of smaller list & then perform the sum operation on every pair of node.
Another boundary condition is to add the last carry to the end of the linked list.

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int fCount = 0, sCount = 0 ;
        ListNode curr = l1;
        while(curr != null){
            curr = curr.next;
            fCount++;
        }
        curr = l2;
        while(curr != null){
            curr = curr.next ;
            sCount++;
        }
        if(fCount > sCount){
            l2 = padZero(l2, fCount - sCount);
        }else if(fCount < sCount){
            l1 = padZero(l1, sCount - fCount);
        }
        int carry = 0 ;
        ListNode result = new ListNode(l1.val + l2.val, null);
        curr = result;
        if(curr.val >= 10 ){
            carry = 1;
            // if sum comes out to be 18 it should be converted to 8 for current node & 1 is carried to the next.
            curr.val = curr.val % 10;
        }else{
            carry  = 0;
        }
        l1 = l1.next;
        l2 = l2.next;
        while(l1 != null && l2 != null){
            ListNode node = new ListNode(l1.val + l2.val + carry, null);        
            if(node.val >= 10 ){
                carry = 1;
                node.val %= 10 ;
            }else{
                carry =0;
            }
            curr.next = node;
            curr = curr.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        // at last check if carry is 1, add this to the end of the list & then return result.
        if(carry == 1){
            ListNode node = new ListNode(1);
            node.next = null;
            curr.next = node;
        }
        return result;
    }
    
    public ListNode padZero(ListNode list, int count){
        if(list ==  null)
            return null;
        ListNode curr = list;
        while(curr.next != null){
            curr = curr.next;
        }
        while(count-- > 0){
            ListNode node = new ListNode(0);
            curr.next = node;
            curr = curr.next;
        }
        return list;
        
    }
}