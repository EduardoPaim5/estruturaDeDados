package Trabalho4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ABB<K extends Comparable<K>, V> implements MapCustom<K, V> {
    private Node<K, V> root;

    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> left;
        Node<K, V> right;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    @Override
    public void clear() {
        root = null;
    }

    @Override
    public boolean containsKey(Object key) {
        return getNode(root, key) != null;
    }

    @Override
    public boolean containsValue(Object value) {
        return containsValue(root, value);
    }

    private boolean containsValue(Node<K, V> node, Object value) {
        if (node == null) return false;
        if (node.value.equals(value)) return true;
        return containsValue(node.left, value) || containsValue(node.right, value);
    }

    @Override
    public V get(Object key) {
        Node<K, V> node = getNode(root, key);
        return node == null ? null : node.value;
    }

    private Node<K, V> getNode(Node<K, V> node, Object key) {
        if (node == null) return null;
        int cmp = ((K) key).compareTo(node.key);
        if (cmp < 0) return getNode(node.left, key);
        else if (cmp > 0) return getNode(node.right, key);
        else return node;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public V put(K key, V value) {
        Node<K, V> node = root;
        if (node == null) {
            root = new Node<>(key, value);
            return null;
        }
        return put(root, key, value);
    }

    private V put(Node<K, V> node, K key, V value) {
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            if (node.left == null) {
                node.left = new Node<>(key, value);
                return null;
            }
            return put(node.left, key, value);
        } else if (cmp > 0) {
            if (node.right == null) {
                node.right = new Node<>(key, value);
                return null;
            }
            return put(node.right, key, value);
        } else {
            V oldValue = node.value;
            node.value = value;
            return oldValue;
        }
    }

    @Override
    public V remove(Object key) {
        Node<K, V> node = root;
        Node<K, V> parent = null;
        while (node != null && !node.key.equals(key)) {
            parent = node;
            if (((K) key).compareTo(node.key) < 0) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        if (node == null) return null;

        V oldValue = node.value;
        if (node.left == null && node.right == null) {
            if (node == root) root = null;
            else if (node == parent.left) parent.left = null;
            else parent.right = null;
        } else if (node.left == null) {
            if (node == root) root = node.right;
            else if (node == parent.left) parent.left = node.right;
            else parent.right = node.right;
        } else if (node.right == null) {
            if (node == root) root = node.left;
            else if (node == parent.left) parent.left = node.left;
            else parent.right = node.left;
        } else {
            Node<K, V> successor = findMin(node.right);
            K successorKey = successor.key;
            V successorValue = successor.value;
            remove(successor.key);
            node.key = successorKey;
            node.value = successorValue;
        }
        return oldValue;
    }

    private Node<K, V> findMin(Node<K, V> node) {
        while (node.left != null) node = node.left;
        return node;
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(Node<K, V> node) {
        if (node == null) return 0;
        return 1 + size(node.left) + size(node.right);
    }

    @Override
    public Collection<V> values() {
        List<V> values = new ArrayList<>();
        inOrderTraversal(root, values);
        return values;
    }

    private void inOrderTraversal(Node<K, V> node, List<V> values) {
        if (node == null) return;
        inOrderTraversal(node.left, values);
        values.add(node.value);
        inOrderTraversal(node.right, values);
    }
}
