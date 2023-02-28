package S0000_0099;

import entity.ListNode;

/**
 * 反转链表
 */
public class S0206_Reverse_List {

    public static ListNode reverseList(ListNode head){
        ListNode pre = null;
        ListNode current = head;
        while (current!=null){
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        l1.next = l2;
        reverseList(l1);
    }
}
