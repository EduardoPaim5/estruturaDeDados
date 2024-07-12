package Trabalho4;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Veiculo[] veiculos = gerarVeiculos(100000);

        boolean sair = false;
        while (!sair) {
            exibirMenu();
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

    public static void exibirMenu() {
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Mostrar apenas os tempos");
        System.out.println("2 - Mostrar os detalhes dos veículos e os tempos");
        System.out.println("3 - Sair");
    }

    public static int capturarInteiro(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida. Digite um número válido:");
            scanner.next(); // Limpa o buffer do scanner
        }
        return scanner.nextInt();
    }

    public static void medirTempos(boolean mostrarDetalhes, Veiculo[] veiculos) {
        // Implementação dos métodos medirTempos
        // ... (o código que você já possui para medir os tempos)
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

