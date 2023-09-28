package Algoritmos.BinarySearchTree;

public class NodeTree {
    private int content;
    private NodeTree father;
    private NodeTree big;
    private NodeTree small;

    public NodeTree(Integer content) {
        this.content = content;
    }

    public Integer getContent() {
        return this.content;
    }

    public void setFather(NodeTree n) {
        this.father = n;
    }

    public void setBig(NodeTree n) {
        this.big = n;
    }

    public void setSmall(NodeTree n) {
        this.small = n;
    }

    public NodeTree getFather() {
        return this.father;
    }

    public NodeTree getBig() {
        return this.big;
    }

    public NodeTree getSmall() {
        return this.small;
    }
}
