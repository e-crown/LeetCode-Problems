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

    private  int Max = 0;

    public int maximalSquare(char[][] matrix) {

         if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;

         int M = matrix.length;
         int N = matrix[0].length;

        for (int x = 0; x < M; x++) {

            for (int y = 0; y < N; y++) {

                if( matrix[x][y] == '0'){
                    continue;
                }
                if(Max >= N - y || Max >= M - x){
                    break;
                }
                for (int k = 0; k < N - y && k < M - x  ; k++) {

                    if(isOne(matrix,x,y,k)){
                        Max = Math.max(Max,k+1);
                    }else {
                        break;
                    }
                }

            }
        }
        return Max == 0 ?0:Max*Max;
    }


    private boolean isOne(char[][] matrix,int i,int j,int K) {

        if(K == 0 && matrix[i][j] == '1' ) return true;

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
}
