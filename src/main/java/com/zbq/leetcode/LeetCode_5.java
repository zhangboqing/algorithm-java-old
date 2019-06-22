package com.zbq.leetcode;


import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zhangboqing
 * @date 2019/2/20
 * <p>
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class LeetCode_5 {



    /**暴力破解*/
    public static String longestPalindrome(String s) {

        //aba
        if (s == null || s.length() == 0) {
            return "";
        }

        //记录每个字符对应的位置
        HashMap<Character, Integer[]> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Integer[] integers = map.get(s.charAt(i));
            if (integers == null) {
                integers = new Integer[1];
                integers[0] = i;
                map.put(s.charAt(i), integers);
            } else {
                Integer[] newArray = new Integer[integers.length + 1];
                for (int j = 0; j < integers.length; j++) {
                    newArray[j] = integers[j];
                }
                newArray[integers.length] = i;
                map.put(s.charAt(i), newArray);
            }

        }

        Set<Map.Entry<Character, Integer[]>> entries = map.entrySet();
        //记录所有的区间
        List<Integer[]> intervalList = new ArrayList<>(map.size());
        for (Map.Entry<Character, Integer[]> entry : entries) {
            Integer[] indexs = entry.getValue();
            int size = indexs.length;

            for (int i = 0; i < size; i++) {
                for (int j = i + 1; j < size; j++) {
                    Integer[] startAndEndIndex = new Integer[2];
                    startAndEndIndex[0] = indexs[i];
                    startAndEndIndex[1] = indexs[j];
                    intervalList.add(startAndEndIndex);
                }
            }

        }

        //根据最大跨度倒序
        List<Integer[]> sortedIntervalList = intervalList.stream().sorted((a, b) -> {

            int startA = a[0];
            int endA = a[1];
            int subValueA = endA - startA;

            int startB = b[0];
            int endB = b[1];
            int subValueB = endB - startB;

            return subValueB - subValueA;
        }).collect(Collectors.toList());

        boolean isHaveResult = false;
        int[] lastValue = new int[2];
        //遍历求最大值

        for (Integer[] a : sortedIntervalList) {
            int startA = a[0];
            int endA = a[1];
            int subValueA = endA - startA;
            //1
            if (subValueA == 0) {
                lastValue[0] = startA;
                lastValue[1] = endA;
                isHaveResult = true;
                break;
            }

            //>1  2,3,4
            boolean isValid = true;
            int templateId = startA + (endA - startA) / 2;
            for (int i = startA; i <= templateId; i++) {
                if (s.charAt(i) != s.charAt(endA - (i - startA))) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                lastValue[0] = startA;
                lastValue[1] = endA;
                isHaveResult = true;
                break;
            }

        }

        if (!isHaveResult) {
            lastValue[0] = 0;
            lastValue[1] = 0;
        }
        int start = lastValue[0];
        return s.substring(start, lastValue[1]+1);
    }

    /**
     * 中心扩散
     * @param s
     * @return
     */
    public static String longestPalindrome2(String s) {

        if (s == null || s.length() == 0) {
            return "";
        }

        int length = s.length();

        int start = 0;
        int end = 0;
        for (int i = 0; i < length; i++) {
          int len1 = center(s,i,i);
          int len2 = center(s,i,i+1);
            int maxLen = Math.max(len1, len2);
            if (maxLen > (end - start)) {
                start = i - maxLen /2;
                end = i + (maxLen +1) /2;
            }
        }

        return s.substring(start,end+1);
    }

    private static int center(String s, int start, int end) {

        while (start >=0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        return end - start -2 ;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome2(""));
    }
}
