package Atividade5;

public class Main {
    public static void main(String[] args) {
    Lista l1 = new LDE();

    Aluno a1 = new Aluno("Antônio", 21, 8.5);

    Aluno a2 = new Aluno("Uryu", 18, 10.0);

    Aluno a3 = new Aluno("Goku", 15, 0.0);

    l1.insereInicio(a1);

    l1.insereFim(a3);

    l1.insereInicio(a2);


    //Teste do método remove()
    l1.remove(a3);


    //Teste do método imprimirLista()
        l1.imprimirLista();

    //Teste do método imprimirListaInverso()
        l1.imprimirListaInverso();

     l1.estahVazia();

        System.out.println("O tamanho da lista é: "+ l1.tamanho());

     }

    }

