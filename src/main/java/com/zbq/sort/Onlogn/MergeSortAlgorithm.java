package com.zbq.sort.Onlogn;

import com.zbq.sort.On2.InsectionSortAlgorithm;
import com.zbq.sort.base.CommonUtils;
import com.zbq.sort.base.SortAlgorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangboqing
 * @date 2018/1/9
 */
public class MergeSortAlgorithm extends SortAlgorithm {


    public MergeSortAlgorithm() {
        setSortName("归并排序");
    }

    /**
     * 归并排序
     *
     * @param arr
     * @param <T>
     */
    public static <T extends Comparable> void mergeSort(List<T> arr) {

        mergeSort(arr, 0, arr.size() - 1);
    }

    /**
     * @param arr
     * @param left  数组左下标
     * @param right 右下标
     * @param <T>
     */
    public static <T extends Comparable> void mergeSort(List<T> arr, Integer left, Integer right) {

        if (left >= right) {
            return;
        }

        int middle = (left + right) / 2;
        mergeSort(arr, left, middle);
        mergeSort(arr, middle + 1, right);
        merge(arr, left, middle, right);
    }

    /** 插入排序进行优化*/
    // 递归使用归并排序,对arr[l...r]的范围进行排序
    public static <T extends Comparable> void mergeSort2(List<T> arr, Integer left, Integer right) {

        //对于小规模数组,使用插入排序
        if ((right - left) < 15) {
            InsectionSortAlgorithm.insectionSort(arr,left,right);
        }

        int middle = (left + right) / 2;
        mergeSort(arr, left, middle);
        mergeSort(arr, middle + 1, right);

        // 对于arr[mid] <= arr[mid+1]的情况,不进行merge
        // 对于近乎有序的数组非常有效,但是对于一般情况,有一定的性能损失
        if (arr.get(middle).compareTo(arr.get(middle+1)) > 0) {
            merge(arr, left, middle, right);
        }
    }

    /**
     * 归并
     *
     * @param arr
     * @param left
     * @param middle
     * @param right
     * @param <T>
     */
    private static <T extends Comparable> void merge(List<T> arr, Integer left, int middle, Integer right) {

        ArrayList<T> temArr = new ArrayList<>();
        temArr.addAll(arr);

        int i = left; //左索引
        int j = middle + 1; //右索引
        int index; //代码原数组待插入的位置

        for (index = left; index <= right; index++) {
            if (i > middle) {
                arr.set(index, temArr.get(j++));
            } else if (j > right) {
                arr.set(index, temArr.get(i++));
            } else if (temArr.get(i).compareTo(temArr.get(j)) <= 0) {
                arr.set(index, temArr.get(i++));
            } else {
                arr.set(index, temArr.get(j++));
            }
        }

    }


    @Override
    public <T extends Comparable> void sort(List<T> arr) {
        MergeSortAlgorithm.mergeSort(arr);
    }

    public static void main(String[] args) {
        List<Integer> arr = CommonUtils.generateIntRandomArray(20, 0, 100);
        MergeSortAlgorithm mergeSort = new MergeSortAlgorithm();

        CommonUtils.testSortTime(arr,mergeSort);

    }

}
