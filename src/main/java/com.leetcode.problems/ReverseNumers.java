package com.leetcode.problems;
/**
 * @Description TODO
 * @Author cgc
 * @Date 2019/4/2/002 22:47
 * @Version 1.0
 */

/**
 * @Description
 *
 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

示例 1:
输入: 123
输出: 321
示例 2:

输入: -123
输出: -321
示例 3:

输入: 120
输出: 21
注意:

假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^(31 − 1)]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * @Author cgc
 * @Date 2019/4/2/002 22:47
 * @Version 1.0
 */
public class ReverseNumers {

    public int reverse(int x) {

        int n = x;
        long b = x;
        if(x < 0 ){
            b = -(long)x;
        }
        long m = 0;
        long c = 0;
        while (b != 0){
            c = b % 10;
            m = m * 10 + c;
            b /= 10;
        }

        if(n < 0){
            m = -(-m < Integer.MIN_VALUE?0:m);
        }else{
            m = m > Integer.MAX_VALUE?0:m;
        }

        return (int)m;
    }

    public static void main(String[] args) {
//        System.out.println(-(long)Integer.MIN_VALUE);
//        System.out.println(1<<31 -1 );
//        System.out.println(1056389759 > Integer.MAX_VALUE);
//        System.out.println((long)Math.abs(Integer.MIN_VALUE)/2);
        System.out.println(new ReverseNumers().reverse(-12000));
    }
}
