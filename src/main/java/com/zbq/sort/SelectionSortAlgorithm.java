package com.zbq.sort;

import com.zbq.sort.base.CommonUtils;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author zhangboqing
 * @date 2018/1/2
 * <p>
 * 选择排序
 */
public class SelectionSortAlgorithm extends SortAlgorithm {


    public SelectionSortAlgorithm() {
        setSortName("选择排序");
    }

    /**
     * 选择排序
     * @param arr
     * @param <T>
     */
    public static  <T extends Comparable> void selectionSort(List<T> arr) {

        if (CollectionUtils.isEmpty(arr)) {
            return;
        }

        int n = arr.size();
        for (int i = 0; i < n; i++) {
            //选择出最小的值
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr.get(j).compareTo(arr.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            //交换值
            T temp = arr.get(i);
            arr.set(i,arr.get(minIndex));
            arr.set(minIndex,temp);
        }

    }

    @Override
    public  <T extends Comparable> void sort(List<T> arr) {
        SelectionSortAlgorithm.selectionSort(arr);
    }


    public static void main(String[] args) {

        List<Integer> arr = CommonUtils.generateIntRandomArray(10, 10, 20);

        System.out.println(arr);

        selectionSort(arr);
        System.out.println(arr);

    }



}
