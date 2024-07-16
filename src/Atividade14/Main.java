package Atividade14;

public class Main {
    public static void main(String[] args) {
        ArvoreBinariaBusca arvore = new ArvoreBinariaBusca();

        // Inserindo elementos na árvore
        arvore.insere(50);
        arvore.insere(30);
        arvore.insere(20);
        arvore.insere(40);
        arvore.insere(70);
        arvore.insere(60);
        arvore.insere(80);

        // Testando busca iterativa
        int elementoBuscado = 40;
        ArvoreBinariaBusca.Noh encontradoIter = arvore.buscaIter(elementoBuscado);
        if (encontradoIter != null) {
            System.out.println("Elemento " + elementoBuscado + " encontrado (iterativo): " + encontradoIter.valor);
        } else {
            System.out.println("Elemento " + elementoBuscado + " não encontrado (iterativo)");
        }

        // Testando busca recursiva
        int elementoBuscadoRec = 60;
        ArvoreBinariaBusca.Noh encontradoRec = arvore.buscaRec(elementoBuscadoRec);
        if (encontradoRec != null) {
            System.out.println("Elemento " + elementoBuscadoRec + " encontrado (recursivo): " + encontradoRec.valor);
        } else {
            System.out.println("Elemento " + elementoBuscadoRec + " não encontrado (recursivo)");
        }

        // Imprimindo em ordens diferentes
        System.out.println("Impressão pré-ordem:");
        arvore.preOrdem();

        System.out.println("Impressão em ordem:");
        arvore.emOrdem();

        System.out.println("Impressão pós-ordem:");
        arvore.posOrdem();

        System.out.println("Impressão em largura:");
        arvore.imprimeLargura();

        // Removendo um nó e imprimindo novamente
        int elementoRemover = 30;
        System.out.println("Removendo o elemento " + elementoRemover);
        arvore.remove(elementoRemover);

        System.out.println("Após remoção, impressão em ordem:");
        arvore.emOrdem();
    }
}

