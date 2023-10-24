package queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DoubleEndedQueueTest {

    private DoubleEndedQueue<Integer> queue;

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
}
