/**
 날짜: 2026/08/17
 시간: 20분
 풀이 여부: O
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
/**
 next가 null이 아니면 스왑 -> 그리고 next.next를 호출
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode nextAndNext = head.next.next;

        ListNode temp = head;
        head = head.next;
        head.next = temp;

        head.next.next = swapPairs(nextAndNext);

        return head;
    }
}
