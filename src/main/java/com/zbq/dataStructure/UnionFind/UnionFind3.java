package com.zbq.dataStructure.UnionFind;

/**
 * @author zhangboqing
 * @date 2018/1/30
 *
 * Quick Union + sz
 */
public class UnionFind3 {

    private int[] parent;
    private int[] sz; //sz[i]表示以i为根的集合中元素个数
    private int count;


    public UnionFind3(int count) {
        parent = new int[count];
        sz = new int[count];

        this.count = count;
        for (int i = 0; i < count; i++) {
            parent[i] = i;
            sz[i] = 1;
        }
    }


    public int find(int p) {
        assert (p >= 0 && p < count);
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }

    public Boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public void unionElements(int p, int q) {

        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) {
            return;
        }

        if( sz[pRoot] < sz[qRoot] ){
            parent[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        }
        else{
            parent[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }
    }


}
