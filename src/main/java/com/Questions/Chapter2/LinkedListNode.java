package com.Questions.Chapter2;

class LinkedListNode<T> {
	public LinkedListNode<T> next, last;
	public T data;
    public LinkedListNode() {

	}
	public LinkedListNode(T data) {
		this.data = data;
	}

	public void add(T data) {
	    if (is_empty()) {
	        this.data = data;
	        last = this;
        } else {
            LinkedListNode<T> newNode = new LinkedListNode<T>(data);
            newNode.last = newNode;
            last.next = newNode;
            last = newNode;
        }
	}

	public T get(int i) {
		LinkedListNode<T> curr = this;
		while(curr != null ) {
			if (i == 0) {
				return curr.data;
			} else {
				curr = curr.next;
				i--;
			}
		}
		throw new IndexOutOfBoundsException();
	}
	
	public boolean is_empty() {
		return last == null;
	}

}