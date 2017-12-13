package com.Questions.Chapter2;

import java.util.NoSuchElementException;

public class kthToLast2 {
	static <T> LinkedListNode<T> kthToLast2(LinkedListNode<T> head, int k) {
		try {
			return head == null ? null : kthToLast2(head, new Index(k));
		} catch(IllegalArgumentException e) {
			throw new NoSuchElementException(String.format("%d", k));
		}
	}

	static <T> LinkedListNode<T> kthToLast2(LinkedListNode<T> head, Index index) {
		if (head.next == null) {
			return head;
		}

		LinkedListNode<T> node = kthToLast2(head.next, index);

		if (index.k > 0) {
			index.k--;
			return head;
		} else if (index.k == 0) {
			return node;
		} else {
			throw new IllegalArgumentException();
		}
	}

	public static void main(String... args) {
		LinkedListNode<Integer> list = new LinkedListNode<Integer>();
        for(int i = 0; i < 5; list.add(i++));
        LinkedListNode<Integer> result = kthToLast2(list, 2);
        assert result.data == 4;
	}

	static class Index {
		int k;
		Index(int k) {
			this.k = k;
		}
	}
}