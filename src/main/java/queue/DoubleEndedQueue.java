package queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoubleEndedQueue<T> implements Iterable<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;

    private static class Node<T> {
        private T data;
        private Node<T> next;
        private Node<T> prev;

        public Node(T data) {
            this.data = data;
        }
    }

    public DoubleEndedQueue() {
        first = null;
        last = null;
        size = 0;
    }

    public void addFirst(T item) {
        Node<T> newNode = new Node<>(item);
        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            newNode.next = first;
            first.prev = newNode;
            first = newNode;
        }
        size++;
    }


    public void addLast(T item) {
        Node<T> newNode = new Node<>(item);
        if (isEmpty()) {
            first = newNode;
        } else {
            newNode.prev = last;
            last.next = newNode;
        }
        last = newNode;
        size++;
    }


    public T removeFirst() {
        checkIsEmpty();
        T data = first.data;
        if (first == last) {
            first = null;
            last = null;
        } else {
            first = first.next;
            if (first != null) {
                first.prev = null;
            }
        }
        size--;
        return data;
    }


    public T removeLast() {
        checkIsEmpty();
        T data = last.data;
        if (first == last) {
            first = null;
            last = null;
        } else {
            last = last.prev;
            if (last != null) {
                last.next = null;
            }
        }
        size--;
        return data;
    }


    private class DoubleEndedIterator implements Iterator<T> {
        private Node<T> current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T data = current.data;
            current = current.next;
            return data;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new DoubleEndedIterator();
    }

    public void addAtIndex(int index, T item) {
        checkIndex(index);
        if (index == 0) {
            addFirst(item);
        } else if (index == size) {
            addLast(item);
        } else {
            Node<T> newNode = new Node<>(item);
            Node<T> current = first;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            newNode.prev = current.prev;
            newNode.next = current;
            current.prev.next = newNode;
            current.prev = newNode;
            size++;
        }
    }


    public int find(T item) {
        Node<T> current = first;
        int index = 0;
        while (current != null) {
            if (current.data.equals(item)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }


    public void updateAtIndex(int index, T newItem) {
        checkIndex(index);
        Node<T> current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.data = newItem;
    }


    public T getFirst() {
        checkIsEmpty();
        return first.data;
    }


    public T getLast() {
        checkIsEmpty();
        return last.data;
    }


    public void clear() {
        first = null;
        last = null;
        size = 0;
    }


    public boolean contains(T item) {
        return find(item) != -1;
    }


    public boolean isEmpty() {
        return size == 0;
    }


    public int size() {
        return size;
    }


    public T get(int index) {
        checkIndex(index);
        Node<T> current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    public void removeAtIndex(int index) {
        checkIndex(index);
        if (index == 0) {
            removeFirst();
        } else if (index == size() - 1) {
            removeLast();
        } else {
            Node<T> current = first;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            current.prev.next = current.next;
            current.next.prev = current.prev;
            current.next = null;
            current.prev = null;
            size--;
        }
    }
    private void checkIndex(int index) {
        if (isEmpty() || index < 0 || index >= size()) {
            throw new NoSuchElementException("Invalid index");
        }
    }
    private void checkIsEmpty() {
        if (isEmpty()) {
            throw new NoSuchElementException("Очередь пуста");
        }
    }
}