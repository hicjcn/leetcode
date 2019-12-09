package com.jc.leetcode;

/**
 * 单调递增的数字
 *
 * 给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
 *
 * （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
 *
 * 示例 1:
 *
 * 输入: N = 10
 * 输出: 9
 * 示例 2:
 *
 * 输入: N = 1234
 * 输出: 1234
 * 示例 3:
 *
 * 输入: N = 332
 * 输出: 299
 * 说明: N 是在 [0, 10^9] 范围内的一个整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/monotone-increasing-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chenjian on 2019/12/9
 */
public class MonotoneIncreasingDigits {
    public static void main(String[] args) {
        System.out.println(monotoneIncreasingDigits(332));
    }

    /**
     * 从右向左扫描数字，若发现当前数字比其左边一位（较高位）小，
     * 则把其左边一位数字减1，并将该位及其右边的所有位改成9
     * @param N
     * @return
     */
    public static int monotoneIncreasingDigits(int N) {
        int i = 1;
        int res = N;
        while(i <= res/10) {
            int n = res / i % 100; // 每次取两个位
            i *= 10;
            if(n/10 > n%10) // 比较的高一位大于底一位
            {
                res = res / i * i - 1; //例如1332 循环第一次变为1330-1=1329 第二次变为1300-1=1299
            }
        }
        return res;
    }
}
