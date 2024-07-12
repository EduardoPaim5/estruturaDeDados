package Trabalho4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AVL<K extends Comparable<K>, V> implements MapCustom<K, V> {
    private Node<K, V> root;

    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> left;
        Node<K, V> right;
        int height;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.height = 1; // Inicialmente, a altura do nó é 1
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
        root = put(root, key, value);
        return null;
    }

    private Node<K, V> put(Node<K, V> node, K key, V value) {
        if (node == null) return new Node<>(key, value);
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else if (cmp > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value;
            return node;
        }
        return balance(node);
    }

    @Override
    public V remove(Object key) {
        Node<K, V> removedNode = getNode(root, key);
        if (removedNode == null) return null;
        root = remove(root, (K) key);
        return removedNode.value;
    }

    private Node<K, V> remove(Node<K, V> node, K key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = remove(node.left, key);
        } else if (cmp > 0) {
            node.right = remove(node.right, key);
        } else {
            if (node.left == null || node.right == null) {
                node = (node.left != null) ? node.left : node.right;
            } else {
                Node<K, V> minNode = findMin(node.right);
                node.key = minNode.key;
                node.value = minNode.value;
                node.right = remove(node.right, minNode.key);
            }
        }
        if (node == null) return null;
        return balance(node);
    }

    private Node<K, V> findMin(Node<K, V> node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    private Node<K, V> balance(Node<K, V> node) {
        updateHeight(node);
        int balanceFactor = getBalanceFactor(node);

        if (balanceFactor > 1) {
            if (getBalanceFactor(node.left) < 0) {
                node.left = rotateLeft(node.left);
            }
            return rotateRight(node);
        } else if (balanceFactor < -1) {
            if (getBalanceFactor(node.right) > 0) {
                node.right = rotateRight(node.right);
            }
            return rotateLeft(node);
        }
        return node;
    }

    private void updateHeight(Node<K, V> node) {
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    private int getHeight(Node<K, V> node) {
        return node == null ? 0 : node.height;
    }

    private int getBalanceFactor(Node<K, V> node) {
        return node == null ? 0 : getHeight(node.left) - getHeight(node.right);
    }

    private Node<K, V> rotateRight(Node<K, V> y) {
        Node<K, V> x = y.left;
        Node<K, V> T2 = x.right;
        x.right = y;
        y.left = T2;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    private Node<K, V> rotateLeft(Node<K, V> x) {
        Node<K, V> y = x.right;
        Node<K, V> T2 = y.left;
        y.left = x;
        x.right = T2;
        updateHeight(x);
        updateHeight(y);
        return y;
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
