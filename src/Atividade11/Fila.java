package Atividade11;

public class Fila {
    private LSE lse;

    public Fila() {
        this.lse = new LSE();
    }

    public void enfileirar(Aluno aluno) {
        lse.insereFim(aluno);
    }

    public Aluno desenfileirar() {
        if (lse.estahVazia()) {
            return null;
        }
        Aluno aluno = (Aluno) lse.getInicio().getObject();
        lse.remove(aluno);
        return aluno;
    }

    public boolean estahVazia() {
        return lse.estahVazia();
    }

    public void imprimirFila() {
        lse.imprimirLista();
    }

    private class Noh {
        private Aluno aluno;
        private Noh prox;

        public Noh(Aluno aluno) {
            this.aluno = aluno;
            this.prox = null;
        }

        public Aluno getAluno() {
            return aluno;
        }

        public void setAluno(Aluno aluno) {
            this.aluno = aluno;
        }

        public Noh getProx() {
            return prox;
        }

        public void setProx(Noh prox) {
            this.prox = prox;
        }
    }
}

