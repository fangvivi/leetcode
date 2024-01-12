package com.wayne.hot100;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 * 给你一个按照非递减顺序排列的整数数组nums，和一个目标值target。请你找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 * <a href="https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/?envType=study-plan-v2&envId=top-100-liked">链接</a>
 *
 * @author waine
 * @date 2024-01-09 17:09
 */
@Slf4j
public class SearchRange {
    @Test
    public void test() {
        int[] nums = {5,7,7,8,8,10};
        log.info("{}", Arrays.toString(searchRange(nums, 6)));
    }

    /**
     * 使用二分查找分别找第一个和最后一个
     */
    public static int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int leftIndex = -1;
        int rightIndex = -1;
        // 获取第一个target的索引
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            // 找到target以后，往左边找，最后找到的就是第一个
            if (nums[mid] == target) {
                leftIndex = mid;
                right = mid - 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        left = 0;
        right = n - 1;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            // 找到target以后，往右边找，最后找到的就是最后一个
            if (nums[mid] == target) {
                rightIndex = mid;
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return new int[]{leftIndex, rightIndex};
    }

}

