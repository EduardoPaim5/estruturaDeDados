package Atividade6;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        LDE lista = new LDE();
        Random rand = new Random();

        // Preenchendo a lista com 1000 alunos com notas aleatórias
        for (int i = 0; i < 1000; i++) {
            lista.insereFim(new Aluno("Aluno " + i, rand.nextInt(1000), rand.nextDouble() * 1000));
        }

        long inicioIterativo = System.nanoTime();
        Aluno maiorIterativo = lista.encontrarMaiorIterativo();
        long fimIterativo = System.nanoTime();
        long tempoIterativo = fimIterativo - inicioIterativo;
        System.out.println("Maior (Iterativo): " + maiorIterativo.getNome() + " com nota " + maiorIterativo.getNota());
        System.out.println("Tempo (Iterativo): " + tempoIterativo + " nanosegundos");

        long inicioRecursivo = System.nanoTime();
        Aluno maiorRecursivo = lista.encontrarMaiorRecursivo();
        long fimRecursivo = System.nanoTime();
        long tempoRecursivo = fimRecursivo - inicioRecursivo;
        System.out.println("Maior (Recursivo): " + maiorRecursivo.getNome() + " com nota " + maiorRecursivo.getNota());
        System.out.println("Tempo (Recursivo): " + tempoRecursivo + " nanosegundos");
    }
}