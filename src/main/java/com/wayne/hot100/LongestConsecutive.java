package com.wayne.hot100;


import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 最长连续序列
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * <a href="https://leetcode.cn/problems/longest-consecutive-sequence/description/?envType=study-plan-v2&envId=top-100-liked">链接</a>
 *
 * @author waine
 * @date 2023-12-25 17:25
 */
public class LongestConsecutive {

    @Test
    public void test(){
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        assertEquals(9, longestConsecutive(nums));

    }
    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int longestStreak = 0;
        for (Integer num : numSet) {
            // 如果set中没有比当前元素小的元素，当前元素就是连续序列的起始
            if(!numSet.contains(num - 1)){
                int currentNum = num;
                // 记录当前序列的长度
                int currentStreak = 1;
                while (numSet.contains(currentNum + 1)){
                    currentStreak++;
                    currentNum++;
                }
                longestStreak = Math.max(currentStreak, longestStreak);
            }
        }
        return longestStreak;
    }
}
