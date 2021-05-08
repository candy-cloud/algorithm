package com.candy.algorithm.sum2;

public class Demo {

    public static int selectNum(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int l = 0;
        int r = arr.length - 1;
        while (r >= l) {
            int mid = (l + r) / 2;
            if (arr[mid] == num) {
                return mid;
            }
            if (arr[mid] > num) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    public static int selectNum1(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int l = 0;
        int r = arr.length - 1;
        int t = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] >= num) {
                r = mid - 1;
                t = r;
            } else {
                l = mid + 1;
            }
        }
        return t;
    }

    public static int[] randomArr(int maxLen,int maxValue){
        int len = (int)(Math.random()*maxLen);
        int[] arr = new int[len];
        if(len>0){
            arr[0] = (int)(Math.random()*maxValue);
            for(int i=1;i<len;i++){
                do{
                    int val = (int)(Math.random()*maxValue);
                    int c = (int)(Math.random()*2);
                    if(c==1){
                        val = val * -1;
                    }
                    arr[i]=val;
                }while(arr[i]==arr[i-1]);
            }
        }
        return arr;
    }

    public static void printArr(int[] arr){
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+",");
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 5, 7, 9, 11, 15, 16};
        int[] arr1 = randomArr(10,10);
        printArr(arr1);
    }

}
