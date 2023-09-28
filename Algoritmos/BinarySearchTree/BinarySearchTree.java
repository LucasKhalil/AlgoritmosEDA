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

    public void remove(int value) {
        NodeTree toRemove = this.search(value);
        if (toRemove == null)
            return;
        String[] toAdd = this.preOrder(toRemove).split(" ");
        if (toRemove.getContent() > toRemove.getFather().getContent())
            toRemove.getFather().setBig(null);
        else
            toRemove.getFather().setSmall(null);

        for (int i = 1; i < toAdd.length; i++) {
            if (toAdd[i] != "")
                this.add(Integer.valueOf(toAdd[i]));
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

    @Override
    public int hashCode() {
        String value = this.preOrder();
        return Integer.valueOf(value);
    }

}
