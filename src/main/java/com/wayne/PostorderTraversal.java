package com.wayne;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树后续遍历
 * https://leetcode.cn/problems/binary-tree-postorder-traversal/
 * @author wayne
 */
public class PostorderTraversal {

    /**
     * 递归法
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postorder(root, list);
        return list;
    }

    public void postorder(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        postorder(root.left, list);
        postorder(root.right, list);
        list.add(root.val);
    }

    public List<Integer> postorderTraversalA(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stk = new LinkedList<>();
       while (!stk.isEmpty() || root != null){
           while (root != null){
               stk.push(root);
               root = root.left;
           }
           root = stk.pop();
           if(root.right == null){
               list.add(root.val);

           } else {
               stk.push(root);
               root = root.right;
           }
       }
        return list;
    }
}
