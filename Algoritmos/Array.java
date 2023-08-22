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

    public void selectionSort() { // selectionSort
        for (int i = 0; i < this.content.length - 1; i++) {
            int menorValorIdx = i;
            for (int j = i + 1; j < this.content.length; j++) {
                if (this.content[j] < this.content[menorValorIdx]) {
                    menorValorIdx = j;
                }
            }
            swap(i, menorValorIdx);
        }
    }

    public void mergeSort() {
        if (!(this.content == null || this.content.length == 0)) {
            breaker(0, this.content.length - 1);
        }
    }

    private void breaker(int inicio, int fim) {
        if (inicio == fim) { // condição de parada, o intervalo tem somente um elemento
            return;
        }
        // aqui marcamos o meio do array:
        int meio = (fim + inicio) / 2;
        // quebramos mais uma vez, agora nos intervalos do início até o meio e do meio+1
        // até o fim
        breaker(inicio, meio);
        breaker(meio + 1, fim);
        // aqui unimos os dois intervalos
        merger(inicio, meio, meio + 1, fim);
    }

    private void merger(int ini1, int fim1, int ini2, int fim2) { // ini2 é igual a fim1 + 1, portanto não precisa de
                                                                  // duas variàveis
        int original = ini1; // início original da lista
        int[] aux = new int[fim1 - ini1 + fim2 - ini2 + 2]; // array auxiliar tem o tamanho dos dois intervalos somados
        int closestIdx = 0; // índice mais próximo do início do array
        while (ini1 <= fim1 && ini2 <= fim2) { // enquanto não chegarmos ao fim dos dois intervalos:
            if (this.content[ini2] < this.content[ini1]) { // se o menor valor do intervalo2 for menor que o do
                                                           // intervalo1
                aux[closestIdx] = this.content[ini2]; // será ele que irá para a menor posição do array
                ini2 += 1;
            } else { // caso contrário, será o outro valor
                aux[closestIdx] = this.content[ini1];
                ini1 += 1;
            }
            closestIdx += 1;
        }
        // esses dois whiles a frente servem para identificar por que razão o while
        // anterior foi encerrado, terminando de inserir os valores restantes
        while (ini1 <= fim1) {
            aux[closestIdx] = this.content[ini1];
            ini1 += 1;
            closestIdx += 1;
        }
        while (ini2 <= fim2) {
            aux[closestIdx] = this.content[ini2];
            ini2 += 1;
            closestIdx += 1;
        }

        // substitui os valores da lista original pelos do array auxiliar
        for (int i = 0; i < aux.length; i++) {
            this.content[i + original] = aux[i];
        }
    }

    public void quickSort() {
        particiona(0, this.content.length - 1);
    }

    public void particiona(int lmtEsquerdo, int lmtDireito) {
        if (lmtEsquerdo >= lmtDireito) {
            return;
        }
        int idxPivot = (int) Math.floor(Math.random() * (lmtDireito - lmtEsquerdo + 1) + lmtEsquerdo);
        int pivot = this.content[idxPivot];
        swap(idxPivot, lmtEsquerdo);
        idxPivot = lmtEsquerdo;
        int fim = lmtDireito;
        int i = lmtEsquerdo + 1;
        while (i <= fim) {
            if (this.content[i] <= pivot) {
                swap(i++, idxPivot++);
            } else {
                swap(i, fim--);
            }
        }
        particiona(lmtEsquerdo, idxPivot - 1);
        particiona(idxPivot + 1, lmtDireito);
    }

    public void radixSort() {
        int biggestValue = getMaximum();
        for (int exp = 1; biggestValue / exp > 0; exp *= 10)
            countSort(exp);
    }

    private void countSort(int exp) { // exp é o expoente de 10
        int orderedArray[] = new int[this.content.length]; // Array que ficará com os elementos ordenados a partir do
                                                           // dígito atual
        int aux[] = new int[10];

        // Registra as ocorrências de cada dígito no array auxiliar
        for (int i = 0; i < this.content.length; i++)
            aux[(this.content[i] / exp) % 10]++;

        // transforma o array auxiliar na cumulativa
        for (int i = 1; i < 10; i++)
            aux[i] += aux[i - 1];

        // ordena o orderedArray de acordo com o dígito atual
        for (int i = this.content.length - 1; i >= 0; i--) {
            orderedArray[aux[(this.content[i] / exp) % 10] - 1] = this.content[i];
            aux[(this.content[i] / exp) % 10]--;
        }

        // modifica o this.content para o array ordenado pelo dígito atual
        for (int i = 0; i < this.content.length; i++)
            this.content[i] = orderedArray[i];
    }

    private int getMaximum() {
        int biggestValue = 0;
        for (int i = 0; i < this.content.length; i++) {
            if (this.content[i] > biggestValue) {
                biggestValue = this.content[i];
            }
        }
        return biggestValue;
    }

    public void swap(int i, int j) {
        int aux = this.content[i]; // variável auxiliar
        this.content[i] = this.content[j];
        this.content[j] = aux;
    }

    public int[] getContent() {
        return this.content;
    }
}
