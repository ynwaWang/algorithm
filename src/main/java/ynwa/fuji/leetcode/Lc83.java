package ynwa.fuji.leetcode;

/**
 * Created by David Wang<wdw@winbaoxian.com> on 2016-07-06.
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 */
public class Lc83 {

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode cursor = head;
        int key = cursor.val;
        while (cursor.next != null) {
            if (cursor.next.val != key) {
                cursor = cursor.next;
                key = cursor.val;
            } else {
                cursor.next = cursor.next.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 2};
        ListNode head = new ListNode(a[0]);
        ListNode cursor = head;
        for (int i = 1; i < a.length; i++) {
            cursor.next = new ListNode(a[i]);
            cursor = cursor.next;
        }

        deleteDuplicates(head);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
