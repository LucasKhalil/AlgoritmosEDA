import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import Algoritmos.Array;
import Algoritmos.ArrayList;
import Algoritmos.Stack;
import Algoritmos.BinarySearchTree.BinarySearchTree;
import Algoritmos.BinarySearchTree.NodeTree;

import org.junit.Before;
import org.junit.Test;

public class Tests {

    BinarySearchTree tree1;
    BinarySearchTree tree2;
    BinarySearchTree tree3; // Tree Three LOL

    @Before
    public void setUp() {
        this.tree1 = new BinarySearchTree();
        this.tree2 = new BinarySearchTree();

        this.tree1.add(13);
        this.tree1.add(14);
        this.tree1.add(2);
        this.tree1.add(9);
        this.tree1.add(17);
        this.tree1.add(16);
        this.tree1.add(10);
        this.tree1.add(12);
        this.tree1.add(19);
        this.tree1.add(7);
        this.tree1.add(5);
        this.tree1.add(4);
        this.tree1.add(20);
        this.tree1.add(18);
        this.tree1.add(3);
        this.tree1.add(11);
        this.tree1.add(15);
        this.tree1.add(1);
        this.tree1.add(8);
        this.tree1.add(6);

        for (int i = 1; i < 101; i++) {
            this.tree2.add((int) (Math.random() * 100) + 1);
        }
    }

    @Test
    public void testSucessor() {
        for (int i = 1; i < 20; i++) {
            assert (tree1.sucessor(i).equals(new NodeTree(i + 1)));
        }
        for (int i = 1; i < 100; i++) {
            if (tree2.contains(i) && tree2.contains(i + 1)) {
                assert (tree2.sucessor(i).equals(new NodeTree(i + 1)));
            }
        }
    }

    @Test
    public void testPredecessor() {
        for (int i = 2; i < 21; i++) {
            assert (tree1.predecessor(i).equals(new NodeTree(i - 1)));
        }
        for (int i = 2; i < 101; i++) {
            if (tree2.contains(i) && tree2.contains(i - 1)) {
                assert (tree2.predecessor(i).equals(new NodeTree(i - 1)));
            }
        }
    }

    @Test
    public void testRemoveAll() {
        int aux;
        while (!tree1.isEmpty()) {
            aux = (int) (Math.random() * 20) + 1;
            tree1.remove(aux);
        }
        while (!tree2.isEmpty()) {
            aux = (int) (Math.random() * 100) + 1;
            tree2.remove(aux);
        }
    }
}