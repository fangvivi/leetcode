package com.wayne;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/plus-one/
 * @author wayne
 */
public class PlusOne {
    public static void main(String[] args) {
        int[] arr = {9,9,9,9};
        System.out.println(Arrays.toString(plusOne(arr)));
    }

    public static int[] plusOne(int[] digits) {
        int len = digits.length;
        for (int i = len-1; i >=0 ; i--) {
            digits[i]++;
            // 如果当前元素为9，对10取余的结果为0，相当于进行了进位操作
            // 如果当前元素不为9，对10取余还是本身
            digits[i] = digits[i] % 10;
            // 如果没有发生进位，表示这是从后往前遍历第一个不为9的元素
            if(digits[i] != 0){
                return digits;
            }
        }
        digits = new int[len+1];
        digits[0] = 1;
        return digits;
    }

    public static int[] plusOneA(int[] digits) {
        int len = digits.length;
        for (int i = len-1; i >=0 ; i--) {
            int num = digits[i];
            // 当前元素如果为9，赋值为0
            if(num != 9){
                digits[i] = 0;
            } else {
                // 9的前一位加1之后，直接结束循环
                digits[i] += 1;
                return digits;
            }
        }
        // 走到这里说明所有的元素都是9
        digits = new int[len+1];
        digits[0] = 1;
        return digits;
    }
}
