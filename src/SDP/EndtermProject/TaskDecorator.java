package SDP.EndtermProject;

public abstract class TaskDecorator extends Task {
    protected Task decoratedTask;

    public TaskDecorator(Task decoratedTask) {
        super(decoratedTask.getTitle(), decoratedTask.getDescription(), decoratedTask.getDueDate());
        this.decoratedTask = decoratedTask;
    }
}


