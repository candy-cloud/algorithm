package com.candy.algorithm.commons;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode creatTreeNode(int maxLenght, int maxValue){
        TreeNode node = new TreeNode((int)(Math.random()*maxValue));
        creatTreeNode(node,maxLenght,maxValue);
        return node;
    }

    public static TreeNode creatTreeNode(TreeNode node, int maxLenght, int maxValue) {
        if (maxLenght <= 0) {
            return node;
        }
        TreeNode right = new TreeNode((int) (Math.random() * maxValue));
        TreeNode left = new TreeNode((int) (Math.random() * maxValue));
        node.right = right;
        node.left = left;
        creatTreeNode(right, --maxLenght, maxValue);
        creatTreeNode(left, --maxLenght, maxValue);
        return node;
    }

    public static void print(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        process(root,res,0);
        System.out.println(res);
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
}
