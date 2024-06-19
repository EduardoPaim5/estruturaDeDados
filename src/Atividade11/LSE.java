package Atividade11;

public class LSE implements Lista{
    public Noh getInicio() {
        return inicio;
    }

    private Noh inicio;

    public LSE(){
        this.inicio = null;

    }

    @Override
    public void insereInicio(Object o) {
        Noh novo = new Noh(o);
        if (inicio == null)
            inicio = novo;
        else{
            novo.setProx(inicio);
            inicio = novo;
        }


    }

    @Override
    public void insereFim(Object o) {
        Noh novo = new Noh(o);
        if (inicio == null)
            inicio = novo;
        else{
            Noh ultimo = null;
            for(Noh i = inicio; i != null; i = i.getProx())
                ultimo = i;
            ultimo.setProx(novo);
        }




    }

    @Override
    public boolean estahVazia() {
        if (inicio != null){
            return false;
        }
        return true;
    }

    @Override
    public boolean remove(Object o) {
        Noh ant = null, p;
        p = inicio;
        while (p != null && p.getObject() != o) {
            ant = p;
            p = p.getProx();
        }
        if (p == null)
            return false;
        if (ant == null)
            inicio = p.getProx();
        else
            ant.setProx(p.getProx());
        return true;
    }

    @Override
    public int tamanho() {
        Noh p = inicio;
        int contador = 0;
        if (estahVazia()){
            System.out.println("A lista está vazia!");
            return 0;
        }

        while (p != null){
            contador++;
            p = p.getProx();
        }
        return contador;
    }

    @Override
    public void imprimirLista() {
        Noh p = inicio;

        if (estahVazia()) {
            System.out.println("A lista está vazia!");
            return;
        }

        while (p != null) {
            Aluno aluno = (Aluno) p.getObject();
            System.out.println("Lista dos objetos presente nessa lista: " + aluno.getNome());
            p = p.getProx();
        }
    }

}
