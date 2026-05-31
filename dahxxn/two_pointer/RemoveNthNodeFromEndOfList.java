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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = new ListNode(0, head);

        ListNode end = first;
        ListNode start = first;

        for(int i = 0; i < n ; i++){ // 앞에서 n번쨰 위치로 이동
            end = end.next;
        }
        // start -- end = n 만큼의 간격 존재

        // end가 끝일때까지 start와 end를 같이 옆으로 이동
        while(end.next != null){
            start = start.next;
            end = end.next;
        }

        start.next = start.next.next;
        return first.next;
    }
}
