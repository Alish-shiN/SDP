public class TurnOnCommand implements Command {
    private Computer computer;

    public TurnOnCommand(Computer computer) {
        this.computer = computer;
    }

    public void execute() {
        computer.turnOn();
    }
}
