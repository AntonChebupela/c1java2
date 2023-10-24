package queue;

public class Task {

    private String title;
    private String description;
    private boolean priority;

    public Task(String title, String description, boolean priority) {
        this.title = title;
        this.description = description;
        this.priority = priority;
    }

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.priority = false;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isPriority() {
        return priority;
    }

    public void setPriority(boolean priority) {
        this.priority = priority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task task)) return false;

        if (isPriority() != task.isPriority()) return false;
        if (getTitle() != null ? !getTitle().equals(task.getTitle()) : task.getTitle() != null) return false;
        return getDescription() != null ? getDescription().equals(task.getDescription()) : task.getDescription() == null;
    }

    @Override
    public int hashCode() {
        int result = getTitle() != null ? getTitle().hashCode() : 0;
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        result = 31 * result + (isPriority() ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", priority=" + priority +
                '}';
    }
}
