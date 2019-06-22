package com.zbq.leetcode;

/**
 * @author zhangboqing
 * @date 2019/2/20
 */
public class LeetCode_4 {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1 == null || nums2 == null) {
            return -1;
        }

        int length1 = nums1.length;
        int length2 = nums2.length;
        //区分奇数、偶数
        int length = length1 + length2;
        //是否是奇数
        boolean isOddNumber = length % 2 == 1 ? true : false;
        int middleIndex = length / 2;

        int temp11 = -1;
        int temp12 = -1;
        int temp21 = -1;
        int temp22 = -1;
        int m1 = 0;
        int m2 = 0;
        for (int i = 0; i <= middleIndex;i ++) {

            if ((m1 < length1) &&
                    ( ( m2 >= length2) ||
                    (nums1[m1] <= nums2[m2]))) {
                if (i == (middleIndex -1) && !isOddNumber){
                    if (temp11 == -1) {
                        temp11 = m1;
                    } else {
                        temp12 = m1;
                    }
                }

                if (i == middleIndex) {
                    if (temp11 == -1) {
                        temp11 = m1;
                    } else {
                        temp12 = m1;
                    }
                }

                m1++;
            } else {

                if (i == (middleIndex -1) && !isOddNumber){
                    if (temp21 == -1) {
                        temp21 = m2;
                    } else {
                        temp22 = m2;
                    }
                }

                if (i == middleIndex) {
                    if (temp21 == -1) {
                        temp21 = m2;
                    } else {
                        temp22 = m2;
                    }
                }

                m2++;
            }
        }


        double result = 0;
        if (temp11 != -1) {
            result += nums1[temp11];
        }
        if (temp12 != -1) {
            result += nums1[temp12];
        }
        if (temp21 != -1) {
            result += nums2[temp21];
        }
        if (temp22 != -1) {
            result += nums2[temp22];
        }

        if (!isOddNumber) {
            result = result / 2;
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        double medianSortedArrays = findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);
    }
}
