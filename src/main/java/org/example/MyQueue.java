package org.example;

public class MyQueue<T> {
    private MyLinkedList<T> list = new MyLinkedList<>();

    public void enqueue(T element) {
        list.addLast(element);
    }

    public T dequeue() {
        return list.remove(0);
    }

    public T peek() {
        return list.getFirst();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public int size() {
        return list.size();
    }
}