package Atividade9;

public class FilaVet implements IFila {
    private int nElemFila;
    private int inicio;
    private Object[] vetFila;

    public FilaVet(int capacidade) {
        this.nElemFila = 0;
        this.inicio = 0;
        this.vetFila = new Object[capacidade];
    }

    @Override
    public boolean add(Object info) {
        if (this.nElemFila == vetFila.length) {
            System.out.println("Capacidade da fila esgotou");
            return false;
        }
        int fim = (this.inicio + this.nElemFila) % this.vetFila.length;
        this.vetFila[fim] = info;
        this.nElemFila++;
        return true;
    }

    @Override
    public Object remove() {
        if (this.nElemFila == 0) {
            System.out.println("Fila vazia");
            return null;
        }
        Object elem = this.vetFila[this.inicio];
        this.vetFila[this.inicio] = null;
        this.inicio = (this.inicio + 1) % this.vetFila.length;
        this.nElemFila--;
        return elem;
    }

    @Override
    public boolean isEmpty() {
        return this.nElemFila == 0;
    }

    @Override
    public int size() {
        return this.nElemFila;
    }

    @Override
    public void print() {
        if (this.isEmpty()) {
            System.out.println("Fila vazia");
            return;
        }
        System.out.print("Fila: ");
        for (int i = 0; i < this.nElemFila; i++) {
            int index = (this.inicio + i) % this.vetFila.length;
            System.out.print(this.vetFila[index] + " ");
        }
        System.out.println();
    }
}
