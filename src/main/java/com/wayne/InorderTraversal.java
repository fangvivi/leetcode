package com.wayne;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树中序遍历
 * @author wayne
 */
public class InorderTraversal {
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
        System.out.println(inorderTraversal(t1));
    }

    /**
     * 递归解法
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list;
    }
    public static void inorder(TreeNode root, List<Integer> list) {
        if(root == null){
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    /**
     * 迭代解法
     */
    public static List<Integer> inorderTraversalA(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || root != null){
            while (root != null){
                // 这个循环相当于把所有的节点和它们的左节点都放到了栈中
                stack.push(root);
                root = root.left;
            }
            // 放完之后栈顶就是最左的叶子节点
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }



}
