package com.wayne;

import java.util.Arrays;

/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * https://leetcode.cn/problems/remove-element/
 *
 * @author wayne
 */
public class RemoveElement {
    public static void main(String[] args) {
        RemoveElement remove = new RemoveElement();
        int[] arr = {3, 2, 2, 3};
        int val = 3;
        System.out.println("原数组："+Arrays.toString(arr));
        System.out.println("需要对比的数值："+val);
        System.out.println(remove.removeElementB(arr, val));
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 暴力法，遇到匹配的元素就用下一个元素的值覆盖当前元素
     * 覆盖完要重置元素的长度，和当前遍历的位置
     */
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        if(len==0){
            return 0;
        }
        int i;
        for (i = 0; i < len; i++) {
            if(nums[i]==val){
                for (int j = i; j < len-1; j++) {
                    nums[j] = nums[j+1];
                }
                i--;
                len--;
            }
        }
        return i;
    }

    /**
     * 双指针法
     */
    public int removeElementA(int[] nums, int val) {
        int len = nums.length;
        if(len == 0){
            return 0;
        }
        // 指向所有和val不同的元素
        int slow = 0;
        for (int fast = 0; fast < len; fast++) {
            // 相当于跳过相等的元素
            if(nums[fast] != val){
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }


    /**
     * 双指针优化，从数组的两头往中间遍历，最多遍历一遍数组，不会重复遍历
     */
    public int removeElementB(int[] nums, int val) {
        int len = nums.length;
        if(len == 0){
            return 0;
        }
        // 指向所有和val不同的元素
        int left = 0;
        int right = len;
        while (left < right){
            // 如果左边元素的和val相等，就把右边的元素放到左边，然后继续对比
            if(nums[left]==val){
                nums[left] = nums[right-1];
                // 右指针往左边移动一
                right--;
            } else {
                //不一样的话，左指针就继续往右边移动
                left++;
            }
        }
        return left;
    }

}
