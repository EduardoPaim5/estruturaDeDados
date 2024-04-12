package Atividade5;

public class Aluno {
    private String nome;

    private int idade;

    private double nota;

    public Aluno(String nome, int idade, double nota) {
        this.nome = nome;
        this.idade = idade;
        this.nota = nota;
    }

    public String getNome() {
        return nome;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (getClass() != obj.getClass())
            return false;

        Aluno outroAluno = (Aluno) obj;

        if (!nome.equals(outroAluno.nome))
            return false;
        if (idade != outroAluno.idade)
            return false;
        if (nota != outroAluno.nota)
            return false;

        return true;
    }

}