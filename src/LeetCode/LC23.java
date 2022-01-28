package LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

/*23. Merge k Sorted Lists*/
public class LC23 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparing(o -> o.val));
        for (ListNode node : lists) {
            if (node != null)
                pq.offer(node);
        }
        ListNode head = new ListNode();
        ListNode temp = head;
        while (!pq.isEmpty()) {
            ListNode cur = pq.poll();
            temp.next = cur;
            temp = temp.next;
            if (cur.next != null) {
                pq.offer(cur.next);
            }
        }
        return head.next;
    }
}
