package org.example;

import java.util.Iterator;

public class MyArrayList<T> implements MyList<T> {
    private Object[] elements = new Object[100];
    private int size = 0;

    public void add(T element) {
        elements[size++] = element;
    }

    public void add(int index, T element) {
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size++;
    }

    public void addFirst(T element) {
        add(0, element);
    }

    public void addLast(T element) {
        add(element);
    }

    public T get(int index) {
        return (T) elements[index];
    }

    public T getFirst() {
        return get(0);
    }

    public T getLast() {
        return get(size - 1);
    }

    public void set(int index, T element) {
        elements[index] = element;
    }

    public T remove(int index) {
        T removed = (T) elements[index];
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        size--;
        return removed;
    }

    public void removeFirst() {
        remove(0);
    }

    public void removeLast() {
        remove(size - 1);
    }

    public void clear() {
        size = 0;
    }

    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(object)) return i;
        }
        return -1;
    }

    public int lastIndexOf(Object object) {
        for (int i = size - 1; i >= 0; i--) {
            if (elements[i].equals(object)) return i;
        }
        return -1;
    }

    public void sort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                Comparable<T> a = (Comparable<T>) elements[i];
                T b = (T) elements[j];
                if (a.compareTo(b) > 0) {
                    Object temp = elements[i];
                    elements[i] = elements[j];
                    elements[j] = temp;
                }
            }
        }
    }

    public int size() {
        return size;
    }

    public Object[] toArray() {
        Object[] array = new Object[size];
        for (int i = 0; i < size; i++) {
            array[i] = elements[i];
        }
        return array;
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = 0;
            public boolean hasNext() { return index < size; }
            public T next() { return (T) elements[index++]; }
        };
    }
}