package com.zbq.sort.Onlogn;

import com.zbq.sort.base.CommonUtils;
import com.zbq.sort.base.SortAlgorithm;

import java.util.List;

/**
 * @author zhangboqing
 * @date 2018/1/9
 */
public class QuickSortAlgorithm extends SortAlgorithm {

    public QuickSortAlgorithm() {
        setSortName("快速排序");
    }


    public static <T extends Comparable> void quickSort(List<T> arr) {

        quickSort(arr,0,arr.size()-1);
    }


    private static <T extends Comparable> void quickSort(List<T> arr,Integer left,Integer right) {

        if (left >= right) {
            return;
        }

        Integer p = partition(arr,left,right);
        quickSort(arr,left,p);
        quickSort(arr,p+1,right);
    }

    private static <T extends Comparable> Integer partition(List<T> arr, Integer left, Integer right) {

        T middleValue = arr.get(left);
        int j = left;
        for (int i = left +1; i <= right; i++) {
            if (arr.get(i).compareTo(middleValue) < 0) {
                j++;
                CommonUtils.swap(arr,j,i);
            }
        }
        CommonUtils.swap(arr,left,j);

        return j;
    }

    @Override
    public <T extends Comparable> void sort(List<T> arr) {
        QuickSortAlgorithm.quickSort(arr);
    }

    public static void main(String[] args) {
        QuickSortAlgorithm quickSortAlgorithm = new QuickSortAlgorithm();
        List<Integer> arr = CommonUtils.generateIntRandomArray(100, 0, 1000);
        CommonUtils.testSortTime(arr,quickSortAlgorithm);
        assert CommonUtils.isAscSorted(arr);
    }
}
