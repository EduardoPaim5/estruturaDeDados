package Atividade15;

class ArvoreAVL {
    private Noh raiz;

    private class Noh {
        int valor, altura;
        Noh esq, dir;

        Noh(int valor) {
            this.valor = valor;
            this.altura = 1;
            this.esq = this.dir = null;
        }
    }

    public void insere(int valor) {
        raiz = insereRec(raiz, valor);
    }

    private Noh insereRec(Noh node, int valor) {
        if (node == null)
            return new Noh(valor);

        if (valor < node.valor)
            node.esq = insereRec(node.esq, valor);
        else if (valor > node.valor)
            node.dir = insereRec(node.dir, valor);
        else
            return node; // Valor duplicado, não inserir

        // Atualiza a altura do nó atual
        node.altura = 1 + Math.max(getAltura(node.esq), getAltura(node.dir));

        // Verifica o fator de balanceamento e realiza o rebalanceamento, se necessário
        int balanceamento = getBalanceamento(node);

        // Caso esquerda-esquerda (Rotação simples à direita - RSD)
        if (balanceamento > 1 && valor < node.esq.valor) {
            return rotacaoDireita(node);
        }

        // Caso direita-direita (Rotação simples à esquerda - RSE)
        if (balanceamento < -1 && valor > node.dir.valor) {
            return rotacaoEsquerda(node);
        }

        // Caso esquerda-direita (Rotação dupla à direita - RDD)
        if (balanceamento > 1 && valor > node.esq.valor) {
            node.esq = rotacaoEsquerda(node.esq);
            return rotacaoDireita(node);
        }

        // Caso direita-esquerda (Rotação dupla à esquerda - RDE)
        if (balanceamento < -1 && valor < node.dir.valor) {
            node.dir = rotacaoDireita(node.dir);
            return rotacaoEsquerda(node);
        }

        return node;
    }

    private int getAltura(Noh node) {
        if (node == null)
            return 0;
        return node.altura;
    }

    private int getBalanceamento(Noh node) {
        if (node == null)
            return 0;
        return getAltura(node.esq) - getAltura(node.dir);
    }

    private Noh rotacaoDireita(Noh y) {
        Noh x = y.esq;
        Noh T2 = x.dir;

        // Realiza a rotação
        x.dir = y;
        y.esq = T2;

        // Atualiza alturas
        y.altura = Math.max(getAltura(y.esq), getAltura(y.dir)) + 1;
        x.altura = Math.max(getAltura(x.esq), getAltura(x.dir)) + 1;

        System.out.println("Rotação simples à direita (RSD) aplicada para o valor " + y.valor);

        return x;
    }

    private Noh rotacaoEsquerda(Noh x) {
        Noh y = x.dir;
        Noh T2 = y.esq;

        // Realiza a rotação
        y.esq = x;
        x.dir = T2;

        // Atualiza alturas
        x.altura = Math.max(getAltura(x.esq), getAltura(x.dir)) + 1;
        y.altura = Math.max(getAltura(y.esq), getAltura(y.dir)) + 1;

        System.out.println("Rotação simples à esquerda (RSE) aplicada para o valor " + x.valor);

        return y;
    }

    public void preOrdem() {
        preOrdem(raiz);
        System.out.println();
    }

    private void preOrdem(Noh node) {
        if (node != null) {
            System.out.print(node.valor + " ");
            preOrdem(node.esq);
            preOrdem(node.dir);
        }
    }

    public void emOrdem() {
        emOrdem(raiz);
        System.out.println();
    }

    private void emOrdem(Noh node) {
        if (node != null) {
            emOrdem(node.esq);
            System.out.print(node.valor + " ");
            emOrdem(node.dir);
        }
    }

    public void posOrdem() {
        posOrdem(raiz);
        System.out.println();
    }

    private void posOrdem(Noh node) {
        if (node != null) {
            posOrdem(node.esq);
            posOrdem(node.dir);
            System.out.print(node.valor + " ");
        }
    }

    public static void main(String[] args) {
        ArvoreAVL arvore = new ArvoreAVL();

        // Inserções conforme a sequência fornecida
        int[] sequencia = {51, 57, 98, 19, 11, 45, 79};
        for (int valor : sequencia) {
            arvore.insere(valor);
            System.out.println("Inserido: " + valor);
        }

        System.out.println("\nÁrvore AVL em ordem:");
        arvore.emOrdem();
    }
}

