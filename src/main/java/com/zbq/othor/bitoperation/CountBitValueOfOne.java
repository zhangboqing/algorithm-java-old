package com.zbq.othor.bitoperation;

/**
 * @author zhangboqing
 * @date 2018/2/27
 * <p>
 * 求二进制中1的个数
 */
public class CountBitValueOfOne {

    /**
     * 第一种: 可能引起死循环的解法
     * 通过每次右移一位，来判断最右边的位是否为1
     * @param n
     * @return
     */
    public static int countBitValueOfOne(int n) {

        int count = 0;

        while (n != 0) {

            if ((n & 1) != 0) {
                count++;
            }

            n = (n >> 1);
        }

        return count;
    }

    /**
     * 第二种: 常规解法（可避免死循环）
     * 通过把1左移一位，循环的次数等于整数二进制的位数
     * @param n
     * @return
     */
    public static int countBitValueOfOne2(int n) {

        int count = 0;
        int flag = 1;

        while (flag != 0) {

            if ((n & flag) != 0) {
                count++;
            }

            flag = flag << 1;
        }

        return count;

    }

    /**
     * 第三种：能给面试官带来惊喜的解法，整数中有几个1就循环几次
     * 思路：把整数和它减去1的结果做位与运算，相当于把它最右边的1变成0
     * @param n
     * @return
     */
    public static int countBitValueOfOne3(int n) {

        int count = 0;

        while (n != 0) {
            count++;
            n = n & (n - 1);
        }

        return count;
    }


    public static void main(String[] args) {

        System.out.println(countBitValueOfOne(11));
        System.out.println(countBitValueOfOne2(11));
        System.out.println(countBitValueOfOne3(11));

    }

}
