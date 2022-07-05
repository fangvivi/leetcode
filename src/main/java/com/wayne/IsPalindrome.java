package com.wayne;

/**
 * https://leetcode.cn/problems/palindrome-number/
 * @author wayne
 */
public class IsPalindrome {
    public static void main(String[] args) {
        IsPalindrome isPalindrome = new IsPalindrome();
        boolean result = isPalindrome.isPalindromeB(10);
        System.out.println(result);
    }

    /**
     * 把输入的数字转换为字符串，直接使用StringBuilder的api翻转字符串，
     * 对比翻转之后的字符串和输入的是否相等
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
     * 遍历所有的字符，对比首尾字符是否相等
     */
    public boolean isPalindromeA(int x) {
        if(x < 0) {
            return false;
        }
        String str = String.valueOf(x);
        int length = str.length();
        // 如果是回文的话，只需要对比一半的字符就可以知道结果
        for (int i = 0; i < length/2; i++) {
            char head = str.charAt(i);
            char tail = str.charAt(length - 1 - i);
            if(head != tail){
                return false;
            }
        }
        return true;
    }

    /**
     * 翻转一半的数字，进行比较,
     * 源数字每次去掉一位，回文数字每次增加一位
     */
    public boolean isPalindromeB(int x) {
        // 负数不是回文，如果个位数是0的话，只有0才是回文
        if(x < 0 ||(x % 10 == 0 && x != 0)) {
            return false;
        }
        // 保存翻转之后的数字
        int reversedNum = 0;
        while (x > reversedNum){
            // 回文数字每次加上去掉的个位数，相应的要乘以10
            reversedNum = reversedNum * 10 + x % 10;
            // 源数字每次循环去掉个位数，相当于除以10
            x /= 10;
        }
        return reversedNum == x || x == reversedNum/10;
    }
}
