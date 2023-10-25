package queue;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import queue.Task;
import queue.TaskManager;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskManagerTest {

    TaskManager taskManager = new TaskManager();

    @BeforeEach
    void setUp() {
        taskManager = new TaskManager();
    }

    private void printSeparator() {
        System.out.println("_____________________________");
    }

    @Test
    void testTask1() {
        taskManager.addPriorityTask(new Task("Priority 1", "Perform urgent task 1"));
        taskManager.addPriorityTask(new Task("Priority 2", "Prepare a report for a meeting 2"));
        taskManager.addRegularTask(new Task("Regular 1", "Send a letter to a client 3"));
        taskManager.addRegularTask(new Task("Regular 2", "Order office supplies 4"));

        printSeparator();
        taskManager.performPriorityTask();
        taskManager.performRegularTask();
        printSeparator();

        if (taskManager.size() > 0) {
            taskManager.displayTasks();
        } else {
            System.out.println("Task queue is empty.");
        }

        System.out.println("------------------------------"); // Добавляем разделение
    }

    @Test
    void testTask2() {
        taskManager.addPriorityTask(new Task("Priority 1", "Prepare an important report 1"));
        taskManager.addRegularTask(new Task("Regular 1", "Send a letter to a client 2"));
        taskManager.addPriorityTask(new Task("Priority 2", "Call investors 3"));
        taskManager.addRegularTask(new Task("Regular 2", "Prepare sales report 4"));

        printSeparator();
        while (taskManager.size() > 0) {
            if (Math.random() < 0.5) {
                taskManager.performPriorityTask();
            } else {
                taskManager.performRegularTask();
            }
        }

        if (taskManager.size() > 0) {
            System.out.println("Remaining tasks:");
            taskManager.displayTasks();
        } else {
            System.out.println("------------------------------");
            System.out.println("Task queue is empty.");
        }

        System.out.println("------------------------------"); // Добавляем разделение
    }

}
