package com.leetcode.problems;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description
 *      在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 *
 *          示例:
 *
 *          输入:
 *
 *          1 0 1 0 0
 *          1 0 1 1 1
 *          1 1 1 1 1
 *          1 0 0 1 0
 *
 *          输出: 4
 *
 *          来源：力扣（LeetCode）
 *          链接：https://leetcode-cn.com/problems/maximal-square
 *          著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author chengc
 * @Date 2020/5/6 15:25
 */
public class N0221 {



    public int maximalSquare(char[][] matrix) {
        return matrix_x_y(matrix,0,0);
    }

    private int matrix_x_y(char[][] matrix, int i, int i1) {

        return 0;
    }

    public static void main(String[] args) {
        N0221 n0221 = new N0221();
        Scanner sc = new Scanner(System.in);
        int MAX = sc.nextInt();
        String input = null;
        char[][] matrix = new char[MAX][MAX];
        for (int i = 0; i < MAX; i++) {
            for (int j = 0; j < MAX; j++) {
                matrix[j][i]  = (char) (sc.nextInt()+'0');
            }
        }
        ArrayList<char[]> chars = Lists.newArrayList(matrix);
//        n0221.maximalSquare(matrix);

    }

}
