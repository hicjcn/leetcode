package com.jc.leetcode;

/**
 * 最小差值 I
 *
 * 给定一个整数数组 A，对于每个整数 A[i]，我们可以选择任意 x 满足 -K <= x <= K，并将 x 加到 A[i] 中。
 *
 * 在此过程之后，我们得到一些数组 B。
 *
 * 返回 B 的最大值和 B 的最小值之间可能存在的最小差值。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/smallest-range-i
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author chenjian on 2019/10/24
 */
public class SmallestRangeI {
    public static void main(String[] args) {
        int[] A = new int[]{1,3,6};
        int K = 3;
        System.out.println(smallestRangeI(A, K));
    }
    public static int smallestRangeI(int[] A, int K) {
        int max = A[0], min = A[0];
        for (int i = 1; i < A.length; i++) {
            if (A[i] >= max){
                max = A[i];
            }
            if (A[i] <= min){
                min = A[i];
            }
        }
        int result = max - min - 2 * K;
        return Math.max(result, 0);
    }
}
