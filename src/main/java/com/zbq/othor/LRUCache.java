package com.zbq.othor;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author zhangboqing
 * @date 2018/2/24
 *
 * Java代码实现最近被使用（LRU）缓存
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private int cacheSize;

    public LRUCache(int cacheSize) {
        super(16, 0.75f, true);
        this.cacheSize = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() >= cacheSize;
    }


    public static void main(String[] args) {

        LRUCache<String, String> lruCache = new LRUCache<>(4);

        lruCache.put("1","a");
        lruCache.put("2","b");
        lruCache.put("3","c");

//        String s = lruCache.get("3");
//        String s2 = lruCache.get("2");
        String s3 = lruCache.get("1");

        lruCache.put("4","d");


        Set<String> keySet = lruCache.keySet();
        Set<Map.Entry<String, String>> entries = lruCache.entrySet();

        for (Map.Entry<String, String> entry : entries) {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
//        System.out.println(keySet.size());
//        for (String key : keySet) {
//            System.out.println(key);
//            System.out.println(lruCache.get(key));
//        }

    }
}
