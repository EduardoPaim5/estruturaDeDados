package Atividade13;

public class ABB {
    private Noh raiz;

    public boolean isEmpty(){
        return this.raiz == null;
    }

    // Método para a inserção na ABB por meio de recursividade
    public void recursiveAdd(int element){
        if (isEmpty()){
            this.raiz = new Noh(element);
        }else{
            recursiveAdd(this.raiz, element);
        }
    }


    // Método auxiliar para a inserção na ABB por meio de recursividade
    private void recursiveAdd(Noh node, int element){
        if(element < node.valor){
            if(node.esq == null){
                Noh newNode = new Noh(element);
                node.esq = newNode;
                newNode.pai = node;
                return;
            }
            recursiveAdd(node.esq, element);
        }else{
            if(node.dir == null){
                Noh newNode = new Noh(element);
                node.dir = newNode;
                newNode.pai = node;
                return;
            }
            recursiveAdd(node.dir, element);
        }
    }

    // Método para buscar um elemento na ABB por meio de recursividade
    public boolean buscaRecursiva(int element) {
        return buscaRecursiva(this.raiz, element);
    }

    // Método auxiliar para buscar um elemento na ABB por meio de recursividade
    private boolean buscaRecursiva(Noh node, int element) {
        if (node == null) {
            return false;
        }
        if (element == node.valor) {
            return true;
        }
        if (element < node.valor) {
            return buscaRecursiva(node.esq, element);
        } else {
            return buscaRecursiva(node.dir, element);
        }
    }

    // Método para percorrer a árvore inteira e imprimir os elementos em ordem
    public void impressaoEmOrdem() {
        impressaoEmOrdem(this.raiz);
    }

    // Método auxiliar para percorrer a árvore inteira e imprimir os elementos em ordem
    private void impressaoEmOrdem(Noh node) {
        if (node != null) {
            impressaoEmOrdem(node.esq);
            System.out.print(node.valor + " ");
            impressaoEmOrdem(node.dir);
        }
    }
}


