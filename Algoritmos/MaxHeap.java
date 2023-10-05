package Algoritmos;

import java.util.Arrays;

public class MaxHeap {
    ArrayList content;
    int tail;

    public MaxHeap() {
        this.content = new ArrayList();
        this.tail = -1;
    }

    public boolean isEmpty() {
        return this.tail == -1;
    }

    public void removeTop() {
        this.heapify(0);
    }

    public void removeTail() {
        this.heapify(this.tail);
    }

    public void add(int value) {
        this.tail++;
        this.content.append(value);
        int current = tail;
        int aux = (this.tail - 1) / 2;
        while (this.content.getValueAt(aux) < value) {
            this.content.swap(current, aux);
            current = aux;
            aux = (aux - 1) / 2;
        }
    }

    public void heapify(int idx) {
        if (!(idx > this.tail)) {
            this.content.swap(this.tail, idx);
            this.tail--;
            int aux = idx;
            int left;
            int right;
            int bigger;
            while (aux <= this.tail) {
                left = 2 * aux + 1;
                right = 2 * aux + 2;
                if (left <= this.tail && right <= this.tail) {
                    if (this.content.getValueAt(left) >= this.content.getValueAt(right))
                        bigger = left;
                    else
                        bigger = right;
                } else if (left <= this.tail)
                    bigger = left;
                else if (right <= this.tail)
                    bigger = right;
                else
                    return;
                this.content.swap(aux, bigger);
                aux = bigger;
            }
        }

    }

    @Override
    public String toString() {
        int[] aux = Arrays.copyOf(this.content.getContent(), this.tail + 1);
        return Arrays.toString(aux);
    }

}

class Main {
    public static void main(String[] args) {
        MaxHeap hp = new MaxHeap();
        int[] values = new int[] { 7, 32, 54, 78, 43, 65, 44, 12, 99, 19, 267, 34 };
        for (int i = 0; i < values.length; i++) {
            hp.add(values[i]);
        }
        System.out.println(hp.toString());
        hp.heapify(0);
        System.out.println(hp.toString());
        while (!hp.isEmpty()) {
            hp.removeTop();
            System.out.println(hp.toString());
        }
        System.out.println(Arrays.toString(values));
        for (int i = 0; i < values.length; i++) {
            hp.add(values[i]);
            System.out.println(hp.toString());
        }
        System.out.println(hp.toString());

    }
}
