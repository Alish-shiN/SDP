package SDP.EndtermProject;

public class TaskFactory {
    public static Task createTask(String title, String description, String dueDate) {
        return new Task(title, description, dueDate);
    }
}

