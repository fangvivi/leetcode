package com.wayne;

/**
 * 罗马数字转整数
 * https://leetcode.cn/problems/roman-to-integer/
 * @author wayne
 */
public class RomanToInteger {
    public static void main(String[] args) {
        String str = "VI";
        RomanToInteger romanToInteger = new RomanToInteger();
        System.out.println(romanToInteger.romanToInt(str));

    }

    /**
     * 把每一个字符看成一个数字，如果是左大右小的顺序，累加即可
     * 如果出现左小右大，做减法
     */
    public int romanToInt(String s) {
        int sum = 0;
        int preNum = getValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int num = getValue(s.charAt(i));
            if(preNum < num){
                // 如果小的在左边，表示减
                sum -= preNum;
            } else {
                // 大的在右边，表示加
                sum += preNum;
            }
            preNum = num;

        }
        sum += preNum;
        return sum;
    }

    public int getValue(char c){
        switch (c){
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return -1;
        }
    }
}
