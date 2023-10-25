package queue;

import java.util.Iterator;
import java.util.Scanner;

public class TaskManager {
    private final DoubleEndedQueue<Task> tasks;

    public TaskManager(DoubleEndedQueue<Task> tasks) {
        this.tasks = tasks;
    }

    public TaskManager() {
        this.tasks = new DoubleEndedQueue<>();
    }

    public void addPriorityTask(Task task) {
        task.setPriority(true);
        tasks.addFirst(task);
        System.out.println("Priority task added: " + task.getTitle());
    }

    public void addRegularTask(Task task) {
        tasks.addLast(task);
        System.out.println("Regular task added: " + task.getTitle());
    }

    public void performPriorityTask() {
        Iterator<Task> iterator = tasks.iterator();
        while (iterator.hasNext()) {
            Task task = iterator.next();
            if (task.isPriority()) {
                System.out.println("Priority task performed: " + task.getTitle());
                iterator.remove();  // Remove the element from the queue.
                return;
            }
        }
        System.out.println("No priority tasks to perform.");
    }

    public void performRegularTask() {
        Iterator<Task> iterator = tasks.iterator();
        while (iterator.hasNext()) {
            Task task = iterator.next();
            if (!task.isPriority()) {
                System.out.println("Regular task performed: " + task.getTitle());
                iterator.remove();
                return;
            }
        }
        System.out.println("No regular tasks to perform.");
    }

    public void displayTasks() {
        System.out.println("Task list:");

        System.out.println("Priority tasks:");
        boolean priorityTasksExist = false;
        for (Task task : tasks) {
            if (task.isPriority()) {
                System.out.println(task);
                priorityTasksExist = true;
            }
        }

        if (!priorityTasksExist) {
            System.out.println("No priority tasks.");
        }

        System.out.println("\nRegular tasks:");
        boolean regularTasksExist = false;
        for (Task task : tasks) {
            if (!task.isPriority()) {
                System.out.println(task);
                regularTasksExist = true;
            }
        }

        if (!regularTasksExist) {
            System.out.println("No regular tasks.");
        }
    }

    public int size() {
        return tasks.size();
    }
}
