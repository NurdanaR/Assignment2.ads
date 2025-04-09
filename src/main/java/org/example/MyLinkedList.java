package org.example;

public class MyLinkedList<T> implements MyList<T> {
    private class Node {
        T data;
        Node next;
        Node prev;

        Node(T data) {
            this.data = data;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public void add(T element) {
        Node newNode = new Node(element);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public void add(T element, int index) {

    }

    public void add(int index, T element) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        Node newNode = new Node(element);
        if (index == 0) {
            newNode.next = head;
            if (head != null) head.prev = newNode;
            head = newNode;
            if (tail == null) tail = newNode;
        } else if (index == size) {
            add(element);
            return;
        } else {
            Node current = getNode(index);
            Node prevNode = current.prev;
            prevNode.next = newNode;
            newNode.prev = prevNode;
            newNode.next = current;
            current.prev = newNode;
        }
        size++;
    }

    public T get(int index) {
        return getNode(index).data;
    }

    public T remove(int index) {
        Node toRemove = getNode(index);
        if (toRemove.prev != null) toRemove.prev.next = toRemove.next;
        else head = toRemove.next;

        if (toRemove.next != null) toRemove.next.prev = toRemove.prev;
        else tail = toRemove.prev;

        size--;
        return toRemove.data;
    }

    public boolean remove(T element) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(element)) {
                if (current.prev != null) current.prev.next = current.next;
                else head = current.next;

                if (current.next != null) current.next.prev = current.prev;
                else tail = current.prev;

                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    private Node getNode(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node current = head;
        for (int i = 0; i < index; i++) current = current.next;
        return current;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        head = tail = null;
        size = 0;
    }

    public boolean contains(T element) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(element)) return true;
            current = current.next;
        }
        return false;
    }

    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
            private Node current = head;

            public boolean hasNext() {
                return current != null;
            }

            public T next() {
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }
}