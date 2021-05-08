package com.candy.algorithm.v0to10.v7整数反转;

/**
 *  数字翻转
 */
class ReverseNum {
    public static int reverse(int x) {
        long n = 0;
        while (x != 0) {
            n = n * 10 + x % 10;
            x = x / 10;
        }
        return (int) n == n ? (int) n : 0;
    }

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }
}