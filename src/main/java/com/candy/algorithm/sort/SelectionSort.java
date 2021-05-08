package com.candy.algorithm.sort;

public class SelectionSort {

    public static void selectSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int minValueIndex = i;
            for (int j = i+1;j<n;j++){
                minValueIndex = arr[j]<arr[minValueIndex]?j:minValueIndex;
            }
            swap(arr,i,minValueIndex);
        }
    }

    public static void swap(int[] arr,int i,int j){
        int tmp = arr[j];
        arr[j]=arr[i];
        arr[i]=tmp;
    }

    public static void printArray(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,6,3,8,9,5,1};
        selectSort(arr);
        printArray(arr);
    }
}
