package com.wayne.hot100;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * <a href="https://leetcode.cn/problems/search-insert-position/?envType=study-plan-v2&envId=top-100-liked">链接</a>
 * @author waine
 * @date 2024-01-09 16:09
 */
public class SearchInsert {

    @Test
    public void test(){
        int[] nums = {1,3,5,6};
        assertEquals(2, searchInsert(nums, 4));
    }

    public static int searchInsert(int[] nums, int target){
        int n = nums.length;
        int ans = n;
        int low = 0;
        int high = n - 1;
        // 在有序数组中寻找第一个 >= target 的元素索引
        while (low <= high){
            // 计算low 和 high中间的数
            // (low + high)>>1
            // ((high-low)>>1)+low，可以避免在极端情况下的整数溢出
            int mid = ((high - low) >> 1) + low;
            if(target <= nums[mid]){
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
