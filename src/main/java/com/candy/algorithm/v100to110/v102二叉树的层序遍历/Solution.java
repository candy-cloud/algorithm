package com.candy.algorithm.v100to110.v102二叉树的层序遍历;

import com.candy.algorithm.commons.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> all = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        if (root == null) {
            return all;
        }
        while (queue != null && queue.size() > 0) {
            List<Integer> sums = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();
                if (tmp.left != null) {
                    queue.add(tmp.left);
                }
                if (tmp.right != null) {
                    queue.add(tmp.right);
                }
                sums.add(tmp.val);
            }
            all.add(sums);
        }
        return all;
    }

    public static List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        process(root,res,0);
        return res;
    }



    public static void process(TreeNode node, List<List<Integer>> res,int level){
        if(node!=null) {
            if(res.size()<level+1){
                res.add(new ArrayList<Integer>());
            }
            res.get(level).add(node.val);
            if (node.left != null) {
                process(node.left, res, level + 1);
            }
            if (node.right != null) {
                process(node.right, res, level + 1);
            }
        }
    }

    public static Info cc(TreeNode node){
        if(node==null){
            return null;
        }
        Info leftInfo = cc(node.left);
        Info rightInfo = cc(node.right);

        boolean ifFlat = true;
        int max = node.val;
        int min = node.val;

        if(leftInfo!=null) {
            max = Math.max( leftInfo.max,max);
            min = Math.min(leftInfo.min,min);
        }
        if(rightInfo!=null) {
            max = Math.max(max, rightInfo.max);
            min = Math.min(min, rightInfo.min);
        }

        if(leftInfo!=null&&!leftInfo.isFlat){
            ifFlat = false;
        }
        if(rightInfo!=null&&!rightInfo.isFlat){
            ifFlat = false;
        }
        boolean leftFlat = leftInfo==null?true: (leftInfo.max < node.val);
        boolean rightFlat = rightInfo == null?true:(rightInfo.min>node.val);
        if(leftFlat ^ rightFlat){
            ifFlat = false;
        }
        return new Info(max,min,ifFlat);
    }

    public static boolean cc1(TreeNode root,int max,int min){
        System.out.println(max);
        System.out.println(min);

        if(root == null)
            return true;
        if(root.val >= max || root.val <= min)
            return false;
        return cc1(root.left,root.val,min) && cc1(root.right,max,root.val);
    }

    public static class Info{
        int max;
        int min;
        boolean isFlat;
        Info(int max,int min,boolean ifFlat){
            this.max=max;
            this.min=min;
            this.isFlat=ifFlat;
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(10);
        TreeNode.creatTreeNode(treeNode, 2, 20);
//        System.out.println(treeNode);
//        List<List<Integer>> pp = levelOrder(treeNode);
//        System.out.println(pp);
        List<List<Integer>> levelOrder1 = levelOrder1(treeNode);
        System.out.println(levelOrder1);
        boolean i = cc1(treeNode,Integer.MAX_VALUE,Integer.MIN_VALUE);
        System.out.println(i);
    }
}