package com.zbq.sort.On2;

import com.zbq.sort.base.CommonUtils;
import com.zbq.sort.base.SortAlgorithm;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author zhangboqing
 * @date 2018/1/2
 */
public class InsectionSortAlgorithm extends SortAlgorithm {

    public InsectionSortAlgorithm() {
        setSortName("插入排序");
    }


    public static <T extends Comparable> void insectionSort(List<T> arr) {
        if (CollectionUtils.isEmpty(arr)) {
            return;
        }

        int size = arr.size();
        for (int i = 0; i < size - 1; i++) {
            //寻找元素arr[i]合适的插入位置
            //写法一
//            for (int j = i + 1; j > 0; j--) {
//                if (arr.get(j).compareTo(arr.get(j-1)) < 0) {
//                    T temp = arr.get(j-1);
//                    arr.set(j-1, arr.get(j));
//                    arr.set(j, temp);
//                } else {
//                    break;
//                }
//            }

            //写法二
//            for (int j = i + 1; j > 0 && arr.get(j).compareTo(arr.get(j - 1)) < 0; j--) {
//                T temp = arr.get(j - 1);
//                arr.set(j - 1, arr.get(j));
//                arr.set(j, temp);
//            }

            //写法三
            T temp = arr.get(i+1);
            // j保存元素e应该插入的位置
            int j;
            for (j = i + 1; j > 0 && arr.get(j-1).compareTo(temp) > 0; j--) {
               arr.set(j,arr.get(j-1));
            }

            arr.set(j,temp);
        }


    }


    public static <T extends Comparable> void insectionSort(List<T> arr,Integer left,Integer right) {
        if (CollectionUtils.isEmpty(arr)) {
            return;
        }

        for (int i = left; i < right-1; i++) {
            //写法三
            T temp = arr.get(i+1);
            // j保存元素e应该插入的位置
            int j;
            for (j = i + 1; j > 0 && arr.get(j-1).compareTo(temp) > 0; j--) {
                arr.set(j,arr.get(j-1));
            }

            arr.set(j,temp);
        }


    }

    @Override
    public <T extends Comparable> void sort(List<T> arr) {
        InsectionSortAlgorithm.insectionSort(arr);
    }


    public static void main(String[] args) {

        List<Integer> integers = CommonUtils.generateIntRandomArray(10, 1, 20);
        System.out.println(integers);
        insectionSort(integers,0,integers.size());
        System.out.println(integers);

    }
}
