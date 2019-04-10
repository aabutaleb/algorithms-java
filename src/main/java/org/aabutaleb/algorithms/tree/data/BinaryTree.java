package org.aabutaleb.algorithms.tree.data;

import org.aabutaleb.algorithms.util.DataLoader;

import java.io.IOException;
import java.util.Arrays;

public class BinaryTree {
    private Node root;

    public enum Traversal {
        PREORDER, INORDER, POSTORDER;
    }

    private BinaryTree(){}

    public static BinaryTree build() {
        var newobject = new BinaryTree();
        try {
            newobject.loadData(DataLoader.read("integers-tree.data"));
        } catch (IOException e) {
            System.err.println("Couldn't load the data");
            e.printStackTrace();
        }
        return newobject;
    }

    private void loadData(int[] arr) {
        Arrays.stream(arr).forEach(x -> {
            root = insert(root, x);
        });
    }

    public boolean isBST() {
        return checkBST(root);
    }

    private boolean checkBST(Node root) {
        if (root != null) {
            return (checkBST(root.getLeft()) && checkBST(root.getRight()) &&
                    (root.getLeft() == null || root.getLeft().getValue() < root.getValue()) &&
                    (root.getRight() == null || root.getRight().getValue() > root.getValue()));
        }
        else return true;
    }

    private Node insert(Node root, int data) {
        if (root == null) {
            root = new Node(data);
        }
        else if (root.getValue() < data){
            root.setRight(insert(root.getRight(), data));
        }
        else {
            root.setLeft(insert(root.getLeft(), data));
        }
        return root;
    }

    public void print(Traversal traversal){
        System.out.println("Printing tree:");
        switch (traversal){
            case INORDER:{
                printInorder(root);
                break;
            }
            case PREORDER:{
                printPreorder(root);
                break;
            }
            case POSTORDER:{
                printPostOrder(root);
                break;
            }
        }
        System.out.println("\b\n----");
    }

    private void printPostOrder(Node root) {
        if (root != null) {
            printPostOrder(root.getLeft());
            printPostOrder(root.getRight());
            System.out.print(root.getValue()+",");
        }
    }

    private void printPreorder(Node root) {
        if (root != null) {
            System.out.print(root.getValue() + ",");
            printPreorder(root.getLeft());
            printPreorder(root.getRight());
        }
    }

    private void printInorder(Node root) {
        if (root != null) {
            printInorder(root.getLeft());
            System.out.print(root.getValue() + ",");
            printInorder(root.getRight());
        }
    }

    class Node {
        private int value;
        private Node right;
        private Node left;

        Node(int value){
            this.value = value;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public int getValue() {
            return value;
        }
    }
}
