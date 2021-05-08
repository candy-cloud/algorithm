package com.candy.algorithm.partitionlist;

import com.candy.algorithm.commons.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public static ListNode partition(ListNode head, int x) {
        ListNode smailHead = new ListNode();
        ListNode smailNode = smailHead;
        ListNode bigHead = new ListNode();
        ListNode bigNode = bigHead;
        while(head!=null){
            if(head.val < x ) {
                smailNode.next = head;
                smailNode = head;
            }else{
                bigNode.next = head;
                bigNode = head;
            }
            head = head.next;
        }
        bigNode.next = null;
        smailNode.next=bigHead.next;
        return smailHead.next;
    }

    public static void main(String[] args) {
        ListNode node = ListNode.createNode(5,20);
        ListNode.print(node);
        ListNode n = partition(node,5);
        ListNode.print(n);
        ListNode b = partition(node,5);
        ListNode.print(n);
    }
}