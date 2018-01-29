package com.zbq.sort.Onlogn;

import com.zbq.sort.On2.InsectionSortAlgorithm;
import com.zbq.sort.base.CommonUtils;
import com.zbq.sort.base.SortAlgorithm;

import java.util.List;

/**
 * @author zhangboqing
 * @date 2018/1/9
 *
 * 随机选择中间值
 */
public class QuickSortAlgorithm3 extends SortAlgorithm {

    public QuickSortAlgorithm3() {
        setSortName("快速排序");
    }


    public static <T extends Comparable> void quickSort(List<T> arr) {

        quickSort(arr,0,arr.size()-1);
    }


    private static <T extends Comparable> void quickSort(List<T> arr,Integer left,Integer right) {

        //TODO:数组长度小于或等于15时，采用插入排序进行优化
        if (right - left <= 15) {
            InsectionSortAlgorithm.insectionSort(arr,left,right);
            return;
        }

//        Integer p = partition(arr,left,right);
        Integer p = partition2(arr,left,right);
        quickSort(arr,left,p);
        quickSort(arr,p+1,right);
    }

    private static <T extends Comparable> Integer partition(List<T> arr, Integer left, Integer right) {
        //TODO:随机获取中间值
        CommonUtils.swap(arr,left,CommonUtils.getRandomValue(left,right));

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


    private static <T extends Comparable> Integer partition2(List<T> arr, Integer left, Integer right) {
        //TODO:随机获取中间值
        CommonUtils.swap(arr,left,CommonUtils.getRandomValue(left,right));

        T middleValue = arr.get(left);
        //
        int i = left + 1,j = right;
        while (true) {
            while (i <= right && arr.get(i).compareTo(middleValue) < 0) {
                i ++;
            }

            while ( j >= left+1 && arr.get(j).compareTo(middleValue) > 0) {
                j --;
            }

            if (i > j) {
                break;
            }

            CommonUtils.swap(arr,i,j);
            i++;
            j--;
        }


        CommonUtils.swap(arr,left,j);

        return j;
    }

    @Override
    public <T extends Comparable> void sort(List<T> arr) {
        QuickSortAlgorithm3.quickSort(arr);
    }

    public static void main(String[] args) {
        QuickSortAlgorithm3 quickSortAlgorithm = new QuickSortAlgorithm3();
        List<Integer> arr = CommonUtils.generateIntRandomArray(100, 0, 1000);
        CommonUtils.testSortTime(arr,quickSortAlgorithm);
        assert CommonUtils.isAscSorted(arr);
    }
}
