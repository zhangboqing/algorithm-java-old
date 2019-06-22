package com.zbq.leetcode;

/**
 * @author zhangboqing
 * @date 2019/2/20
 */
public class LeetCode_20190220_1 {

    public static int[] generateFabonacci(int n) {
        int[] temp = new int[n];
        temp[0] = 1;
        temp[1] = 1;
        for(int i = 2; i < n; i++) {
            temp[i] = temp[i-1] + temp[i-2];
        }

        return temp;
    }

    public static void main(String[] args) {
//        int[] ints = generateFabonacci(10);
//        for (int v : ints) {
//            System.out.println(v);
//        }

        String s = Long.toUnsignedString(10,2);
        System.out.println(s);


    }
}
