package S0000_0099;

import entity.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 */
public class SC0019_RemoveNthFromEnd {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        Map<Integer,ListNode> listNodeMap = new HashMap<>();
        ListNode h = head;
        int i=1;
        while (h!=null){
            listNodeMap.put(i,h);
            h = h.next;
            i++;
        }
        int start = listNodeMap.size()-n;
        if (start == 0){
            if (listNodeMap.size()==1){
                return null;
            }else{
                return head.next;
            }
        }
        ListNode listNode = listNodeMap.get(start);
        if (listNode.next!=null){
            listNode.next = listNode.next.next;
        }else{
            listNode.next = null;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l3 = new ListNode(3,null);
        ListNode l2 = new ListNode(2,l3);
        ListNode l1 = new ListNode(1,l2);
        ListNode head  =removeNthFromEnd(l1,3);
        while (head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }


}
