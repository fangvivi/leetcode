package com.wayne;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/two-sum/
 * @author wayne
 */
public class TwoSum {
    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] nums = {1, 3, 6, 11};
        int target = 9;
        System.out.println(Arrays.toString(twoSum.twoSumHashMap(nums, target)));
    }

    /**
     * 暴力枚举法，把遍历数组，判断任意两个元素的和是否等于target
     */
    public int[] twoSum(int[] nums, int target) {
        int[] out = new int[2];
        for(int i = 0; i < nums.length; i++){
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i] + nums[j]==target){
                    out[0] = i;
                    out[1] = j;
                }
            }
        }
        return out;
    }

    /**
     * 如果数组中存在满足两数之和的情况，那两个元素必然都会保存在map中
     */
    public int[] twoSumHashMap(int[] nums, int target){
        int[] out = new int[2];
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        // 遍历数组，把所有元素放进map中
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])){
                out[0] = map.get(target-nums[i]);
                out[1] = i;
                return out;
            }
            map.put(nums[i], i);
        }
        return out;
    }
}
