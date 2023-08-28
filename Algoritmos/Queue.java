package Algoritmos;

public class Queue {

    private Integer[] content;

    private int size;

    private int head;

    private int tail;

    public Queue(int size){
        this.size = size;
        this.content = new Integer[size];
        this.head = 0;
        this.tail = 0;
    }

    public boolean isEmpty(){
        if(this.head == this.tail){
            return true;
        }
        return false;
    }

    public boolean isFull(){
        if(this.head%this.size == (this.tail+1)%this.size){
            return true;
        }
        return false;
    }

    public int peek(){
        if(this.isEmpty()){
            throw new RuntimeException("FILA VAZIA!!!");
        }
        return this.content[this.head];
    }

    public void add(Integer n){
        if(this.isFull()){
            throw new RuntimeException("FILA CHEIA!!!");
        }
        this.content[this.tail] = n;
        this.tail = (this.tail+1)%size;
    }

    public Integer pop(){
        if(this.isEmpty()){
            throw new RuntimeException("FILA VAZIA!!!");
        }
        Integer n = this.content[this.head];
        this.head = (this.head+1)%this.size;
        return n;
    }

    public boolean contains(Integer n){
        boolean toReturn = false;
        for(int i = 0; i < this.size; i++){
            if(this.content[i] == n){
                toReturn = true;
            }
        }
        return toReturn;
    }
    
}
