package com.wayne.classic;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 快速排序
 * 调用栈的高度为O(log n)），而每层需要的时间为O(n)。因此整个算法需要的时间为O(n) * O(log n) = O(n log n)
 * @author waine
 * @date 2023-12-14 11:14
 */
public class QuickSort {

    @Test
    public void test(){
        int[] arr = {9, 4, 1, 6, 8, 3, 5};
        int[] arrSorted = {1, 3, 4, 5, 6, 8, 9};
        quickSort(arr, 0, arr.length - 1);
        assertEquals(Arrays.toString(arrSorted), Arrays.toString(arr));
    }
    /**
     * 快速排序
     * @param arr 待排序的数组
     * @param low 数组的起始索引
     * @param high 数组的最大索引
     */
    public static void quickSort(int[] arr, int low, int high){
        // 基线条件：当 low == high 时，只剩下一个元素，排序结束
        if(low < high){
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    /**
     * 快速排序的核心逻辑，找出基准元素（pivot），然后把小于 pivot 的元素放到左边，大于pivot的元素放到右边
     * @param arr 带排序的数组
     * @param low 最小的索引
     * @param high 最大的索引
     * @return pivot的索引
     */
    public static int partition(int[] arr, int low, int high){
        // 选择最右边的元素作为pivot
        int pivot = arr[high];
        int i = low - 1;
        // 把小于pivot的元素都放到左边
        for (int j = low; j < high; j++) {
            if(arr[j] < pivot){
                i++;
                swap(arr, i, j);
            }
        }
        // 遍历结束，索引<=i 的元素都是小于pivot的，所以pivot最终应该放在 i+1 的位置上
        swap(arr, i + 1, high);
        return i + 1;
    }

    /**
     * 交换数组中元素i和元素j的位置
     * @param arr 待排序的数组
     * @param i 元素i的索引
     * @param j 元素j的索引
     */
    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
