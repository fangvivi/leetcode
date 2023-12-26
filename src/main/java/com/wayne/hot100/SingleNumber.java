package com.wayne.hot100;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 只出现一次的数字
 * 给你一个非空整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
 * <a href="https://leetcode.cn/problems/single-number/description/?envType=study-plan-v2&envId=top-100-liked">链接</a>
 * @author waine
 * @date 2023-12-26 10:26
 */
public class SingleNumber {
    public void test(){
        int[] nums = {4,1,2,1,2};
        assertEquals(4,singleNumber(nums));
    }
    public static int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            // 任何数和 0 做异或运算，结果还是原来的数
            // 任何数和自身做异或运算，结果是0
            // 异或运算是不进位的加法
            single = single ^ num;
        }
        return single;
    }
}
