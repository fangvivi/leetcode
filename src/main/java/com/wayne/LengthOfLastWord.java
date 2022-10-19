package com.wayne;

/**
 * 获取字符串中最后一个单词的长度
 * https://leetcode.cn/problems/length-of-last-word/solutions/
 * @author wayne
 */
public class LengthOfLastWord {
    public static void main(String[] args) {
        String str = "hello wro ld  ";
        int len = lengthOfLastWordA(str);
        System.out.println(len);
    }

    /**
     * api 解法
     */
    public static int lengthOfLastWord(String s) {
        String[] subStrArr = s.split("\\s");
        return subStrArr[subStrArr.length-1].length();
    }

    /**
     * 从尾部往头部遍历，从第一个非空格的字符开始计数，遇到空格停止
     */
    public static int lengthOfLastWordA(String s) {
        int len = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            if (' ' != s.charAt(i)){
                len++;
            }
            if(len > 0 && ' '==s.charAt(i)){
                break;
            }
        }
        return len;
    }
}
