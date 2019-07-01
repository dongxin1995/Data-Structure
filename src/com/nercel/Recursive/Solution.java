package com.nercel.Recursive;

/**
 * @author dongxin
 * @create 2019/7/1
 * <p>
 * 删除链表中等于给定值 val 的所有节点。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution {

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            ListNode delNode = head;
            head = delNode.next;
            delNode.next = null;
        }

        if (head == null) {
            return null;
        }

        //prev的值一定不是val了
        ListNode prev = head;
        while (prev.next != null) {
            if (prev.val == val) {
                ListNode delNode = prev;
                prev.next = delNode.next;
                delNode.next = null;
            } else {
                prev = prev.next;
            }
        }
        return head;
    }

    //使用虚拟头结点
    public ListNode removeElements2(ListNode head, int val) {
        //创建虚拟头结点
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.val == val) {
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            } else {
                prev = prev.next;
            }
        }

        return dummyHead.next;
    }

}