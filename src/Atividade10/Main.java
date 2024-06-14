package Atividade10;

public class Main {
    public static void main(String[] args) {
        FilaLista fila = new FilaLista();

        fila.add(1);
        fila.add(2);
        fila.add(3);

        System.out.println("Tamanho da fila: " + fila.size()); // Tamanho da fila: 3
        fila.printFila(); // 1 2 3

        fila.remove();
        System.out.println("Tamanho da fila: " + fila.size()); // Tamanho da fila: 2
        fila.printFila(); // 2 3

        fila.remove();
        fila.remove();
        System.out.println("Tamanho da fila: " + fila.size()); // Tamanho da fila: 0
        fila.printFila(); // (imprime nada)


    }
}
