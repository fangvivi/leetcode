package com.wayne;

/**
 * 把两个有序链表合并为一个新的升序链表
 * https://leetcode.cn/problems/merge-two-sorted-lists/
 * @author wayne
 */
public class MergeTwoSortedLists {


    public static void main(String[] args) {
        ListNode list1Node1 = new ListNode(1);
        ListNode list1Node2 = new ListNode(2);
        ListNode list1Node3 = new ListNode(4);
        list1Node1.next = list1Node2;
        list1Node2.next = list1Node3;

        ListNode list2Node1 = new ListNode(1);
        ListNode list2Node2 = new ListNode(3);
        ListNode list2Node3 = new ListNode(4);
        list2Node1.next = list2Node2;
        list2Node2.next = list2Node3;

        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
        mergeTwoSortedLists.mergeTwoLists(list1Node1, list2Node1);



    }

    /**
     * 递归实现
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        } else if(list2 == null){
            return list1;
        } else if(list1.val < list2.val){
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list2.next, list1);
            return list2;
        }
    }


    /**
     * 迭代实现
     */
    public ListNode mergeTwoListsA(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode headRef =  head;
        while (list1 != null && list2 != null){
            if(list1.val < list2.val){
                headRef.next = list1;
                list1 = list1.next;
            } else {
                headRef.next = list2;
                list2 = list2.next;
            }
            headRef = headRef.next;
        }
        headRef.next = list1 == null ? list2 : list1;
        return head;
    }

}
