package com.zbq.othor.fabonacci;

/**
 * @author zhangboqing
 * @date 2018/2/26
 *
 * 写一个函数，输入n，求斐波拉契（Fibonacci）数列的第n项。
 */
public class FabonacciDemo {

    /**
     * 第一种：效率很低的解法（递归方法，重复计算多）,挑剔的面试官不会喜欢
     *  时间复杂度是以n的指数的方式递增的
     * @param n
     * @return
     */
    public static long fabonacciOne(int n) {

        if ( n <= 0) {
            return 0;
        }

        if ( n == 1) {
            return 1;
        }

        return fabonacciOne(n - 1) + fabonacciOne(n - 2);
    }


    /**
     * 第二种：更简单的方法从下往上计算（避免重复计算，效率高），面试官期待的实用解法
     * 这种思路时间复杂度为O(n)
     * @param n
     * @return
     */
    public static long fabonacciTwo(int n) {

        int[] result = {0,1};

        if (n < 2) {
            return result[n];
        }

        long fibNMinusOne = 1;
        long fibNminusTwo = 0;
        long fibN = 0;

        for (int i = 2; i <= n; ++i) {
            fibN = fibNMinusOne + fibNminusTwo;

            fibNminusTwo = fibNMinusOne;
            fibNMinusOne = fibN;
        }

        return fibN;
    }

    //*****************************************************************************************************************

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
//        System.out.println(fabonacciOne(30));
        long end = System.currentTimeMillis();

        System.out.println(fabonacciTwo(30));
        long end2 = System.currentTimeMillis();

        System.out.println(end - start);
        System.out.println(end2 - end);

    }






}
