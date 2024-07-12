package Trabalho4;
import java.util.*;

public class TemporizadorUtil {

    public static long medidaTempoInsercao(Map<Integer, Veiculo> mapa, Veiculo[] veiculos, String estrutura) {
        long inicio = System.nanoTime();
        for (Veiculo veiculo : veiculos) {
            mapa.put(veiculo.getChassi(), veiculo);
        }
        long fim = System.nanoTime();
        return fim - inicio;
    }

    public static long medidaTempoListagem(Map<Integer, Veiculo> mapa, String estrutura, boolean mostrarDetalhes) {
        long inicio = System.nanoTime();

        // Crie uma lista temporária para armazenar os veículos em ordem crescente de chassi
        List<Veiculo> veiculosOrdenados = new ArrayList<>(mapa.values());
        veiculosOrdenados.sort(Comparator.comparing(Veiculo::getChassi));

        long fim = System.nanoTime();
        long tempo = fim - inicio;

        if (mostrarDetalhes) {
            System.out.println("=== Veículos em ordem crescente de chassi (" + estrutura + ") ===");
            for (Veiculo veiculo : veiculosOrdenados) {
                System.out.println(veiculo);
            }
        }

        return tempo;
    }

    public static long medidaTempoContagemFord(Map<Integer, Veiculo> mapa, String estrutura) {
        long inicio = System.nanoTime();
        int contador = 0;
        for (Veiculo veiculo : mapa.values()) {
            if (veiculo.getMarca().equals("Ford")) {
                contador++;
            }
        }
        long fim = System.nanoTime();
        return fim - inicio;
    }

    public static long medidaTempoRemocao(Map<Integer, Veiculo> mapa, String estrutura, int chassiLimite) {
        long inicio = System.nanoTime();
        List<Integer> chavesParaRemover = new ArrayList<>();
        for (Integer chave : mapa.keySet()) {
            if (chave <= chassiLimite) {
                chavesParaRemover.add(chave);
            }
        }
        for (Integer chave : chavesParaRemover) {
            mapa.remove(chave);
        }
        long fim = System.nanoTime();
        return fim - inicio;
    }
}
