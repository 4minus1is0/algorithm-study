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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int cnt = right - left; 

        if(cnt == 0) return head; 
        if(head == null || head.next == null) return head; 

        int i = 0;
        ListNode dummy = new ListNode(0, head); 
        ListNode start = dummy; 
        while(i < left-1){
            start = start.next; 
            i++;
        }

    
        ListNode result = reverse(start.next, cnt); 
        start.next = result; 

        return dummy.next; 
    }

    public ListNode reverse(ListNode start, int cnt){
        ListNode prev = null;
        ListNode curNode = start; 
        int i = 0; 
        while(i <= cnt){
            ListNode nextNode = curNode.next; 
            curNode.next = prev; 
            prev = curNode;
            curNode = nextNode; 
            i++; 
        }

    
        start.next = curNode; 
        return prev; 
    }
}
