package com.candy.algorithm.v100to110.v113路径总和II;

import com.candy.algorithm.commons.TreeNode;

import java.util.ArrayList;
import java.util.List;

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
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 *
 * 叶子节点 是指没有子节点的节点。
 *
 */
class Solution {
    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        pathSum(root,path,0,targetSum,res);
        System.out.println(res);
        return res;
    }

    public static void pathSum(TreeNode node,List<Integer> path,int sum,int targetSum,List<List<Integer>> res){
        if(node.left==null&&node.right==null){
            if(node.val+sum==targetSum){
                path.add(node.val);
                res.add(copy(path));
                path.remove(path.size()-1);
            }
            return;
        }
        path.add(node.val);
        sum = node.val+sum;
        if(node.left!=null){
            pathSum(node.left,path,sum,targetSum,res);
        }
        if(node.right!=null) {
            pathSum(node.right, path, sum, targetSum, res);
        }
        path.remove(path.size()-1);
    }

    public static List<Integer> copy(List<Integer> path){
        List<Integer> tmp = new ArrayList<>();
        for(int i=0;i<path.size();i++){
            tmp.add(path.get(i));
        }
        return tmp;
    }

    public static void main(String[] args) {
        TreeNode node = TreeNode.creatTreeNode(3,10);

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left=new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right=new TreeNode(1);
//        [   5,
//        4,       8,
//      11,null, 13,     4,
//     7, 2,   null,null,5,1]

        TreeNode.print(root);
        pathSum(root,22);
    }
}