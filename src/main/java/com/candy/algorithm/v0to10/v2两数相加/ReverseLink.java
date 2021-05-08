//package com.candy.algorithm.addtwonumbers;
//
//import com.candy.algorithm.commons.ListNode;
//
//public class ReverseLink {
//
//    public static ListNode rever(ListNode head){
//        ListNode next = null;
//        ListNode pre = null;
//        while(head!=null){
//            next = head.next;
//            head.next = pre;
//            pre = head;
//            head = next;
//        }
//        return pre;
//    }
//
//    public static DoubleNode doublerever(DoubleNode head){
//        DoubleNode next = null;
//        DoubleNode pre = null;
//        while(head!=null){
//            next = head.next;
//            head.next = pre;
//            head.last = next;
//            pre = head;
//            head = next;
//        }
//        return pre;
//    }
//
//    public static void print(ListNode node){
//        while(node!=null){
//            System.out.print((node.val)+",");
//            node = node.next;
//        }
//        System.out.println("");
//    }
//
//
//
//    public static void main(String[] args) {
//        ListNode l15 = new ListNode(1);
//        ListNode l14 = new ListNode(2, l15);
//        ListNode l13 = new ListNode(3, l14);
//        ListNode l12 = new ListNode(4, l13);
//        ListNode l1 = new ListNode(5, l12);
//        ListNode l23 = new ListNode(6);
//        ListNode l22 = new ListNode(7, l23);
//        ListNode l2 = new ListNode(8, l22);
////        print(l1);
////        ListNode node2 = rever(l1);
////        print(node2);
////        print(l2);
//
//
//        DoubleNode d13 = new DoubleNode(3);
//        DoubleNode d12 = new DoubleNode(2,d13);
//        DoubleNode d1 = new DoubleNode(1,d12);
//       d1.last = null;
//       d12.last = d1;
//       d13.last = d12;
//
//
//        print(d1);
//        DoubleNode node1 = doublerever(d1);
//        System.out.println(node1);
//        print1(node1);
//
//    }
//
//    public static void print(DoubleNode node){
//        while(node!=null){
//            System.out.print((node.val)+",");
//            node = node.next;
//        }
//        System.out.println("");
//    }
//    public static void print1(DoubleNode node){
//        DoubleNode last = null;
//        while(node!=null&&last!=null){
//            System.out.print((node.val)+",");
//            node = node.next;
//            if(node==null){
//                last = node.last;
//            }
//        }
//        System.out.println("");
//    }
//}
