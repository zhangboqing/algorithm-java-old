package com.zbq.dataStructure.UnionFind;

/**
 * @author zhangboqing
 * @date 2018/1/30
 *
 * Quick Union + rank + path compression
 */
public class UnionFind5 {

    private int[] parent;
    private int[] rank; //rank[i]表示以i为根的集合所表示的树的层数
    private int count;


    public UnionFind5(int count) {
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

        // path compression 1
        while( p != parent[p] ){
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;

        // path compression 2
//            if( p != parent[p] )
//                parent[p] = find( parent[p] );
//            return parent[p];
    }

    public Boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if( pRoot == qRoot )
            return;

        if( rank[pRoot] < rank[qRoot] ) {
            parent[pRoot] = qRoot;
        } else if( rank[qRoot] < rank[pRoot]) {
            parent[qRoot] = pRoot;
        } else{ // rank[pRoot] == rank[qRoot]
            parent[pRoot] = qRoot;
            rank[qRoot] ++;
        }
    }

    public void show(){
        for( int i = 0 ; i < count ; i ++ ) {
            System.out.println(i+":"+parent[i]);
        }
    }


}
