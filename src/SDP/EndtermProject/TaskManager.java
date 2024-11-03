package SDP.EndtermProject;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> tasks = new ArrayList<>();
    private EmailNotifier emailNotifier = new EmailNotifier();

    public void addTask(Task task) {
        tasks.add(task);
        System.out.println("Task added: " + task);
    }

    public boolean completeTask(String title) {
        for (Task task : tasks) {
            if (task.getTitle().equalsIgnoreCase(title) && !task.isCompleted()) {
                task.complete();
                emailNotifier.update(task.getTitle());
                System.out.println("Task completed: " + task);
                return true;
            }
        }
        System.out.println("Task not found or already completed.");
        return false;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void showTasks() {
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    public void addEmailNotifier(String email) {
        emailNotifier.addObserver(email);
    }
}
