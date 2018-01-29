package com.zbq.search;

import java.util.List;

/**
 * @author zhangboqing
 * @date 2018/1/29
 */
public class BinarySearchAlgorithm {


    // 二分查找法,在有序数组arr中,查找target
    // 如果找到target,返回相应的索引index
    // 如果没有找到target,返回-1
    public <T extends Comparable> int binarySearch(List<T> arr, T target) {

        int n = arr.size();

        // 在arr[l...r]之中查找target
        int l = 0, r = n - 1;
        while (l <= r) {

            //int mid = (l + r)/2;
            int mid = l + (r - l) / 2;
            if (arr.get(mid).compareTo(target) == 0) {
                return mid;
            }

            if (arr.get(mid).compareTo(target) > 0) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return -1;
    }


    public <T extends Comparable> int binarySearch2(List<T> arr, T target) {
      return   __binarySearch2(arr,0,arr.size()-1,target);
    }

    // 用递归的方式写二分查找法
    public <T extends Comparable> int __binarySearch2(List<T> arr, int l, int r, T target) {

        if (l > r) {
            return -1;
        }

        int mid = (l + r) / 2;
        if (arr.get(mid).compareTo(target) == 0) {
            return mid;
        } else if (arr.get(mid).compareTo(target) > 0) {
            return __binarySearch2(arr, 0, mid - 1, target);
        } else {
            return __binarySearch2(arr, mid + 1, r, target);
        }

    }


}
