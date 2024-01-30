package com.wayne.classic;

import com.wayne.ListNode;
import org.junit.jupiter.api.Test;

/**
 * @author waine
 * @date 2024-01-29 17:29
 */
public class ReverseLinkedList {

    @Test
    public void test(){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        reverseRecurse(n1);
    }

    /**
     * 递归的方式反转链表
     */
    public static ListNode reverseRecurse(ListNode head){
        // 递归的基线条件
        if(head == null || head.next == null){
            return head;
        }
        // 最终找到链表的尾节点返回，作为新的头节点
        ListNode newHead = reverseRecurse(head.next);
        // 调换父子节点的关系
        head.next.next = head;
        // 去掉子节点
        head.next = null;
        return newHead;
    }

    /**
     * 双指针反转链表
     */
    public static ListNode reverseDoublePointer(ListNode head){
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;

    }
}
