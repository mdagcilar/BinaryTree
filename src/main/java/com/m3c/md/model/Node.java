package com.m3c.md.model;

public class Node {

    private int value;
    private Node left, right;

    public Node(int value) {
        this.value = value;
        right = null;
        left = null;
    }

    public int getValue(){
        return value;
    }
}