package com.jc.leetcode;

import java.util.Arrays;

/**
 * 分糖果
 *
 * @author chenjian on 2019/10/21
 */
public class DistributeCandies {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(distributeCandies(10, 3)));
    }

    public static int[] distributeCandies(int candies, int num_people) {
        int[] ans = new int[num_people];
        int index = 0;
        int counts = 1;
        while (candies - counts >= 0) {
            ans[index++ % num_people] += counts;
            candies -= counts++;
        }
        ans[index % num_people] += candies;
        return ans;
    }
}
