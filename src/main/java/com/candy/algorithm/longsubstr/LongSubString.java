package com.candy.algorithm.longsubstr;

import java.util.HashSet;
import java.util.Set;

/**
 * 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 输入: s = ""
 * 输出: 0
 */
class LongSubString {

    //@TODO 需要熟系，不是很了解
    //@TODO 需要关注，一定要熟练
    public static int lengthOfLongestSubstring(String s) {
        int[] last = new int[128];
        for(int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();
        int res = 0;
        int start = 0;
        for(int i = 0; i < n; i++) {
            int index = s.charAt(i);
            start = Math.max(start, last[index] + 1);
            res   = Math.max(res, i - start + 1);
            last[index] = i;
        }
        return res;
    }

    public static int lengthOfLongestSubstring3(String s) {
        Set<String> maxSet = new HashSet<>();
        int l = s.length();
        int max = 0;
        char[] arr = s.toCharArray();
        for(int i = 0 ; i<s.length();i++){
            int tmp = 0;
            for(int j=i+1;j<s.length();j++){
                if(arr[i]==arr[j]){
                    break;
                }
                tmp++;
            }
            if(tmp>max){
                max=tmp;
            }
        }
        return max+1;
    }

    public static int lengthOfLongestSubstring5(String s) {
        if(s==null){
            return 0;
        }
        int[] dp = new int[s.length()];
        char[] arr = s.toCharArray();
        int n = arr.length;
        for (int end = 1; end < n; end++) {
            int newNumIndex = end;
            int max = 0;
            while (newNumIndex - 1 >= 0) {
                if(arr[newNumIndex - 1] == arr[newNumIndex]){
                    break;
                }
                max++;
                dp[end]= max;
                newNumIndex--;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int v = lengthOfLongestSubstring5("abcabcbb");
        System.out.println(v);
    }
}