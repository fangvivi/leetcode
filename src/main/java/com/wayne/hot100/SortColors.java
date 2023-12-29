package com.wayne.hot100;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        int[] nums = {1,2,0};
        sortColors(nums);
        log.info("{}",Arrays.toString(nums));
    }
    public static void sortColors(int[] nums) {
        int i = -1;
        int j = nums.length;
        for (int k = 0; k < nums.length; k++) {
            if(k == j){
                break;
            }
            if (nums[k] == 0) {
                i++;
                swap(nums, i, k);
            }
            if (nums[k] == 2) {
                j--;
                swap(nums, j, k);
            }
        }
    }

    public static void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }


}

