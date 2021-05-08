package com.candy.algorithm.atoi;

class Solution {
    public static int myAtoi(String s) {
        if (s == null || s == "") {
            return 0;
        }
        s = s.trim();

        int[] arr = new int[10];

        StringBuffer ns = new StringBuffer();
        for(int i=0;i<s.length();i++){
            if(i==0){
                if(s.charAt(0)!='-'&&(s.charAt(0)!=' '&&!Character.isDigit(s.charAt(0))&&s.charAt(0)!='+')||s.charAt(0)!='+'&&(s.charAt(0)!=' '&&!Character.isDigit(s.charAt(0))&&s.charAt(0)!='-')){
                    return 0;
                }
                else{
                    ns.append(s.charAt(0));
                    continue;
                }
            }
            if(s.charAt(i)=='-'){
                return 0;
            }
            if(s.charAt(i)=='+'){
                return 0;
            }
            if(!Character.isDigit(s.charAt(i))){
                break;
            }
            if(s.charAt(i)!=' ') {
                ns.append(s.charAt(i));
            }
        }

        String str = ns.toString();
        System.out.println(ns.toString());
        if("".equals(ns.toString())){
            return 0;
        }
        if(str.length()==1&&(str.equals("-")||str.equals("+"))){
            return 0;
        }

        if(str.length()>20&&str.equals("-")){
            return Integer.MIN_VALUE;
        }
        if(str.length()>20){
            return Integer.MAX_VALUE;
        }
        long num = Long.parseLong(str);
        if(num>Integer.MAX_VALUE){
            num=Integer.MAX_VALUE;
        }
        if(num<Integer.MIN_VALUE){
            num=Integer.MIN_VALUE;
        }
        return (int)num;
    }

    public static void main(String[] args) {
//        System.out.println(myAtoi("000000000000000000"));
//        int ant = 0;
//        for(int i=0;i<2;i++) {
//            int c = (int) (Math.random()*2);
//            if(c==1){
//                ant++;
//            }
//        }
//        System.out.println(ant);
        int x = 576%10;
        System.out.println(x);
    }
}