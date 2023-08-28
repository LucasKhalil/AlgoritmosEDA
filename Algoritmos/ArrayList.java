package Algoritmos;

public class ArrayList {

    private int[] content;
    private int last;
    private final static int DEF_SIZE = 5;

    public ArrayList() {
        this(DEF_SIZE);
    }

    public ArrayList(int size) {
        this.content = new int[size];
        this.last = 0;
    }

    public boolean isFull() {
        return this.last == this.content.length;
    }

    public boolean isEmpty() {
        return this.last == 0;
    }

    public void append(int n) {
        if (this.isFull()) {
            this.resize();
        }
        this.content[this.last++] = n;
    }

    public void addFirst(int n) {
        if (this.isFull()) {
            this.resize();
        }
        this.addTo(0, n);
    }

    public void addTo(int index, int n) {
        this.shiftRight(index);
        this.content[index] = n;
    }

    public void setTo(int index, int n) {
        this.content[index] = n;
    }

    public void ensureCapacity(int n) {
        if (this.content.length >= n) {
            return;
        }
        this.resize(n);
    }

    public int pop() {
        if (this.isEmpty()) {
            throw new RuntimeException("ARRAY VAZIO!!!");
        }
        int n = this.content[last--];
        return n;
    }

    public int remove(int index) {
        int n = this.content[index];
        shiftLeft(index);
        return n;
    }

    public int getValueAt(int index) {
        return this.content[index];
    }

    private void shiftRight(int index) {
        if (this.isFull()) {
            this.resize();
        }
        for (int i = this.content.length - 1; i >= index; i--) {
            this.content[i + 1] = this.content[i];
        }
        last++;
    }

    private void shiftLeft(int index) {
        if (this.isEmpty()) {
            throw new RuntimeException("ARRAY VAZIO!!!");
        }
        for (int i = index; i < this.content.length - 1; i++) {
            this.content[i] = this.content[i + 1];
        }
        last--;
    }

    private void resize() {
        int[] aux = new int[this.content.length * 2];
        for (int i = 0; i < this.content.length; i++) {
            aux[i] = this.content[i];
        }
        this.content = aux;
    }

    private void resize(int newSize) {
        int[] aux = new int[newSize];
        int length;
        if (newSize < this.content.length) {
            throw new RuntimeException("TAMANHO PASSADO MENOR QUE O DO ARRAY ORIGINAL!!!");
        } else {
            length = this.content.length;
        }

        for (int i = 0; i < length; i++) {
            aux[i] = this.content[i];
        }
        this.content = aux;
    }
}
