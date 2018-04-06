package com.zbq.sort.test;

/**
 * @author zhangboqing
 * @date 2018/4/3
 */
public class Test3 {

    public static void insectionSort(int[] arr) {

        int length = arr.length;

        for (int i = 1; i <= length-1 ; i++) {
            int j = i;
            int temp = arr[i];
            for (j--;j>=0;j--) {
                if (arr[j] > temp) {
                    arr[j+1] = arr[j];
                    continue;
                }
                break;
            }

            j++;

            arr[j] = temp;
        }

    }


    public static void main(String[] args) {
        int[] arr = {4,3,2,1};
        insectionSort(arr);


        for (int i : arr) {
            System.out.println(i);
        }

    }
}
