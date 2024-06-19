package Atividade11;

public class InverterFila {
    public static void inverterFila(Fila fila, PilhaLista pilha) {
        // Transferir elementos da fila para a pilha
        while (!fila.estahVazia()) {
            Aluno aluno = fila.desenfileirar();
            pilha.push(aluno);
        }

        // Transferir elementos da pilha de volta para a fila
        while (!pilha.estahVazia()) {
            Aluno aluno = (Aluno) pilha.pop();
            fila.enfileirar(aluno);
        }
    }
}


