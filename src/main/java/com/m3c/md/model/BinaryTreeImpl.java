package com.m3c.md.model;

import com.m3c.md.controller.ElementNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeImpl implements BinaryTree {

    private Node root;
    private int numberOfNodes = 1;
    private List<Integer> sortedTreeAsc = new ArrayList<Integer>();
    private List<Integer> sortedTreeDesc = new ArrayList<Integer>();

    public BinaryTreeImpl(int rootValue) {
        root = new Node(rootValue);
    }

    public int getRootElement() {
        return root.getValue();
    }

    public int getNumberOfElements() {
        return numberOfNodes;
    }

    public void addElement(final int element) {
        addElementHelper(root, element);
    }

    public void addElements(int[] elements) {
        //loop through elements and call addElement
        for (int i : elements) {
            addElementHelper(root, i);
        }
    }

    /**
     * @param value
     * @return
     */
    public boolean findElement(final int value) {
        if (getNode(root, value) != null && getNode(root, value).getValue() == value)
            return true;
        else
            return false;
    }

    /**
     * @param element
     * @return
     * @throws ElementNotFoundException
     */
    public int getLeftChild(int element) throws ElementNotFoundException {
        if (findElement(element)) {
            Node node = getNode(root, element);
            return node.getLeftChild().getValue();
        }
        return 0;
    }

    /**
     * @param element
     * @return
     * @throws ElementNotFoundException
     */
    public int getRightChild(int element) throws ElementNotFoundException {
        if (findElement(element)) {
            Node node = getNode(root, element);
            return node.getRightChild().getValue();
        }
        return 0;
    }

    public List<Integer> getSortedTreeAsc() {
        getSortedTreeAscHelper(root);
        return sortedTreeAsc;
    }

    public List<Integer> getSortedTreeDesc() {
        getSortedTreeDescHelper(root);
        return sortedTreeDesc;
    }

    /**
     * @param node
     * @param element
     * @return
     */
    private Node addElementHelper(Node node, int element) {
        if (node == null) {
            node = new Node(element);
        }

        if (element <= node.getValue()) {
            if (node.isLeftChildEmpty()) {
                node.setLeftChild(new Node(element));
                numberOfNodes++;
            } else {
                node.setLeftChild(addElementHelper(node.getLeftChild(), element));
            }
        } else if (node.isRightChildEmpty()) {
            node.setRightChild(new Node(element));
            numberOfNodes++;
        } else {
            node.setRightChild(addElementHelper(node.getRightChild(), element));
        }
        return node;
    }

    /**
     * @param node
     * @param value
     * @return
     */
    private Node getNode(Node node, final int value) {
        while (node != null) {
            if (node.getValue() == value) return node;
            if (value < node.getValue()) {
                node = node.getLeftChild();
            } else if (value > node.getValue()) {
                node = node.getRightChild();
            }
        }
        return null;
    }

    /**
     * @param node
     * @return
     */
    private void getSortedTreeAscHelper(Node node) {
        if (node != null) {
            getSortedTreeAscHelper(node.getLeftChild());
            sortedTreeAsc.add(node.getValue());
            getSortedTreeAscHelper(node.getRightChild());
        }
    }

    private void getSortedTreeDescHelper(Node node) {
        if (node != null) {
            getSortedTreeDescHelper(node.getRightChild());
            sortedTreeDesc.add(node.getValue());
            getSortedTreeDescHelper(node.getLeftChild());
        }
    }
}
