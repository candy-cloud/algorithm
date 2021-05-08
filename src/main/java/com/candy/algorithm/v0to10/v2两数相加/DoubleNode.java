package com.candy.algorithm.v0to10.v2两数相加;

public class DoubleNode {

    int val;
    DoubleNode next;
    DoubleNode last;

    DoubleNode(int val){
        this.val=val;
    }
    DoubleNode(int val,DoubleNode node){
        this.next = node;
        this.val=val;
    }
}
