package com.wayne;

/**
 * 打印99乘法表
 * @author wayne
 */
public class NineMultiplyNineTable {
    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i;j++) {
                System.out.printf("%d * %d = %-2d  ", i, j, i*j);
            }
            System.out.printf("%n");
        }
    }
}
