package Trabalho4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MapaVetorOrdenado<K extends Comparable<K>, V> implements MapCustom<K, V> {
    private List<Entry<K, V>> vector;

    public MapaVetorOrdenado() {
        this.vector = new ArrayList<>();
    }

    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    @Override
    public void clear() {
        vector.clear();
    }

    @Override
    public boolean containsKey(Object key) {
        return vector.stream().anyMatch(entry -> entry.key.equals(key));
    }

    @Override
    public boolean containsValue(Object value) {
        return vector.stream().anyMatch(entry -> entry.value.equals(value));
    }

    @Override
    public V get(Object key) {
        return vector.stream()
                .filter(entry -> entry.key.equals(key))
                .map(entry -> entry.value)
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean isEmpty() {
        return vector.isEmpty();
    }

    @Override
    public V put(K key, V value) {
        for (int i = 0; i < vector.size(); i++) {
            Entry<K, V> entry = vector.get(i);
            if (entry.key.equals(key)) {
                V oldValue = entry.value;
                entry.value = value;
                return oldValue;
            } else if (entry.key.compareTo(key) > 0) {
                vector.add(i, new Entry<>(key, value));
                return null;
            }
        }
        vector.add(new Entry<>(key, value));
        return null;
    }

    @Override
    public V remove(Object key) {
        for (int i = 0; i < vector.size(); i++) {
            Entry<K, V> entry = vector.get(i);
            if (entry.key.equals(key)) {
                vector.remove(i);
                return entry.value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return vector.size();
    }

    @Override
    public Collection<V> values() {
        List<V> values = new ArrayList<>();
        for (Entry<K, V> entry : vector) {
            values.add(entry.value);
        }
        return values;
    }
}
