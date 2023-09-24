package Algoritmos;

public class Stack<T> {

    T[] content;
    int top;
    int capacity;

    public Stack(int capacity) {
        this.content = (T[]) new Comparable[capacity];
        this.top = 0;
        this.capacity = capacity;
    }

    public void push(T element) {
        if (this.isFull())
            throw new RuntimeException();

        this.content[this.top] = element;
        top++;
    }

    public T peek() {
        if (this.isEmpty())
            throw new RuntimeException();

        return this.content[this.top - 1];
    }

    public T pop() {
        if (this.isEmpty())
            throw new RuntimeException();

        this.top--;
        return this.content[this.top];
    }

    public boolean isFull() {
        return this.top == this.capacity;
    }

    public boolean isEmpty() {
        return this.top == 0;
    }

    public int capacity() {
        return this.capacity;
    }

    public int size() {
        return this.top;
    }

}