package org.example;

public class MyMinHeap<T extends Comparable<T>> {
    private MyArrayList<T> heap;

    public MyMinHeap() {
        heap = new MyArrayList<>();
        heap.add(null); // для удобства — индекс 0 не используется
    }

    public void insert(T element) {
        heap.add(element);
        traverseUp(heap.size() - 1);
    }

    public T extractMin() {
        if (isEmpty()) return null;
        T min = heap.get(1);
        T last = heap.remove(heap.size() - 1);
        if (!isEmpty()) {
            heap.set(1, last);
            heapify(1);
        }
        return min;
    }

    public T getMin() {
        if (isEmpty()) return null;
        return heap.get(1);
    }

    public boolean isEmpty() {
        return heap.size() <= 1;
    }

    public int size() {
        return heap.size() - 1;
    }

    void heapify(int index) {
        int smallest = index;
        int left = leftChildOf(index);
        int right = rightChildOf(index);

        if (left < heap.size() && heap.get(left).compareTo(heap.get(smallest)) < 0) {
            smallest = left;
        }
        if (right < heap.size() && heap.get(right).compareTo(heap.get(smallest)) < 0) {
            smallest = right;
        }
        if (smallest != index) {
            swap(index, smallest);
            heapify(smallest);
        }
    }

    void traverseUp(int index) {
        while (index > 1 && heap.get(index).compareTo(heap.get(parentOf(index))) < 0) {
            swap(index, parentOf(index));
            index = parentOf(index);
        }
    }

    void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    int leftChildOf(int i) {
        return 2 * i;
    }

    int rightChildOf(int i) {
        return 2 * i + 1;
    }

    int parentOf(int i) {
        return i / 2;
    }
}