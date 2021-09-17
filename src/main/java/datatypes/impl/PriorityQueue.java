package datatypes.impl;

import datatypes.Queue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PriorityQueue<T extends Comparable<T>> implements Queue<T> {
    private Comparator<T> comparator;
    private List<T> heap;
    private int currentSize = 0;
    private int MAX_SIZE = (int) 1e6;

    public PriorityQueue(Comparator<T> comparator) {
        this.comparator = comparator;
        heap = new ArrayList<>();
    }

    private PriorityQueue(int capacity) {
        if (capacity < 0)
            throw new IllegalArgumentException("Capacity cannot be negative");
        heap = new ArrayList<>(capacity);
    }

    public PriorityQueue() {
        this(Comparable::compareTo);
        heap = new ArrayList<>();
    }



    private void sink(int k, T x, Comparator<T> comparator, int size) {
        if (currentSize==0) {
            heap.add(x);
            return;
        }
        int upto = size >>> 1;
        while (k < upto) {
            int child = (k << 1) + 1; //left child
            //this will store lower priority element of immediate child
            T downLeast = heap.get(child);
            int right = child + 1;
            if (right < size && comparator.compare(downLeast, heap.get(right)) > 0)
                downLeast = heap.get(child = right);
            if (comparator.compare(x, downLeast) <= 0)
                break;
            heap.set(k, downLeast);
            k = child;
        }
        heap.set(k, x);
    }

    private void swim(int k, T x, Comparator<T> comparator, int size) {
        while (k > 0) {
            int upto = (k - 1) >>> 1;
            T upValue = heap.get(upto);
            if (comparator.compare(x, upValue) > 0)
                break;
            heap.set(k, upValue);
            k = upto;
        }
        heap.set(k, x);
    }

    @Override
    public boolean add(T value) {
        if (value == null)
            throw new IllegalArgumentException("Null value not supported");
        heap.add(value);
        ++currentSize;
        swim(currentSize - 1, heap.get(currentSize - 1), this.comparator, currentSize);
        return true;
    }

    @Override
    public T peek() {
        if (currentSize <= 0)
            throw new IllegalArgumentException("Queue is empty");
        return heap.get(0);
    }

    @Override
    public T poll() {
        if (currentSize <= 0)
            throw new IllegalArgumentException("Queue is empty");
        T value = heap.get(0);
        --currentSize;
        T removed = heap.remove(currentSize);
        sink(0, removed, this.comparator, currentSize);
        return value;
    }

    @Override
    public boolean isEmpty() {
        return currentSize<=0;
    }


}
