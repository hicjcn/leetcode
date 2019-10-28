package com.jc.leetcode;

/**
 * 搜索二维矩阵 II
 *
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 *
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * 示例:
 *
 * 现有矩阵 matrix 如下：
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 *
 * 给定 target = 20，返回 false。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author chenjian on 2019/10/28
 */
public class SearchMatrix {
    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][]{{1,1}}, 0));
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        int y = matrix.length;
        if (y == 0){
            return false;
        }
        int x = matrix[0].length;
        if (x == 0){
            return false;
        }
        int foreachLoop = Math.min(x,y);
        int i = 0;
        for (; i < foreachLoop; i++) {
            if (target < matrix[i][i]){
                for (int m = 0; m <= i; m++) {
                    if (target == matrix[i][i - m]){
                        return true;
                    } else if (target > matrix[i][i - m]){
                        break;
                    }
                }
                for (int m = 0; m <= i; m++) {
                    if (target == matrix[i - m][i]){
                        return true;
                    } else if (target > matrix[i - m][i]){
                        break;
                    }
                }
            } else if (target == matrix[i][i]){
                return true;
            }
        }
        // 多出来的X部分 先还原i位置
        if ((--i + 1) < x){
            for (int tx = i; tx < x; tx++) {
                for (int j = 0; j < y; j++) {
                    if (target == matrix[i - j][tx]) {
                        return true;
                    } else if (target > matrix[i - j][tx]) {
                        break;
                    }
                }
            }
        }
        // 多出来的Y部分
        if ((i + 1) < y){
            for (int tx = i; tx < y; tx++) {
                for (int j = 0; j < x; j++) {
                    if (target == matrix[tx][i - j]){
                        return true;
                    } else if (target > matrix[tx][i - j]){
                        break;
                    }
                }
            }
        }
        return false;
    }
}
