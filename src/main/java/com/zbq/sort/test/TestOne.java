package com.zbq.sort.test;

/**
 * @author zhangboqing
 * @date 2018/3/5
 */
public class TestOne {

    public static void quickSort(int[] arr,int left,int right) {

        if (left>=right) {
            return;
        }

        int p = partition(arr,left,right);
        quickSort(arr,left,p-1);
        quickSort(arr,p+1,right);
    }

    private static int partition(int[] arr, int left, int right) {

        int middleValue = arr[left];

        int i = left+1;
        for (int j = left+1;j <= right;j++) {

            if (arr[j]<=middleValue) {
                swap(arr,i,j);
                i++;
            }
        }

        swap(arr,left,i-1);

        return i-1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {

        int[] arr = {3,4,5,1,2,7,6,8,4,9};

         quickSort(arr,0,arr.length-1);

        for (int i : arr) {
            System.out.println(i);
        }
    }
}
