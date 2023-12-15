package com.wayne.classic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author waine
 * @date 2023-12-15 10:15
 */
public class ArrayCountRecursion {

    @Test
    public void test(){
        int[] arr = {1, 2, 3, 4, 5, 6};
        assertEquals(6, arrayCountRecursionLeft(arr, 0));
        assertEquals(6, arrayCountRecursionRight(arr, arr.length - 1));
    }



    /**
     * 递归计算数组中从指定索引到最右端的元素数量。
     *
     * @param arr 要计算的数组。
     * @param index 开始计算的索引。
     * @return 从指定索引到最右端的元素数量。
     */
    public static int arrayCountRecursionLeft(int[] arr, int index){
        if(index == arr.length - 1){
            return 1;
        }
        return 1 + arrayCountRecursionLeft(arr, index + 1);
    }

    /**
     * 递归计算数组中从指定索引到最左端的元素数量。
     *
     * @param arr 要计算的数组。
     * @param index 开始计算的索引。
     * @return 从指定索引到最左端的元素数量。
     */
    public static int arrayCountRecursionRight(int[] arr, int index){
        if(index == 0){
            return 1;
        }
        return 1 + arrayCountRecursionRight(arr, index - 1);
    }
}
