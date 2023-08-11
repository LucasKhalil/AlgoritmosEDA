package Algoritmos;

import java.lang.Math;

public class Array {

    private int[] content;

    public Array(int[] arr) {
        this.content = arr;
    }

    public void bubbleSort() {
        int n = this.content.length;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (this.content[j - 1] > this.content[j]) {
                    swap(j - 1, j);
                }
            }
        }
    }

    public void insertionSort() {
        for (int i = 1; i < this.content.length; i++) {
            insert(i);
        }
    }

    private void insert(int limit) {
        int j = limit;
        for (int i = limit - 1; i >= 0; i--) {
            if (this.content[j] < this.content[i]) {
                swap(i, j);
                j -= 1;
                continue;
            }
            break;
        }
    }

    public void selectionSort() {
        for (int i = 0; i < this.content.length - 1; i++) {
            for (int j = i + 1; j < this.content.length; j++) {
                if (this.content[j] < this.content[i]) {
                    swap(i, j);
                }
            }
        }
    }

    public void mergeSort() {
        breaker(0, this.content.length - 1);
    }

    private void breaker(int inicio, int fim) {
        if (inicio == fim) {
            return;
        }
        int meio = (fim + inicio) / 2;
        breaker(inicio, meio);
        breaker(meio + 1, fim);
        merger(inicio, meio, meio + 1, fim);
    }

    private void merger(int ini1, int fim1, int ini2, int fim2) {
        int original = ini1;
        int[] aux = new int[fim1 - ini1 + fim2 - ini2 + 2];
        int lastIdx = 0;
        while (ini1 <= fim1 && ini2 <= fim2) {
            if (this.content[ini2] < this.content[ini1]) {
                aux[lastIdx] = this.content[ini2];
                ini2 += 1;
            } else {
                aux[lastIdx] = this.content[ini1];
                ini1 += 1;
            }
            lastIdx += 1;
        }
        while (ini1 <= fim1) {
            aux[lastIdx] = this.content[ini1];
            ini1 += 1;
            lastIdx += 1;
        }
        while (ini2 <= fim2) {
            aux[lastIdx] = this.content[ini2];
            ini2 += 1;
            lastIdx += 1;
        }

        for (int i = 0; i < aux.length; i++) {
            this.content[i + original] = aux[i];
        }
    }

    public void quickSort() {
        particiona(0, this.content.length - 1);
    }

    private void particiona(int inicio, int fim) { // inicio e fim não serão alterados
        if (inicio >= fim) {
            return;
        }

        int first = 0; // first e last serão alterados
        int last = fim - inicio;

        int pivot = (int) Math.floor(Math.random() * (fim - inicio + 1) + inicio);
        int[] aux = new int[fim - inicio + 1];
        for (int i = 0; i <= fim - inicio; i++) {
            if (i == pivot - inicio) {
                continue;
            }
            if (this.content[i + inicio] < this.content[pivot]) {
                aux[first] = this.content[i + inicio];
                first += 1;
            } else {
                aux[last] = this.content[i + inicio];
                last -= 1;
            }
        }
        int posPivot = first + inicio; // nesse ponto, first indica o último índice de aux ainda ocupado por um 0
        aux[posPivot] = this.content[pivot];
        for (int k = 0; k < aux.length; k++) {
            this.content[k + inicio] = aux[k];
        }
        particiona(inicio, posPivot - 1);
        particiona(posPivot + 1, fim);
    }

    public void swap(int i, int j) {
        int aux = this.content[i];
        this.content[i] = this.content[j];
        this.content[j] = aux;
    }

    public int[] getContent() {
        return this.content;
    }

}
