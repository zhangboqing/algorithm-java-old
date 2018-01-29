package com.zbq.dataStructure;

import com.zbq.sort.base.CommonUtils;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangboqing
 * @date 2018/1/24
 *
 * 最大堆的实现
 * 完全二叉树
 *
 * 数组实现 下标从 1 开始
 *
 */
public class  MaxHeap<T extends Comparable> {

    private List<T> data;
    //堆中元数大小
    private Integer count;
    //堆容量大小
    private int capacity;

    //===================================共有方法=========================================================

    public MaxHeap(Integer capacity) {
        data = new ArrayList(capacity + 1);
        this.count = 0;
        this.capacity = capacity;
    }


    public MaxHeap(List<T> arr) {
        data = new ArrayList<T>(arr.size()+1);
        capacity = arr.size();

        for (int i = 0; i < arr.size(); i++) {
            data.set(i + 1,arr.get(i));
        }
        count = arr.size();

        //i = count/2 基于一个性质  二叉树第一个非叶子节点 count/2
        for (int i = count/2; i >= 1 ; i--) {
            shiftDown(i);
        }

    }

    public Integer size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }


    public T getMax() {
        Assert.isTrue(count > 0,"堆中无元素");

        return data.get(1);
    }

    /**
     * 插入元素
     * @param item
     */
    public void insert(T item) {
        Assert.isTrue(count + 1 <= capacity,"堆容量不足");
        data.set(count+1,item);
        count++;
        shiftUp(count+1);
    }


    /**
     * 弹出最大元素
     * @return
     */
    public T extractMax() {
        Assert.isTrue(count > 0,"堆中无元素");

        T maxItem = data.get(1);

        CommonUtils.swap(data,1,count);
        count--;
        shiftDown(1);

        return maxItem;
    }


    //===================================私有方法=========================================================

    /**
     * 上浮操作
     * @param k
     */
    private void shiftUp(int k) {
        while (k > 1 && data.get(k/2).compareTo(data.get(k)) < 0) {
            CommonUtils.swap(data,k/2,k);
            k = k / 2;
        }
    }

    /**
     * 下沉操作
     * @param k
     */
    private void shiftDown(int k) {

        while (2*k <= count) {
            // 在此轮循环中,满足条件，data[k]和data[j]交换位置
            int j = 2*k;
            if (j+1 < count && data.get(j+1).compareTo(data.get(j)) > 0) {
                j++;
            }

            if (data.get(k).compareTo(data.get(j)) >= 0) {
                break;
            }

            CommonUtils.swap(data,k,j);
            k = j;
        }

    }


    public static void main(String[] args) {

        MaxHeap<Integer> maxHeap = new MaxHeap<>(100);
        System.out.println(maxHeap.size());


    }
}
