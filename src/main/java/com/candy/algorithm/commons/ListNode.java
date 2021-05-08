package com.candy.algorithm.commons;

public class ListNode {

    public int val;

    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode createNode(int lenght,int maxValue){
        ListNode head = null;
        for(int i=0;i<lenght;i++){
            ListNode node = new ListNode((int) (Math.random()*maxValue));
            if(head==null){
                head = node;
            }else{
                node.next=head;
                head = node;
            }
        }
        return head;
    }

    public static void print(ListNode node){
        while(node!=null){
            System.out.print((node.val)+",");
            node = node.next;
        }
        System.out.println("");
    }
}
