package Algoritmos;

public class LinkedList {

    private Node head;
    private Node tail;
    private int size;

    public boolean isEmpty() {
        return head == null;
    }

    public void addFirst(Node newNode) {
        if (this.isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.setNext(this.head);
            this.head.setPrev(newNode);
            this.head = newNode;
        }
        size++;
    }

    public void addLast(Node newNode) {
        if (this.isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.setNext(newNode);
            newNode.setPrev(this.tail);
            this.tail = newNode;
        }
        size++;
    }

    public void addTo(Node newNode, int position) {
        if (position < 0 || position > this.size) {
            throw new RuntimeException("NOT VALID POSITION!!!");
        }
        if (position == 0)
            this.addFirst(newNode);
        else if (position == size - 1)
            this.addLast(newNode);
        else {
            if (position <= this.size / 2) {
                Node aux = this.head;
                for (int i = 0; i < position - 1; i++) {
                    aux = aux.getNext();
                }
                newNode.setNext(aux.getNext());
                newNode.setPrev(aux);
                aux.setNext(newNode);
                newNode.getNext().setPrev(newNode);
            } else {
                Node aux = this.tail;
                for (int i = size - 1; i > position + 1; i--) {
                    aux = aux.getPrev();
                }
                newNode.setPrev(aux.getPrev());
                newNode.setNext(aux);
                aux.setPrev(newNode);
                newNode.getPrev().setNext(newNode);
            }
        }
    }

    public boolean contains(Node n) {
        Node aux = this.head;
        boolean toReturn = false;
        for (int i = 0; i < size; i++) {
            toReturn = aux.Equals(n);
        }
        return toReturn;
    }

    public int indexOf(Node n) {
        if (this.isEmpty()) {
            return -1;
        }
        Node aux = this.head;
        for (int i = 0; i < size; i++) {
            if (aux.Equals(n)) {
                return i;
            }
        }
        return -1;
    }

    public void swap(int i, int j) {
        if (i == j) {
            return;
        }
        int smol; // YES, I do know it isn't written like that
        int big; // This one is right though
        if (i < j) {
            smol = i;
            big = j;
        } else {
            smol = j;
            big = i;
        }
        Node auxSmol = this.head;
        for (int k = 0; k <= smol; k++) {
            auxSmol = auxSmol.getNext();
        }
        Node nodeAtSmol = auxSmol;

        Node auxBig = this.tail;
        for (int k = this.size - 1; k >= big; k--) {
            auxBig = auxBig.getPrev();
        }
        Node nodeAtBig = auxBig;

        nodeAtSmol.setNext(auxBig.getNext());
        nodeAtSmol.setPrev(auxBig.getPrev());
        nodeAtBig.setNext(auxSmol.getNext());
        nodeAtBig.setPrev(auxSmol.getPrev());
    }
}

class Node {

    private Node next;
    private Node prev;
    private Integer content;

    public Node(Integer content) {
        this.content = content;
    }

    public void setNext(Node n) {
        this.next = n;
    }

    public Node getNext() {
        return this.next;
    }

    public void setPrev(Node n) {
        this.prev = n;
    }

    public Node getPrev() {
        return this.prev;
    }

    public boolean Equals(Node n) {
        return this.content == n.content;
    }

}
