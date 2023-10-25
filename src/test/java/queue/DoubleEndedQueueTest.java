package queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class DoubleEndedQueueTest {

    private DoubleEndedQueue<Object> queue;

    @BeforeEach
    void beforeEach() {
        queue = new DoubleEndedQueue<>();
    }

    @Test
    void test1() {
        int quantity = 10;
        for (int i = 0; i < quantity; i++) {
            queue.addFirst(i);
        }
        for (int i = 0; i < quantity; i++) {
            assertEquals(i, queue.getLast());
            queue.removeLast();
            assertEquals(quantity - i - 1, queue.size());
        }

    }

    @Test
    void testAddFirstAndRemoveFirst() {
        queue.addFirst(3);
        queue.addFirst(2);
        queue.addFirst(1);
        queue.addFirst("cherry");
        queue.addFirst("banana");
        queue.addFirst("apple");

        assertEquals("apple", queue.removeFirst());
        assertEquals("banana", queue.removeFirst());
        assertEquals("cherry", queue.removeFirst());
        assertEquals(1, queue.removeFirst());
        assertEquals(2, queue.removeFirst());
        assertEquals(3, queue.removeFirst());

        assertEquals(0, queue.size());
    }

    @Test
    void testAddLastAndRemoveLast() {
        queue.addLast(30);
        queue.addLast(20);
        queue.addLast(10);
        queue.addLast("fox");
        queue.addLast("elephant");
        queue.addLast("dog");

        assertEquals("dog", queue.removeLast());
        assertEquals("elephant", queue.removeLast());
        assertEquals("fox", queue.removeLast());
        assertEquals(10, queue.removeLast());
        assertEquals(20, queue.removeLast());
        assertEquals(30, queue.removeLast());

        assertEquals(0, queue.size());
    }

    @Test
    void testAddAtIndex() {
        queue.addFirst("apple");
        queue.addFirst("banana");
        queue.addFirst("cherry");


        queue.addAtIndex(1, "orange");

        assertEquals("cherry", queue.get(0));
        assertEquals("orange", queue.get(1));
        assertEquals("banana", queue.get(2));
    }

    @Test
    void testFind() {
        queue.addLast("apple");
        queue.addLast("banana");
        queue.addLast("cherry");

        int index = queue.find("banana");

        assertEquals(1, index);
    }



    @Test
    void testUpdateAtIndex() {
        queue.addLast("apple");
        queue.addLast("banana");
        queue.addLast("cherry");

        queue.updateAtIndex(1, "orange");

        assertEquals("apple", queue.get(0));
        assertEquals("orange", queue.get(1));
        assertEquals("cherry", queue.get(2));
    }
    @Test
    void testGetFirst() {
        queue.addFirst("apple");
        queue.addLast("banana");
        queue.addLast("cherry");

        assertEquals("apple", queue.getFirst());
    }

    @Test
    void testClear() {
        queue.addLast("apple");
        queue.addLast("banana");

        queue.clear();

        assertEquals(0, queue.size());
    }

    @Test
    void testContains() {
        queue.addFirst("apple");
        queue.addLast("banana");
        queue.addLast("cherry");

        assertEquals(true, queue.contains("banana"));
        assertEquals(false, queue.contains("grape"));
    }

    @Test
    void testRemoveAtIndex() {
        queue.addFirst("apple");
        queue.addLast("banana");
        queue.addLast("cherry");

        queue.removeAtIndex(1);

        assertEquals("apple", queue.get(0));
        assertEquals("cherry", queue.get(1));
    }

}
