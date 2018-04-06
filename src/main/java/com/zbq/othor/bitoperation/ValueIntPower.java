package com.zbq.othor.bitoperation;

/**
 * @author zhangboqing
 * @date 2018/2/28
 *
 * 求数值的整数次方
 */
public class ValueIntPower {

    //true 有异常 false 没异常

    private static boolean INVALID_INPUT_FLAG = false;

    /**
     *
     *
     * @param base
     * @param exponent
     * @return
     */
    public static double valueIntPower1(double base,int exponent) {

        double result = 1.0;

        if (base == 0 && exponent < 0) {
            INVALID_INPUT_FLAG = true;
            return 0.0;
        }

        int abExponent = exponent;
        if (exponent < 0) {
            abExponent = -exponent;
        }

        result = powerWithUnsignedExponent(base,abExponent);
        if (exponent < 0) {
            result = 1.0/result;
        }

        return result;
    }



    /**
     * 第一种：全面但不高效的解法
     * @param base
     * @param abExponent
     * @return
     */
    private static double powerWithUnsignedExponent(double base, int abExponent) {

        double result = 1.0;
        for (int i = 0; i < abExponent; i++) {
            abExponent *= base;
        }

        return result;
    }


    /**
     * 第二种：全面又高效的解法 (递归)
     * @param base
     * @param abExponent
     * @return
     */
    private static double powerWithUnsignedExponent2(double base, int abExponent) {

        if (abExponent == 0) {
            return 1.0;
        }

        if(abExponent == 1) {
            return base;
        }

        double result = powerWithUnsignedExponent2(base,abExponent >> 1);
        result *= base;
        if ((abExponent & 1) != 0) {
            result *= base;
        }

        return result;
    }

    public static void main(String[] args) {

//        System.out.println(Math.pow(2,-2));
//
//        System.out.println(valueIntPower1(0,-2));
//        System.out.println(INVALID_INPUT_FLAG);

        System.out.println(3>>1);
    }
}
