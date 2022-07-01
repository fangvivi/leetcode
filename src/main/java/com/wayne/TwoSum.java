package com.wayne;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/two-sum/
 * @author wayne
 */
public class TwoSum {
    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] nums = {3,3};
        int target = 6;
        System.out.println(Arrays.toString(twoSum.twoSum(nums, target)));
    }
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
}
