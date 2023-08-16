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
        breaker(0, this.content.length - 1);
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

    private void merger(int ini1, int fim1, int ini2, int fim2) {
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

    private void particiona(int lmtEsquerdo, int lmtDireito) {
        // Os limites esquerdo e direito do slice do Array que será particionado
        if (lmtDireito <= lmtEsquerdo) { // condição de parada
            return;
        }
        // Aqui definimos o pivot como um valor dentro dos limites estabelecidos:
        int idxPivot = (int) Math.floor(Math.random() * (lmtDireito - lmtEsquerdo + 1) + lmtEsquerdo);
        int pivot = this.content[idxPivot];
        // Array auxiliar que será utilizado para o particionamento:
        int[] aux = new int[lmtDireito - lmtEsquerdo + 1];
        // menor índice disponível no array auxiliar:
        int menorIdx = 0;
        // maior índice disponível no array auxiliar:
        int maiorIdx = aux.length - 1;
        // aqui iteramos pela lista auxiliar
        for (int i = 0; i < aux.length; i++) {
            if (i + lmtEsquerdo == idxPivot) { // se o valor que estivermos olhando for o pivot, pulamos
                                               // ele
                continue;
            }
            if (this.content[i + lmtEsquerdo] < pivot) { // se o valor que estivermos olhando for menor que o pivot, ele
                                                         // será colocado no espaço mais à esquerda do array auxiliar
                aux[menorIdx] = this.content[i + lmtEsquerdo];
                menorIdx += 1;
            } else {
                aux[maiorIdx] = this.content[i + lmtEsquerdo]; // caso contrário, será colocado mais à direita
                maiorIdx -= 1;
            }
        }
        int idxPivotAuxiliar = menorIdx; // índice do pivot na lista auxiliar
        aux[idxPivotAuxiliar] = pivot; // aqui colocamos o pivot no seu lugar
        // note que agora temos :
        // idxPivot(índice original do pivot)
        // idxPivotAuxiliar(índice do pivot na lista auxiliar)
        // agora vamos substituir o slice correspondente por aux na lista original:
        for (int i = 0; i < aux.length; i++) {
            this.content[i + lmtEsquerdo] = aux[i];
        }
        // uma vez feito isso, o índice do pivot na lista original mudou, agora ele é
        idxPivot = idxPivotAuxiliar + lmtEsquerdo;
        // repetiremos o processo para os slices agora antes e depois do pivot
        particiona(lmtEsquerdo, idxPivot - 1);
        particiona(idxPivot + 1, lmtDireito);
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
