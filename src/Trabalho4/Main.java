package Trabalho4;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Veiculo[] veiculos = gerarVeiculos(50);

        boolean sair = false;
        while (!sair) {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Mostrar apenas os tempos");
            System.out.println("2 - Mostrar os detalhes dos veículos e os tempos");
            System.out.println("3 - Sair");

            // Captura a escolha do usuário
            int opcao = capturarInteiro(scanner);

            switch (opcao) {
                case 1:
                    medirTempos(false, veiculos);
                    break;
                case 2:
                    medirTempos(true, veiculos);
                    break;
                case 3:
                    sair = true;
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Escolha novamente.");
                    break;
            }
        }

        scanner.close();
    }

    // Método para capturar um inteiro digitado pelo usuário
    public static int capturarInteiro(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida. Digite um número válido:");
            scanner.next(); // Limpa o buffer do scanner
        }
        return scanner.nextInt();
    }

    public static void medirTempos(boolean mostrarDetalhes, Veiculo[] veiculos) {
        // Exemplo de uso com MapaVetorOrdenado
        Map<Integer, Veiculo> mapaVetorOrdenado = new MapaVetorOrdenado<>();
        long tempoInsercaoVetorOrdenado = medirInsercao(mapaVetorOrdenado, veiculos);
        long tempoListagemVetorOrdenado = mostrarDetalhes ? medirListagem(mapaVetorOrdenado) : 0;
        long tempoContagemFordVetorOrdenado = medirContagemFord(mapaVetorOrdenado);
        long tempoRemocaoVetorOrdenado = medirRemocao(mapaVetorOrdenado, 202050000);

        System.out.println("Tempo de inserção na Vetor Ordenado: " + tempoInsercaoVetorOrdenado + " ns");
        if (mostrarDetalhes) {
            System.out.println("Tempo de listagem na Vetor Ordenado: " + tempoListagemVetorOrdenado + " ns");
        }
        System.out.println("Tempo de contagem de veículos Ford na Vetor Ordenado: " + tempoContagemFordVetorOrdenado + " ns");
        System.out.println("Tempo de remoção na Vetor Ordenado: " + tempoRemocaoVetorOrdenado + " ns");

        // Exemplo de uso com MapaABB
        Map<Integer, Veiculo> mapaABB = new MapaABB<>();
        long tempoInsercaoABB = medirInsercao(mapaABB, veiculos);
        long tempoListagemABB = mostrarDetalhes ? medirListagem(mapaABB) : 0;
        long tempoContagemFordABB = medirContagemFord(mapaABB);
        long tempoRemocaoABB = medirRemocao(mapaABB, 202050000);

        System.out.println("Tempo de inserção na ABB: " + tempoInsercaoABB + " ns");
        if (mostrarDetalhes) {
            System.out.println("Tempo de listagem na ABB: " + tempoListagemABB + " ns");
        }
        System.out.println("Tempo de contagem de veículos Ford na ABB: " + tempoContagemFordABB + " ns");
        System.out.println("Tempo de remoção na ABB: " + tempoRemocaoABB + " ns");

        // Exemplo de uso com MapaAVL
        Map<Integer, Veiculo> mapaAVL = new MapaAVL<>();
        long tempoInsercaoAVL = medirInsercao(mapaAVL, veiculos);
        long tempoListagemAVL = mostrarDetalhes ? medirListagem(mapaAVL) : 0;
        long tempoContagemFordAVL = medirContagemFord(mapaAVL);
        long tempoRemocaoAVL = medirRemocao(mapaAVL, 202050000);

        System.out.println("Tempo de inserção na AVL: " + tempoInsercaoAVL + " ns");
        if (mostrarDetalhes) {
            System.out.println("Tempo de listagem na AVL: " + tempoListagemAVL + " ns");
        }
        System.out.println("Tempo de contagem de veículos Ford na AVL: " + tempoContagemFordAVL + " ns");
        System.out.println("Tempo de remoção na AVL: " + tempoRemocaoAVL + " ns");
    }

    public static long medirInsercao(Map<Integer, Veiculo> mapa, Veiculo[] veiculos) {
        long inicio = System.nanoTime();
        for (Veiculo veiculo : veiculos) {
            mapa.put(veiculo.getChassi(), veiculo);
        }
        long fim = System.nanoTime();
        return (fim - inicio);
    }

    public static long medirListagem(Map<Integer, Veiculo> mapa) {
        long inicio = System.nanoTime();
        for (Veiculo veiculo : mapa.values()) {
            // Imprimir ou processar cada veículo conforme necessário
            System.out.println(veiculo);
        }
        long fim = System.nanoTime();
        return (fim - inicio);
    }

    public static long medirContagemFord(Map<Integer, Veiculo> mapa) {
        long inicio = System.nanoTime();
        int count = 0;
        for (Veiculo veiculo : mapa.values()) {
            if (veiculo.getMarca().equals("Ford")) {
                count++;
            }
        }
        long fim = System.nanoTime();
        System.out.println("Número de veículos Ford: " + count);
        return (fim - inicio);
    }

    public static long medirRemocao(Map<Integer, Veiculo> mapa, int chassiLimite) {
        long inicio = System.nanoTime();
        Iterator<Map.Entry<Integer, Veiculo>> iterator = mapa.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Veiculo> entry = iterator.next();
            if (entry.getKey() <= chassiLimite) {
                iterator.remove();
            }
        }
        long fim = System.nanoTime();
        return (fim - inicio);
    }

    // Método para gerar um array de veículos aleatórios
    public static Veiculo[] gerarVeiculos(int quantidade) {
        Veiculo[] veiculos = new Veiculo[quantidade];
        for (int i = 0; i < quantidade; i++) {
            veiculos[i] = new Veiculo();
        }
        return veiculos;
    }
}
