package org.example;

public interface MyList<T> extends Iterable<T> {
    void add(T element);
    void add(T element, int index);
    T get(int index);
    T remove(int index);
    boolean remove(T element);
    int size();
    boolean isEmpty();
    void clear();
    boolean contains(T element);
}
