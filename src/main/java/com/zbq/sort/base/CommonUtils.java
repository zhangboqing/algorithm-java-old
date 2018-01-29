package com.zbq.sort.base;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
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
     * 交换数组中的两个值
     * @param arr
     * @param i
     * @param j
     * @param <T>
     */
    public static <T> void swap(List<T> arr,Integer i,Integer j) {
        T temp = arr.get(i);
        arr.set(i,arr.get(j));
        arr.set(j,temp);
    }


    /**
     * copy数组
     * @param arr
     * @param <T>
     * @return
     */
    public static <T> List<T> copyArray(List<T> arr) {

        ArrayList<T> newArr = new ArrayList<>();
        newArr.addAll(arr);
        return newArr;
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

        for (int i = 0; i < arr.size() - 1; i++) {
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
        System.out.println(arr);
        long startTime = System.currentTimeMillis();
        sortAlgorithm.sort(arr);
        long endTime = System.currentTimeMillis();
        System.out.println(sortAlgorithm.getSortName() + ": " + (endTime - startTime)  + "ms");
        System.out.println(arr);
    }

    /**
     * 随机获取值
     * @param left
     * @param right
     * @return
     */
    public static Integer getRandomValue(Integer left,Integer right) {

        Random random = new Random();
        return random.nextInt(right-left+1) + left;
    }

    /**
     * 计算数据的逆序对数量
     * @param arr
     * @param <T>
     * @return
     */
    public static <T extends Comparable> Integer countInversion(List<T> arr) {
        Integer count = 0 ;

        if (CollectionUtils.isEmpty(arr)) {
            return count;
        }
        int size = arr.size();
        for (int i = 1; i < size ; i++) {
            for (int j = i-1; j >= 0 ; j--) {
                if (arr.get(i).compareTo(arr.get(j)) < 0) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
//        SelectionSortAlgorithm selectionSortAlgorithm = new SelectionSortAlgorithm();
//        InsectionSortAlgorithm insectionSortAlgorithm = new InsectionSortAlgorithm();
//
        List<Integer> arr = generateIntRandomArray(15, 0, 1000000000);
//        Integer[] tempArr = new Integer[arr.size()];
//        System.arraycopy(arr.toArray(),0,tempArr,0,arr.size());
//        List<Integer> arr2 = Arrays.asList(tempArr);
//
//        testSortTime(arr, selectionSortAlgorithm);
//        testSortTime(arr2, insectionSortAlgorithm);


//        ArrayList<Integer> arr = new ArrayList<>();
//        arr.add(1);
//        arr.add(2);
//        System.out.println(arr);
////        swap(arr,0,1);
//        List<Integer> newArr = copyArray(arr);
//        System.out.println(newArr);
//        Assert.isTrue(1==2,"1");

//        System.out.println(getRandomValue(0,1));
        System.out.println(arr);
        Integer countInversion = countInversion(arr);
        System.out.println(countInversion);

    }
}
