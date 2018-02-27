package com.zbq.dataStructure.UnionFind;

/**
 * @author zhangboqing
 * @date 2018/1/30
 *
 * Quick Union + rank
 */
public class UnionFind4 {

    private int[] parent;
    private int[] rank; //rank[i]表示以i为根的集合所表示的树的层数
    private int count;


    public UnionFind4(int count) {
        parent = new int[count];
        rank = new int[count];

        this.count = count;
        for (int i = 0; i < count; i++) {
            parent[i] = i;
            rank[i] = 1;
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

        if( rank[pRoot] < rank[qRoot] ){
            parent[pRoot] = qRoot;
        }
        else if( rank[qRoot] < rank[pRoot]){
            parent[qRoot] = pRoot;
        }
        else{ // rank[pRoot] == rank[qRoot]
            parent[pRoot] = qRoot;
            rank[qRoot] += 1;
        }
    }


}
