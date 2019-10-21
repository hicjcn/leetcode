package com.jc.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 计算右侧小于当前元素的个数
 *
 * 给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * [10,27,10,35,12,22,28,8,19,2,12,2,9,6,12,5,17,9,19,12,14,6,12,5,12,3,0,10,0,7,8,4,0,0,4,3,2,0,1,0]
 * @author chenjian on 2019/10/12
 */
public class CountSmaller {
    public static void main(String[] args) {
        int[] data = new int[]{26,78,27,100,33,67,90,23,66,5,38,7,35,23,52,22,83,51,98,69,81,32,78,28,94,13,2,97,3,76,99,51,9,21,84,66,65,36,100,41};
        System.out.println(countSmaller(data));
    }
    public static List<Integer> countSmaller(int[] nums) {
        if (null == nums || nums.length == 0){
            return new ArrayList<Integer>();
        }
        Integer[] counts  = new Integer[nums.length];
        counts[nums.length - 1] = 0;
        int maxIndex = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            maxIndex = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]){
                    maxIndex++;
                }
                if (j == nums.length - 1 && nums[i] <= nums[j] && counts[i] == null){
                    counts[i] = 0;
                } else if (nums[i] >= nums[j]) {
                    counts[i] = counts[j] + maxIndex;
                } else if (nums[i] == nums[j]) {
                    counts[i] = counts[j] + maxIndex;
                    break;
                }
            }
        }
        return new ArrayList<Integer>(Arrays.asList(counts));
    }
}
