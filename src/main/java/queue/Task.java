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

    public String getType() {
        return isPriority() ? "Priority" : "Regular";
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", type='" + getType() + '\'' +
                '}';
    }
}
