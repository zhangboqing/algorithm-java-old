package com.zbq.sort.test;

/**
 * @author zhangboqing
 * @date 2018/3/6
 */
public class TestTwo {


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


    public static void process(int[] array, int l, int middle, int r) {


        int length = r - l + 1;
        int[] copyArray = new int[length];
        for (int i = 0; i < length; i++) {
            copyArray[i] = array[l + i];
        }
        int j = 0;
        int k = middle - l + 1;
        for (int m = 0; m < length; m++) {
            if (j > middle - l) {
                array[l + m] = copyArray[k];
                k++;
            } else if (k > r - l) {
                array[l + m] = copyArray[j];
                j++;
            } else if (copyArray[j] > copyArray[k]) {
                array[l + m] = copyArray[k];
                k++;
            } else if(copyArray[j] <= copyArray[k]){
                array[l + m] = copyArray[j];
                j++;
            }


        }


    }


    public static void main(String[] args) {


        int[] arr = {4, 3, 5, 8, 1, 7, 9, 3};

        mergeSort(arr, 0, arr.length - 1);

        for (int i : arr) {
            System.out.println(i);
        }
    }

}
