package com.wayne.classic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 递归实现数组元素求和
 * @author waine
 * @date 2023-12-15 09:15
 */
public class ArraySumRecursion {
    @Test
    public void test(){
        int[] arr = {1, 2, 3, 4, 5, 6};
        assertEquals(21, arraySumRecursionLeft(arr, 0));
        assertEquals(21, arraySumRecursionRight(arr, arr.length - 1));
    }

    /**
     * 递归实现数组元素求和，从左边的元素开始递归
     * @param arr 待求和数组
     * @param index 最小索引值
     * @return 数组元素和
     */
    public static int arraySumRecursionLeft(int[] arr, int index){
        if(index == arr.length - 1){
            return arr[index];
        }
        return arr[index] + arraySumRecursionLeft(arr, index + 1);
    }

    /**
     * 递归实现数组元素求和，从右边的元素开始递归
     * @param arr 待求和数组
     * @param index 最大索引值
     * @return 数组元素和
     */
    public static int arraySumRecursionRight(int[] arr, int index){
        if(index == 0){
            return arr[index];
        }
        return arr[index] + arraySumRecursionRight(arr,index - 1);
    }
}
