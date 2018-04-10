package com.zbq.sort.test;

import java.util.Random;

/**
 * @author zhangboqing
 * @date 2018/3/6
 */
public class TestTwo {


    /**
     * 1.选择排序
     */
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

    /**
     * 2.插入排序
     */
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

    /**
     * 3.冒泡排序
     */
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

    /**
     * 4.归并排序
     */
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

        int[] tempArr = new int[end - start + 1];

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


    /**
     * 5.希尔排序
     */
    public static void shellSort(int[] arr, int start, int end, int stepLength) {

        if (stepLength < 1) {
            return;
        }
        int length = arr.length;

        //插入排序
        insectionSortByStepLength(arr, stepLength);
        //递归调用
        shellSort(arr, start, end, stepLength / 2);
    }

    private static void insectionSortByStepLength(int[] arr, int stepLength) {
        int length = arr.length;

        for (int i = 0; i < stepLength; i++) {
            int indexFlag;
            int indexValue;
            for (int j = i + stepLength; j < length; j = j + stepLength) {
                indexFlag = j;
                indexValue = arr[j];
                for (int k = j - stepLength; k >= i; k = k - stepLength) {
                    if (arr[k] > indexValue) {
                        indexFlag = k;
                        arr[k + stepLength] = arr[k];
                    }
                }

                if (indexFlag < j) {
                    arr[indexFlag] = indexValue;
                }
            }
        }

    }

    /**
     * 6.随机快排
     */
    public static void randomQuickSort(int[] arr, int start, int end) {

        if (start >= end) {
            return;
        }

        int partFlag = partition(arr, start, end);

        randomQuickSort(arr, start, partFlag - 1);
        randomQuickSort(arr, partFlag + 1, end);
    }

    private static int partition(int[] arr, int start, int end) {
        //获取随机值
        int flagIndex = start + new Random().nextInt(end - start + 1);
        int flagValue = arr[flagIndex];

        if (flagIndex != start) {
            arr[flagIndex] = arr[start];
            arr[start] = flagValue;
        }

        int flagL = start;
        for (int i = start + 1; i <= end; i++) {
            if (arr[i] <= flagValue) {
                int temp = arr[i];
                arr[i] = arr[flagL + 1];
                arr[flagL + 1] = temp;
                flagL++;
            }
        }

        if (flagL > start) {
            int temp = arr[flagL];
            arr[flagL] = arr[start];
            arr[start] = temp;
        }

        return flagL;
    }


    /**
     * 双路快排
     */
    public static void RandomQuickSortFor2Way(int[] arr, int start, int end) {

        if (start >= end) {
            return;
        }

        int flagIndex = partition2(arr, start, end);
        RandomQuickSortFor2Way(arr, start, flagIndex - 1);
        RandomQuickSortFor2Way(arr, flagIndex + 1, end);
    }

    private static int partition2(int[] arr, int start, int end) {

        int randomIndex = start + new Random().nextInt(end - start + 1);
        int randomValue = arr[randomIndex];
        if (randomIndex > start) {
            int temp = arr[start];
            arr[start] = arr[randomIndex];
            arr[randomIndex] = temp;
        }

        int flagL = start;
        int flagR = end + 1;

        int stopFlag = 2;
        int changeFlag = 0;

        while ( flagL+1<= end && flagL+1 < flagR  ) {

            if (stopFlag == 2) {
                if (arr[flagL + 1] < randomValue) {
                    flagL++;

                } else {
                    stopFlag = 1;
                    changeFlag++;
                }
            }


            if (stopFlag == 1) {
                if (arr[flagR - 1] > randomValue) {
                    flagR--;
                } else {
                    stopFlag = 2;
                    changeFlag++;
                }
            }

            if (changeFlag == 2) {

                int temp = arr[flagL + 1];
                arr[flagL + 1] = arr[flagR - 1];
                arr[flagR - 1] = temp;

                flagL++;
                flagR--;
                changeFlag = 0;
            }

        }

        if (flagL!= start) {
            int temp = arr[flagL];
            arr[flagL] = arr[start];
            arr[start] = temp;
        }

        return flagL;
    }


    /**  */
    public static void RandomQuickSortFor3Way(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }


        int length = arr.length;
        swap(arr,start,start + new Random().nextInt(end-start+1));

        int compValue =  arr[start];
        int i = start + 1;
        int flagL = start;
        int flagR = end + 1;

        for (; i < flagR; i++) {
            if ((arr[i] < compValue) && (i == flagL+1)) {
                flagL++;
            } else if ((arr[i] < compValue) && i > flagL + 1 ) {
                swap(arr,i,flagL+1);
                flagL++;
            } else if ((arr[i] > compValue) && i == flagR -1) {
                flagR--;
            } else if ((arr[i] > compValue) && i < flagR -1) {
                swap(arr,i,flagR-1);
                flagR--;
                i--;
            }
        }

        if (start < flagL) {
            swap(arr,start,flagL);
        }

        RandomQuickSortFor3Way(arr,start,flagL-1);
        RandomQuickSortFor3Way(arr,flagR,end);
    }

    public static void swap(int[] arr,int l,int r) {
        int temp = arr[l];
        arr[l]  = arr[r];
        arr[r] = temp;
    }

    public static void main(String[] args) {


        int[] arr = {4, 3, 5, 8, 1, 7, 9, 3};

        RandomQuickSortFor3Way(arr, 0, arr.length - 1);

        for (int i : arr) {
            System.out.println(i);
        }
    }

}
