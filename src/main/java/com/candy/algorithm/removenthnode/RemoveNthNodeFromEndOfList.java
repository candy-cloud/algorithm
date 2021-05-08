package com.candy.algorithm.removenthnode;

import com.candy.algorithm.commons.ListNode;

import java.util.ArrayList;
import java.util.List;

public class RemoveNthNodeFromEndOfList {


    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = head;
        int count = 0;
        List<ListNode> arr = new ArrayList<>();
        while (start != null) {
            arr.add(start);
            start = start.next;
            count++;
        }
        if (count == 1) {
            return null;
        }
        int curNum = count - n;
        if (count >= n) {
            ListNode next = null;
            int c = curNum - 1;
            ListNode node = null;
            if (c >= 0) {
                node = arr.get(c);
            }
            if (curNum + 1 < count) {
                next = arr.get(curNum + 1);
            }
            if (node == null) {
                return next;
            }
            node.next = next;
        }
        return arr.get(0);
    }

    public static ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode preNode = head;
        ListNode endNode = head;
        for (int i = 0; i < n; i++)
            preNode = preNode.next;
        if (preNode == null)
            return head.next;
        while (preNode.next != null) {
            preNode = preNode.next;
            endNode = endNode.next;
        }
        endNode.next = endNode.next.next;
        return head;
    }

    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode start = head;
        ListNode end = head;
        for (int i = 0; i < n; i++) {
            start = start.next;
        }
        if (start == null) {
            return head.next;
        }
        while (start.next != null) {
            start = start.next;
            end = end.next;
        }
        end.next = end.next.next;
        return head;
    }

    public static ListNode createNode(int lenght) {
        ListNode head = null;
        for (int i = 0; i < lenght; i++) {
            ListNode node = new ListNode(i);
            if (head == null) {
                head = node;
            } else {
                node.next = head;
                head = node;
            }
        }
        return head;
    }

    public static void print(ListNode node) {
        while (node != null) {
            System.out.print((node.val) + ",");
            node = node.next;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        ListNode node = createNode(5);
        print(node);
        ListNode v = removeNthFromEnd(node, 2);
        print(v);
        ListNode v1 = removeNthFromEnd1(node, 2);
        print(v1);
        ListNode v2 = removeNthFromEnd2(node, 2);
        print(v2);
    }
}
