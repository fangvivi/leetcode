package com.wayne.classic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 计算阶乘
 * @author waine
 * @date 2023-12-15 10:15
 */
public class Factorial {

    @Test
    public void test(){
        assertEquals(120, factorial(5));
        assertEquals(40320, factorial(8));
    }

    /**
     * 计算给定整数的阶乘。
     * @param n 要计算阶乘的正整数。
     * @return 给定整数的阶乘。
     * @throws IllegalArgumentException 如果传入的整数小于 1，将抛出 IllegalArgumentException。
     */
    public static int factorial(int n){
        if (n < 1) {
            throw new IllegalArgumentException("输入的整数必须大于等于 1");
        }
        if(n == 1){
            return 1;
        }
        return n * factorial(n - 1);
    }
}
