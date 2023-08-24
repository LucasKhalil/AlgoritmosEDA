package Algoritmos;

import javax.management.RuntimeErrorException;

public class Stack {

    private int top;
    private int[] content;

    // Cria uma pilha vazia com tamanho definido
    public Stack(int size) {
        this.top = -1;
        this.content = new int[size];
    }

    // cria uma pilha já com elementos
    public Stack(int[] content) {
        this.top = content.length - 1;
        this.content = content;
    }

    public boolean isEmpty() {
        return this.top == -1;
    }

    public boolean isFull() {
        return this.top == this.content.length - 1;
    }

    // remove o valor no topo da pilha
    public int pop() {
        if (this.isEmpty()) {
            throw new RuntimeException("Empty Stack!!!");
        }
        return this.content[top--];
    }

    // retorna o valor no topo da pilha
    public int peek() {
        if (this.isEmpty()) {
            throw new RuntimeException("Empty Stack!!!");
        }
        return this.content[top];
    }

    // adiciona um valor à pilha
    public void push(int n) {
        if (this.isFull()) {
            throw new RuntimeException("Stack Overflow!!!");
        }
        this.top++;
        this.content[top] = n;
    }

    // retorna o tamanho atual da pilha ( sem considerar os espaços vazios )
    public int size() {
        return this.top + 1;
    }

    // retorna a capacidade da pilha ( considerando os espaços vazios )
    public int capacity() {
        return this.content.length;
    }

    // verifica se a pilha contém o elemento
    public boolean contains(int n) {
        if (this.isEmpty()) {
            return false;
        }
        Stack aux = new Stack(top + 1);
        while (this.content[this.top] != n || !this.isEmpty()) {
            aux.push(this.pop());
        }
        boolean toReturn = false;
        if (aux.peek() == n) {
            toReturn = true;
        }
        while (!aux.isEmpty()) {
            this.push(aux.pop());
        }
        return toReturn;
    }

    // retorna o index do elemento na pilha, se ele não estiver presente retorna -1
    public int indexOf(int n) {
        if (this.isEmpty()) {
            return -1;
        }
        Stack aux = new Stack(top + 1);
        while (this.content[this.top] != n || !this.isEmpty()) {
            aux.push(this.pop());
        }
        int toReturn = -1;
        if (aux.peek() == n) {
            toReturn = this.getTop() + 1;
        }
        while (!aux.isEmpty()) {
            this.push(aux.pop());
        }
        return toReturn;
    }

    public int getTop() {
        return this.top;
    }
}