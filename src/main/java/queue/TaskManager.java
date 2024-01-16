package queue;

import java.util.Iterator;

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

    public void performTask() {
        boolean performed = false;

        // Пытаемся выполнить приоритетную задачу
        Iterator<Task> iterator = tasks.iterator();
        while (iterator.hasNext()) {
            Task task = iterator.next();
            if (task.isPriority()) {
                System.out.println("Priority task performed: " + task.getTitle());
                iterator.remove();
                performed = true;
                break;
            }
        }

        // Если приоритетная задача не найдена, выполняем обычную задачу
        if (!performed) {
            iterator = tasks.iterator();
            if (iterator.hasNext()) {
                Task task = iterator.next();
                System.out.println("Regular task performed: " + task.getTitle());
                iterator.remove();
            } else {
                System.out.println("No tasks to perform.");
            }
        }
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
    public void initializeDefaultTasks() {
        // Добавление приоритетных задач
        addPriorityTask(new Task("Срочный отчёт", "Подготовить ежемесячный отчёт для руководства.", true));
        addPriorityTask(new Task("Обновление системы", "Выполнить срочное обновление программного обеспечения.", true));

        // Добавление обычных задач
        addRegularTask(new Task("Встреча с клиентом", "Обсудить детали нового проекта с клиентом."));
        addRegularTask(new Task("План маркетинга", "Разработать план маркетинга на следующий квартал."));
    }

    public int size() {
        return tasks.size();
    }
}
