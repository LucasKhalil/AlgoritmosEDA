package Algoritmos.BinarySearchTree;

public class NodeTree {
    private int content;
    private NodeTree father;
    private NodeTree big;
    private NodeTree small;

    public NodeTree(Integer content) {
        this.content = content;
    }

    public void setContent(int content) {
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

    public int getDegree() {
        int toReturn = 0;
        if (this.big != null)
            toReturn++;
        if (this.small != null)
            toReturn++;
        return toReturn;
    }

    @Override
    public boolean equals(Object node) {
        if (node != null) {
            if (node instanceof NodeTree) {
                NodeTree tree = (NodeTree) node;
                if (tree.getContent() == this.content) {
                    return true;
                }
            }
        }
        return false;
    }
}
