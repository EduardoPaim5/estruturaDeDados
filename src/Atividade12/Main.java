package Atividade12;

public class Main {
    public static void main(String[] args) {
        HashTable tabelaHash = new HashTable(10);

        Aluno aluno1 = new Aluno("João", 123);
        Aluno aluno2 = new Aluno("Maria", 456);
        Aluno aluno3 = new Aluno("Pedro", 789);
        Aluno aluno4 = new Aluno("Ana", 213);

        tabelaHash.put(aluno1.getMatricula(), aluno1);
        tabelaHash.put(aluno2.getMatricula(), aluno2);
        tabelaHash.put(aluno3.getMatricula(), aluno3);
        tabelaHash.put(aluno4.getMatricula(), aluno4);

        tabelaHash.imprimirTabela();

        System.out.println("Buscando aluno com matrícula 456: " + tabelaHash.get(456));

        tabelaHash.remove(456);
        tabelaHash.imprimirTabela();
    }
}

