package com.candy.algorithm.reversenodes;

import com.candy.algorithm.commons.ListNode;

import java.util.List;

/**
 *
 */
public class ReverseNodesInKGroup {

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode start = head;
        ListNode end = goToEnd(start,k);
        if(end==null){
            return head;
        }
        head = end;
        revers(start,end);
        ListNode lastEnd = start;

        while(lastEnd.next!=null){
            start = start.next;
            end = goToEnd(start,k);
            if(end==null){
                return head;
            }
            revers(start,end);
            lastEnd.next = end;
            lastEnd = start;
        }
        return head;
    }

    public static ListNode revers(ListNode start,ListNode end){
        end = end.next;
        ListNode pre = null;
        ListNode cur = start;
        ListNode next = null;
        while(cur!=end){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        start.next = end;
        return start;
    }

    public static ListNode goToEnd(ListNode start,int k){
        while(--k!=0&&start!=null){
            start = start.next;
        }
        return start;
    }

    public static ListNode createNode(int lenght){
        ListNode head = null;
        for(int i=0;i<lenght;i++){
            ListNode node = new ListNode(i);
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

    public static void main(String[] args) {
        ListNode node = createNode(18);
        print(node);
        ListNode v = reverseKGroup(node,5);
        print(v);
    }

}
