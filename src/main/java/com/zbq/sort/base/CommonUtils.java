package com.zbq.sort.base;

import com.zbq.sort.On2.InsectionSortAlgorithm;
import com.zbq.sort.On2.SelectionSortAlgorithm;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author zhangboqing
 * @date 2018/1/2
 */
public class CommonUtils {

    /**
     * 交换两个值
     * 由于java中都是值传递 此方法无效
     *
     * @param t1
     * @param t2
     * @param <T>
     */
    public static <T> void swap(T t1, T t2) {
        T tmp = t1;
        t1 = t2;
        t2 = tmp;
        System.out.println("t1=" + t1);
        System.out.println("t2=" + t2);
    }


    /**
     * 生成有n个元素的随机数组,每个元素的随机范围为[rangeL, rangeR]
     */
    public static List<Integer> generateIntRandomArray(Integer n, Integer rangeL, Integer rangeR) {
        ArrayList<Integer> arr = new ArrayList<>();

        Random random = new Random();
        for (int i = 0; i < n; i++) {
            arr.add(random.nextInt(rangeR - rangeL + 1) + rangeL);
        }
        return arr;
    }

    /**
     * 是否有序 从小到大
     *
     * @param arr 数组
     * @param <T>
     * @return
     */
    public static <T extends Comparable> boolean isAscSorted(List<T> arr) {

        if (CollectionUtils.isEmpty(arr)) {
            return false;
        }

        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).compareTo(arr.get(i + 1)) > 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * 获取近似排序的数组
     *
     * @param n         数组大小
     * @param swapTimes 打乱次数
     */
    public static List<Integer> generateNearlyOrderedIntArray(Integer n, Integer swapTimes) {
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(i);
        }

        Random random = new Random();
        for (int i = 0; i < swapTimes; i++) {

            int posx = random.nextInt(n);
            int posy = random.nextInt(n);

            int temp = arr.get(posx);
            arr.set(posx,arr.get(posy));
            arr.set(posy,temp);
        }

        return arr;
    }




    /**
     * 测试排序时间
     *
     * @param arr           数组
     * @param sortAlgorithm 排序算法
     * @param <T>
     */
    public static <T extends Comparable> void testSortTime(List<T> arr, SortAlgorithm sortAlgorithm) {

        long startTime = System.currentTimeMillis();
        sortAlgorithm.sort(arr);
        long endTime = System.currentTimeMillis();
        System.out.println(sortAlgorithm.getSortName() + ": " + (endTime - startTime)  + "ms");
        System.out.println(arr);
    }

    public static void main(String[] args) {
        SelectionSortAlgorithm selectionSortAlgorithm = new SelectionSortAlgorithm();
        InsectionSortAlgorithm insectionSortAlgorithm = new InsectionSortAlgorithm();

        List<Integer> arr = generateIntRandomArray(10, 0, 5);
        Integer[] tempArr = new Integer[arr.size()];
        System.arraycopy(arr.toArray(),0,tempArr,0,arr.size());
        List<Integer> arr2 = Arrays.asList(tempArr);

        testSortTime(arr, selectionSortAlgorithm);
        testSortTime(arr2, insectionSortAlgorithm);

    }
}
