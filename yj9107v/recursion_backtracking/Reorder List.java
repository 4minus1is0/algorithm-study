/**
 날짜: 2026/08/23
 시간: 30분, AI 20분
 풀이 여부: X
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

    private ListNode front;

    public void reorderList(ListNode head) {
        front = head;
        dfs(head);
    }

    private void dfs(ListNode current) {
        if (current == null) return;

        dfs(current.next);

        if (front == null) return;

        if (front == current) {
            current.next = null;
            front = null;
            return;
        }

        if (front.next == current) {
            current.next = null;
            front = null;
            return;
        }

        ListNode nextFront = front.next;
        front.next = current;
        current.next = nextFront;

        front = nextFront;
    }
}
