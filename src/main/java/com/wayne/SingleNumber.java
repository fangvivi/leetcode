package com.wayne;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/single-number/
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素
 * @author wayne
 */
public class SingleNumber {
    public static void main(String[] args) {
        int[] arr = {2,2,3,4,5,3,4,5,8,9,8};
        System.out.println(singleNumberA(arr));
    }

    /**
     * 1、把所有元素和出现的次数保存在map中
     * 2、遍历map，获取value为1的元素
     */
    public static int singleNumber(int[] nums) {
        final int length = nums.length;
        Map<Integer, Integer> numCount = new HashMap<>(length);
        for (final int num : nums) {
            if (numCount.containsKey(num)) {
                Integer count = numCount.get(num);
                count++;
                numCount.put(num, count);
            } else {
                numCount.put(num, 1);
            }
        }
        for (int num : nums) {
            final Integer count = numCount.get(num);
            if (count == 1) {
                return num;
            }
        }
        return 0;
    }

    public static int singleNumberA(int[] nums){
        int single = 0;
        for (int num : nums) {
            single = single ^ num;
        }
        return single;
    }
}
