package Atividade1;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        PontoCartesiano a = new PontoCartesiano(3, 6, 9, 4);
        a.CalcDistanciaEuclidiana();
        System.out.println(a.getD());

    }
}