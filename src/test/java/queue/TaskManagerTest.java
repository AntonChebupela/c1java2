package queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskManagerTest {

    private TaskManager taskManager;

    @BeforeEach
    void setUp() {
        taskManager = new TaskManager(new DoubleEndedQueue<>());
    }

    @Test
    void testAddAndPerformTasks() {

        taskManager.addPriorityTask(new Task("Priority 1", "Urgent task"));
        taskManager.addRegularTask(new Task("Regular 1", "Normal task"));
        taskManager.addPriorityTask(new Task("Priority 2", "Another urgent task"));
        taskManager.addRegularTask(new Task("Regular 2", "Another normal task"));

        taskManager.performTask();
        taskManager.performTask();
        taskManager.performTask();
        taskManager.performTask();

        assertEquals(0, taskManager.size());
    }

    @Test
    void testPerformTaskWhenEmpty() {

        taskManager.performTask();
        assertEquals(0, taskManager.size());
    }

    @Test
    void testAddTask() {

        taskManager.addPriorityTask(new Task("Priority", "Urgent task"));
        taskManager.addRegularTask(new Task("Regular", "Normal task"));

        assertEquals(2, taskManager.size());
    }

    @Test
    void testDisplayTasks() {

        taskManager.addPriorityTask(new Task("Priority", "Urgent task"));
        taskManager.addRegularTask(new Task("Regular", "Normal task"));


        assertEquals(2, taskManager.size());
    }

}
