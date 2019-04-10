package org.aabutaleb.algorithms;

import org.aabutaleb.algorithms.tree.data.BinaryTree;

public class Main {
    public static void main(String[] args) {
        BinaryTree tree = BinaryTree.build();
        tree.print(BinaryTree.Traversal.INORDER);
    }
}
