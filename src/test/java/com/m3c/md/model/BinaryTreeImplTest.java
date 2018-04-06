package com.m3c.md.model;

import com.m3c.md.controller.ElementNotFoundException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class BinaryTreeImplTest {

    private static BinaryTree binaryTree;

    /**
     * Initialise the BinaryTree with a root element 5.
     */
    @Before
    public void setup() {
        binaryTree = new BinaryTreeImpl(5);
    }

    @Test
    public void getRootElement() {
        Node root = new Node(7);
        assertEquals(7, root.getValue());
    }

    @Test
    public void getNumberOfElements() {
        binaryTree.addElement(1);
        binaryTree.addElement(9);
        binaryTree.addElement(3);
        assertEquals(4, binaryTree.getNumberOfElements());
    }

    @Test
    public void addElement() {
        assertEquals(1, binaryTree.getNumberOfElements());
        binaryTree.addElement(4);
        assertEquals(2, binaryTree.getNumberOfElements());
    }

    @Test
    public void addElements() {
        int[] elements = {4, 7, 8};
        binaryTree.addElements(elements);
        String s = "abs";
        s.hashCode();
        System.identityHashCode(s);

    }

    @Test
    public void findElement() {
        binaryTree.addElement(4);
        binaryTree.addElement(8);
        binaryTree.addElement(7);
        binaryTree.addElement(2);

        assertEquals(true, binaryTree.findElement(4));
    }

    @Test
    public void elementDoesNotExist() {
        binaryTree.addElement(4);
        binaryTree.addElement(8);
        binaryTree.addElement(7);
        binaryTree.addElement(2);

        assertEquals(false, binaryTree.findElement(1));
    }

    @Test
    public void getLeftChild() {
        binaryTree.addElement(4);
        binaryTree.addElement(8);
        binaryTree.addElement(7);

        try {
            assertEquals(binaryTree.getLeftChild(5), 4);
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getRightChild() {
        binaryTree.addElement(4);
        binaryTree.addElement(8);
        binaryTree.addElement(7);

        try {
            assertEquals(binaryTree.getRightChild(5), 8);
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getSortedTreeAsc() {
        binaryTree.addElement(4);
        binaryTree.addElement(8);
        binaryTree.addElement(7);
        binaryTree.addElement(3);
        binaryTree.addElement(2);
        binaryTree.addElement(9);

        List<Integer> expected = Arrays.asList(2, 3, 4, 5, 7, 8, 9);
        assertEquals(expected, binaryTree.getSortedTreeAsc());
    }

    @Test
    public void getSortedTreeDesc() {
        binaryTree.addElement(4);
        binaryTree.addElement(8);
        binaryTree.addElement(7);
        binaryTree.addElement(3);
        binaryTree.addElement(2);
        binaryTree.addElement(9);

        List<Integer> expected = Arrays.asList(9, 8, 7, 5, 4, 3, 2);
        assertEquals(expected, binaryTree.getSortedTreeDesc());
    }
}