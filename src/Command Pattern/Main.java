public class Main {
    public static void main(String[] args) {
        // Создаём лампу
        Light lamp = new Light();

        // Создаём команды для включения и выключения света
        Command lightOn = new LightOnCommand(lamp);
        Command lightOff = new LightOffCommand(lamp);

        // Создаём пульт и настраиваем его для включения света
        RemoteControl remote = new RemoteControl();

        // Включаем свет
        remote.setCommand(lightOn);
        remote.pressButton();  // Output: Light is On

        // Выключаем свет
        remote.setCommand(lightOff);
        remote.pressButton();  // Output: Light is Off
    }
}
