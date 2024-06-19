package Atividade11;

public class Noh {
    private Object o;
    private Noh prox;


    public Noh(Object o) {
        this.o = o;
        this.prox = null;
    }

    public Noh setProx(Noh n){
        this.prox = n;
        return n;
    }


    public Noh getProx() {
        return prox;
    }

    public Object getObject() {
        return o;
    }
}
