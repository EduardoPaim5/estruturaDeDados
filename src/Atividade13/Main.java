package Atividade13;

public class Main {
    public static void main(String[] args){
        ABB abb = new ABB();

        //teste de busca com um valor que não está na ABB
        System.out.println(abb.buscaRecursiva(20));
        abb.recursiveAdd(5);
        abb.recursiveAdd(50);
        abb.recursiveAdd(5000);
        abb.recursiveAdd(2525);
        abb.recursiveAdd(1);
        // teste de busca com um valor existente
        System.out.println(abb.buscaRecursiva(5000));
        abb.impressaoEmOrdem();
    }
}
