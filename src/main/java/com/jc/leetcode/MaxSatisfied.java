package com.jc.leetcode;

/**
 * 爱生气的书店老板
 * <p>
 * 今天，书店老板有一家店打算试营业 customers.length 分钟。每分钟都有一些顾客（customers[i]）会进入书店，所有这些顾客都会在那一分钟结束后离开。
 * <p>
 * 在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。 当书店老板生气时，那一分钟的顾客就会不满意，不生气则他们是满意的。
 * <p>
 * 书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 X 分钟不生气，但却只能使用一次。
 * <p>
 * 请你返回这一天营业下来，最多有多少客户能够感到满意的数量。
 *  [1,7,6,10,10,5,1,3]
 * [0,0,1,0,0,0,1,1]
 * 2
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/grumpy-bookstore-owner
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chenjian on 2019/10/22
 */
public class MaxSatisfied {
    public static void main(String[] args) {
        int[] customers = new int[]{4, 10, 10};
        int[] grumpy = new int[]{1, 1, 0};
        System.out.println(maxSatisfied(customers, grumpy, 2));
    }

    public static int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int temp = 0;
        int sum = 0;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                sum += customers[i];
            }
        }
        for (int j = 0; j < X; j++) {
            if (grumpy[j] == 1) {
                temp += customers[j];
            }
        }
        int max = temp;
        for (int i = 1; i <= (customers.length - X); i++) {
            if (grumpy[i - 1] == 1) {
                temp -= customers[i - 1];
            }
            if (grumpy[i + X - 1] == 1) {
                temp += customers[i + X - 1];
            }
            if (temp > max) {
                max = temp;
            }
        }
        return max + sum;
    }
}
