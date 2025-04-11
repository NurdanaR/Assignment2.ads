package org.example;

import java.util.Iterator;

public interface MyList<T> extends Iterable<T> {
    void add(T element);
    void add(int index, T element);
    T get(int index);
    void set(int index, T element);
    T remove(int index);
    void removeFirst();
    void removeLast();
    T getFirst();
    T getLast();
    void addFirst(T element);
    void addLast(T element);
    void clear();
    boolean exists(Object object);
    int indexOf(Object object);
    int lastIndexOf(Object object);
    void sort();
    int size();
    Object[] toArray();
    Iterator<T> iterator();
}