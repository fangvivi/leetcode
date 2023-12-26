package com.wayne.hot100;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 多数元素
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <a href="https://leetcode.cn/problems/majority-element/description/?envType=study-plan-v2&envId=top-100-liked">链接</a>
 * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 * @author waine
 * @date 2023-12-26 15:26
 */
public class MajorityElement {
    @Test
    public void test(){
        int[] nums = {2,2,1,1,1,2,2};
        assertEquals(2, majorityElement3(nums));
    }


    /**
     * 摩尔投票算法，空间复杂度是 O(1)
     */
    public static int majorityElement3(int[] nums){
        int candidate = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if(count == 0){
                candidate = nums[i];
                count = 1;
            } else {
                if(candidate == nums[i]){
                    count++;
                } else {
                    count--;
                }
            }
        }
        return candidate;
    }


    /**
     * 数组排序之后，中间的元素一定是多数元素
     */
    public static int majorityElement2(int[] nums){
        Arrays.sort(nums);
        return nums[nums.length /2];
    }

    /**
     * 使用hash来记录元素的出现次数
     */
    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if(map.containsKey(num)){
                map.put(num, map.get(num) +1);
            } else {
                map.put(num, 1);
            }
        }
        int length = nums.length;
        Set<Integer> keySet = map.keySet();
        for (Integer key : keySet) {
            Integer value = map.get(key);
            if(value > length / 2){
                return key;
            }
        }
        return 1;
    }
}
