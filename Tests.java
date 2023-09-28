import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import Algoritmos.Array;
import Algoritmos.Stack;
import Algoritmos.BinarySearchTree.BinarySearchTree;

import org.junit.Before;
import org.junit.Test;

public class Tests {

    BinarySearchTree BST1;
    BinarySearchTree BST2;
    BinarySearchTree BST3;

    @Before
    public void setUp() {
        this.BST1 = new BinarySearchTree();
        this.BST2 = new BinarySearchTree();
        this.BST3 = new BinarySearchTree();

        // BST1 Ordenada
        this.BST1.add(10);
        BST1.add(9);
        BST1.add(8);
        BST1.add(7);
        BST1.add(6);
        BST1.add(5);
        BST1.add(4);
        BST1.add(3);
        BST1.add(2);
        BST1.add(1);
        BST1.add(0);

        // BST2 Balanceada
        BST2.add(5);
        BST2.add(2);
        BST2.add(8);
        BST2.add(0);
        BST2.add(3);
        BST2.add(6);
        BST2.add(9);
        BST2.add(1);
        BST2.add(4);
        BST2.add(7);
        BST2.add(10);

        // BST Aleatória
        BST3.add((int) (Math.random() * 11));
        BST3.add((int) (Math.random() * 11));
        BST3.add((int) (Math.random() * 11));
        BST3.add((int) (Math.random() * 11));
        BST3.add((int) (Math.random() * 11));
        BST3.add((int) (Math.random() * 11));
        BST3.add((int) (Math.random() * 11));
        BST3.add((int) (Math.random() * 11));
        BST3.add((int) (Math.random() * 11));
        BST3.add((int) (Math.random() * 11));
        BST3.add((int) (Math.random() * 11));
        BST3.add((int) (Math.random() * 11));
        BST3.add((int) (Math.random() * 11));
        BST3.add((int) (Math.random() * 11));
        BST3.add((int) (Math.random() * 11));
        BST3.add((int) (Math.random() * 11));
    }

    @Test
    public void testRemove() {
        System.out.println(Arrays.toString(this.BST1.preOrder().split(" ")));
        System.out.println(Arrays.toString(this.BST2.preOrder().split(" ")));
        System.out.println(Arrays.toString(this.BST3.preOrder().split(" ")));
        this.BST1.remove(0);
        this.BST2.remove(2);
        this.BST3.remove(0);
        System.out.println(Arrays.toString(this.BST1.preOrder().split(" ")));
        System.out.println(Arrays.toString(this.BST2.preOrder().split(" ")));
        System.out.println(Arrays.toString(this.BST3.preOrder().split(" ")));

    }

}