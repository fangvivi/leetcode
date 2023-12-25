package com.wayne.hot100;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * <a href="https://leetcode.cn/problems/move-zeroes/?envType=study-plan-v2&envId=top-100-liked">链接</a>
 * @author waine
 * @date 2023-12-15 13:15
 */
public class MoveZeroes {
    @Test
    public void test(){
        int[] arr = {0,1,0,3,12};
        int[] movedArr = {1,3,12,0,0};
        moveZeroes(arr);
        assertEquals(Arrays.toString(movedArr),Arrays.toString(arr));
    }

    public void moveZeroes(int[] nums) {
        // 这个索引最终会指向最后一个不为0的元素，每遇到一个不为0的元素就加一
        int i = -1;
        int length = nums.length;
        for (int j = 0; j < length; j++) {
            if(nums[j] != 0){
                i++;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
    }
}
