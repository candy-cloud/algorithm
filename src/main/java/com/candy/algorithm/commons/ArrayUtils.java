package com.candy.algorithm.commons;

public class ArrayUtils {

    public static int[] creatArr(int max, int length) {
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            int val = (int)(Math.random()*max);
            arr[i] = val;
        }
        return arr;
    }

    public static void print(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+",");
        }
        System.out.println("=======================");
    }
}
