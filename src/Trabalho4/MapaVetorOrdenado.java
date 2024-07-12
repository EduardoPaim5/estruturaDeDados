package Trabalho4;

import java.util.*;

public class MapaVetorOrdenado<K extends Comparable<K>, V> implements Map<Integer, Veiculo> {
    private No<K, V>[] elementos;
    private int tamanho;

    public MapaVetorOrdenado() {
        this.elementos = new No[10]; // Tamanho inicial arbitrário
        this.tamanho = 0;
    }

    @Override
    public int size() {
        return tamanho;
    }

    @Override
    public boolean isEmpty() {
        return tamanho == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        int chave = (Integer) key;
        return get(chave) != null;
    }

    @Override
    public boolean containsValue(Object value) {
        for (int i = 0; i < tamanho; i++) {
            if (elementos[i].valor.equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Veiculo get(Object key) {
        int chave = (Integer) key;
        for (int i = 0; i < tamanho; i++) {
            if (elementos[i].chave == chave) {
                return elementos[i].valor;
            }
        }
        return null;
    }

    @Override
    public Veiculo put(Integer key, Veiculo value) {
        int chave = key;
        if (containsKey(chave)) {
            for (int i = 0; i < tamanho; i++) {
                if (elementos[i].chave == chave) {
                    Veiculo antigo = elementos[i].valor;
                    elementos[i].valor = value;
                    return antigo;
                }
            }
        } else {
            if (tamanho >= elementos.length) {
                aumentarCapacidade();
            }
            elementos[tamanho++] = new No<>(key, value);
        }
        return null;
    }

    private void aumentarCapacidade() {
        int novoTamanho = elementos.length * 2;
        elementos = Arrays.copyOf(elementos, novoTamanho);
    }

    @Override
    public Veiculo remove(Object key) {
        int chave = (Integer) key;
        for (int i = 0; i < tamanho; i++) {
            if (elementos[i].chave == chave) {
                Veiculo removido = elementos[i].valor;
                // Deslocar os elementos à esquerda para preencher o espaço vazio
                for (int j = i; j < tamanho - 1; j++) {
                    elementos[j] = elementos[j + 1];
                }
                elementos[--tamanho] = null; // Remover última referência redundante
                return removido;
            }
        }
        return null;
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Veiculo> m) {
        for (Entry<? extends Integer, ? extends Veiculo> entry : m.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public void clear() {
        elementos = new No[10]; // Reinicializa o vetor de elementos
        tamanho = 0;
    }

    @Override
    public Set<Integer> keySet() {
        Set<Integer> chaves = new HashSet<>();
        for (int i = 0; i < tamanho; i++) {
            chaves.add(elementos[i].chave);
        }
        return chaves;
    }

    @Override
    public Collection<Veiculo> values() {
        List<Veiculo> valores = new ArrayList<>();
        for (int i = 0; i < tamanho; i++) {
            valores.add(elementos[i].valor);
        }
        return valores;
    }

    @Override
    public Set<Entry<Integer, Veiculo>> entrySet() {
        Set<Entry<Integer, Veiculo>> entradas = new HashSet<>();
        for (int i = 0; i < tamanho; i++) {
            entradas.add(new AbstractMap.SimpleEntry<>(elementos[i].chave, elementos[i].valor));
        }
        return entradas;
    }

    private static class No<K, V> {
        private Integer chave;
        private Veiculo valor;

        public No(Integer chave, Veiculo valor) {
            this.chave = chave;
            this.valor = valor;
        }
    }
}

