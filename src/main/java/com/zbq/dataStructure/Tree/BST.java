package com.zbq.dataStructure.Tree;

import java.util.ArrayDeque;
import java.util.Objects;

/**
 * @author zhangboqing
 * @date 2018/1/29
 * <p>
 * Binary Search Tree 二插搜索树
 */
public class BST<K extends Comparable, V> {


    public BST() {
        root = null;
        count = 0;
    }

    public int size() {
        return count;
    }

    public Boolean isEmpty() {
        return count == 0;
    }


    public void insert(K key, V value) {
        root = insert(root, key, value);
    }

    public Boolean contain(K key) {
        return contain(root, key);
    }

    public V search(K key) {
        return search(root, key);
    }

    // 前序遍历
    public void preOrder() {
        preOrder(root);
    }

    // 中序遍历
    public void inOrder() {
        inOrder(root);
    }

    // 后序遍历
    public void postOrder() {
        postOrder(root);
    }


    // 层序遍历
    public void levelOrder() {

        ArrayDeque<Node> q = new ArrayDeque<>();

        q.push(root);
        while (!q.isEmpty()) {

            Node node = q.pop();

            if (node.left != null) {
                q.push(node.left);
            }
            if (node.right != null) {
                q.push(node.right);
            }
        }
    }


    // 寻找最小的键值
    public K minimum() {
        assert (count != 0);
        Node minNode = minimum(root);
        return minNode.key;
    }

    // 寻找最大的键值
    public K maximum() {
        assert (count != 0);
        Node maxNode = maximum(root);
        return maxNode.key;
    }

    // 从二叉树中删除最小值所在节点
    public void removeMin() {
        if (root != null) {
            root = removeMin(root);
        }
    }

    // 从二叉树中删除最大值所在节点
    public void removeMax() {
        if (root != null) {
            root = removeMax(root);
        }
    }


    // 从二叉树中删除键值为key的节点
    public void remove(K key) {
        root = remove(root, key);
    }

//====================================== 私有 ======================================

    private Node root;
    private Integer count;

    /**
     * 向以node为根的二叉搜索树中,插入节点(key, value)
     * 返回插入新节点后的二叉搜索树的根
     *
     * @param node
     * @param key
     * @param value
     * @return
     */
    Node insert(Node node, K key, V value) {

        if (Objects.isNull(node)) {
            count++;
            return new Node(key, value);
        }

        if (key == node.key) {
            node.value = value;
        } else if (key.compareTo(node.key) < 0) {
            node.left = insert(node.left, key, value);
        } else {
            node.right = insert(node.right, key, value);
        }

        return node;

    }

    /**
     * 查看以node为根的二叉搜索树中是否包含键值为key的节点
     *
     * @param node
     * @param key
     * @return
     */
    private Boolean contain(Node node, K key) {

        if (node == null) {
            return false;
        }

        if (key.compareTo(node.key) == 0) {
            return true;
        } else if (key.compareTo(node.key) < 0) {
            return contain(node.left, key);
        } else {
            return contain(node.right, key);
        }

    }

    /**
     * 在以node为根的二叉搜索树中查找key所对应的value
     *
     * @param node
     * @param key
     * @return
     */
    private V search(Node node, K key) {

        if (node == null) {
            return null;
        }

        if (key.compareTo(node.key) == 0) {
            return node.value;
        } else if (key.compareTo(node.key) < 0) {
            return search(node.left, key);
        } else {
            return search(node.right, key);
        }

    }


    // 对以node为根的二叉搜索树进行前序遍历
    private void preOrder(Node node) {

        if (node != null) {
            System.out.println(node.key);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    // 对以node为根的二叉搜索树进行中序遍历
    private void inOrder(Node node) {

        if (node != null) {
            inOrder(node.left);
            System.out.println(node.key);
            inOrder(node.right);
        }
    }

    // 对以node为根的二叉搜索树进行后序遍历
    private void postOrder(Node node) {

        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.key);
        }
    }


    // 在以node为根的二叉搜索树中,返回最小键值的节点
    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }

        return minimum(node.left);
    }

    // 在以node为根的二叉搜索树中,返回最大键值的节点
    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }

        return maximum(node.right);
    }

    // 删除掉以node为根的二分搜索树中的最小节点
    // 返回删除节点后新的二分搜索树的根
    private Node removeMin(Node node) {

        if (node.left == null) {

            Node rightNode = node.right;
            node = null;
            count--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    // 删除掉以node为根的二分搜索树中的最大节点
    // 返回删除节点后新的二分搜索树的根
    private Node removeMax(Node node) {

        if (node.right == null) {

            Node leftNode = node.left;
            node = null;
            count--;
            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }


    // 删除掉以node为根的二分搜索树中键值为key的节点
    // 返回删除节点后新的二分搜索树的根
    private Node remove(Node node, K key) {

        if (node == null)
            return null;

        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            return node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            return node;
        } else {   // key == node->key

            if (node.left == null) {
                Node rightNode = node.right;
                node = null;
                count--;
                return rightNode;
            }

            if (node.right == null) {
                Node leftNode = node.left;
                node = null;
                count--;
                return leftNode;
            }

            // node->left != NULL && node->right != NULL
            Node successor = new Node(minimum(node.right));
            count++;

            successor.right = removeMin(node.right);
            successor.left = node.left;

            node = null;
            count--;

            return successor;
        }
    }




    /**
     * 节点
     */
    private class Node {
        K key;
        V value;
        Node left;
        Node right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }

        public Node(Node node) {
            this.key = node.key;
            this.value = node.value;
            this.left = node.left;
            this.right = node.right;
        }
    }
}
