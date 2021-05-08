package com.candy.algorithm.code;

public class Code1 {

    public static void print(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
    }

    public static void main(String[] args) {

        int num = 89549854;
        print(12);

    }
}
