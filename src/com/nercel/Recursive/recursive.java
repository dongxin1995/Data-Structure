package com.nercel.Recursive;

/**
 * @author dongxin
 * @create 2019/7/1
 */

//递归解决删除链表元素问题
public class recursive {

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return null;

        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }


}
