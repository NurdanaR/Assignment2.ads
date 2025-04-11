package org.example;

public class MyStack<T> {
    private MyArrayList<T> list = new MyArrayList<>();

    public void push(T element) {
        list.add(element);
    }

    public T pop() {
        return list.remove(list.size() - 1);
    }

    public T peek() {
        return list.get(list.size() - 1);
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public int size() {
        return list.size();
    }
}