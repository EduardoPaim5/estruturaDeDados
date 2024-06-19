package Atividade11;

import static Atividade11.InverterFila.inverterFila;

public class Main {
    public static void main(String[] args){
            Fila fila = new Fila();
            PilhaLista pilha = new PilhaLista();

            fila.enfileirar(new Aluno("Alice", 5, 0));
            fila.enfileirar(new Aluno("Fernando", 10, 9));
            fila.enfileirar(new Aluno("Jorge", 90, 8));

            System.out.println("Fila original:");
            fila.imprimirFila();

            inverterFila(fila, pilha);

            System.out.println("\nFila invertida:");
            fila.imprimirFila();
    }
}

