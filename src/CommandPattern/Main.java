public class Main {
    public static void main(String[] args) {
        // Создаем компьютер
        Computer computer = new Computer();

        // Создаем команды
        Command turnOn = new TurnOnCommand(computer);
        Command turnOff = new TurnOffCommand(computer);

        // Создаем пульт (отправитель команд)
        RemoteControl remote = new RemoteControl();

        // Включаем компьютер
        remote.setCommand(turnOn);
        remote.pressButton();

        // Выключаем компьютер
        remote.setCommand(turnOff);
        remote.pressButton();
    }
}
