package com.Questions.Chapter2;
import com.Questions.Chapter2.myLinkedList.Node;

import java.util.HashSet;

/**
 * Created by hkaunda on 11/26/17.
 */
public class removeDups {
    public static void removeDuplicates(Node node) {
        HashSet set = new HashSet();
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
    public static void main(String... args) {
    	myLinkedList<Integer> linkedList = new myLinkedList<Integer>();
    	myLinkedList<Integer> list = new myLinkedList<Integer>();
    	for(int i = 0; i < 10; list.add(i), linkedList.add(i), linkedList.add(i++));
    	removeDuplicates(linkedList.head);
    	System.out.println(String.format("expected : %s \nactual   : %s", list.toString(), linkedList.toString()));
    	assert list.toString().equals(linkedList.toString());
    }
}
