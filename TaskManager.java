import java.util.ArrayList;
import java.util.List;

/**
 * The TaskManager class is responsible for managing a list of tasks.
 * It provides methods to add, remove, and retrieve tasks.
 */
public class TaskManager {
    private List<Task> tasks;

    public TaskManager() {
        tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(Task task) {
        tasks.remove(task);
    }

    public List<Task> getTasks() {
        return tasks;
    }
}