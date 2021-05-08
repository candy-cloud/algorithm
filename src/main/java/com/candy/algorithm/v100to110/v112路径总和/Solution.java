package com.candy.algorithm.v100to110.v112路径总和;

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
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum ，判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。
 *
 * 叶子节点 是指没有子节点的节点。
 *
 */
class Solution {

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        return process(root,0,targetSum);
    }

    public static boolean process(TreeNode node,int sum,int targetSum){
        if(node==null){
            return false;
        }
        if(node.left==null&&node.right==null){
            if(node.val+sum==targetSum){
                return true;
            }
        }
        if(process(node.left,node.val+sum,targetSum)||process(node.right,node.val+sum,targetSum)){
            return true;
        }
        return false;
    }

    private boolean flat = false;
    public boolean hasPathSum1(TreeNode root, int targetSum) {
        flat = false;
        if(root!=null){
            process1(root,0,targetSum);
        }
        return flat;
    }

    public void process1(TreeNode node,int sum,int targetSum){
        if(node.left==null&&node.right==null){
            if(node.val+sum==targetSum){
                flat = true;
            }
        }
        sum = node.val+sum;
        if(node.left!=null){
            process(node.left,sum,targetSum);
        }
        if(node.right!=null){
            process(node.right,sum,targetSum);
        }
    }

    public static void main(String[] args) {
        int maxValue = 10;
        int maxLenght = 3;
        TreeNode node = new TreeNode((int)(Math.random()*maxValue));
        TreeNode root = TreeNode.creatTreeNode(node,maxLenght,maxValue);
        TreeNode.print(root);
        boolean bool = hasPathSum(root,10);
        System.out.println(bool);
    }
}