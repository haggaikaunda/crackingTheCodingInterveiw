package com.Questions.Chapter2;

/**
 * Created by hkaunda on 11/26/17.
 */
public class kthToLast {
	static class Index {
		public int value = -1;
	}

    static <T> LinkedListNode<T> kthToLast(LinkedListNode<T> head, int k) {
    	Index index = new Index();

    	return head == null ? null : kthToLast(head, k, index);
    }

    static <T> LinkedListNode<T> kthToLast(LinkedListNode<T> head,
    										 int k, Index indexFromLast) {
    	if (head.next == null) {
    	    indexFromLast.value++;
    		return head;
    	}

    	LinkedListNode<T> node = kthToLast(head.next, k, indexFromLast);
    	if (indexFromLast.value == k) {
    	    return node;
        }
    	indexFromLast.value++;
    	return head;
//    	if (indexFromLast.value++ == k) {
//    		return head;
//    	}
//    	return node;
    }

    public static void main(String... args) {
    	LinkedListNode<Integer> list = new LinkedListNode<Integer>();
    	for(int i = 0; i < 10; list.add(i++));
    	LinkedListNode<Integer> result = kthToLast(list, 2);
    	assert result.data == 7;
    }


}
