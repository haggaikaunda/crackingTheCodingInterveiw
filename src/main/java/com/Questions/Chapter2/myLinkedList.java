
package com.Questions.Chapter2;

import java.util.HashSet;

/**
 * Created by hkaunda on 11/26/17.
 */
public class myLinkedList<T> {

    Node head, tail;
    int size;

    public myLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void add(T k) {
        size++;
        Node newVal = new Node(k);
        if (is_empty()) {
            head = newVal;
            tail = newVal;
        } else {
            tail.next = newVal;
            tail = newVal;
        }
    }

    public T get(int i) {
        Node temp = head;
        while(temp != null) {
            if (i == 0) {
                return temp.value;
            }
            temp = temp.next;
            i--;
        }
        throw new IndexOutOfBoundsException(String.format("%d", i));
    }

    public boolean is_empty() {
        return head == null;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node temp = head;
        while (temp != null) {
            stringBuilder.append(temp != tail ? temp.value + " ->" : " " + temp.value);
            temp = temp.next;
        }
        return stringBuilder.toString();
    }

    class Node {
        T value;
        Node next;
        Node(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.format("value : %s, next : %s", value, next);
        }

        public boolean equals(Object o) {
            if (o instanceof myLinkedList.Node) {
                Node other = (myLinkedList.Node) o;
                return other.value == this.value;
            }
            return false;
        }
    }


    public static void main(String... args) {
//        myLinkedList<Integer> mylist = new myLinkedList<Integer>();
//        for (int i = 0; i < 10; mylist.add(i++));
//        StringBuilder stringBuilder = new StringBuilder();
//        for (int i = 0; i < 10; stringBuilder.append(String.format("%d ", mylist.get(i++))));
//        System.out.println(stringBuilder.toString());

        myLinkedList<Integer> linkedList = new myLinkedList<Integer>();
        myLinkedList<Integer> list = new myLinkedList<Integer>();
        for(int i = 0; i < 10; list.add(i), linkedList.add(i), linkedList.add(i++));
        linkedList.removeDuplicates();
        System.out.println(String.format("expected : %s \nactual   : %s", list.toString(), linkedList.toString()));
        assert list.toString().equals(linkedList.toString());
    }

    // ******************* Questions from Cracking the coding interview on LinkedLists begin here. *********** //

    public void removeDuplicates() {
        HashSet<T> set = new HashSet<>();
        Node node = head;
        if (node == null) {
            return;
        }
        set.add(node.value);
        Node lead = node.next;
        while (lead != null) {

            if (set.contains(lead.value)) {
                node.next = lead.next;
            } else {
                set.add(lead.value);
                node = lead;
            }
            lead = lead.next;
        }
    }
}