package ynwa.fuji.leetcode.easy;

import ynwa.fuji.model.ListNode;

/**
 * Created by ynwa on 16/7/11.
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 */
public class Lc82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0), fast = head, slow = dummy;
        slow.next = fast;
        while(fast != null) {
            while (fast.next != null && fast.val == fast.next.val) {
                fast = fast.next;    //while loop to find the last node of the dups.
            }
            if (slow.next != fast) { //duplicates detected.
                slow.next = fast.next; //remove the dups.
                fast = slow.next;     //reposition the fast pointer.
            } else { //no dup, move down both pointer.
                slow = slow.next;
                fast = fast.next;
            }

        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Lc82 main = new Lc82();
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);

        main.deleteDuplicates(head);
    }
}
