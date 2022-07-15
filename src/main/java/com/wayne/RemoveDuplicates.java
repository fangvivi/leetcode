package com.wayne;

import java.util.Arrays;
import java.util.logging.Logger;

/**
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-array/
 *
 * @author wayne
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        Logger log = Logger.getGlobal();
        //[0,0,1,1,1,2,2,3,3,4]
        int[] arr = {0, 1, 2, 2, 3, 3, 4};
        RemoveDuplicates re = new RemoveDuplicates();
        log.info(re.removeDuplicatesA(arr)+"");
        log.info(Arrays.toString(arr));
    }

    public int removeDuplicates(int[] nums) {
        int count = 0;
        int length = nums.length;
        int end = nums[length - 1];
        for (int i = 0; i < length; i++) {
            // 如果遍历到最后的元素，结束循环
            if (nums[i] == end) {
                count++;
                return count;
            }
            if (i < length - 2) {
                // 如果一个元素重复出现3次及以上，就需要多次移动元素的位置
                while (nums[i] == nums[i + 1]) {
                    switchIndex(nums, i);
                }
                count++;
            } else {
                // 比较最后两个元素
                if (nums[length - 1] != nums[length - 2]) {
                    count += 2;
                } else {
                    count++;
                }
                return count;
            }
        }
        return count;
    }

    /**
     * 把元素往前移动一位
     */
    private void switchIndex(int[] nums, int index) {
        // 最后两个元素不用处理
        while (index != nums.length - 2) {
            // 元素往前移动一位
            nums[index + 1] = nums[index + 2];
            index++;
        }
    }

    /**
     * 双指针解法，快慢指针相当于指出了相等元素的区间
     */
    public int removeDuplicatesA(int[] nums){
        int length = nums.length;
        if(length == 0){
            return 0;
        }
        int fast = 1;
        int slow = 1;
        while (fast < length){
            // 慢指针是连续相等元素的起始位置，快指针是最后的位置
            if(nums[fast] != nums[fast-1]){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

}
