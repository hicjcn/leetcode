package com.jc.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

/**
 * 至少是其他数字两倍的最大数
 *
 * 在一个给定的数组nums中，总是存在一个最大元素 。
 *
 * 查找数组中的最大元素是否至少是数组中每个其他数字的两倍。
 *
 * 如果是，则返回最大元素的索引，否则返回-1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-number-at-least-twice-of-others
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author chenjian on 2019/10/28
 */
public class DominantIndex {
    public static void main(String[] args) {
        System.out.println(dominantIndex(new int[]{3,6,1,0}));
    }
    public static int dominantIndex(int[] nums) {
        int max = -1;
        int max_index = -1;
        int max_2 = -1;
        for(int i = 0;i < nums.length;i++){
            if(nums[i] > max){
                max_2 = max;
                max = nums[i];
                max_index = i;
            }else if(nums[i] > max_2 && nums[i] != max){
                max_2 = nums[i];
            }
        }

        //只有一个数字 max > -1*2 返回0
        if(max >= max_2*2){
            return max_index;
        }else {
            return -1;
        }
    }
}
