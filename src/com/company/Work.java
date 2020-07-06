package com.company;

import java.util.NoSuchElementException;


class Work<E> {

    private Node head;
    private Node tail;
    private int size;

    public Work() {
        size = 0;
    }

    /**
     * this class keeps track of each element information
     *
     * @author java2novice
     */
    public class Node {
        E element;
        Node next;
        Node prev;

        public Node(E element, Node next, Node prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }

    public int size() {
        return size;
    }

    public E seeLast() {
        return tail.element;
    }

    public E seeFirst() {
        return head.element;
    }

    public void addLast(E element) {

        Node tmp = new Node(element, null, tail);
        if (tail != null) {
            tail.next = tmp;
        }
        tail = tmp;
        if (head == null) {
            head = tmp;
        }
        size++;
    }

    public E removeAndReturnFirst() {
        if (size == 0) throw new NoSuchElementException();
        Node tmp = head;
        if (size != 1) {
            head = head.next;
            head.prev = null;
        } else {
            head = null;
            tail = null;
        }
        size--;
        return tmp.element;
    }
}


