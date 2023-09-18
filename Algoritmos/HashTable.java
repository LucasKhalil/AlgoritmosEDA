package Algoritmos;

public class HashTable<T> {

    T[] content;
    int size;
    int occupation;
    double fillBeforeResize;

    public HashTable() {
        this(10);
    }

    public HashTable(int size) {
        this.size = size;
        this.content = (T[]) new Comparable[size];
        this.occupation = 0;
        this.fillBeforeResize = 0.75;
    }

    public void add(T value) {
        int position = value.hashCode() % this.size;
        if (this.occupation / this.size >= this.fillBeforeResize) {
            this.resize();
        }
        while (true) {
            if (this.content[position] == null || this.content[position] instanceof Deleted) {
                this.content[position] = value;
                this.occupation++;
                return;
            }
            position = (position + 1) % this.size;
        }
    }

    public void resize() {
        HashTable aux = new HashTable<T>(this.size * 2);
        this.rehash(aux);
        this.size *= 2;
        this.content = (T[]) aux.getContent();
    }

    public void rehash(HashTable newTable) {
        for (int i = 0; i < this.size; i++) {
            newTable.add(this.content[i]);
        }
    }

    public int get(T value) {
        int position = value.hashCode() % this.size;
        while (true) {
            if (this.content[position] == null) {
                return -1;
            }
            if (this.content[position].hashCode() == value.hashCode()) {
                return position;
            }
            position = (position + 1) % this.size;
        }
    }

    public void remove(T value) {
        int position = this.get(value);
        if (position == -1)
            return;
        this.content[position] = (T) new Deleted();
        this.occupation--;
    }

    public T[] getContent() {
        return this.content;
    }

    public T[] toArray() {
        T[] toReturn = (T[]) new Comparable[this.occupation];
        int pos = 0;
        for (int i = 0; i < this.size; i++) {
            if (this.content[i] != null && !(this.content[i] instanceof Deleted)) {
                toReturn[pos] = this.content[i];
                pos++;
            }
        }
        return toReturn;
    }
}

class Deleted {

    @Override
    public int hashCode() {
        return -1;
    }

}
