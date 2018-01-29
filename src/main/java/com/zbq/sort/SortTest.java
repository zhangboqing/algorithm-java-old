package com.zbq.sort;

import com.zbq.sort.On2.BubbleSortAlgorithm;
import com.zbq.sort.On2.InsectionSortAlgorithm;
import com.zbq.sort.On2.SelectionSortAlgorithm;
import com.zbq.sort.On2_3.ShellSortAlgorithm;
import com.zbq.sort.Onlogn.MergeSortAlgorithm;
import com.zbq.sort.base.CommonUtils;
import org.junit.Test;

import java.util.List;

/**
 * @author zhangboqing
 * @date 2018/1/3
 */
public class SortTest {

    @Test
    public void testSort() {

        SelectionSortAlgorithm selectionSortAlgorithm = new SelectionSortAlgorithm();
        InsectionSortAlgorithm insectionSortAlgorithm = new InsectionSortAlgorithm();
        BubbleSortAlgorithm bubbleSortAlgorithm = new BubbleSortAlgorithm();
        ShellSortAlgorithm shellSortAlgorithm = new ShellSortAlgorithm();
        MergeSortAlgorithm mergeSort = new MergeSortAlgorithm();

        List<Integer> arr = CommonUtils.generateIntRandomArray(10000, 0, 1000);
//        List<Integer> arr = CommonUtils.generateNearlyOrderedIntArray(10000,10);
        List<Integer> arr2 = CommonUtils.copyArray(arr);
        List<Integer> arr3 = CommonUtils.copyArray(arr);
        List<Integer> arr4 = CommonUtils.copyArray(arr);
        List<Integer> arr5 = CommonUtils.copyArray(arr);

        //测试排序性能

        CommonUtils.testSortTime(arr3, bubbleSortAlgorithm);
        CommonUtils.testSortTime(arr, selectionSortAlgorithm);
        CommonUtils.testSortTime(arr2, insectionSortAlgorithm);
        CommonUtils.testSortTime(arr4, shellSortAlgorithm);
        CommonUtils.testSortTime(arr5, mergeSort);


    }
}
