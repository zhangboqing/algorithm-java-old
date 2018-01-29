package com.zbq.sort.Onlogn;

import com.zbq.dataStructure.IndexMaxHeap;
import com.zbq.dataStructure.MaxHeap;
import com.zbq.sort.base.CommonUtils;
import com.zbq.sort.base.SortAlgorithm;

import java.util.List;

/**
 * @author zhangboqing
 * @date 2018/1/29
 */
public class MaxHeapSortAlgorithm extends SortAlgorithm {

    public MaxHeapSortAlgorithm() {
        setSortName("最大堆排序");
    }


    public <T extends Comparable> void heapSortUsingMaxHeap(List<T> arr) {
        MaxHeap<T> maxHeap = new MaxHeap<>(arr.size());
        for (int i = 0; i < arr.size(); i++) {
            maxHeap.insert(arr.get(i));
        }

        for (int i = arr.size() - 1; i >= 0; i--) {
            arr.set(i, maxHeap.extractMax());
        }
    }

    public <T extends Comparable> void heapSortUsingMaxHeap2(List<T> arr) {

        MaxHeap<T> maxHeap = new MaxHeap<>(arr);

        for (int i = arr.size() - 1; i >= 0; i--) {
            arr.set(i, maxHeap.extractMax());
        }

    }

    public <T extends Comparable> void heapSortUsingIndexMaxHeap(List<T> arr) {
        IndexMaxHeap<T> indexMaxHeap = new IndexMaxHeap<>(arr.size());
        for (int i = 0; i < arr.size(); i++) {
            indexMaxHeap.insert(i,arr.get(i));
        }

        for (int i = arr.size() - 1; i >= 0; i--) {
            arr.set(i, indexMaxHeap.extractMax());
        }
    }

    public <T extends Comparable> void heapSort3(List<T> arr) {
        int n = arr.size();

        for (int i = (n - 1) / 2; i >= 0; i--)
            __shiftDown2(arr, i);

        for (int i = n - 1; i > 0; i--) {
            CommonUtils.swap(arr, 0, i);
            __shiftDown2(arr, 0);
        }
    }


    @Override
    public <T extends Comparable> void sort(List<T> arr) {
        heapSortUsingMaxHeap(arr);
    }


    public <T extends Comparable> void __shiftDown(List<T> arr, int k) {
        int n = arr.size();
        while (2 * k + 1 < n) {
            int j = 2 * k + 1;
            if (j + 1 < n && arr.get(j + 1).compareTo(arr.get(j)) > 0) {
                j += 1;
            }

            if (arr.get(k).compareTo(arr.get(j)) >= 0) {
                break;
            }
            CommonUtils.swap(arr, k, j);

            k = j;
        }
    }

    public <T extends Comparable> void __shiftDown2(List<T> arr, int k) {
        int n = arr.size();

        T e = arr.get(k);
        while (2 * k + 1 < n) {
            int j = 2 * k + 1;
            if (j + 1 < n && arr.get(j + 1).compareTo(arr.get(j)) > 0) {
                j += 1;
            }

            if (e.compareTo(arr.get(j)) >= 0) {
                break;
            }

            arr.set(k, arr.get(j));
            k = j;
        }

        arr.set(k, e);

    }

}
