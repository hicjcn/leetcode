package com.jc.leetcode;

/**
 * 完美数
 *
 * 对于一个 正整数，如果它和除了它自身以外的所有正因子之和相等，我们称它为“完美数”。
 *
 * 给定一个 整数 n， 如果他是完美数，返回 True，否则返回 False
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/perfect-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author chenjian on 2019/10/21
 */
public class CheckPerfectNumber {
    public static void main(String[] args) {
        System.out.println(checkPerfectNumber(28));
    }
    public static boolean checkPerfectNumber(int num) {
        if (num == 0 || num % 2 != 0){
            return false;
        }
        final int sqrt_N = (int)Math.sqrt(num);
        int sum = 1; // 1必然是
        int r;
        for(int i = 2; i <= sqrt_N; i++){
            if(0 == num % i){
                r = num / i;
                sum += i + r ;
            }
        }
        return sum == num;
    }
}
