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
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        // add values
        for(ListNode node: lists) {
            if(node != null) {
                minHeap.offer(node);
            }
        }

        // dummy node for result
        ListNode result = new ListNode(-1);
        ListNode tail = result;

        // process heap
        while(!minHeap.isEmpty()) {

            // get the smallest
            ListNode smallest = minHeap.poll();

            // Add to result
            tail.next = smallest;
            tail = tail.next;

            // Add next node 
            if(smallest.next != null) {
                minHeap.offer(smallest.next);
            }
        }

        return result.next;
    }
}
