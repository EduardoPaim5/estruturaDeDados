package Atividade7;

public class LDE {

    private Noh inicio;
    private Noh fim;

    public LDE() {
        this.inicio = null;
        this.fim = null;
    }

    public void insereInicio(int info) {
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

    public void insereFim(int info) {
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

    public boolean estahVazia() {
        return inicio == null;
    }

    private Noh buscar(int info) {
        Noh p = inicio;
        while (p != null && p.getInfo() != info) {
            p = p.getProx();
        }
        return p; // Retorna o nó encontrado ou null se não encontrar
    }

    public boolean remove(int info) {
        Noh p = buscar(info);
        if (p == null) {
            System.out.println("O número não foi encontrado.");
            return false;
        }
        if (p == inicio) {
            inicio = p.getProx();
            if (inicio != null) inicio.setAnt(null);
            else fim = null;
        } else if (p.getProx() == null) {
            p.getAnt().setProx(null);
            fim = p.getAnt();
        } else {
            p.getAnt().setProx(p.getProx());
            p.getProx().setAnt(p.getAnt());
        }
        return true;
    }

    public void imprimirLista() {
        Noh p = inicio;

        if (estahVazia()) {
            System.out.println("A lista está vazia!");
            return;
        }

        while (p != null) {
            System.out.print(p.getInfo() + " ");
            p = p.getProx();
        }
        System.out.println();
    }

    public void imprimirListaInverso() {
        Noh p = fim;

        if (estahVazia()) {
            System.out.println("A lista está vazia!");
            return;
        }

        while (p != null) {
            System.out.print(p.getInfo() + " ");
            p = p.getAnt();
        }
        System.out.println();
    }

    public int tamanho() {
        Noh p = inicio;
        int contador = 0;
        while (p != null) {
            contador++;
            p = p.getProx();
        }
        return contador;
    }

    private Noh getNo(int index) {
        Noh p = inicio;
        for (int i = 0; i < index && p != null; i++) {
            p = p.getProx();
        }
        return p;
    }

    // Método de busca binária iterativa
    public int buscaBinariaIterativa(int x) {
        int l = 0, r = tamanho() - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            Noh nohMeio = getNo(m);
            if (nohMeio.getInfo() == x)
                return m;
            if (nohMeio.getInfo() < x)
                l = m + 1;
            else
                r = m - 1;
        }
        return -1;
    }

    // Método de busca binária recursiva
    public int buscaBinariaRecursiva(int l, int r, int x) {
        if (r >= l) {
            int m = l + (r - l) / 2;
            Noh nohMeio = getNo(m);
            if (nohMeio.getInfo() == x)
                return m;
            if (nohMeio.getInfo() > x)
                return buscaBinariaRecursiva(l, m - 1, x);
            return buscaBinariaRecursiva(m + 1, r, x);
        }
        return -1;
    }
}
