package Atividade2;

public class Principal {
    public static void main(String[] args) {
        Vetor vetAlunos = new Vetor(3);

        Aluno a1 = new Aluno("Nikola Tesla", 15, 10.0);

        Aluno a2 = new Aluno("Isabela", 17, 6.6);

        Aluno a3 = new Aluno("Vinicius", 12, 7.0);

        Aluno a4 = new Aluno("Mônica", 15, 10.0);

        vetAlunos.adiciona(a1);
        vetAlunos.adiciona(a2);
        vetAlunos.adiciona(a3);
        vetAlunos.adiciona(a4);

        System.out.println("Elementos no vetor: " + vetAlunos.tamanho());

        Aluno alunobusca = new Aluno("Nikola Tesla", 15, 10.0);
        if (vetAlunos.contem(alunobusca)) {
            System.out.println("O aluno " + alunobusca.getNome() + " está presente no vetor.");
        } else {
            System.out.println("O aluno " + alunobusca.getNome() + " não está presente no vetor.");
        }

        Aluno alunobusca1 = new Aluno("Ichigo", 17, 4.0);
        if (vetAlunos.contem(alunobusca1)) {
            System.out.println("O aluno " + alunobusca1.getNome() + " está presente no vetor.");
        } else {
            System.out.println("O aluno " + alunobusca1.getNome() + " não está presente no vetor.");
        }

     }
}

