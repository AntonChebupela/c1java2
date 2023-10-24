package queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskManagerTest {

    @Test
    void testing() {
        TaskManager taskManager = new TaskManager();
        taskManager.addRegularTask(new Task("сделать что то", "очень несрочное"));
        taskManager.addRegularTask(new Task("сделать что то 2 ", "очень срочно", true));
        assertEquals(2, taskManager.size());
        taskManager.displayTasks();
    }
}
