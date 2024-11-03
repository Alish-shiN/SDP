package SDP.EndtermProject;

public class ReminderTask extends TaskDecorator {
    private String reminder;

    public ReminderTask(Task task, String reminder) {
        super(task);
        this.reminder = reminder;
    }

    public void notifyReminder() {
        System.out.println("Reminder for task: " + decoratedTask.getTitle() + " - " + reminder);
    }
}

