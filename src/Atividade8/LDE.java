package Atividade8;

import java.util.Random;

public class LDE implements Lista {
    private Noh inicio;
    private Noh fim;
    private int tamanho;

    public LDE() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    @Override
    public void adicionar(int elemento) {
        Noh novo = new Noh(elemento);
        if (inicio == null) {
            inicio = novo;
            fim = novo;
        } else {
            fim.setProx(novo);
            novo.setAnt(fim);
            fim = novo;
        }
        tamanho++;
    }

    @Override
    public void remover(int elemento) {
        Noh atual = inicio;
        while (atual != null) {
            if (atual.getInfo() == elemento) {
                if (atual.getAnt() != null) {
                    atual.getAnt().setProx(atual.getProx());
                } else {
                    inicio = atual.getProx();
                }
                if (atual.getProx() != null) {
                    atual.getProx().setAnt(atual.getAnt());
                } else {
                    fim = atual.getAnt();
                }
                tamanho--;
                return;
            }
            atual = atual.getProx();
        }
    }

    @Override
    public int buscar(int elemento) {
        Noh atual = inicio;
        int posicao = 0;
        while (atual != null) {
            if (atual.getInfo() == elemento) {
                return posicao;
            }
            atual = atual.getProx();
            posicao++;
        }
        return -1; // elemento não encontrado
    }

    @Override
    public void exibir() {
        Noh atual = inicio;
        while (atual != null) {
            System.out.print(atual.getInfo() + " ");
            atual = atual.getProx();
        }
        System.out.println();
    }

    // Implementação do método de ordenação Bolha
    @Override
    public void ordenarBolha() {
        if (inicio == null) return;
        boolean trocado;
        do {
            Noh atual = inicio;
            trocado = false;
            while (atual.getProx() != null) {
                if (atual.getInfo() > atual.getProx().getInfo()) {
                    int temp = atual.getInfo();
                    atual.setInfo(atual.getProx().getInfo());
                    atual.getProx().setInfo(temp);
                    trocado = true;
                }
                atual = atual.getProx();
            }
        } while (trocado);
    }

    // Implementação do método de ordenação Seleção
    @Override
    public void ordenarSelecao() {
        if (inicio == null) return;
        Noh atual = inicio;
        while (atual != null) {
            Noh menor = atual;
            Noh proximo = atual.getProx();
            while (proximo != null) {
                if (proximo.getInfo() < menor.getInfo()) {
                    menor = proximo;
                }
                proximo = proximo.getProx();
            }
            int temp = atual.getInfo();
            atual.setInfo(menor.getInfo());
            menor.setInfo(temp);
            atual = atual.getProx();
        }
    }

    // Implementação do método de ordenação Inserção
    @Override
    public void ordenarInsercao() {
        if (inicio == null) return;
        Noh atual = inicio.getProx();
        while (atual != null) {
            int chave = atual.getInfo();
            Noh anterior = atual.getAnt();
            while (anterior != null && anterior.getInfo() > chave) {
                anterior.getProx().setInfo(anterior.getInfo());
                anterior = anterior.getAnt();
            }
            if (anterior == null) {
                inicio.setInfo(chave);
            } else {
                anterior.getProx().setInfo(chave);
            }
            atual = atual.getProx();
        }
    }
}