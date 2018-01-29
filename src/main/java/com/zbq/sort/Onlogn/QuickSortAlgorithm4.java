package com.zbq.sort.Onlogn;

import com.zbq.sort.On2.InsectionSortAlgorithm;
import com.zbq.sort.base.CommonUtils;
import com.zbq.sort.base.SortAlgorithm;

import java.util.List;

/**
 * @author zhangboqing
 * @date 2018/1/9
 *
 * 插入排序进行优化
 */
public class QuickSortAlgorithm4 extends SortAlgorithm {

    public QuickSortAlgorithm4() {
        setSortName("快速排序");
    }


    public static <T extends Comparable> void quickSort3Ways(List<T> arr) {

        quickSort3Ways(arr,0,arr.size()-1);
    }


    private static <T extends Comparable> void quickSort3Ways(List<T> arr,Integer left,Integer right) {

        //TODO:数组长度小于或等于15时，采用插入排序进行优化
        if (right - left <= 15) {
            InsectionSortAlgorithm.insectionSort(arr,left,right);
            return;
        }

        //TODO:随机获取中间值
        CommonUtils.swap(arr,left,CommonUtils.getRandomValue(left,right));
        T middleValue = arr.get(left);

        //TODO
        int lt = left;          // arr[l+1...lt] < v
        int gt = right + 1;     // arr[gt...r] > v
        int i = left +1;        // arr[lt+1...i) == v
        while (i < gt) {

            if (arr.get(i).compareTo(middleValue) < 0) {
                lt++;
            }else if (arr.get(i).compareTo(middleValue) > 0) {
                gt--;
            }

            i++;
        }

        CommonUtils.swap(arr,left,lt);
        quickSort3Ways(arr,left,lt-1);
        quickSort3Ways(arr,gt,right);
    }



    @Override
    public <T extends Comparable> void sort(List<T> arr) {
        QuickSortAlgorithm4.quickSort3Ways(arr);
    }

    public static void main(String[] args) {
        QuickSortAlgorithm4 quickSortAlgorithm = new QuickSortAlgorithm4();
        List<Integer> arr = CommonUtils.generateIntRandomArray(100, 0, 1000);
        CommonUtils.testSortTime(arr,quickSortAlgorithm);
        assert CommonUtils.isAscSorted(arr);
    }
}
