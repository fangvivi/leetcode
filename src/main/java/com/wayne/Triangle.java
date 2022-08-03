package com.wayne;

/**
 * 使用*打印三角形
 * @author wayne
 */
public class Triangle {
    public static void main(String[] args) {
        int row = 5;
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= row-1; j++) {
                if(j>=row+1-i){
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            for (int j = 1; j <= i ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void formatOutPut(){
        int row = 5;
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= row-1; j++) {
                if(j>=row+1-i){
                    System.out.printf("%s","*");
                } else {
                    System.out.printf("%s"," ");
                }
            }
            for (int j = 1; j <= i ; j++) {
                System.out.printf("%s","*");
            }
            System.out.printf("%n");
        }
    }
}
