package com.lxf.study.simplecase.datastructure;

public class BinaryTree {

    private int[] arr;

    private int size = 0;

    private int capacity;

    private Node root;

    public BinaryTree(int capacity) {
        this.arr = new int[capacity];
        this.capacity = capacity;
    }

    public void add(int value) {
        root = new Node(value, null, null);
    }

    public int size() {

        return size;

    }


    private static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

}
