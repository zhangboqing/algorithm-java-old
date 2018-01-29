package com.zbq.sort.On2_3;

import com.zbq.sort.base.CommonUtils;
import com.zbq.sort.base.SortAlgorithm;
import org.junit.Test;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhangboqing
 * @date 2018/1/3
 * <p>
 * 希尔排序 属于插入排序的一种
 */
public class ShellSortAlgorithm extends SortAlgorithm {

    public ShellSortAlgorithm() {
        setSortName("希尔排序");
    }

    public static <T extends Comparable> void shellSortAlgorithm(List<T> arr) {

        if (CollectionUtils.isEmpty(arr)) {
            return;
        }

        int size = arr.size();

        int h = 1;
        while (h < size / 3) {
            // 计算 increment sequence: 1, 4, 13, 40, 121, 364, 1093...
            h = h * 3 + 1;
        }

        while (h >= 1) {
            // h-sort the array
            for (int i = h; i < size; i++) {
                // 对 arr[i], arr[i-h], arr[i-2*h], arr[i-3*h]... 使用插入排序
                T e = arr.get(i);
                int j;
                for (j = i; j >= h && arr.get(j - h).compareTo(e) > 0; j = j - h) {
                    arr.set(j, arr.get(j - 1));
                }
                arr.set(j, e);


            }
            h = h / 3;
        }


    }

    public static <T extends Comparable> void shellSortAlgorithm2(List<T> arr) {

        if (CollectionUtils.isEmpty(arr)) {
            return;
        }

        int size = arr.size();

        int h = 1;
        while (h < size / 3) {
            // 计算 increment sequence: 1, 4, 13, 40, 121, 364, 1093...
            h = h * 3 + 1;
        }

        while (h >= 1) {
            // h-sort the array
            for (int i = 0; i < h; i++) {

                for (int j = i; j < size; j += h) {
                    T e = arr.get(j);
                    int k;
                    for (k = j; k - h >= 0 && arr.get(k - h).compareTo(e) > 0; k -= h) {
                        arr.set(k, arr.get(k - h));
                    }
                    arr.set(k, e);
                }

            }
            h = h / 3;
        }


    }

    @Override
    public <T extends Comparable> void sort(List<T> arr) {
        ShellSortAlgorithm.shellSortAlgorithm(arr);
    }

    public static void main(String[] args) {
        List<Integer> arr = CommonUtils.generateIntRandomArray(1000, 1, 100);
        Integer[] tempArr = new Integer[arr.size()];
        System.arraycopy(arr.toArray(),0,tempArr,0,arr.size());
        List<Integer> arr2 = Arrays.asList(tempArr);


        System.out.println(arr);
        System.out.println(arr.size());
        long startTime = System.currentTimeMillis();
        shellSortAlgorithm2(arr);
        long endTime = System.currentTimeMillis();
        System.out.println(arr);
        System.out.println(arr.size());
        System.out.println( (endTime - startTime)  + "ms");

        System.out.println(arr2);
        System.out.println(arr2.size());
        long startTime2 = System.currentTimeMillis();
        shellSortAlgorithm(arr2);
        long endTime2 = System.currentTimeMillis();
        System.out.println(arr2);
        System.out.println(arr2.size());
        System.out.println( (endTime2 - startTime2)  + "ms");

//        long startTime2 = System.currentTimeMillis();
//        shellSortAlgorithm2(arr2);
//        long endTime2 = System.currentTimeMillis();
//        System.out.println( (endTime2 - startTime2)  + "ms");
//
//        System.out.println(arr);
//        System.out.println(arr2);

//        Assert.isTrue(CommonUtils.isAscSorted(arr));
//        Assert.isTrue(CommonUtils.isAscSorted(arr2));
    }

    @Test
    public void runTest() {

        List<Integer> arr = CommonUtils.generateIntRandomArray(1000, 1, 100);
        List<Integer> newArr = CommonUtils.copyArray(arr);


        System.out.println(arr);
        long startTime = System.currentTimeMillis();
        shellSortAlgorithm2(arr);
        long endTime = System.currentTimeMillis();
        System.out.println(arr);
        System.out.println( (endTime - startTime)  + "ms");


        newArr.add(1);
        System.out.println(newArr);
        long startTime2 = System.currentTimeMillis();
        shellSortAlgorithm(newArr);
        long endTime2 = System.currentTimeMillis();
        System.out.println(newArr);
        System.out.println( (endTime2 - startTime2)  + "ms");
    }
}
