package com.wayne;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给你一个链表的头节点 head ，判断链表中是否有环
 * https://leetcode.cn/problems/linked-list-cycle/
 *
 * @author wayne
 */
public class HasCycle {
    private Object HashSet;

    /**
     * 1、遍历所有节点，放入hashSet中
     * 2、利用ArrayList来判断是否已经访问过当前节点
     */
    public boolean hasCycle(ListNodeHasCycle head) {
        List<ListNodeHasCycle> nodeList = new ArrayList<>();
        while (head != null) {
            if (nodeList.contains(head)) {
                return true;
            }
            nodeList.add(head);
            head = head.next;
        }
        return false;
    }

    /**
     * 和上面的思路一样，利用hashSet可以获得更快的操作效率
     */
    public boolean hasCycleA(ListNodeHasCycle head) {
        Set<ListNodeHasCycle> nodeSet = new HashSet<>();
        while (head != null) {
            if (!nodeSet.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    public boolean hasCycleB(ListNodeHasCycle head) {
       if(head == null || head.next == null){
           return false;
       }
       ListNodeHasCycle slow = head;
       ListNodeHasCycle fast = head.next;
       while (slow != fast){
           if(fast == null || fast.next == null){
               return false;
           }
           slow = slow.next;
           fast = fast.next.next;
       }
        return true;
    }
}

class ListNodeHasCycle {
    int val;
    ListNodeHasCycle next;

    ListNodeHasCycle(int x) {
        val = x;
        next = null;
    }
}
