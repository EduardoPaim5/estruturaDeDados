package Trabalho4;
import java.util.*;

public class MapaAVL<K extends Comparable<K>, V> implements Map<Integer, Veiculo> {
    private No<K, V> raiz;
    private int tamanho;

    public MapaAVL() {
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
            return no;
        }

        // Atualiza a altura do nó atual
        no.altura = 1 + Math.max(altura(no.esquerda), altura(no.direita));

        // Verifica o balanceamento do nó e realiza as rotações, se necessário
        int balanceamento = getBalanceamento(no);

        // Casos de rotação
        // Caso Esquerda-Esquerda
        if (balanceamento > 1 && chave.compareTo(no.esquerda.chave) < 0) {
            return rotacaoDireita(no);
        }
        // Caso Direita-Direita
        if (balanceamento < -1 && chave.compareTo(no.direita.chave) > 0) {
            return rotacaoEsquerda(no);
        }
        // Caso Esquerda-Direita
        if (balanceamento > 1 && chave.compareTo(no.esquerda.chave) > 0) {
            no.esquerda = rotacaoEsquerda(no.esquerda);
            return rotacaoDireita(no);
        }
        // Caso Direita-Esquerda
        if (balanceamento < -1 && chave.compareTo(no.direita.chave) < 0) {
            no.direita = rotacaoDireita(no.direita);
            return rotacaoEsquerda(no);
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

        // Atualiza a altura do nó atual
        no.altura = 1 + Math.max(altura(no.esquerda), altura(no.direita));

        // Verifica o balanceamento do nó e realiza as rotações, se necessário
        int balanceamento = getBalanceamento(no);

        // Casos de rotação
        // Caso Esquerda-Esquerda
        if (balanceamento > 1 && getBalanceamento(no.esquerda) >= 0) {
            return rotacaoDireita(no);
        }
        // Caso Esquerda-Direita
        if (balanceamento > 1 && getBalanceamento(no.esquerda) < 0) {
            no.esquerda = rotacaoEsquerda(no.esquerda);
            return rotacaoDireita(no);
        }
        // Caso Direita-Direita
        if (balanceamento < -1 && getBalanceamento(no.direita) <= 0) {
            return rotacaoEsquerda(no);
        }
        // Caso Direita-Esquerda
        if (balanceamento < -1 && getBalanceamento(no.direita) > 0) {
            no.direita = rotacaoDireita(no.direita);
            return rotacaoEsquerda(no);
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

        // Atualiza a altura do nó atual
        no.altura = 1 + Math.max(altura(no.esquerda), altura(no.direita));

        // Reequilibra a árvore após remoção
        return reequilibrar(no);
    }

    private int altura(No<K, V> no) {
        return no == null ? 0 : no.altura;
    }

    private int getBalanceamento(No<K, V> no) {
        return no == null ? 0 : altura(no.esquerda) - altura(no.direita);
    }

    private No<K, V> rotacaoDireita(No<K, V> y) {
        No<K, V> x = y.esquerda;
        No<K, V> T2 = x.direita;

        // Realiza a rotação
        x.direita = y;
        y.esquerda = T2;

        // Atualiza alturas
        y.altura = 1 + Math.max(altura(y.esquerda), altura(y.direita));
        x.altura = 1 + Math.max(altura(x.esquerda), altura(x.direita));

        // Retorna a nova raiz
        return x;
    }

    private No<K, V> rotacaoEsquerda(No<K, V> x) {
        No<K, V> y = x.direita;
        No<K, V> T2 = y.esquerda;

        // Realiza a rotação
        y.esquerda = x;
        x.direita = T2;

        // Atualiza alturas
        x.altura = 1 + Math.max(altura(x.esquerda), altura(x.direita));
        y.altura = 1 + Math.max(altura(y.esquerda), altura(y.direita));

        // Retorna a nova raiz
        return y;
    }

    private No<K, V> reequilibrar(No<K, V> no) {
        // Atualiza a altura do nó atual
        no.altura = 1 + Math.max(altura(no.esquerda), altura(no.direita));

        // Verifica o balanceamento do nó e realiza as rotações, se necessário
        int balanceamento = getBalanceamento(no);

        // Casos de rotação
        // Caso Esquerda-Esquerda
        if (balanceamento > 1 && getBalanceamento(no.esquerda) >= 0) {
            return rotacaoDireita(no);
        }
        // Caso Esquerda-Direita
        if (balanceamento > 1 && getBalanceamento(no.esquerda) < 0) {
            no.esquerda = rotacaoEsquerda(no.esquerda);
            return rotacaoDireita(no);
        }
        // Caso Direita-Direita
        if (balanceamento < -1 && getBalanceamento(no.direita) <= 0) {
            return rotacaoEsquerda(no);
        }
        // Caso Direita-Esquerda
        if (balanceamento < -1 && getBalanceamento(no.direita) > 0) {
            no.direita = rotacaoDireita(no.direita);
            return rotacaoEsquerda(no);
        }

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
        private int altura;

        public No(Integer chave, Veiculo valor) {
            this.chave = chave;
            this.valor = valor;
            this.esquerda = null;
            this.direita = null;
            this.altura = 1;
        }
    }
}
