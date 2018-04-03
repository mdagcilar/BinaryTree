package com.m3c.md.model;

import com.m3c.md.controller.ElementNotFoundException;

import java.util.List;

public class BinaryTreeIml implements BinaryTree{

    Node root;

    public int getRootElement() {
        return root.getValue();
    }

    public int getNumberOfElements() {
        return 0;
    }

    public void addElement(int element) {

    }

    public void addElements(int[] elements) {

    }

    public boolean findElement(int value) {
        return false;
    }

    public int getLeftChild(int element) throws ElementNotFoundException {
        return 0;
    }

    public int getRightChild(int element) throws ElementNotFoundException {
        return 0;
    }

    public List<Integer> getSortedTreeAsc() {
        return null;
    }

    public List<Integer> getSortedTreeDesc() {
        return null;
    }
}
