package Atividade9;

public class Main {
    public static void main(String[] args) {
        FilaVet fila = new FilaVet(5);
        fila.print();
        fila.add("A");
        fila.add("B");
        fila.add("C");
        fila.print();
        fila.remove();
        fila.print();
        fila.add("D");
        fila.add("E");
        fila.add("F");
        fila.print();
    }
}
