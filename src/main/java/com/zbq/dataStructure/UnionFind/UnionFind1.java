package com.zbq.dataStructure.UnionFind;

/**
 * @author zhangboqing
 * @date 2018/1/30
 *
 * 并查集
 * Quick Find
 */
public class UnionFind1 {

    private int[] id;
    private int count;

    public UnionFind1(int n) {

        count = n;
        id = new int[n];

        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }



    public int find(int p) {
        assert(p >= 0 && p < count);
        return id[p];
    }

   public Boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public void unionElements(int p, int q) {

        int pID = find(p);
        int qID = find(q);

        if (pID == qID) {
            return;
        }

        for (int i = 0; i < count; i++) {
            if (id[i] == pID) {
                id[i] = qID;
            }

    }
    }
}
