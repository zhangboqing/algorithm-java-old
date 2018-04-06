package com.zbq.othor;


import org.apache.commons.lang.StringUtils;

/**
 * @author zhangboqing
 * @date 2018/3/2
 *
 * 打印1到最大的n位数
 *
 * 思路方法：
 * 1.用字符串模拟加法 （大数问题）
 * 2.把问题转换成数字排列的解法，递归实现（该方式易于实现）
 */
public class Print1ToMaxOfNDigits {


    public static void print1ToMaxOfNDigits(int n) {

        if (n <= 0) {
            return;
        }

        String[] number = new String[n];
        print1ToMaxOfNDigitsRecursively(number, n, 0);
    }

    private static void print1ToMaxOfNDigitsRecursively(String[] number, int n, int index) {

        if (index == n) {
            printNumber(number);
            return;
        }

        for (int i = 0; i < 10; i++) {
            number[index] = i + "";
            print1ToMaxOfNDigitsRecursively(number, n, index + 1);
        }

    }

    private static void printNumber(String[] number) {

        boolean zeroFlag = false;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < number.length; i++) {
            if (!number[i].equals("0")) {
                zeroFlag = true;
            }

            if (zeroFlag) {
                sb.append(number[i]);
            }

        }

        if (StringUtils.isNotEmpty(sb.toString())) {
            System.out.println(sb.toString());
        }
    }


    public static void main(String[] args) {
        print1ToMaxOfNDigits(5);
    }

}
