package com.Questions.Chapter4;

/**
 * Created by hkaunda on 12/13/17.
 */
public abstract class GraphNode<T> {
    Node root;

    abstract class Node {
        Node left, right;
        T data;
        public Node(T data) {
            this.data = data;
        }
    }
}
