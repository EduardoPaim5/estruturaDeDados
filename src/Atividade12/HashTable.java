package Atividade12;

public class HashTable {
    private Aluno[] vetor;
    private int tamanho;

    public HashTable(int capacidade) {
        vetor = new Aluno[capacidade];
        tamanho = 0;
    }

    private int hash(int chave) {
        return chave % vetor.length;
    }

    public void put(int chave, Aluno valor) {
        if (tamanho == vetor.length) {
            System.out.println("Tabela hash cheia");
            return;
        }

        int hash = hash(chave);
        while (vetor[hash] != null) {
            hash = (hash + 1) % vetor.length;
        }
        vetor[hash] = valor;
        tamanho++;
    }

    public Aluno get(int chave) {
        int hash = hash(chave);
        int passos = 0;

        while (vetor[hash] != null && passos < vetor.length) {
            if (vetor[hash].getMatricula() == chave) {
                return vetor[hash];
            }
            hash = (hash + 1) % vetor.length;
            passos++;
        }
        return null;
    }

    public void remove(int chave) {
        int hash = hash(chave);
        int passos = 0;

        while (vetor[hash] != null && passos < vetor.length) {
            if (vetor[hash].getMatricula() == chave) {
                vetor[hash] = null;
                tamanho--;
                return;
            }
            hash = (hash + 1) % vetor.length;
            passos++;
        }
        System.out.println("Aluno não encontrado.");
    }

    public void imprimirTabela() {
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] != null) {
                System.out.println("Índice " + i + ": " + vetor[i]);
            } else {
                System.out.println("Índice " + i + ": vazio");
            }
        }
    }
}
