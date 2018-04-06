package com.zbq.sort.test;

/**
 * @author zhangboqing
 * @date 2018/3/6
 */
public class TestTwo {


    /** 1.选择排序 */
    public static void selectSort(int[] arr) {
        int length = arr.length;

        for (int i = 0; i < length - 1; i++) {
            int temp = arr[i];
            int maxIndex = i;
            int maxValue = arr[i];
            for (int j = i + 1; j < length; j++) {
                if (arr[j] > maxValue) {
                    maxIndex = j;
                    maxValue = arr[j];
                }
            }

            if (i < maxIndex) {
                arr[i] = arr[maxIndex];
                arr[maxIndex] = temp;
            }
        }
    }

    /** 2.插入排序 */
    public static void insectionSort(int[] arr) {

        int length = arr.length;

        int j;
        int temp;
        for (int i = 1; i <= length - 1; i++) {
            j = i;
            temp = arr[i];

            for (j--; j >= 0; j--) {
                if (arr[j] < temp) {
                    arr[j + 1] = arr[j];
                    continue;
                }
                break;
            }
            j++;
            arr[j] = temp;
        }
    }

    /** 3.冒泡排序 */
    public static void bubbleSort(int[] arr) {
        int length = arr.length;

        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /** 4.归并排序 */
    public static void mergeSort(int[] arr, int start, int end) {


        if (end - start < 1) {
            return;
        }

        int middle = start + (end - start) / 2;

        mergeSort(arr, start, middle);
        mergeSort(arr, middle + 1, end);
        mergeProcess(arr, start, middle, end);


    }

    private static void mergeProcess(int[] arr, int start, int middle, int end) {

        int[] tempArr = new int[end-start+1];

        int i = start;
        int j = middle + 1;

        int tempIndex = 0;
        for (int k = start; k <= end; k++) {
            if (i <= middle && j <= end) {
                if (arr[i] > arr[j]) {
                    tempArr[tempIndex] = arr[j];
                    j++;
                } else {
                    tempArr[tempIndex] = arr[i];
                    i++;
                }
                tempIndex++;

            } else if (i <= middle && j > end) {
                tempArr[tempIndex] = arr[i];
                tempIndex++;
                i++;
            } else if (i > middle && j <= end) {
                tempArr[tempIndex] = arr[j];
                tempIndex++;
                j++;
            }
        }
        tempIndex = 0;
        for (int k = start; k <= end; k++) {
            arr[k] = tempArr[tempIndex];
            tempIndex++;
        }

    }


    /** 5.希尔排序*/
    public static void shellSort(int[] arr,int start,int end,int stepLength) {

        if (stepLength < 1) {
            return;
        }
        int length = arr.length;

        //插入排序
        insectionSortByStepLength(arr,stepLength);
        //递归调用
        shellSort(arr,start,end,stepLength/2);
    }

    private static void insectionSortByStepLength(int[] arr, int stepLength) {
        int length = arr.length;

        for (int i = 0; i < stepLength; i++) {
            int indexFlag;
            int indexValue;
            for (int j = i + stepLength; j < length; j = j + stepLength) {
                indexFlag = j;
                indexValue = arr[j];
                for (int k = j - stepLength; k >= i ; k = k -stepLength) {
                    if (arr[k] > indexValue) {
                        indexFlag = k;
                        arr[k+stepLength] = arr[k];
                    }
                }

                if (indexFlag < j) {
                    arr[indexFlag] = indexValue;
                }
            }
        }

    }



    public static void main(String[] args) {


        int[] arr = {4, 3, 5, 8, 1, 7, 9, 3};

        shellSort(arr, 0, arr.length - 1,arr.length/2);

        for (int i : arr) {
            System.out.println(i);
        }
    }

}
