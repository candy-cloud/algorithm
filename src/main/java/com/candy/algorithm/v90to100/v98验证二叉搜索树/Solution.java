package com.candy.algorithm.v90to100.v98验证二叉搜索树;

import com.candy.algorithm.commons.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root,Long.MAX_VALUE,Long.MIN_VALUE); 
    }
    public static boolean isValidBST(TreeNode root,long max,long min) {
        if(root == null)
            return true;
        if(root.val >= max || root.val <= min)
            return false;
        return isValidBST(root.left,root.val,min) && isValidBST(root.right,max,root.val);
    }

    public static void main(String[] args) {
        int maxVal = 10;
        int maxLenght = 10;
        TreeNode node = TreeNode.creatTreeNode(maxLenght,maxVal);
        boolean bool = isValidBST(node);
        System.out.println(bool);
    }
}