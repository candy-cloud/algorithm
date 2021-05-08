package com.candy.algorithm.v0to10.v2两数相加;

import com.candy.algorithm.commons.ListNode;

/**
 * 两数相加
 * 给你两个"非空"的链表，表示两个非负的整数。它们每位数字都是按照"逆序"的方式存储的，并且每个节点只能存储"一位"数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 */
public class AddTwoNumbers {

    /**
     * 方法一：模拟
     * 思路与算法
     * 由于输入的两个链表都是逆序存储数字的位数的，因此两个链表中同一位置的数字可以直接相加。
     * 我们同时遍历两个链表，逐位计算它们的和，并与当前位置的进位值相加。具体而言，如果当前两个链表处相应位置的数字为 n1,n2n1,n2，
     * 进位值为 \textit{carry}carry，则它们的和为 n1+n2+\textit{carry}n1+n2+carry；其中，答案链表处相应位置的数字为
     * (n1+n2+\textit{carry}) \bmod 10(n1+n2+carry)mod10，而新的进位值为 \lfloor\frac{n1+n2+\textit{carry}}{10}\rfloor⌊
     * 10 n1+n2+carry  ⌋。
     * 如果两个链表的长度不同，则可以认为长度短的链表的后面有若干个 00 。
     * 此外，如果链表遍历结束后，有 \textit{carry} > 0carry>0，还需要在答案链表的后面附加一个节点，节点的值为 \textit{carry}carry。
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //@TODO 需要关注，一定要熟练
        ListNode pre = new ListNode();
        ListNode cur = pre;
        int c = 0;
        while (l1 != null || l2 != null || c!=0) {
            int v = c;
            int v1 = l1!=null?l1.val:0;
            int v2 = l2!=null?l2.val:0;
            v = v1 + v2 + v;
            c=v/10;
            cur.next = new ListNode(v%10);
            cur = cur.next;
            l1 = l1!=null?l1.next:null;
            l2 = l2!=null?l2.next:null;
        }
        return pre.next;
    }

    public static void main(String[] args) {
        ListNode l15 = new ListNode(1);
        ListNode l14 = new ListNode(2, l15);
        ListNode l13 = new ListNode(3, l14);
        ListNode l12 = new ListNode(4, l13);
        ListNode l1 = new ListNode(5, l12);

        ListNode l23 = new ListNode(6);
        ListNode l22 = new ListNode(7, l23);
        ListNode l2 = new ListNode(8, l22);
        ListNode node = addTwoNumbers(l1, l2);
        print(node);
    }

    public static void print(ListNode node){
        while(node!=null){
            System.out.print((node.val)+",");
            node = node.next;
        }
    }
}
