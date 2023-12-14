package com.wayne.classic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 二分查找，时间复杂度是O(logn)，以2为底
 *
 * @author wayne
 */
public class BinarySearch {
    @Test
    public void test(){
        int[] arr = {1, 3, 5, 7, 9, 13, 16};
        assertEquals(3, binarySearch(arr, 7));
        assertEquals(0, binarySearch(arr, 1));
        assertEquals(-1, binarySearch(arr, 18));
    }
    /**
     * 二分查找，数组必须是有序的
     * @param arr 待查找的有序数组
     * @param target 需要查找的元素
     * @return 如果找到，返回元素的索引；没有找到，返回 -1
     */
    public static int binarySearch(int[] arr, int target){
        // low 和 high 来控制查找的范围，根据比对的结果不断缩小范围
        int low = 0;
        int high = arr.length - 1;
        while (low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] == target){
                return mid;
            } else if(arr[mid] > target){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
