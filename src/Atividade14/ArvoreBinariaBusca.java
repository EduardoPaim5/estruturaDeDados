package Atividade14;
class ArvoreBinariaBusca {
    private Noh raiz;

    class Noh {
        int valor;
        Noh esq, dir;

        Noh(int valor) {
            this.valor = valor;
            esq = dir = null;
        }
    }

    // Método para inserir um elemento na árvore
    public void insere(int valor) {
        raiz = insereRec(raiz, valor);
    }

    // Método auxiliar recursivo para inserção
    private Noh insereRec(Noh node, int valor) {
        if (node == null) {
            node = new Noh(valor);
            return node;
        }

        if (valor < node.valor)
            node.esq = insereRec(node.esq, valor);
        else if (valor > node.valor)
            node.dir = insereRec(node.dir, valor);

        return node;
    }

    // Método para buscar um elemento iterativamente
    public Noh buscaIter(int elemento) {
        Noh aux = raiz;
        while (aux != null) {
            if (elemento == aux.valor)
                return aux;
            else if (elemento < aux.valor)
                aux = aux.esq;
            else
                aux = aux.dir;
        }
        return null;
    }

    // Método para buscar um elemento recursivamente
    public Noh buscaRec(int elemento) {
        return buscaRec(raiz, elemento);
    }

    private Noh buscaRec(Noh node, int elemento) {
        if (node == null || node.valor == elemento)
            return node;

        if (elemento < node.valor)
            return buscaRec(node.esq, elemento);
        else
            return buscaRec(node.dir, elemento);
    }

    // Métodos de impressão
    public void preOrdem() {
        preOrdem(raiz);
    }

    private void preOrdem(Noh node) {
        if (node != null) {
            System.out.println(node.valor);
            preOrdem(node.esq);
            preOrdem(node.dir);
        }
    }

    public void emOrdem() {
        emOrdem(raiz);
    }

    private void emOrdem(Noh node) {
        if (node != null) {
            emOrdem(node.esq);
            System.out.println(node.valor);
            emOrdem(node.dir);
        }
    }

    public void posOrdem() {
        posOrdem(raiz);
    }

    private void posOrdem(Noh node) {
        if (node != null) {
            posOrdem(node.esq);
            posOrdem(node.dir);
            System.out.println(node.valor);
        }
    }

    public void imprimeLargura() {
        Fila fila = new Fila();
        if (raiz != null)
            fila.insere(raiz);

        while (!fila.isEmpty()) {
            Noh atual = fila.remove();
            System.out.println(atual.valor);

            if (atual.esq != null)
                fila.insere(atual.esq);
            if (atual.dir != null)
                fila.insere(atual.dir);
        }
    }

    // Método para remover um nó
    public void remove(int valor) {
        raiz = removeRec(raiz, valor);
    }

    // Método auxiliar recursivo para remoção
    private Noh removeRec(Noh node, int valor) {
        if (node == null)
            return node;

        // Encontrar o nó a ser removido
        if (valor < node.valor)
            node.esq = removeRec(node.esq, valor);
        else if (valor > node.valor)
            node.dir = removeRec(node.dir, valor);
        else {
            // Caso 1: Nó sem filhos ou com um filho
            if (node.esq == null)
                return node.dir;
            else if (node.dir == null)
                return node.esq;

            // Caso 2: Nó com dois filhos
            node.valor = valorMinimo(node.dir);
            node.dir = removeRec(node.dir, node.valor);
        }
        return node;
    }

    // Método para encontrar o valor mínimo de uma subárvore
    private int valorMinimo(Noh node) {
        int min = node.valor;
        while (node.esq != null) {
            min = node.esq.valor;
            node = node.esq;
        }
        return min;
    }

    // Classe para representar uma fila simples para a impressão em largura
    private class Fila {
        private class Node {
            Noh noh;
            Node prox;

            Node(Noh noh) {
                this.noh = noh;
                this.prox = null;
            }
        }

        private Node frente, tras;

        Fila() {
            frente = tras = null;
        }

        void insere(Noh noh) {
            Node novo = new Node(noh);
            if (tras == null) {
                frente = tras = novo;
            } else {
                tras.prox = novo;
                tras = novo;
            }
        }

        Noh remove() {
            if (frente == null) {
                System.out.println("Fila vazia");
                return null;
            } else {
                Node temp = frente;
                frente = frente.prox;
                if (frente == null)
                    tras = null;
                return temp.noh;
            }
        }

        boolean isEmpty() {
            return frente == null;
        }
    }
}
