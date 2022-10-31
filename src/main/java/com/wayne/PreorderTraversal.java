package com.wayne;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树前序遍历
 * https://leetcode.cn/problems/binary-tree-preorder-traversal/description/
 * @author wayne
 */

public class PreorderTraversal {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        t1.right = t2;
        t1.left = t4;
        t2.left = t3;
        t2.right = t5;
        preorderTraversal(t1);
    }

    /**
     * 递归实现
     */
    public static List<Integer> preorderTraversal(TreeNode root) {
       ArrayList<Integer> list = new ArrayList<>();
       preorder(root, list);
       return list;

    }
    public static void preorder(TreeNode root, ArrayList<Integer> list){
        if(root == null){
            return;
        }
        list.add(root.val);
        preorder(root.left, list);
        preorder(root.right, list);
    }

    /**
     * 迭代实现
     */
    public static List<Integer> preorderTraversalA(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || root != null){
            while (root != null){
                list.add(root.val);
                // 先把当前子树的root节点保存下来
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return list;
    }
}
