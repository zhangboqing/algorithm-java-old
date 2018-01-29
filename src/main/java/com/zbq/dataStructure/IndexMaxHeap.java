package com.zbq.dataStructure;

import com.zbq.sort.base.CommonUtils;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
public class IndexMaxHeap<T extends Comparable> {

    private List<T> data;
    private List<Integer> indexes;
    //堆中元数大小
    private Integer count;
    //堆容量大小
    private int capacity;

    //===================================共有方法=========================================================

    public IndexMaxHeap(Integer capacity) {
        data = new ArrayList(capacity + 1);
        indexes = new ArrayList(capacity + 1);;

        this.count = 0;
        this.capacity = capacity;
    }


    public Integer size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }


    /**
     * 获取最大值
     * @return
     */
    public T getMax() {
        Assert.isTrue(count > 0,"堆中无元素");

        return data.get(indexes.get(1));
    }


    public Integer getMaxIndex() {
        Assert.isTrue(count > 0,"堆中无元素");

        return indexes.get(1) - 1;
    }

    public T getItem(Integer i) {
        return data.get(i+1);
    }

    /**
     * 插入元素
     * @param item
     *
     * 传入的i对用户而言,是从0索引的
     */
    public void insert(Integer i,T item) {
        Assert.isTrue(count + 1 <= capacity,"堆容量不足");
        Assert.isTrue( (i + 1 > 1) && (i + 1 <= capacity),"索引值不对");

        i++;
        count++;

        data.set(i,item);
        indexes.set(count,i);

        shiftUp(count);
    }


    /**
     * 弹出最大元素
     * @return
     */
    public T extractMax() {
        Assert.isTrue(count > 0,"堆中无元素");

        T maxItem = data.get(indexes.get(1  ));
        CommonUtils.swap(indexes,1,count);

        count--;
        shiftDown(1);
        return maxItem;
    }


    /**
     * 弹出最大索引
     * @return
     */
    public Integer extractMaxIndex() {
        Assert.isTrue(count > 0,"堆中无元素");

        Integer ret = indexes.get(1) - 1;
        CommonUtils.swap(indexes,1,count);

        count--;
        shiftDown(1);
        return ret;
    }



    public void change(Integer i,T newItem) {
        i++;
        data.set(i,newItem);

        // 找到indexes[j] = i, j表示data[i]在堆中的位置
        // 之后shiftUp(j), 再shiftDown(j)

        for( int j = 1 ; j <= count ; j ++ )
            if(Objects.equals(indexes.get(j), i)){
                shiftUp(j);
                shiftDown(j);
                return;
            }

    }




    //===================================私有方法=========================================================

    /**
     * 上浮操作
     * @param k
     */
    private void shiftUp(int k) {
        while (k > 1 && data.get(indexes.get(k/2)).compareTo(data.get(indexes.get(k))) < 0) {
            CommonUtils.swap(indexes,k/2,k);
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
            if (j+1 < count && data.get(indexes.get(j+1)).compareTo(data.get(indexes.get(j))) > 0) {
                j++;
            }

            if (data.get(indexes.get(k)).compareTo(data.get(indexes.get(j))) >= 0) {
                break;
            }

            CommonUtils.swap(indexes,k,j);
            k = j;
        }

    }


    public static void main(String[] args) {

        IndexMaxHeap<Integer> maxHeap = new IndexMaxHeap<>(100);
        System.out.println(maxHeap.size());


    }
}
