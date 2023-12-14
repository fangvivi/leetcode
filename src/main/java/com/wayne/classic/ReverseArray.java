package com.wayne.classic;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 翻转数组
 * @author waine
 * @date 2023-12-14 15:14
 */
public class ReverseArray {
    @Test
    public void test(){
        int[] arr = {9, 4, 1, 6, 8, 3, 5};
        int[] reversedArr = {5, 3, 8, 6, 1, 4, 9};
        reverseArray(arr);
        assertEquals(Arrays.toString(reversedArr), Arrays.toString(arr));
    }

    /**
     * 双指针法
     */
    public static void reverseArray(int[] arr){
        int low = 0;
        int high = arr.length - 1;
        while (low < high){
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
    }
}
