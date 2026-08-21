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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) {
            return head;
        }

        int n = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            n++;
        }

        k = k % n;
        if (k == 0) return head;

        ListNode newTail = head;
        for (int i = 0; i < n - k - 1; i++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        tail.next = head;
        newTail.next = null;

        return newHead;
    }
}
// class Solution {
//     public ListNode rotateRight(ListNode head, int k) {
//         if(head == null || head.next == null) {
//             return head;
//         }

//         for(int i = 0; i < k; i++) {
//             ListNode first = head.next;
//             ListNode second = head;

//             while(first.next != null) {
//                 first = first.next;
//                 second = second.next;
//             }

//             first.next = head;
//             second.next = null;
//             head = first;
//         }

//         return head;
//     }
// }