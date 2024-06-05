package Atividade8;


import java.util.Random;

public class Main {
    public static void main(String[] args) {
        LDE listaOriginal = new LDE();
        Random random = new Random();

        // Gerando um vetor com 1.000 elementos aleatórios
        int[] valores = new int[1000];
        for (int i = 0; i < 1000; i++) {
            valores[i] = random.nextInt(10000); // elementos de 0 a 9999
            listaOriginal.adicionar(valores[i]);
        }

        // Ordenando usando Bubble Sort e medindo o tempo
        LDE listaBolha = new LDE();
        for (int valor : valores) {
            listaBolha.adicionar(valor);
        }
        long inicioBolha = System.currentTimeMillis();
        listaBolha.ordenarBolha();
        long fimBolha = System.currentTimeMillis();
        System.out.println("Tempo para ordenar usando Bolha: " + (fimBolha - inicioBolha) + "ms");

        // Ordenando usando Selection Sort e medindo o tempo
        LDE listaSelecao = new LDE();
        for (int valor : valores) {
            listaSelecao.adicionar(valor);
        }
        long inicioSelecao = System.currentTimeMillis();
        listaSelecao.ordenarSelecao();
        long fimSelecao = System.currentTimeMillis();
        System.out.println("Tempo para ordenar usando Selecao: " + (fimSelecao - inicioSelecao) + "ms");

        // Ordenando usando Insertion Sort e medindo o tempo
        LDE listaInsercao = new LDE();
        for (int valor : valores) {
            listaInsercao.adicionar(valor);
        }
        long inicioInsercao = System.currentTimeMillis();
        listaInsercao.ordenarInsercao();
        long fimInsercao = System.currentTimeMillis();
        System.out.println("Tempo para ordenar usando Insercao: " + (fimInsercao - inicioInsercao) + "ms");
    }
}







