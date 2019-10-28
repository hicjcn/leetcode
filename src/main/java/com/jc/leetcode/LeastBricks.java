package com.jc.leetcode;

import java.util.*;

/**
 * 砖墙
 *
 * 你的面前有一堵方形的、由多行砖块组成的砖墙。 这些砖块高度相同但是宽度不同。你现在要画一条自顶向下的、穿过最少砖块的垂线。
 *
 * 砖墙由行的列表表示。 每一行都是一个代表从左至右每块砖的宽度的整数列表。
 *
 * 如果你画的线只是从砖块的边缘经过，就不算穿过这块砖。你需要找出怎样画才能使这条线穿过的砖块数量最少，并且返回穿过的砖块数量。
 *
 * 你不能沿着墙的两个垂直边缘之一画线，这样显然是没有穿过一块砖的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/brick-wall
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author chenjian on 2019/10/28
 */
public class LeastBricks {
    public static void main(String[] args) {

        List<List<Integer>> wall = new ArrayList<List<Integer>>();
        List<Integer> a1 = Arrays.asList(1, 2, 2, 1);
        List<Integer> a2 = Arrays.asList(3,1,2);
        List<Integer> a3 = Arrays.asList(1,3,2);
        List<Integer> a4 = Arrays.asList(2,4);
        List<Integer> a5 = Arrays.asList(3,1,2);
        List<Integer> a6 = Arrays.asList(1,3,1,1);
        wall.add(a1);
        wall.add(a2);
        wall.add(a3);
        wall.add(a4);
        wall.add(a5);
        wall.add(a6);
        System.out.println(leastBricks1(wall));
    }
    public static int leastBricks1(List<List<Integer>> wall) {
        Map<Integer, Integer> preFixSumCount = new HashMap<>();
        int maxCount = 0;
        for (List<Integer> list: wall) {
            int sum = 0;
            for (int i = 0; i < list.size() - 1; i++) {
                sum += list.get(i);
                int count = preFixSumCount.getOrDefault(sum, 0) + 1;
                preFixSumCount.put(sum, count);
                maxCount = Math.max(maxCount, count);
            }
        }
        return wall.size() - maxCount;
    }
    public static int leastBricks(List<List<Integer>> wall) {
        int y = wall.size();
        int x = wall.get(0).stream().reduce(0,Integer::sum);
        if (x == 1){
            return y;
        }
        int minThrough = Integer.MAX_VALUE;
        for (int i = 1; i < x; i++) {
            int curThrough = 0;
            for (int j = 0; j < y; j++) {
                List<Integer> row = wall.get(j);
                if (isThrough(row, i)){
                    curThrough ++;
                }
                if (curThrough >= minThrough){
                    break;
                }
            }
            if (curThrough < minThrough){
                minThrough = curThrough;
            }
        }
        return minThrough;
    }

    private static boolean isThrough(List<Integer> row, int i) {
        int edge = 0;
        for (int j = 0; j < row.size(); j++) {
            edge += row.get(j);
            if (edge == i){
                return false;
            }
            if (edge > i){
                return true;
            }
        }
        return true;
    }
}
