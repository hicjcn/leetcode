package com.jc.leetcode;

/**
 * 二进制间距
 *
 * 给定一个正整数 N，找到并返回 N 的二进制表示中两个连续的 1 之间的最长距离。
 *
 * 如果没有两个连续的 1，返回 0 。
 *
 * @author chenjian on 2019/10/8
 */
public class BinaryGap {
    public static void main(String[] args) {
        System.out.println(new BinaryGap().binaryGap(266));
    }

    public int binaryGap(int N) {
        int last = -1, ans = 0;
        for (int i = 0; i < 32; ++i) {
            if (((N >> i) & 1) > 0) {
                if (last >= 0) {
                    ans = Math.max(ans, i - last);
                }
                last = i;
            }
        }
        return ans;
    }
}
