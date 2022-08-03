package com.wayne;

/**
 * https://leetcode.cn/problems/implement-strstr/
 * @author wayne
 */
public class ImplementStr {
    public static void main(String[] args) {
        String a = "mississippi";
        String b = "issip";
        ImplementStr implementStr = new ImplementStr();
        System.out.println(implementStr.strStrA(a, b));
    }

    /**
     * 使用api暴力匹配
     */
    public int strStr(String haystack, String needle) {
        int len = needle.length();
        if(len==0){
            return 0;
        }
        for (int i = 0; i <= haystack.length()-len; i++) {
            String sub = haystack.substring(i, i+len);
            if(needle.equals(sub)){
                return i;
            }
        }
        return -1;
    }

    /**
     * 不使用api，暴力匹配
     */
    public int strStrA(String haystack, String needle) {
        int len = needle.length();
        if(len==0){
            return 0;
        }
        for (int i = 0; i <= haystack.length()-len; i++) {
            for (int j = 0; j < len; j++) {
                char c = haystack.charAt(i+j);
                char c1 = needle.charAt(j);
                if(c != c1){
                    break;
                }
                if(j == len-1){
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * KMP算法实现
     */
    public int strStrB(String haystack, String needle) {
        int len = needle.length();
        if(len==0){
            return 0;
        }

        return -1;
    }

}
