package S0000_0099;

import entity.ListNode;

//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
//l1 = [2,4,3], l2 = [5,6,4] 输出 [7,0,8] 342 + 465 = 807.

public class S0002_ADD_TWO_NUMBERS {
    /**
     * 思路：使用两个指针，一个指针指向l1开头，一个指针指向l2开头，同时一起向后遍历，取出列表中的数字对应相加再加上进位符，如果数字大于等于10，
     * 则进位符设置为1，否则为0，得到的相加结果大于等于10则减去，将相加结果放在新的ListNode中。
     * 注意的是：遍历完l1和l2后如果进位符为1，则需要单独再加上进位符。
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pHead = new ListNode(-1,null);
        ListNode pre = pHead;
        //进位符
        int accu = 0;
        //l1和l2都为空则退出
        while (l1 != null || l2 != null || accu!=0){
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int sum = val1 + val2 + accu;
            if (sum >= 10){
                sum = sum - 10;
                accu = 1;
            }else{
                accu = 0;
            }
            ListNode listNode = new ListNode(sum,null);
            pre.next = listNode;
            pre = listNode;
            if (l1!=null){
                l1 = l1.next;
            }
            if (l2!=null){
                l2 = l2.next;
            }
        }
        return pHead.next;
    }
}
