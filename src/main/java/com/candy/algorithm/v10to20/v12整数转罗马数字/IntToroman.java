package com.candy.algorithm.v10to20.v12整数转罗马数字;

public class IntToroman {

    public static String intToRoman(int num) {
        ////@TODO 需要关注，一定要熟练
        String[] thousands = new String[]{"", "M", "MM", "MMM","MMMM","MMMMM","MMMMMM","MMMMMMM","MMMMMMMM","MMMMMMMMM","", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM","", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC","", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        StringBuffer bf = new StringBuffer(thousands[num/1000]);
        bf.append(thousands[num%1000/100+10]);
        bf.append(thousands[num%1000%100/10+20]);
        bf.append(thousands[num%1000%100%10+30]);
        return bf.toString();
    }

    public static String intToRoman1(int num) {
        //@TODO 需要关注，一定要熟练
        StringBuilder sb = new StringBuilder();
        int[] value = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        for(int i = 0; i < value.length && num >= 0; i++){
            while(value[i] <= num){
                num -= value[i];
                sb.append(roman[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(1990));
        System.out.println(intToRoman1(1990));
    }
}