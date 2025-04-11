package org.example;

import java.util.Iterator;

public class MyLinkedList<T> implements MyList<T> {
    private class MyNode {
        T data;
        MyNode next, prev;
        MyNode(T data) { this.data = data; }
    }

    private MyNode head, tail;
    private int size;

    public void add(T element) {
        addLast(element);
    }

    public void add(int index, T element) {
        if (index == 0) addFirst(element);
        else if (index == size) addLast(element);
        else {
            MyNode current = getNode(index);
            MyNode node = new MyNode(element);
            node.prev = current.prev;
            node.next = current;
            current.prev.next = node;
            current.prev = node;
            size++;
        }
    }

    public void addFirst(T element) {
        MyNode node = new MyNode(element);
        if (head == null) head = tail = node;
        else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
    }

    public void addLast(T element) {
        MyNode node = new MyNode(element);
        if (tail == null) head = tail = node;
        else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }

    public T get(int index) {
        return getNode(index).data;
    }

    public T getFirst() {
        return head.data;
    }

    public T getLast() {
        return tail.data;
    }

    public void set(int index, T element) {
        getNode(index).data = element;
    }

    public T remove(int index) {
        MyNode current = getNode(index);
        if (current.prev != null) current.prev.next = current.next;
        else head = current.next;
        if (current.next != null) current.next.prev = current.prev;
        else tail = current.prev;
        size--;
        return current.data;
    }

    public void removeFirst() {
        remove(0);
    }

    public void removeLast() {
        remove(size - 1);
    }

    public void clear() {
        head = tail = null;
        size = 0;
    }

    public boolean exists(Object obj) {
        return indexOf(obj) != -1;
    }

    public int indexOf(Object obj) {
        MyNode current = head;
        int i = 0;
        while (current != null) {
            if (current.data.equals(obj)) return i;
            current = current.next;
            i++;
        }
        return -1;
    }

    public int lastIndexOf(Object obj) {
        MyNode current = tail;
        int i = size - 1;
        while (current != null) {
            if (current.data.equals(obj)) return i;
            current = current.prev;
            i--;
        }
        return -1;
    }

    public void sort() {}

    public int size() {
        return size;
    }

    public Object[] toArray() {
        Object[] array = new Object[size];
        MyNode current = head;
        int i = 0;
        while (current != null) {
            array[i++] = current.data;
            current = current.next;
        }
        return array;
    }

    private MyNode getNode(int index) {
        MyNode current = head;
        for (int i = 0; i < index; i++) current = current.next;
        return current;
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            MyNode current = head;
            public boolean hasNext() { return current != null; }
            public T next() {
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }
}