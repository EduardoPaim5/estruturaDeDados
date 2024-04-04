package Atividade2;

public class Vetor {

    private final Aluno[] alunos;
    private int totalAlunos = 0;


    public Vetor(int capacidade){
        this.alunos = new Aluno[capacidade];
        totalAlunos++;
    }

    public void adiciona(Aluno aluno) {
        this.alunos[this.totalAlunos] = aluno;
        this.totalAlunos++;
    }

    public int tamanho() {
        return totalAlunos;
    }

    public boolean contem(Aluno aluno) {
        for (int i = 0; i < this.totalAlunos; i++) {
            if (this.alunos[i] != null && this.alunos[i].equals(aluno)) {
                return true;
            }
        }
        return false;
    }


}



