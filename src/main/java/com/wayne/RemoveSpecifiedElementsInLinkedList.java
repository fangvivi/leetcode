package com.wayne;

/**
 * https://leetcode.cn/problems/remove-linked-list-elements/
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 *
 * @author wayne
 */
public class RemoveSpecifiedElementsInLinkedList {

    /**
     * 增加一个虚拟头节点
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        ListNode newHead = new ListNode(-1);
        ListNode cur = newHead;
        newHead.next = head;
        while (cur.next != null){
            if(cur.next.val ==val){
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return newHead.next;
    }
}
