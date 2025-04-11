package org.example;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> arrayList = new MyArrayList<>();
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(1, 15);
        System.out.println("ArrayList:");
        for (int n : arrayList) System.out.print(n + " ");
        System.out.println();

        MyLinkedList<String> linkedList = new MyLinkedList<>();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.addFirst("Start");
        System.out.println("LinkedList:");
        for (String s : linkedList) System.out.print(s + " ");
        System.out.println();

        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        System.out.println("Stack pop: " + stack.pop());

        MyQueue<String> queue = new MyQueue<>();
        queue.enqueue("One");
        queue.enqueue("Two");
        System.out.println("Queue dequeue: " + queue.dequeue());

        MyMinHeap<Integer> heap = new MyMinHeap<>();
        heap.insert(5);
        heap.insert(2);
        heap.insert(8);
        System.out.println("Min in heap: " + heap.getMin());
        System.out.println("Extract min: " + heap.extractMin());
    }
}