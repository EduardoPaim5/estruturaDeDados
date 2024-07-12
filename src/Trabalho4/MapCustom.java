package Trabalho4;

import java.util.Collection;

public interface MapCustom<K, V> {
    void clear();
    boolean containsKey(Object key);
    boolean containsValue(Object value);
    V get(Object key);
    boolean isEmpty();
    V put(K key, V value);
    V remove(Object key);
    int size();
    Collection<V> values();
}
