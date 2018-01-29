package com.zbq.dataStructure.Tree;

/**
 * @author zhangboqing
 * @date 2018/1/29
 * <p>
 */
public class SequenceST<K extends Comparable, V> {

    public SequenceST() {
        this.head = null;
        count = 0;
    }

    public int size() {
        return count;
    }

    public Boolean isEmpty() {
        return count == 0;
    }

    public void insert(K key, V value) {
        Node node = head;
        while (node != null) {
            if (key == node.key) {
                node.value = value;
                return;
            }
            node = node.next;
        }

        Node newNode = new Node(key, value);
        newNode.next = head;
        head = newNode;
        count++;
    }

    public Boolean contain(K key) {

        Node node = head;
        while (node != null) {
            if (key == node.key) {
                return true;
            }
            node = node.next;
        }

        return false;
    }

    public V search(K key) {

        Node node = head;
        while (node != null) {
            if (key == node.key) {
                return node.value;
            }
            node = node.next;
        }

        return null;
    }

    public void remove(K key) {

        if (key == head.key) {
            Node delNode = head;
            head = head.next;
            delNode = null;
            count--;
            return;
        }

        Node node = head;
        while (node.next != null && node.next.key != key)
            node = node.next;

        if (node.next != null) {
            Node delNode = node.next;
            node.next = delNode.next;
            delNode = null;
            count--;
            return;
        }
    }


//====================================== 私有 ======================================

    private Node head;
    private Integer count;


    /**
     * 节点
     */
    private class Node {
        K key;
        V value;
        Node next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
}
