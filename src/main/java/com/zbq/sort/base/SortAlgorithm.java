package com.zbq.sort.base;

import java.util.List;

/**
 * @author zhangboqing
 * @date 2018/1/2
 *
 * 所有排序都继承该接口
 */
public abstract class SortAlgorithm {

    private String sortName;


    /**
     * 排序方法
     *
     * @param arr
     * @param <T>
     */
    public abstract  <T extends Comparable> void sort(List<T> arr);

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }
}
