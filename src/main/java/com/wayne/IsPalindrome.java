package com.wayne;

/**
 * https://leetcode.cn/problems/palindrome-number/
 * @author wayne
 */
public class IsPalindrome {
    public static void main(String[] args) {
        IsPalindrome isPalindrome = new IsPalindrome();
        boolean result = isPalindrome.isPalindromeA(131);
        System.out.println(result);
    }

    /**
     * 直接使用字符串api
     */
    public boolean isPalindrome(int x) {
        if(x < 0 ) {
            return false;
        }
        String str = String.valueOf(x);
        String reverse = new StringBuilder(str).reverse().toString();
        return reverse.equals(String.valueOf(x));
    }

    /**
     * 对比一半的数字字符是否相等
     */
    public boolean isPalindromeA(int x) {
        if(x < 0) {
            return false;
        }
        String str = String.valueOf(x);
        int length = str.length();
        for (int i = 0; i < length/2; i++) {
            char head = str.charAt(i);
            char tail = str.charAt(length - 1 - i);
            if(head != tail){
                return false;
            }
        }
        return true;
    }

}
