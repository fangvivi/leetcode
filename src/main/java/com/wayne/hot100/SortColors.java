package com.wayne.hot100;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 颜色分类
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
 * <a href="https://leetcode.cn/problems/sort-colors/description/?envType=study-plan-v2&envId=top-100-liked">链接</a>
 * @author waine
 * @date 2023-12-29 15:29
 */
@Slf4j
public class SortColors {
    @Test
    void test(){
        int[] nums = {2};
        sortColorsB(nums);
        log.info("{}",Arrays.toString(nums));
    }

    public static void sortColorsB(int[] nums){
        int n = nums.length;
        int p0 = 0;
        int p1 = 0;
        for (int i = 0; i < n; i++) {
            if(nums[i] == 1){
                swap(nums, i, p1);
                p1++;
            }
            if(nums[i] == 0){
                swap(nums, i, p0);
                // 因为最后一个0和第一个1是相邻的，如果p0 < p1, p0当前的位置一定是1，这个1会被换到i的位置，所以需要把i和p1的元素交换位置
                if(p0 < p1){
                    swap(nums, i, p1);
                }
                p0++;
                p1++;
            }
        }
    }

    public static void sortColorsA(int[] nums) {
        int n = nums.length;
        int cursor = 0;
        for (int i = 0; i < n; i++) {
            if(nums[i] == 0){
                swap(nums, i, cursor);
                cursor++;
            }
        }
        for (int i = cursor; i < n; i++) {
            if(nums[i] == 1){
                swap(nums, i, cursor);
                cursor++;
            }
        }
    }

    /**
     * 遍历两次
     */
    public static void sortColors(int[] nums) {
        int length = nums.length;
        if(length == 1){
            return;
        }
        // 排序完成，指向最后一个0
        int i = -1;
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] == 0) {
                i++;
                swap(nums, k, i);
            }
        }
        // 排序完成，指向第一个2
        i = length;
        for (int k = length - 1; k > 0; k--) {
            if (nums[k] == 2) {
                i--;
                swap(nums, k, i);
            }
        }
    }

    public static void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }


}

