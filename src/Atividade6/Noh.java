package Atividade6;

public class Noh {

    private Object info;

    private Noh ant;

    private Noh prox;

    public Noh(Object info){
        this.info = info;
        this.ant = null;
        this.prox = null;
    }


    public Object getInfo() {
        return info;
    }

    public Noh getAnt() {
        return ant;
    }

    public Noh getProx() {
        return prox;
    }

    public void setAnt(Noh ant) {
        this.ant = ant;
    }

    public void setProx(Noh prox) {
        this.prox = prox;
    }

    public Object getObject() {
        return info;
    }
}
