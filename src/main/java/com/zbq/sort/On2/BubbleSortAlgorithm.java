package com.zbq.sort.On2;

import com.zbq.sort.base.CommonUtils;
import com.zbq.sort.base.SortAlgorithm;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author zhangboqing
 * @date 2018/1/3
 */
public class BubbleSortAlgorithm extends SortAlgorithm {


    public BubbleSortAlgorithm() {
        setSortName("冒泡排序");
    }

    public static <T extends Comparable> void bubbleSortAlgorithm(List<T> arr) {

        if(CollectionUtils.isEmpty(arr)) {
            return;
        }

        int size = arr.size();

        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i-1; j++) {

                if (arr.get(j+1).compareTo(arr.get(j)) < 0) {
                    T temp = arr.get(j);
                    arr.set(j,arr.get(j+1));
                    arr.set(j+1,temp);
                }

            }

        }

    }

    @Override
    public <T extends Comparable> void sort(List<T> arr) {
        BubbleSortAlgorithm.bubbleSortAlgorithm(arr);
    }


    public static void main(String[] args) {
        List<Integer> arr = CommonUtils.generateIntRandomArray(10, 1, 20);
        System.out.println(arr);

        bubbleSortAlgorithm(arr);

        System.out.println(arr);

    }
}
