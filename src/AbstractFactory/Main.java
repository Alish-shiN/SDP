package AbstractFactory;

public class Main {
    public static void main(String[] args) {
        GUIFactory factory;
        String platform = "Windows"; // Можно изменить на "Mac" для тестирования

        if (platform.equals("Windows")) {
            factory = new WindowsFactory();
        } else {
            factory = new MacFactory();
        }

        Button button = factory.createButton();
        Window window = factory.createWindow();

        button.click();  // Outputs: Windows button clicked. (или Mac button clicked.)
        window.open();   // Outputs: Windows window opened. (или Mac window opened.)
    }
}

