package com.candy.algorithm.v10to20.v13罗马数字转整数;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 罗马转数字
 */
public class RomanToInt {

    private static Map<String,Integer> map = new HashMap<>();
    static {
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);
    }

    public static int romanToInt(String s) {

        int num = 0;
        for(int i=0;i<s.length();){
            if(i+1<s.length()&&map.containsKey(s.substring(i,i+2))){
                num += map.get(s.substring(i,i+2));
                i=i+2;
            }else{
                num += map.get(s.substring(i,i+1));
                i=i+1;
            }
        }
        return num;
    }

    public static int[] arrMap = new int[256];

    static {
        arrMap['I'] = 1;
        arrMap['V'] = 5;
        arrMap['X'] = 10;
        arrMap['L'] = 50;
        arrMap['C'] = 100;
        arrMap['D'] = 500;
        arrMap['M'] = 1000;
    }

    public static int romanToInt1(String s) {
        ////@TODO 需要关注，一定要熟练
        char[] chars = s.toCharArray();
        int i = 1, len = chars.length - 1, itemp1 = 0, itemp2 = 0, sum = 0;
        if(len == 0){
            return arrMap[chars[0]];
        }
        for (;;i ++) {
            itemp1 = i - 1;//前面那个索引
            itemp2 = (char)chars[itemp1];//前面那个索引对应的 char 转 int
            if(arrMap[itemp2] < arrMap[chars[i]])//前面小于后面
                sum -= arrMap[itemp2];
            else
                sum += arrMap[itemp2];
            if(i == len){//
                sum += arrMap[chars[i]];//最后
                break;
            }
        }
        return sum;
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        StringBuilder res = new StringBuilder();
        Arrays.sort(strs);
        // 字符串转数组
        char[] a = strs[0].toCharArray();
        char[] b = strs[strs.length - 1].toCharArray();
        for (int i = 0; i < a.length; i++) {
            if (i < b.length && a[i] == b[i]) {
                res.append(a[i]);
            }
            else{
                break;
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXC"));
        System.out.println(romanToInt1("MCMXC"));
    }

}
