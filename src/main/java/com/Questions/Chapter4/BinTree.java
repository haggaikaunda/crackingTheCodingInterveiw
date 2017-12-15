package com.Questions.Chapter4;


/**
 * Created by hkaunda on 12/13/17.
 */
class BinTree<T> extends GraphNode<T> {
	Node root;
	public BinTree() {
	
	}

	public void put(T data) {
		Node newNode = new Node(data);

		if (isEmpty()) {
			root = newNode;
		} else {
			root.put(newNode);
		}
	}

	public String toString() {
		if (isEmpty()) return "";
		return root.toString();
	}

	public boolean isEmpty() {
		return root == null;
	}


    class Node {
    	Node left, right;
    	T data;

    	Node(T data) {
    		this.data = data;
    	}

    	private void put(Node node) {
    		/* unchecked */
			Comparable<? super T> myData = (Comparable<? super T>) data;
    		if (myData.compareTo(node.data) < 1) {
    			if (left == null) left = node;
    			else left.put(node);
    		} else if (myData.compareTo(node.data) > 1) {
    			if (right == null) right = node;
    			else right.put(node);
    		}
    	}

		/**
		 * returns all the values of this node and it's children in increasing order, ie by traversing the tree
		 * represented by the node using an 'inorder' traversal.
		 */
		public String toString() {
    		String result = "";

    		if (left != null) {
    			result += left.toString();
			}

			result += String.format("%s ", data);
    		if (right != null) {
    			result += right.toString();
			}

    		return result;
		}
    }
}
