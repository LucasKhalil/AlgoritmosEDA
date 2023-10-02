package Algoritmos.BinarySearchTree;

public class BinarySearchTree {

    private NodeTree root;

    public void add(Integer content) {
        NodeTree newNode = new NodeTree(content);
        if (this.isEmpty())
            this.root = newNode;

        else {
            NodeTree aux = this.root;
            while (content != aux.getContent()) {
                if (content < aux.getContent()) {
                    if (aux.getSmall() == null) {
                        aux.setSmall(newNode);
                        newNode.setFather(aux);
                        return;
                    }
                    aux = aux.getSmall();
                } else {
                    if (aux.getBig() == null) {
                        aux.setBig(newNode);
                        newNode.setFather(aux);
                        return;
                    }
                    aux = aux.getBig();
                }
            }
        }
    }

    public NodeTree search(int value) {
        return this.search(this.root, value);
    }

    private NodeTree search(NodeTree current, int value) {
        if (current == null)
            return null;
        if (current.getContent() == value)
            return current;
        if (current.getContent() > value)
            return this.search(current.getSmall(), value);
        else
            return this.search(current.getBig(), value);
    }

    public boolean contains(int value) {
        return this.contains(this.root, value);
    }

    private boolean contains(NodeTree current, int value) {
        if (current == null)
            return false;
        if (current.getContent() == value)
            return true;
        if (current.getContent() > value)
            return this.contains(current.getSmall(), value);
        else
            return this.contains(current.getBig(), value);
    }

    public String preOrder() {
        return this.preOrder(this.root);
    }

    private String preOrder(NodeTree current) {
        if (current == null)
            return "";
        String toReturn = "";
        toReturn += current.getContent() + " ";
        toReturn += this.preOrder(current.getSmall()) + " ";
        toReturn += this.preOrder(current.getBig()) + " ";
        return toReturn;
    }

    public String inOrder() {
        return this.inOrder(this.root);
    }

    private String inOrder(NodeTree current) {
        if (current == null)
            return "";
        String toReturn = "";
        toReturn += this.inOrder(current.getSmall()) + " ";
        toReturn += current.getContent() + " ";
        toReturn += this.inOrder(current.getBig()) + " ";
        return toReturn;
    }

    public String postOrder() {
        return this.postOrder(this.root);
    }

    private String postOrder(NodeTree current) {
        if (current == null)
            return "";
        String toReturn = "";
        toReturn += this.postOrder(current.getSmall()) + " ";
        toReturn += this.postOrder(current.getBig()) + " ";
        toReturn += current.getContent() + " ";
        return toReturn;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public NodeTree min() {
        return this.min(this.root);
    }

    private NodeTree min(NodeTree node) {
        NodeTree toReturn = null;
        if (node != null) {
            if (node.getSmall() == null)
                toReturn = node;
            else
                toReturn = this.min(node.getSmall());
        }
        return toReturn;
    }

    public NodeTree max() {
        return this.max(this.root);
    }

    private NodeTree max(NodeTree node) {
        NodeTree toReturn = null;
        if (node != null) {
            if (node.getBig() == null)
                toReturn = node;
            else
                toReturn = this.max(node.getBig());
        }
        return toReturn;
    }

    public NodeTree sucessor(int content) {
        return sucessor(this.search(content));
    }

    public NodeTree sucessor(NodeTree node) {
        NodeTree toReturn = null;
        if (node != null)
            toReturn = this.min(node.getBig());
        if (toReturn == null) {
            NodeTree aux = node.getFather();
            while (aux != null && aux.getContent() < node.getContent()) {
                aux = aux.getFather();
            }
            toReturn = aux;
        }
        return toReturn;
    }

    public NodeTree predecessor(int content) {
        return predecessor(this.search(content));
    }

    public NodeTree predecessor(NodeTree node) {
        NodeTree toReturn = null;
        if (node != null)
            toReturn = this.max(node.getSmall());
        if (toReturn == null) {
            NodeTree aux = node.getFather();
            while (aux != null && aux.getContent() > node.getContent()) {
                aux = aux.getFather();
            }
            toReturn = aux;
        }
        return toReturn;
    }

    public void remove(int content) {
        this.remove(this.search(content));
    }

    public void remove(NodeTree node) {
        if (node == null)
            return;
        int degree = node.getDegree();
        if (degree == 0) { // Folha
            if (node.getFather() == null) { // Raiz folha
                this.root = null;
            } else {
                if (node.getContent() > node.getFather().getContent())
                    node.getFather().setBig(null);
                else
                    node.getFather().setSmall(null);
            }

        } else if (degree == 1) { // Ramo simples
            if (node.getFather() == null) { // Ramo simples é a raiz
                if (node.getBig() != null)
                    this.root = node.getBig();
                else
                    this.root = node.getSmall();

            } else { // Ramo simples não é a raiz
                NodeTree aux = null;
                if (node.getBig() != null)
                    aux = node.getBig();
                else
                    aux = node.getSmall();

                if (node.getContent() > node.getFather().getContent())
                    node.getFather().setBig(aux);
                else
                    node.getFather().setSmall(aux);
                aux.setFather(node.getFather());
            }

        } else { // Ramo duplo
            NodeTree substitute = this.sucessor(node);
            this.remove(substitute);
            node.setContent(substitute.getContent());
        }
    }
}
