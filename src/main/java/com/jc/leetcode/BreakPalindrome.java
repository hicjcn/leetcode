package com.jc.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 1328. 破坏回文串
 *
 * 给你一个回文字符串 palindrome ，请你将其中 一个 字符用任意小写英文字母替换，使得结果字符串的字典序最小，且 不是 回文串。
 *
 * 请你返回结果字符串。如果无法做到，则返回一个空串。
 *
 * 示例 1：
 *
 * 输入：palindrome = "abccba"
 * 输出："aaccba"
 * 示例 2：
 *
 * 输入：palindrome = "a"
 * 输出：""
 *  
 *
 * 提示：
 *
 * 1 <= palindrome.length <= 1000
 * palindrome 只包含小写英文字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/break-a-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BreakPalindrome {

    public static void main(String[] args) {
        System.out.println(breakPalindrome("abccba"));
    }

    public static String breakPalindrome(String palindrome) {

        if (null == palindrome || palindrome.length() <= 1) {
            return "";
        }

        for (int i = 0; i < palindrome.length() / 2; i++) {
            if ('a' != palindrome.charAt(i)) {
                return palindrome.substring(0, i) + 'a' + palindrome.substring(i + 1);
            }
        }

        return palindrome.substring(0, palindrome.length() - 1) + 'b';
    }
}
