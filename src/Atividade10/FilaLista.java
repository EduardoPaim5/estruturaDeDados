package Atividade10;

public class FilaLista implements IFila {
    private Noh inicio;
    private Noh fim;
    private int tamanho;

    public FilaLista() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    @Override
    public boolean add(Object info) {
        Noh novoNoh = new Noh((int) info);
        if (isEmpty()) {
            inicio = novoNoh;
        } else {
            fim.setProx(novoNoh);
            novoNoh.setAnt(fim);
        }
        fim = novoNoh;
        tamanho++;
        return true;
    }

    @Override
    public boolean remove() {
        if (isEmpty()) {
            return false;
        }
        inicio = inicio.getProx();
        if (inicio != null) {
            inicio.setAnt(null);
        } else {
            fim = null;
        }
        tamanho--;
        return true;
    }

    @Override
    public boolean isEmpty() {
        return tamanho == 0;
    }

    @Override
    public int size() {
        return tamanho;
    }

    public void printFila() {
        Noh atual = inicio;
        while (atual != null) {
            System.out.print(atual.getInfo() + " ");
            atual = atual.getProx();
        }
        System.out.println();
    }
}
