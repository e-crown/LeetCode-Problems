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

    private static int[][] MAX_SQUARE;
    private static int Max = 0;

    public int maximalSquare(char[][] matrix) {
         if(matrix == null || matrix.length == 0 ) return 0;
         MAX_SQUARE = new int[matrix.length][matrix[0].length];

        for (int x = 0; x < matrix.length; x++) {

            for (int y = 0; y < matrix[0].length; y++) {

                if( matrix[x][y] == '0'){
                    continue;
                }
                for (int k = 1; k < matrix[0].length - y && k < matrix.length - x; k++) {
                    if(isOne(matrix,x,y,k)){
                        Max = Math.max(Max,(MAX_SQUARE[x][y] = k));
                    }else {
                        break;
                    }
                }

            }
        }
        return (Max+1)*(Max+1);
    }


    private boolean isOne(char[][] matrix,int i,int j,int K) {
        boolean isOne = true;
        for (int x = 0; x <= K; x++) {
            if(matrix[i+x][j+K]  == '0') {
                isOne = false;
                break;
            }
        }
        for (int y = 0; isOne && y <= K; y++) {
            if(matrix[i+K][j+y]  == '0') {
                isOne = false;
                break;
            }
        }
        return isOne;
    }

    public static void main(String[] args) {
        N0221 n0221 = new N0221();
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();

        char[][] matrix = new char[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j]  = (char)(sc.nextInt()+'0');
            }
        }
        Max = n0221.maximalSquare(matrix);

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print((MAX_SQUARE[i][j]+" "));
            }
            System.out.println();
        }
        System.out.println("Max="+Max);
    }

}
