package Atividade5;
public class LDE implements Lista {

    private Noh inicio;
    private Noh fim;

    public LDE() {
        this.inicio = null;
        this.fim = null;
    }

    @Override
    public void insereInicio(Object info) {
        Noh novo = new Noh(info);
        if (inicio == null) {
            inicio = novo;
            fim = novo;
        } else {
            novo.setProx(inicio);
            inicio.setAnt(novo);
            inicio = novo;
        }
    }


    @Override
    public void insereFim(Object info) {
        Noh novo = new Noh(info);
        if (fim == null) {
            inicio = novo;
            fim = novo;
        } else {
            novo.setAnt(fim);
            fim.setProx(novo);
            fim = novo;
        }
    }

    @Override
    public boolean estahVazia() {
        if (inicio != null) {
            System.out.println("A lista não está vazia.");
            return false;
        }
        System.out.println("A lista está vazia");
        return true;
    }

    private Noh buscar(Object info) {
        Noh p = inicio;
        while (p != null && !p.getInfo().equals(info)) {
            p = p.getProx();
        }
        return p; // Retorna o nó encontrado ou null se não encontrar
    }


    @Override
    public boolean remove(Object info) {
        Noh p = buscar(info); // Utiliza o método buscar
        if (p == null) { // não achou, então não faz nada e retorna false
            System.out.println("O aluno não foi encontrado.");
            return false;
        }
        if (p == inicio) { //info está no início
            inicio = p.getProx();
            if (inicio != null) inicio.setAnt(null);
            else fim = null;
        } else if (p.getProx() == null) { //info está no fim
            p.getAnt().setProx(null);
            fim = p.getAnt();
        } else { //info está no meio
            p.getAnt().setProx(p.getProx());
            p.getProx().setAnt(p.getAnt());
        }
        Aluno aluno = (Aluno) p.getObject();
        System.out.println("O aluno " + aluno.getNome() + " foi removido com sucesso.");
        return true;
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

    @Override
    public void imprimirListaInverso() {
        Noh p = fim;

        if (estahVazia()) {
            System.out.println("A lista está vazia!");
            return;
        }

        while (p != null) {
            Aluno aluno = (Aluno) p.getObject();
            System.out.println("Lista dos objetos presente nessa lista (sentido inverso): " + aluno.getNome());
            p = p.getAnt();
        }
    }


    @Override
    public int tamanho() {
        Noh p = inicio;
        int contador = 0;
        if (estahVazia()) {
            return 0;
        }
        while (p != null) {
            contador++;
            p = p.getProx();
        }
        return contador;
    }
}
