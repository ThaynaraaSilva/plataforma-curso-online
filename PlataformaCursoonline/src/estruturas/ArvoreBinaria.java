package estruturas;

public class ArvoreBinaria<T extends Comparable<T>> {
    private class Nodo {
        T dado;
        Nodo esquerda;
        Nodo direita;

        Nodo(T dado) {
            this.dado = dado;
        }
    }

    private Nodo raiz;

    public void inserir(T elemento) {
        raiz = inserirRecursivamente(raiz, elemento);
    }

    private Nodo inserirRecursivamente(Nodo atual, T elemento) {
        if (atual == null) {
            return new Nodo(elemento);
        }
        if (elemento.compareTo(atual.dado) < 0) {
            atual.esquerda = inserirRecursivamente(atual.esquerda, elemento);
        } else if (elemento.compareTo(atual.dado) > 0) {
            atual.direita = inserirRecursivamente(atual.direita, elemento);
        }
        return atual;
    }

    public void imprimirEmOrdem() {
        imprimirEmOrdemRecursivamente(raiz);
    }

    private void imprimirEmOrdemRecursivamente(Nodo atual) {
        if (atual != null) {
            imprimirEmOrdemRecursivamente(atual.esquerda);
            System.out.println(atual.dado);
            imprimirEmOrdemRecursivamente(atual.direita);
        }
    }
}

