package com.wayne.hot100;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出和为目标值 target 的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 * <a href="https://leetcode.cn/problems/two-sum/description/?envType=study-plan-v2&envId=top-100-liked">链接</a>
 * @author waine
 * @date 2023-12-15 14:15
 */
@Slf4j
public class TwoSum {

    @Test
    public void test(){
        int[] arr = {1, 3, 5, 7, 13, 16};
        int target = 6;
        int[] result = {0, 2};
        assertEquals(Arrays.toString(result), Arrays.toString(twoSum(arr, target)));
        target = 12;
        int[] result2 = {2, 3};
        assertEquals(Arrays.toString(result2), Arrays.toString(twoSum(arr, target)));
    }
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> searched = new HashMap<>(nums.length);
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            // 使用当前元素去查找当前元素的匹配元素是否保存在HashMap中，找到的话就算满足条件
            if(searched.containsKey(num)){
                result[0] = searched.get(num);
                result[1] = i;
                return result;
            } else {
                // 没有找到匹配元素就把当前元素存起来
                searched.put(nums[i], i);
            }
        }
        return result;
    }
}
