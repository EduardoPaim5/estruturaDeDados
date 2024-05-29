package Atividade7;

public class Main {

    public static void main(String[] args) {
        LDE lista = new LDE();

        for (int i = 1; i <= 1000; i++) {
            lista.insereFim(i);
        }

        int elementoParaBuscar = 1000;

        long startTime = System.nanoTime();
        int resultadoIterativo = lista.buscaBinariaIterativa(elementoParaBuscar);
        long endTime = System.nanoTime();
        long duracaoIterativa = endTime - startTime;

        startTime = System.nanoTime();
        int resultadoRecursivo = lista.buscaBinariaRecursiva(0, lista.tamanho() - 1, elementoParaBuscar);
        endTime = System.nanoTime();
        long duracaoRecursiva = endTime - startTime;

        System.out.println("Resultado da busca iterativa: " + resultadoIterativo + ", Tempo: " + duracaoIterativa + " ns");
        System.out.println("Resultado da busca recursiva: " + resultadoRecursivo + ", Tempo: " + duracaoRecursiva + " ns");
    }
}
