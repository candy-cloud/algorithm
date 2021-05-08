package com.candy.algorithm.sort;

import com.candy.algorithm.commons.ArrayUtils;

public class QuickSort {

    public int[] quickSort(int [] arr){
        return null;
    }

    /**
     * 将所有大于数组最后一个数的放在该数的右侧，反之放到左侧。
     * @param arr
     * @return
     */
    public static void splitMax(int[] arr){
        int index = 0;
        //较大的
        int less = 0;
        //较小的
        int curr = arr.length-1;
        while(index<arr.length){
            if(arr[index]<=arr[curr]) {
                swap(arr, less++, index);

            }
            index++;
        }
        return;
    }

    /**
     * 将所有大于数组最后一个数的放在该数的右侧，小于的放在左边，等于的放在中间。
     * @param arr
     * @return
     */
    public static void splitCenter(int[] arr){
        int index = 0;
        //较大的
        int less = 0;
        //较小的
        int curr = arr.length-1;
        while(index<arr.length){
            if(arr[index]<=arr[curr]) {
                swap(arr, less++, index);

            }else{

            }

        }
        return;
    }



    /**
     * 互换数据
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = ArrayUtils.creatArr(20,8);
        ArrayUtils.print(arr);
//        quickSort1(arr);
        ArrayUtils.print(arr);
    }
}
