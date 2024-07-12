package Trabalho4;

import java.util.*;

public class MapaABB<K extends Comparable<K>, V> implements Map<Integer, Veiculo> {
    private No<K, V> raiz;
    private int tamanho;

    public MapaABB() {
        this.raiz = null;
        this.tamanho = 0;
    }

    @Override
    public int size() {
        return tamanho;
    }

    @Override
    public boolean isEmpty() {
        return raiz == null;
    }

    @Override
    public boolean containsKey(Object key) {
        return get((Integer) key) != null;
    }

    @Override
    public boolean containsValue(Object value) {
        return containsValueHelper(raiz, (Veiculo) value);
    }

    private boolean containsValueHelper(No<K, V> no, Veiculo value) {
        if (no == null) {
            return false;
        }
        if (no.valor.equals(value)) {
            return true;
        }
        return containsValueHelper(no.esquerda, value) || containsValueHelper(no.direita, value);
    }

    @Override
    public Veiculo get(Object key) {
        return get(raiz, (Integer) key);
    }

    private Veiculo get(No<K, V> no, Integer chave) {
        if (no == null) {
            return null;
        }
        int cmp = chave.compareTo(no.chave);
        if (cmp < 0) {
            return get(no.esquerda, chave);
        } else if (cmp > 0) {
            return get(no.direita, chave);
        } else {
            return no.valor;
        }
    }

    @Override
    public Veiculo put(Integer key, Veiculo value) {
        raiz = put(raiz, key, value);
        return value;
    }

    private No<K, V> put(No<K, V> no, Integer chave, Veiculo valor) {
        if (no == null) {
            tamanho++;
            return new No<>(chave, valor);
        }
        int cmp = chave.compareTo(no.chave);
        if (cmp < 0) {
            no.esquerda = put(no.esquerda, chave, valor);
        } else if (cmp > 0) {
            no.direita = put(no.direita, chave, valor);
        } else {
            no.valor = valor;
        }
        return no;
    }

    @Override
    public Veiculo remove(Object key) {
        raiz = remove(raiz, (Integer) key);
        return null;
    }

    private No<K, V> remove(No<K, V> no, Integer chave) {
        if (no == null) {
            return null;
        }
        int cmp = chave.compareTo(no.chave);
        if (cmp < 0) {
            no.esquerda = remove(no.esquerda, chave);
        } else if (cmp > 0) {
            no.direita = remove(no.direita, chave);
        } else {
            if (no.direita == null) {
                tamanho--;
                return no.esquerda;
            }
            if (no.esquerda == null) {
                tamanho--;
                return no.direita;
            }
            No<K, V> temp = no;
            no = min(temp.direita);
            no.direita = deleteMin(temp.direita);
            no.esquerda = temp.esquerda;
        }
        return no;
    }

    private No<K, V> min(No<K, V> no) {
        if (no.esquerda == null) {
            return no;
        } else {
            return min(no.esquerda);
        }
    }

    private No<K, V> deleteMin(No<K, V> no) {
        if (no.esquerda == null) {
            return no.direita;
        }
        no.esquerda = deleteMin(no.esquerda);
        return no;
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Veiculo> m) {
        for (Entry<? extends Integer, ? extends Veiculo> entry : m.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public void clear() {
        raiz = null;
        tamanho = 0;
    }

    @Override
    public Set<Integer> keySet() {
        Set<Integer> chaves = new HashSet<>();
        adicionarChaves(raiz, chaves);
        return chaves;
    }

    private void adicionarChaves(No<K, V> no, Set<Integer> chaves) {
        if (no != null) {
            chaves.add(no.chave);
            adicionarChaves(no.esquerda, chaves);
            adicionarChaves(no.direita, chaves);
        }
    }

    @Override
    public Collection<Veiculo> values() {
        List<Veiculo> valores = new ArrayList<>();
        adicionarValores(raiz, valores);
        return valores;
    }

    private void adicionarValores(No<K, V> no, List<Veiculo> valores) {
        if (no != null) {
            valores.add(no.valor);
            adicionarValores(no.esquerda, valores);
            adicionarValores(no.direita, valores);
        }
    }

    @Override
    public Set<Entry<Integer, Veiculo>> entrySet() {
        Set<Entry<Integer, Veiculo>> entradas = new HashSet<>();
        adicionarEntradas(raiz, entradas);
        return entradas;
    }

    private void adicionarEntradas(No<K, V> no, Set<Entry<Integer, Veiculo>> entradas) {
        if (no != null) {
            entradas.add(new AbstractMap.SimpleEntry<>(no.chave, no.valor));
            adicionarEntradas(no.esquerda, entradas);
            adicionarEntradas(no.direita, entradas);
        }
    }

    private static class No<K, V> {
        private Integer chave;
        private Veiculo valor;
        private No<K, V> esquerda;
        private No<K, V> direita;

        public No(Integer chave, Veiculo valor) {
            this.chave = chave;
            this.valor = valor;
            this.esquerda = null;
            this.direita = null;
        }
    }
}
