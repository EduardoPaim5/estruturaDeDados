package Atividade4;


public class Main {
    public static void main(String[] args) {
        Lista l1 = new LSE();

        Aluno a1 = new Aluno("Eduardo", 18, 10.0);

        Aluno a2 = new Aluno("Fernando", 19, 5.0);

        Aluno a3 = new Aluno("Marcelina", 2, 9.00);

        Aluno a4 = new Aluno("Maju", 98, 8.5);


        //Teste do método insereInicio
        l1.insereInicio(a1);
        l1.insereInicio(a2);


        //Teste do método insereFim
        l1.insereFim(a3);


        //Teste do método remove
        if (l1.remove(a1))
            System.out.println("O aluno " + a1.getNome() + " foi removido com sucesso!" );
        else
            System.out.println("Houve algum erro e o aluno não foi removido.");


        //Teste do método estahVazia
        if(l1.estahVazia())
            System.out.println("A lista está vazia!");
        else
            System.out.println("A lista não está vazia!");


        //Teste do método imprimirLista
        l1.imprimirLista();


        //Teste do método tamanho
        System.out.println("O tamanho da lista é: "+ l1.tamanho());

    }
}