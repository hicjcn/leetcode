package com.jc.leetcode;

/**
 * 填充书架
 *
 * 附近的家居城促销，你买回了一直心仪的可调节书架，打算把自己的书都整理到新的书架上。
 *
 * 你把要摆放的书 books 都整理好，叠成一摞：从上往下，第 i 本书的厚度为 books[i][0]，高度为 books[i][1]。
 *
 * 按顺序 将这些书摆放到总宽度为 shelf_width 的书架上。
 *
 * 先选几本书放在书架上（它们的厚度之和小于等于书架的宽度 shelf_width），然后再建一层书架。重复这个过程，直到把所有的书都放在书架上。
 *
 * 需要注意的是，在上述过程的每个步骤中，摆放书的顺序与你整理好的顺序相同。 例如，如果这里有 5 本书，那么可能的一种摆放情况是：第一和第二本书放在第一层书架上，第三本书放在第二层书架上，第四和第五本书放在最后一层书架上。
 *
 * 每一层所摆放的书的最大高度就是这一层书架的层高，书架整体的高度为各层高之和。
 *
 * 以这种方式布置书架，返回书架整体可能的最小高度。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/filling-bookcase-shelves
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author chenjian on 2019/10/28
 */
public class MinHeightShelves {
    public static void main(String[] args) {
        int[][] books = new int[][]{
                {1,1},
                {2,3},
                {2,3},
                {1,1},
                {1,1},
                {1,1},
                {1,2},
        };
        System.out.println(minHeightShelves(books,4));
    }

    /**
     * 动态规划，用 dp[i] 表示放置前 i 本书所需要的书架最小高度，初始值 dp[0] = 0，其他为最大值 1000*1000。
     * 遍历每一本书，把当前这本书作为书架最后一层的最后一本书，将这本书之前的书向后调整，
     * 看看是否可以减少之前的书架高度。状态转移方程为 dp[i] = min(dp[i] , dp[j - 1] + h)，
     * 其中 j 表示最后一层所能容下书籍的索引，h 表示最后一层最大高度。
     *
     * @param books
     * @param shelf_width
     * @return
     */
    public static int minHeightShelves(int[][] books, int shelf_width) {
        int n = books.length;
        int[] dp = new int[n + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            int tmpWidth = 0, j = i, h = 0;
            while (j > 0){
                tmpWidth += books[j - 1][0];
                if (tmpWidth > shelf_width){
                    break;
                }
                h = Math.max(h, books[j - 1][1]);
                dp[i] = Math.min(dp[i], dp[j - 1] + h);
                j --;
            }
        }
        return dp[n];
    }
}
