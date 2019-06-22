package com.zbq.leetcode;

/**
 * @author zhangboqing
 * @date 2019/2/20
 */
public class LeetCode_3 {

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        //标记不重复字符串的起始下标
        int startIndex = 0;
        int endIndex = 0;
        int maxLength = 1;

        char[] chars = s.toCharArray();
        for (int i = 1; i < chars.length; i ++) {
            int jMax = endIndex;
            for (int j = startIndex; j <= jMax; j++) {
                if (chars[j] == chars[i]) {
                    startIndex = j + 1;
                    endIndex++;
                    break;
                }

                if (j == jMax) {
                    endIndex++;
                }
            }

            int i1 = endIndex - startIndex + 1;
            if (i1 > maxLength) {
                maxLength = i1;
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abadcad"));
    }
}
