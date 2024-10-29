package CommandPattern;

public class TurnOffCommand implements Command {
    private Computer computer;

    public TurnOffCommand(Computer computer) {
        this.computer = computer;
    }

    @Override
    public void execute() {
        computer.turnOff();
    }
}
