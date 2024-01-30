package com.wayne.hot100;

import com.wayne.ListNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false。
 * <a href="https://leetcode.cn/problems/palindrome-linked-list/description/?envType=study-plan-v2&envId=top-100-liked">链接</a>
 * @author waine
 * @date 2024-01-30 11:30
 */
public class PalindromeLinkedList {

    @Test
    public void test(){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        assertEquals(true, isPalindrome(n1));
        assertEquals(false, isPalindrome(n2));
    }

    /**
     * 先把链表中的数字保存到集合中，然后使用双指针前后对比
     */
    public static boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        // 把链表中的数字复制到集合中
        ListNode cur = head;
        while (cur != null ){
            list.add(cur.val);
            cur = cur.next;
        }
        // 使用双指针往中间遍历，判断列表是否为回文
        int j = list.size() - 1;
        for (int i = 0; i < list.size() / 2; i++) {
            int left = list.get(i);
            int right = list.get(j--);
            if(left != right){
                return false;
            }
        }
        return true;
    }
}
