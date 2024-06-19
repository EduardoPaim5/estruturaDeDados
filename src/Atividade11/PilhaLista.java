package Atividade11;

public class PilhaLista implements IPilha {
    private Noh topo;
    private int tamanho;

    public PilhaLista() {
        this.topo = null;
        this.tamanho = 0;
    }

    @Override
    public void push(Object o) {
        Noh novo = new Noh(o);
        novo.setProx(topo);
        topo = novo;
        tamanho++;
    }

    @Override
    public Object pop() {
        if (estahVazia()) {
            return null;
        }
        Object obj = topo.getObject();
        topo = topo.getProx();
        tamanho--;
        return obj;
    }

    @Override
    public Object top() {
        if (estahVazia()) {
            return null;
        }
        return topo.getObject();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean estahVazia() {
        return topo == null;
    }
}

